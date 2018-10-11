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
    
    <title>My JSP 'edit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<jsp:include page="/web/shared/resource.jsp"></jsp:include>
    <style type="text/css">
    .aside
    {
    display: inline-block;
    }
    </style>
    
<script type="text/javascript">
    $("#home", parent.document).removeClass("active");
    $("#link", parent.document).empty();
    $("#link", parent.document).addClass("active");
    $("#link", parent.document).text("用户角色分配");
</script>
  </head>
  
  <body>
     <div class=title>
  &nbsp;用户仓库分配
   </div>
    <div class="container-fluid editpage-content">

   <form   class="form-horizontal" >
   <c:if test="${user.fid>0 }">  <input type="hidden" id=fid name=fid value=${user.fid }></c:if>
 
  <div class="form-group">
    <label for="username" class=col-sm-3>用户名称</label>
    <div class=col-sm-9>
    <input type="text" readonly="readonly" class="form-control" id="username" name="username" placeholder="用户名称" value=${user.username }>
  </div>
  </div>

   <div class="form-group ">
    <label for="fname" class=col-sm-3>用户仓库</label>
       <div class=col-sm-9>
<c:forEach items="${erpstocklist }" var="map">
<div class=row>
<label for="FRole${map.fid }" class=col-sm-4>${map.fnumber }</label>
<div class=col-sm-3 >
<input type="checkbox" class="check" id="FRole${map.fid }" name="check" value="${map.fid }"/>
</div>
</div>
</c:forEach>
</div>
        <c:forEach items="${user.erpStocks }" var="r">
    <script type="text/javascript">
    var id='${r.fid}';
    //alert()
	  $("#FRole"+id).prop("checked",true) ;
    </script>
    </c:forEach>
  </div>


       <div class="form-group">
           <div class="col-sm-offset-3 col-sm-9">
               <button type="button" class="btn btn-primary btn-sm" onclick="BindStock()">
                   <span class="glyphicon glyphicon-saved" aria-hidden="true"></span>   保存</button>

               <button  type="button" class="btn btn-warning btn-sm" onclick="javascript:history.go(-1);">

                   <span class="glyphicon glyphicon-log-out" aria-hidden="true" ></span>  退出</button>
           </div>
       </div>
</form>
  </body>
</html>
