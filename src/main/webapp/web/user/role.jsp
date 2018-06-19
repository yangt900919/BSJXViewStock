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
    

  </head>
  
  <body>
     <h3 class=title>
  用户角色分配
   </h3>
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
    <label for="FRole" class=col-sm-3>用户角色</label>
       <div class=col-sm-9>
<c:forEach items="${roleList }" var="map">
<div class=row>
<label for="FRole${map.fid }" class=col-sm-4>${map.rolename }</label>
<div class=col-sm-3 >
<input type="checkbox" class="check" id="FRole${map.fid }" name="check" value="${map.fid }"/>
</div>
</div>
</c:forEach>
</div>
        <c:forEach items="${user.roles }" var="r">
    <script type="text/javascript">
    var id='${r.fid}';
    //alert()
	  $("#FRole"+id).prop("checked",true) ;
    </script>
    </c:forEach>
  </div>
   

  <div class="form-group">
  <div class="col-sm-offset-3 col-sm-9">
  <a  class="btn btn-primary" onclick="Bind()" href="javaScript:;">
    <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>   提交</a>
   <button type="button" class="btn btn-warning" onclick="javascript:history.go(-1);">
    <span class="glyphicon glyphicon-log-out" aria-hidden="true" ></span> 返回</button>
   </div>
   </div>
</form>
  </body>
</html>
