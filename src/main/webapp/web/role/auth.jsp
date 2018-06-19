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
 
  </head>
  
  <body>
   <h3 class=title>
角色权限分配
   </h3>
    <div class="container-fluid editpage-content">
  
   <form action=""  class="form-horizontal" >
   <c:if test="${role.fid>0 }">  <input type="hidden" name=fid id=fid value=${role.fid }></c:if>
 
    
  <div class="form-group">
    <label for="rolename" class=col-sm-3>角色名称</label>
     <div class="col-sm-9">
    <input type="text" readonly="readonly"  class="form-control" id="rolename" name="rolename" placeholder="角色名称" value=${role.rolename }>
  </div>
  </div>
  
     <div class="form-group ">
    <label for="fpermission" class=col-sm-3>权限</label>
       <div class=col-sm-9>
<c:forEach items="${permissionList }" var="map">
<div class=row>
<label for="fpermission${map.fid }" class=col-sm-4>${map.fname }</label>
<div class=col-sm-3 >
<c:choose>
<c:when test="${map.fname=='管理首页' }">
<input type="checkbox" class="check" id="fpermission${map.fid }" name="check" value="${map.fid }" checked="checked"/>
</c:when>
<c:otherwise>
<input type="checkbox" class="check" id="fpermission${map.fid }" name="check" value="${map.fid }"/>
</c:otherwise>
</c:choose>

</div>
</div>
</c:forEach>
</div>
        <c:forEach items="${role.permissions }" var="p">
    <script type="text/javascript">
    var id='${p.fid}';
    //alert()
	  $("#fpermission"+id).prop("checked",true) ;
    </script>
    </c:forEach>
  </div>
 
  <div class="form-group">
  <div class="col-sm-offset-3 col-sm-9">
  <a  class="btn btn-primary" onclick="doAuth()" href="javaScript:;">
    <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>  提交</a>
   <button type="button" class="btn btn-warning" onclick="javascript:history.go(-1);">
  <span class="glyphicon glyphicon-log-out" aria-hidden="true" ></span>   返回</button>
   </div>
   </div>
  </form>
  </div>
  </body>
</html>
