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
	<jsp:include page="../../web/shared/resource.jsp"></jsp:include>

  </head>
  
  <body>
   <h3 class=title>
  盘点方案信息管理
   </h3>
    <div class="container-fluid editpage-content">
  
   <form action="inv/save"  class="form-horizontal" method="post" id=form>
   <c:if test="${inv.fid>0 }">  <input type="hidden" name=fid value=${inv.fid }></c:if>
 

  <div class="form-group">
    <label for="fname" class=col-sm-3>盘点方案名称</label>
    <div class=col-sm-9>
    <input type="text" readonly class="form-control" id="fname" name="fname" placeholder="盘点方案名称" value=${inv.fname }>
  </div>
  </div>
   <div class="form-group">
    <label for="fdate" class=col-sm-3>日期</label>
    <div class=col-sm-9>
    <input type="date" readonly class="form-control" id="fdate" name="fdate" placeholder="日期" value=${inv.fdate }>
  </div>
  </div>


               <input type="hidden" readonly class="form-control" id="fstate" name="fstate" placeholder="日期" value=${inv.fstate }>


   <div class="form-group">
  <div class="col-sm-offset-3 col-sm-9">
      <button type="submit" class="btn btn-primary">
          <span class="glyphicon glyphicon-saved" aria-hidden="true"></span>   保存</button>

      <button  type="button" class="btn btn-warning" onclick="javascript:history.go(-1);">

          <span class="glyphicon glyphicon-log-out" aria-hidden="true" ></span>  退出</button>
   </div>
   </div>
  </form>
  </body>
</html>
