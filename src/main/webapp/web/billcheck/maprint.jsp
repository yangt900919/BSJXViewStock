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
            .datacode{
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
            .datacode{
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
        <c:forEach items="${mplist}" var="map" varStatus="st">

            <%--<c:choose>
            <c:when test="${ map.fisqt!=null || map.fisqt==1}">
--%>
            <div id="code${st.index}" class="code"></div>

            <c:if test="${map.fisdata!=null && map.fisdata==1}">
                <div id="datacode${st.index}" class="datacode"></div>
            </c:if>

          <%--  </c:when>
            <c:otherwise>
<c:if>
            <c:forEach items="${map.billcheckentries}" var="entry" varStatus="ste">
                <div id="code${ste.index}" class="code"></div>
            </c:forEach>
        </c:otherwise>
        </c:choose>--%>
        </c:forEach>
    </div>
    <div  align="center" id="image">

        <%--${mplist[0]}--%>
       <c:forEach items="${mplist}" var="map" varStatus="st">
          <%-- <div id="code${st.index}" class="code"></div>--%>

           <c:if test="${map.fisdata!=null && map.fisdata==1}">
               <c:forEach items="${map.billcheckentries}" var="entry" varStatus="ste">
                   <%--  <div id="code${ste.index}" class="code"></div>--%>
                   <table border="1" cellspacing="0" style="text-align: center; width:400px;font-size:15px" >
                       <tr style="height: 50px;">
                           <td width="60px" colspan="2">资料</td>
                           <td colspan="2" rowspan="3"> <img id="dataimage${st.index}"  src="" /></td>

                       </tr>
                       <tr style="height: 50px;">
                           <td width="60px">编号</td><td width="160px">${map.fnumber}</td>
                       </tr>
                       <tr style="height: 50px;">
                           <td>物料编码</td><td >${entry.fMaterial.materialnumber}</td>
                       </tr>
                       <tr style="height: 60px;">
                           <td>物料名称</td><td colspan="3">${entry.fMaterial.materialname}</td>
                       </tr>
                           <%--     <tr style="height: 60px;">
                                    <td>规格型号</td><td>${entry.fMaterial.materialmodel}</td>
                                </tr>--%>
                      <%-- <tr style="height: 50px;">
                           <td>保质期</td><td>${entry.fguartime}</td><td width="60px">生产日期</td><td>
                           <fmt:formatDate value="${entry.fdate}" pattern="yyyy-MM-dd"></fmt:formatDate>
                               &lt;%&ndash; ${entry.fdate}&ndash;%&gt;
                       </td>
                       </tr>--%>
                       <tr style="height: 60px;">
                           <td>供货单位</td><td colspan="3">
                               ${map.supplier.suppliername}
                       </td>
                               <%-- <td>合格数量</td><td></td>--%><%--<td>到货日期</td><td>
                           <fmt:formatDate value="${entry.fdeltime}" pattern="yyyy-MM-dd"></fmt:formatDate>
                               &lt;%&ndash;            ${entry.fdeltime}&ndash;%&gt;
                       </td>--%>
                       </tr>
                           <%--<tr style="height: 60px;">
                               <td>供货单位</td><td colspan="3">
                                   ${map.supplier.suppliername}
                           </td>
                           </tr>--%>
                   </table>
                   <div style="page-break-after: always"></div>
                   <script>
                       var str="{\"fnumber\":\"${entry.fMaterial.materialnumber}\",\"fsrc_number\":\"${map.fnumber}\",\"fsrc_billid\":${entry.fbillid},\"fsrc_entryid\":${entry.fentryid},\"ftype\":\"z\"}";
                       //var str="123";
                       str=toUtf8(str);
                       $("#datacode${st.index}").qrcode({
                           render: "canvas", //table方式
                           width:120, //宽度
                           height:120, //高度
                           text: str //任意内容
                       });
                       var canvas  = document.getElementsByTagName("canvas");
                       document.getElementById("dataimage${st.index}").src=canvas[${st.index}].toDataURL();
                   </script>
               </c:forEach>
           </c:if>

           <c:choose>
               <c:when test="${ map.fisqt!=null && map.fisqt==1}">

                <%--   <div id="code${st.index}" class="code"></div>--%>
                     <table border="1" cellspacing="0" style="text-align: center; width:400px;font-size:15px" >
                         <tr style="height: 60px;">
                             <td width="60px">编号</td><td >${map.fnumber}</td><td colspan="2" rowspan="3">
                             <img id="image${st.index}" src />
                         </td>
                         </tr>
                         <tr style="height: 60px;">
                             <td width="60px">箱号</td><td width="180px">${map.fboxno}</td>
                         </tr>
                         <tr style="height: 60px;">
                             <td width="60px">批号</td><td >${map.billcheckentries[0].fbatch}</td>
                         </tr>

                         <tr style="height: 60px;">
                             <td>供货单位</td><td colspan="3">
                                 ${map.supplier.suppliername}
                         </td>
                         </tr>
                     </table>

                     <div style="page-break-after: always"></div>
                     <script>
                         var str="{\"fnumber\":\"${map.fboxno}\",\"fsrc_number\":\"${map.fnumber}\",\"ftype\":\"q\"}";
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

               </c:when>
               <c:otherwise>
                      <c:forEach items="${map.billcheckentries}" var="entry" varStatus="ste">
                        <%--  <div id="code${ste.index}" class="code"></div>--%>
                      <table border="1" cellspacing="0" style="text-align: center; width:400px;font-size:15px" >
                          <tr style="height: 50px;">
                              <td width="60px">编号</td><td>${map.fnumber}</td>
                              <td colspan="2" rowspan="3"> <img id="image${st.index}"  src="" /></td>

                          </tr>
                          <tr style="height: 50px;">
                              <td width="60px">批号</td><td width="160px">${entry.fbatch}</td>
                          </tr>
                          <tr style="height: 50px;">
                              <td>物料编码</td><td >${entry.fMaterial.materialnumber}</td>
                          </tr>
                          <tr style="height: 60px;">
                              <td>物料名称</td><td colspan="3">${entry.fMaterial.materialname}</td>
                          </tr>
                     <%--     <tr style="height: 60px;">
                              <td>规格型号</td><td>${entry.fMaterial.materialmodel}</td>
                          </tr>--%>
                          <tr style="height: 50px;">
                              <td>保质期</td><td>${entry.fguartime}</td><td width="60px">生产日期</td><td>
                                   <fmt:formatDate value="${entry.fdate}" pattern="yyyy-MM-dd"></fmt:formatDate>
                                 <%-- ${entry.fdate}--%>
                          </td>
                          </tr>
                          <tr style="height: 60px;">
                              <td>供货单位</td><td  style="width: 160px;word-wrap: break-word">
                                  ${map.supplier.suppliername}
                          </td>
                             <%-- <td>合格数量</td><td></td>--%><td>到货日期</td><td>
                                   <fmt:formatDate value="${entry.fdeltime}" pattern="yyyy-MM-dd"></fmt:formatDate>
                      <%--            ${entry.fdeltime}--%>
                          </td>
                          </tr>
                          <%--<tr style="height: 60px;">
                              <td>供货单位</td><td colspan="3">
                                  ${map.supplier.suppliername}
                          </td>
                          </tr>--%>
                      </table>
                      <div style="page-break-after: always"></div>
                 <script>
                          var str="{\"fnumber\":\"${entry.fMaterial.materialnumber}\",\"fsrc_number\":\"${map.fnumber}\",\"fsrc_billid\":${entry.fbillid},\"fsrc_entryid\":${entry.fentryid},\"ftype\":\"w\"}";
                          //var str="123";
                          str=toUtf8(str);
                          $("#code${st.index}").qrcode({
                              render: "canvas", //table方式
                              width:120, //宽度
                              height:120, //高度
                              text: str //任意内容
                          });
                          var canvas  = document.getElementsByTagName("canvas");
                          document.getElementById("image${st.index}").src=canvas[${st.index}].toDataURL();
                      </script>
                      </c:forEach>
               </c:otherwise>
           </c:choose>



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