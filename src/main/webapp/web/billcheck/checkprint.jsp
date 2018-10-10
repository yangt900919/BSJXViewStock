<%--
  Created by IntelliJ IDEA.
  User: Yang
  Date: 2018/5/16
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="assets/pages/scripts/jquery.jqprint-0.3.js"></script>
    <script type="text/javascript" src="assets/pages/scripts/jquery.qrcode.js"></script>
    <style>
        @media screen
        {
            #billprint
            {
                display: none;
            }
            /*  table{
                  width:250px; !important;
                  !* height:100px; !important;*!
                  text-align: center ;
                  font-size: xx-small;
              }
              .tr_height
              {
                  height: 45px;
              }*/
            .code{
                display: none;
            }
        }
    </style>
</head>

<body>
<table align="center" style="width: 90%" id="billprint">
    <tr><th colspan="2">  <h3>收货通知请检单</h3></th></tr>
    <tr>
        <td> <img id="image" src=""/>
            <div id="code" style="display: none;"></div></td>
        <td>
            <table style="width: 100%">
                <tr>
                    <th>单据编号</th><td>${billcheck.fnumber}</td>
                    <th>业务日期</th><td>
                    <fmt:formatDate value="${billcheck.fbizdate}" pattern="yyyy-MM-dd"></fmt:formatDate>
                </td>
                    <th>供应商</th><td>${billcheck.supplier.suppliername}</td>
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
                <th>计量单位</th>
                <th>仓库</th>
                <th>批号</th>
                <th>收料数量</th>
                <th>合格数量</th>



            </tr>
            </thead>
            <tbody align="center">
            <c:forEach items="${billcheck.billcheckentries}" var="map" varStatus="st">
                <tr style="height: 45px;">
                    <td>${map.fMaterial.materialnumber}</td>
                    <td>${map.fMaterial.materialname}</td>
                    <td>${map.fMaterial.materialunit}</td>
                    <td>${map.fStock.fname}</td>
                    <td>${map.fbatch}</td>
                    <td>${map.fqty}</td>
                    <td>${map.feligqty}
                    </td>



                </tr>
            </c:forEach>
            </tbody>
        </table>
        </td>
    </tr>
</table>
<%--<div   >
    <div class="row" align="center">

    </div>
  <div class="row">
        <div class="col-md-3">

        </div>
        <div class="col-md-9">

        </div>
    </div>
    <div class="row">
        <div class="col-md-3">

        </div>
        <div class="col-md-9">

        </div>
    </div>
      <br>
    <div class="row" align="center">

    </div>
</div>--%>
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

    var str="${billcheck.fnumber}";
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
           /* alert($("#billprint").length);*/
            $("#billprint").jqprint({
                debug:false,
                importCSS:true,
                printContainer:true,
                operaSupport:false
            });

</script>
</body>
</html>
