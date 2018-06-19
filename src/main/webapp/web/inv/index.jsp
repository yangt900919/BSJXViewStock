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
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<jsp:include page="/web/shared/resource.jsp"></jsp:include>
  </head>
  
  <body>
   <div class=container-fluid>
   <h3 class=title_index>
盘点方案信息管理
   </h3>
   <div class="row">
       <div class="col-md-3 col-sm-3 col-xs-3" >
        <div class=row>

            <div class="col-md-4 col-sm-4 col-xs-4" >  <a class="btn btn-primary btn-sm"  href="inv/create">
                <span class="glyphicon   glyphicon-plus" aria-hidden="true"></span>     新增</a></div>

        <div class="col-md-4 col-sm-4 col-xs-4">
        <a class="btn btn-warning btn-sm"  href="javascript:;" onclick="CloseBatch('inv')">
    <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
        关闭</a>
        </div>

           </div>
              </div>
    <div class="col-md-8 col-sm-8 col-xs-8 search">
    <form class="form-inline" action="inv/getList">
  <div class="form-group">
    <label for="fname">盘点方案名称</label>
    <input type="text" class="form-control" id="FName" name="FName" placeholder="" value=${model.fname }>
  </div>
  <button type="submit" class="btn btn-primary " >
  <span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询
</button>
</form>
    </div>


   </div>
   <table class="table table-bordered table-hover table-striped ">
  <thead class=thead>
  <tr>
  <th>
  <input type="checkbox"  class="check" id="checkall" onclick="checkall()">全选
  </th>
  <th >序号</th>
  <th >盘点方案名称</th>
  <th>日期</th>
  <th>状态</th>
  <th></th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${invList }" var="map" varStatus="st">
  <tr>
  <td>
    <input type="checkbox" name=check class="check" value=${map.fid}>
  </td>
 
  <td>${st.count }</td>
  <td>${map.fname }</td>
  <td>
${map.fdate }
  <td>

  <c:choose>
  <c:when test="${map.fstate==0 }">正常</c:when>
  <c:otherwise>关闭</c:otherwise>
  </c:choose>
  </td>
  <td>
   <button class="btn btn-primary btn-xs" onclick="location.href='inv/entry?ID=${map.fid}'">
        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查看</button>
        <c:if test="${invscheme_close=='invscheme_close' }">
        <button class="btn btn-warning btn-xs" id="delete" onclick="Close('Inv',${map.fid})">
       <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
       关闭</button>    </c:if>   
  </td>
  </tr>
  </c:forEach>
  </tbody>
</table>
<jsp:include page="../../page.jsp"></jsp:include>
   </div>
  </body>
</html>
