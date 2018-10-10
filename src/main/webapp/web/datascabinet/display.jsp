<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>货架展示</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<jsp:include page="../../web/shared/resource.jsp"></jsp:include>
    <link rel="stylesheet" href="assets/pages/css/page/display.css"/>
      <script src="assets/pages/scripts/display.js"></script>
  </head>
  
  <body class=stock_body>
    <div class=container-fiuld align="left">
        <jsp:include page="../../web/shared/Atop.jsp"></jsp:include>
        <div class=stock-display >
   <%--   <div class="row  main-top" align="left">
    <div class=title_asicde>
       <div class=title-box>
 ${scdlist[0].snumber }库${scdlist[0].sname}&nbsp;${scdlist[0].cnumber }-${scdlist[0].cname }&nbsp; ${scdlist[0].scnumber }-${scdlist[0].scname }
  </div>

   </div>
   </div>--%>
            <div class="cname " >${scdlist[0].cname}</div>
    <div class=page-body style="margin-top: -10px">
   <div class=row align="center">
   <c:set var="begin" value="${scdlist[0].begins }"></c:set>
   <c:forEach begin="${begin }" end="${ scdlist[0].frow-1}" var="j">

   <div>
       <diV  align="left" class="scabinet_aside layer">${scdlist[begin].layer}</diV>
   <c:forEach begin="${begin }" end="${begin+scdlist[0].fcol-1 }" var="i">

 <div class=scabinet_aside onclick="gotoGoodSeat('${scdlist[i].fnumber }','${scdlist[i].fnumber }','${scdlist[i].flag }')">
 <div class="sc_head ${scdlist[i].css }_head">  ${scdlist[i].fnumber }
 </div>
 <div class="sc_body ${scdlist[i].css }_body">

 <div class="row">
    <div class="col-md-6 col-xs-6 col-sm-6" align="left">${scdlist[i].maqty }</div>
    <div class="col-md-6 col-xs-6 col-sm-6" align="right"> ${scdlist[i].macount }</div>
 </div>
     <div class="row">
         <div class="col-md-6 col-xs-6 col-sm-6" align="left">数量</div>
         <div class="col-md-6 col-xs-6 col-sm-6" align="right"> 种类</div>
     </div>
 <%-- <div class=row>
 数量：${scdlist[i].maqty }
 </div>
  <div class=row>
 物料种类：${scdlist[i].macount }
 </div>--%>
 </div>
 </div>
       <c:if test="${i%2!=0}">
           <div class=scabinet_aside>&nbsp;&nbsp;&nbsp;&nbsp;</div>
       </c:if>
   </c:forEach>
   </div>
    <c:set var="begin" value="${begin+scdlist[0].fcol }"></c:set>
   </c:forEach>
   </div>
    </div>
    </div>
    </div>
  </body>
</html>
