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
    <jsp:include page="../../web/shared/resource.jsp"></jsp:include>
<%--    <script type="text/javascript" src="assets/global/plugins/jquery.min.js"></script>--%>
    <script type="text/javascript" src="assets/pages/scripts/jquery.jqprint-0.3.js"></script>
    <script type="text/javascript" src="assets/pages/scripts/jquery.qrcode.js"></script>

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
            table{
                border:darkblue;
            }
         /*   table{
                width:100px; !important;
                !* height:100px; !important;*!
                text-align: center ;
                font-size: 20px;
                border: 1px solid red;
            }
            .tr_height
            {
                height: 60px;
            }*/
            .code{
                display: none;
            }
        }
        @media screen
        {
            #image
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
                height: 60px;
            }*/
            .code{
                display: none;
            }
        }
    </style>
<%--    <style>
        @media screen
        {
            .noPrint
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

        }
#image
{
   /* width: 100px;
    height: 100px;
    border :1px solid grey;*/
}
    </style>--%>
    <style>

    </style>
</head>
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


</script>

</head>
<body >

<div class="container">
    <div id="codes" align="center">
        <c:forEach items="${mpboxlist}" var="map" varStatus="st">
            <div id="code${st.index}" class="code"></div>
        </c:forEach>
    </div>
    <div  align="center" id="image">
        <%--${mpboxlist[0]}--%>
       <c:forEach items="${mpboxlist}" var="map" varStatus="st">
          <%-- <div id="code${st.index}" class="code"></div>--%>

           <table border="1" cellspacing="0" style="text-align: center; width:400px;  font-size: 15px;" >
               <tr style="height: 60px;">
                  <td width="60px">编号</td><td>${map.fbillno}</td><td colspan="2" rowspan="3">
                   <img id="image${st.index}" src />
               </td>
               </tr>
               <tr style="height: 60px;">
                  <td width="60px">齐套编号</td><td width="180px">${map.fboxno}</td>
               </tr>
               <tr style="height: 60px;">
                  <td width="60px">批号</td><td >${map.fbatch}</td>
               </tr>

               <tr style="height: 60px;">
                  <td>供货单位</td><td colspan="3">
                   ${map.supplier.suppliername}
               </td>
               </tr>
           </table>

           <div style="page-break-after: always"></div>
           <script>
               var str="{\"fnumber\":\"${map.fboxno}\",\"fsrc_number\":\"${map.fbillno}\",\"ftype\":\"q\"}";
              //var str="123";
               str=toUtf8(str);
               $("#code${st.index}").qrcode({
                   render: "canvas", //table方式
                   width:130, //宽度
                   height:130, //高度
                   text: str //任意内容
               });
               var canvas  = document.getElementsByTagName("canvas");
               document.getElementById("image${st.index}").src=canvas[${st.index}].toDataURL();
           </script>

       </c:forEach>

    </div>
</div>



</body>
<script>
      $("#image").jqprint({debug:false,
    importCSS:true,
        printContainer:true,
        operaSupport:false});
</script>
</html>