<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>柜列展示</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
      <jsp:include page="../../web/shared/resource.jsp"></jsp:include>
    <link rel="stylesheet" href="assets/pages/css/page/display.css"/>
  </head>
    <script type="text/javascript">
    $(function () {
    	  $('[data-toggle="popover"]').popover('show');
    	
    	});
    </script>
  <script src="assets/pages/scripts/display.js"></script>
  <body class=stock_body>
  
       <div class=container-fiuld align="left">
        <jsp:include page="../../web/shared/top.jsp"></jsp:include>
   <%--     <div class=stock-display >
      <div class="row main-top" align="left">
    <div class=title_asicde>
       <div class=title-box>
&lt;%&ndash; ${cInfoList[0].stock }库${cInfoList[0].stockname }&nbsp; ${cInfoList[0].cnumber }-${cInfoList[0].cname }&ndash;%&gt;
  </div>
   </div>
   </div>--%>
   <div class=page-body>
    <div class=row align="center">
     <div class="col-md-4 col-sm-4 col-xs-4">

    </div>
    
           <div class="col-md-4 col-sm-4 col-xs-4">
       
      
    <c:forEach items="${cdlist}" var="map">
    
    <div class="row row-padding" onclick="gotoSCabinet('${map.fnumber}','${map.fnumber}','${map.flag}')">

   
    <div class="cabinet_head">
   ${map.fname }
    </div>
    <div class="cabinet_body">
  <div class=row align="center">
  <div class="col-md-1 col-sm-1 col-xs-1"> </div>
   <div class="col-md-2 col-sm-2 col-xs-2"><font color="#F58521"> ${map.maqty }</font></div>
      <div class="col-md-2 col-sm-2 col-xs-2"></div>
      <div class="col-md-2 col-sm-2 col-xs-2"></div>
      <div class="col-md-2 col-sm-2 col-xs-2"></div>
   <div class="col-md-2 col-sm-2 col-xs-2"><font color="#3176B7"> ${map.macount}</font></div>

  </div>
    <div class=row align="center">
  <div class="col-md-1 col-sm-1 col-xs-1"> </div>
   <div class="col-md-2 col-sm-2 col-xs-2 body_font">数量 </div>
        <div class="col-md-2 col-sm-2 col-xs-2"></div>
        <div class="col-md-2 col-sm-2 col-xs-2"></div>
        <div class="col-md-2 col-sm-2 col-xs-2"></div>
   <div class="col-md-3 col-sm-3 col-xs-3 body_font">物料种类 </div>


  </div>
    </div>
    </div>
     
    </c:forEach>
    </div>
       </div>

    </div>

    </div>
    </div>
  </body>
</html>
