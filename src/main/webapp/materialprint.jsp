<%--
  Created by IntelliJ IDEA.
  User: Yang
  Date: 2018/4/18
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="assets/global/plugins/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="assets/pages/css/login.css" />
    <link rel="stylesheet" href="assets/global/plugins/bootstrapValidator/css/bootstrapValidator.css"/>
    <script type="text/javascript" src="assets/global/plugins/jquery.min.js"></script>
    <script type="text/javascript" src="assets/pages/scripts/jquery.jqprint-0.3.js"></script>
    <script type="text/javascript" src="assets/pages/scripts/jquery.qrcode.js"></script>
    <script type="text/javascript" src="assets/global/plugins/jquery.cookie.js"></script>
    <script type="text/javascript" src="assets/global/plugins/bootstrap/js/bootstrap.min.js"></script>
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
         /*   #image
            {
                display: none;
            }*/
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
/*#image
{
    width: 100px;
    height: 100px;
    border :1px solid grey;
}*/
    </style>
</head>
<script>
    function encode(){
        $("#code").html('');
        var str=$('#txt').val();
        str=toUtf8("{\"fmanum\":\"9.2.07.00184\",\"fbillno\":\"CS00001\"}");
        //$('#code').qrcode(str);
        $("#code").qrcode({
            render: "canvas", //table方式
            width: 85, //宽度
            height:85, //高度
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
        var img1 = document.getElementById("image0"); /// get image element
        //var img2 = document.getElementById("image2");
        var canvas  = document.getElementsByTagName("canvas")[0];  /// get canvas element
        img1.src = canvas.toDataURL();
        //img2.src = canvas.toDataURL();  /// update image

        $("#image").jqprint({
            debug:false,
            importCSS:true,
            printContainer:true,
            operaSupport:false
        });
    }
</script>
<style>
    table{
        width:400px; !important;
        height:100px; !important;
       text-align: center ;
        /*border: 1px solid black;*/
        font-size: 12px;
    }
    table>tr
    {
        height: 40px;
    }
</style>
</head>
<body>
<center>
    <input type="text" id="txt" />
    <button id="btnEncode" onclick="encode();">
        生成QRcode</button>
    <button id="btnPrint" onclick="print();">
        打印</button>
    <hr />

    <%--<table border="1">
        <tr>
            <td>编号</td><td>CS00001</td><td>批号</td><td>&nbsp;&nbsp;&nbsp;</td>
        </tr>
        <tr>
            <td>物料编码</td><td>9.2.07.00184</td><td colspan="3" rowspan="3">   <div id="code" >

        </div></td>
        </tr>
        <tr>
            <td>物料名称</td><td>硅微带</td>
        </tr>
        <tr>
            <td>规格型号</td><td>2K4E</td>
        </tr>
        <tr>
            <td>保质期</td><td></td><td>生产日期</td><td>&nbsp;&nbsp;&nbsp;</td>
        </tr>
        <tr>
            <td>合格数量</td><td></td><td>到货日期</td><td>&nbsp;&nbsp;&nbsp;</td>
        </tr>
        <tr>
            <td>供货单位</td><td colspan="3"></td>
        </tr>
    </table>



    <table border="1" id="image" style="text-align: center">
        <tr>
            <td>编号</td><td>CS00001</td><td>批号</td><td>&nbsp;&nbsp;&nbsp;</td>
        </tr>
        <tr>
            <td>物料编码</td><td>9.2.07.00184</td><td colspan="3" rowspan="3"> <img id="image1"  src="" title="32432432"/></td>
        </tr>
        <tr>
            <td>物料名称</td><td>硅微带</td>
        </tr>
        <tr>
            <td>规格型号</td><td>2K4E</td>
        </tr>
        <tr>
            <td>保质期</td><td></td><td>生产日期</td><td></td>
        </tr>
        <tr>
            <td>合格数量</td><td></td><td>到货日期</td><td></td>
        </tr>
        <tr>
            <td>供货单位</td><td colspan="3"></td>
        </tr>
    </table>
--%>
 <%--   <div id="image" align="center">

        <img id="image1"  src="" title="32432432"/>

        <div class="pageBreak">
            <!--如果需要强制换页就在上一页的未尾出加上此代码-->
        </div>
        <img id="image2"  src="" />

    </div>--%>
    <div id="codes" align="center">
        <c:forEach items="${mplist}" var="map" varStatus="st">
            <div id="code${st.index}" class="code"></div>
        </c:forEach>
    </div>
    <div  align="center" id="image">
        <%--${mplist[0]}--%>
        <c:forEach items="${mplist}" var="map" varStatus="st">
            <%-- <div id="code${st.index}" class="code"></div>--%>

            <table border="1" style="text-align: center" >
                <tr class="tr_height">
                    <th width="20%">编号</th><td>${map.fbillno}</td><th width="20%">批号</th><td width="28%">${map.fbatch}</td>
                </tr>
                <tr class="tr_height">
                    <th>物料编码</th><td >${map.material.materialnumber}</td><td colspan="3" rowspan="3"> <img id="image${st.index}"  src="" /></td>
                </tr>
                <tr class="tr_height">
                    <th>物料名称</th><td width="32%">${map.material.materialname}</td>
                </tr>
                <tr class="tr_height">
                    <th>规格型号</th><td>${map.material.materialmodel}</td>
                </tr>
                <tr class="tr_height">
                    <th>保质期</th><td>${map.fgperiod}</td><th>生产日期</th><td>
                        <%-- <fmt:formatDate value="${map.fmdate}" pattern="yyyy-MM-dd"></fmt:formatDate>--%>
                        ${map.fmdate}
                </td>
                </tr>
                <tr class="tr_height">
                    <th>合格数量</th><td>${map.fquqty}</td><th>到货日期</th><td>
                        <%-- <fmt:formatDate value="${map.fadate}" pattern="yyyy-MM-dd"></fmt:formatDate>--%>
                        ${map.fadate}
                </td>
                </tr>
                <tr class="tr_height">
                    <th>供货单位</th><td colspan="3">
                        ${map.supplier.suppliername}
                </td>
                </tr>
            </table>

            <div class="pageBreak"></div>
            <script>
                var str="{\"fnumber\":\"${map.material.materialnumber}\",\"fbillno\":\"${map.fbillno}\",\"fbillid\":\"\",\"fentryid\",\"\",\"ftype\":\"w\"}";
                //var str="123";
                str=toUtf8(str);
                $("#code${st.index}").qrcode({
                    render: "canvas", //table方式
                    width:110, //宽度
                    height:110, //高度
                    text: str //任意内容
                });
                var canvas  = document.getElementsByTagName("canvas");
                document.getElementById("image${st.index}").src=canvas[${st.index}].toDataURL();
            </script>

        </c:forEach>

    </div>
</center>
</body>
</html>