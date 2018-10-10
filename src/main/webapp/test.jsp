<%--
&lt;%&ndash;
  Created by IntelliJ IDEA.
  User: Yang
  Date: 2018/4/18
  Time: 11:00
  To change this template use File | Settings | File Templates.
&ndash;%&gt;
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href=" assets/global/plugins/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href=" assets/pages/css/login.css" />
    <link rel="stylesheet" href="assets/global/plugins/bootstrapValidator/css/bootstrapValidator.css"/>
    <script type="text/javascript" src=" assets/global/plugins/jquery.min.js"></script>
    <script type="text/javascript" src=" assets/pages/scripts/jquery.jqprint-0.3.js"></script>
    <script type="text/javascript" src=" assets/pages/scripts/jquery.qrcode.js"></script>
    <script type="text/javascript" src=" assets/global/plugins/jquery.cookie.js"></script>
    <script type="text/javascript" src=" assets/global/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="assets/global/plugins/bootstrapValidator/js/bootstrapValidator.js"></script>

    <style type="text/css">

        @media print
        {
            .pageBreak
            {
                page-break-after: always; /*强制换页的关键*/
            }
            .noPrint
            {
                display: none;
            }
        }
    </style>
    <style>
        @media screen
        {
            #canvas
            {
                display: block;
            }
            #image
            {
                display: none;
            }
        }
        @media print
        {
            #canvas
            {
                display: none;
            }
            #image
            {
                display: block;
            }
        }
#image
{
    width: 100px;
    height: 100px;
    border :1px solid grey;
}
    </style>
</head>
<script>
    function encode(){
        $("#code").html('');
        var str=$('#txt').val();
        str=toUtf8(str);
        //$('#code').qrcode(str);
        $("#code").qrcode({
            render: "canvas", //table方式
            width: 200, //宽度
            height:200, //高度
            text: str //任意内容
        });



    }

    function toUtf8(str) {
        var out, i, len, c;
        out = "";
        len = str.length;
        for(i = 0; i < len; i++) {
            c = str.charCodeAt(i);
            if ((c >= 0x0001) && (c <= 0x007F)) {
                out += str.charAt(i);
            } else if (c > 0x07FF) {
                out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));
                out += String.fromCharCode(0x80 | ((c >>  6) & 0x3F));
                out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));
            } else {
                out += String.fromCharCode(0xC0 | ((c >>  6) & 0x1F));
                out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));
            }
        }
        return out;
    }

    function print(){
     /*   var img1 = document.getElementById("image1"); /// get image element
        var img2 = document.getElementById("image2");
        var canvas  = document.getElementsByTagName("canvas")[0];  /// get canvas element
        img1.src = canvas.toDataURL();
        img2.src = canvas.toDataURL();  /// update image
*/
        $("#billprint").jqprint({
            debug:false,
            importCSS:true,
            printContainer:true,
            operaSupport:false
        });
    }
</script>

</head>
<body>
<center>
    <input type="text" id="txt" />


    <input type="text" id="" />
    <button id="btnEncode" onclick="encode();">
        生成QRcode</button>
    <button id="btnPrint" onclick="print();">
        打印</button>
    <hr />
    &lt;%&ndash;

    <div id="image" align="center">

        <img id="image1"  src="" title="32432432"/>

        <div class="pageBreak">
            <!--如果需要强制换页就在上一页的未尾出加上此代码-->
        </div>
        <img id="image2"  src="" />

    </div>&ndash;%&gt;
    <table align="center" style="width: 90%" id="billprint">
        <tr><th colspan="2">  <h3>采购订单</h3></th></tr>
        <tr>
            <td> <img id="image" src=""/>
                <div id="code" style="display: none;"></div></td>
            <td>
                <table style="width: 100%">
                    <tr>
                        <th>单据编号</th><td>CGDD201805020006</td>
                        <th>业务日期</th><td>
                        2018-05-02
                    </td>
                        <th>供应商</th><td>测试供应商</td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr><td colspan="2">&nbsp;</td></tr>
        <tr>
            <td colspan="2">
                <table border="1" cellspacing="0" style="width: 100%">
                    <thead>
                    <tr style="height: 45px;">
                        <th>&nbsp;&nbsp;物料代码&nbsp;&nbsp;</th>
                        <th>物料名称</th>
                        <th>仓库</th>
                        <th>数量</th>
                        <th>交货日期</th>
                        <th>合同号</th>


                    </tr>
                    </thead>
                    <tbody align="center">

                    <tr style="height: 45px;">
                        <td>900080763</td>
                        <td>90°弯头 NPT1/8-NPT1/4（作废）</td>
                        <td>油漆库</td>
                        <td>10.0</td>
                        <td>
                        </td>
                        <td></td>


                    </tr>

                    </tbody>
                </table>
            </td>
        </tr>
    </table>

    <script>
        function toUtf8(str) {
            var out, i, len, c;
            out = "";
            len = str.length;
            for(i = 0; i < len; i++) {
                c = str.charCodeAt(i);
                if ((c >= 0x0001) && (c <= 0x007F)) {
                    out += str.charAt(i);
                } else if (c > 0x07FF) {
                    out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));
                    out += String.fromCharCode(0x80 | ((c >>  6) & 0x3F));
                    out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));
                } else {
                    out += String.fromCharCode(0xC0 | ((c >>  6) & 0x1F));
                    out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));
                }
            }
            return out;
        }

        var str="CGDD201805020006";
        //var str="123";
        str=toUtf8(str);
        $("#code").qrcode({
            render: "canvas", //table方式
            width:120, //宽度
            height:120, //高度
            text: str //任意内容
        });
        var canvas  = document.getElementsByTagName("canvas")[0];
        document.getElementById("image").src=canvas.toDataURL();

        /*$("#btn-print").click(function ()
        {*/
       /* alert($("#billprint").length);
        $("#billprint").jqprint({
            debug:false,
            importCSS:true,
            printContainer:true,
            operaSupport:false
        });*/

    </script>

</center>
&lt;%&ndash;<img src="assets/pages/img/c.jpg" height="100%"/>&ndash;%&gt;
</body>
</html>--%>


<!DOCTYPE html>
<html>
<head>
    <title>jQuery bootstrap-select可搜索多选下拉列表插件-www.daimajiayuan.com</title>
    <script type="text/javascript" src="http://www.daimajiayuan.com/download/jquery/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="http://cdn.bootcss.com/bootstrap-select/2.0.0-beta1/js/bootstrap-select.js"></script>
    <link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/bootstrap-select/2.0.0-beta1/css/bootstrap-select.css">



    <!-- 3.0 -->
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>

    <!-- 2.3.2
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet">
    <script src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.js"></script>
    -->
    <script type="text/javascript">
        $(window).on('load', function () {

            $('.selectpicker').selectpicker({
                'selectedText': 'cat'
            });

            // $('.selectpicker').selectpicker('hide');
        });
    </script>
</head>
<body>
<label for="id_select">Test label YEag</label>
<select id="id_select" class="selectpicker bla bla bli" multiple data-live-search="true">
    <option>cow</option>
    <option>bull</option>
    <option class="get-class" disabled>ox</option>
    <optgroup label="test" data-subtext="another test" data-icon="icon-ok">
        <option>ASD</option>
        <option selected>Bla</option>
        <option>Ble</option>
    </optgroup>
</select>

<div class="container">
    <form class="form-horizontal" role="form">
        <div class="form-group">
            <label for="bs3Select" class="col-lg-2 control-label">Test bootstrap 3 form</label>
            <div class="col-lg-10">
                <select id="bs3Select" class="selectpicker show-tick form-control" multiple data-live-search="true">
                    <option>cow</option>
                    <option>bull</option>
                    <option class="get-class" disabled>ox</option>
                    <optgroup label="test" data-subtext="another test" data-icon="icon-ok">
                        <option>ASD</option>
                        <option selected>Bla</option>
                        <option>Ble</option>
                    </optgroup>
                </select>
            </div>
        </div>
        <form>
</div>

</body>
</html>

