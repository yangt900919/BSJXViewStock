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
  用户信息信息管理
   </h3>
       <div class="row">
           <div class="col-md-3 col-sm-3 col-xs-3" >
               <div class=row>
                   <%--  <c:if test="${user_add=='user_add' }">--%>
                   <div class="col-md-4 col-sm-4 col-xs-4" >  <a class="btn btn-primary btn-sm"  href="user/create">
                       <span class="glyphicon   glyphicon-plus" aria-hidden="true"></span>     新增</a></div>
                   <%--</c:if>
                   <c:if test="${user_delete=='user_delete' }">--%>
                   <div class="col-md-4 col-sm-4 col-xs-4"> <a class="btn btn-danger btn-sm"  href="javascript:;" onclick="DeleteBatch('user')">
                       <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                       删除</a>
                   </div>
                   <%--           </c:if>--%>
                   <%--        
                             <div class="col-md-4 col-sm-4 col-xs-4">  <a class="btn btn-info"  onclick="filter('user')" href="javascript:;">
                        <span class="glyphicon   glyphicon-filter" aria-hidden="true"></span>过滤</a>
                           </div> 
                        </div>--%>

               </div>
           </div>
           <div class="col-md-9 col-sm-9 col-xs-3">
               <form class="form-inline" action="user/getList">

                   <div class="form-group">
                       <label for="username">用户名</label>
                       <input type="text" class="form-control" id="username" name="username" placeholder="" value=${model.username }>
                   </div>


                   <button type="submit" class="btn btn-primary btn-sm ">
                       <span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询
                   </button>
               </form>
           </div>
       </div>
       <br>
   <table class="table table-bordered table-hover table-striped ">
  <thead class=thead>
  <tr>
  <!-- <th>
  <input type="checkbox"  class="check" id="checkall" onclick="checkall()">全选
  </th> -->
   <th >序号</th>
  <th >用户名</th>
  <th>用户角色</th>
  <th></th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${userList }" var="map" varStatus="st">
  <tr>
  <!-- <td>
    <input type="checkbox" name=check class="check" value=${map.fid}>
  </td> -->
 
  <td>${st.count }</td>
  <td>${map.username }</td>
 <td>
 <c:forEach items="${map.roles }" var="r" varStatus="s">
${s.count }.${r.rolename }
 </c:forEach>

 </td>
  <td>
      <button class="btn btn-primary btn-xs" onclick="Edit('user',${map.fid})">
          <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 编辑</button>
          <%-- </c:if>
             <c:if test="${role_delete=='role_delete' }">--%>
      <button class="btn btn-danger btn-xs" id="delete" onclick="Delete('user',${map.fid})">
          <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>  删除</button>
          <%--  </c:if>
              <c:if test="${role_permit=='role_permit' }">--%>
      <button class="btn btn-warning btn-xs"  onclick="bindrole(${map.fid})">
          <span class="glyphicon glyphicon-leaf" aria-hidden="true"></span>  分配角色</button>

      <button class="btn btn-warning btn-xs"  onclick="initpsw(${map.fid})">
          <span class="glyphicon glyphicon-leaf" aria-hidden="true"></span>  密码初始化</button>

  </td>
  </tr>
  </c:forEach>
  </tbody>
</table>
<jsp:include page="../../page.jsp"></jsp:include>
   </div>
  </body>
</html>
