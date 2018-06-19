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
	<style type="text/css">
	table
	{
	table-layout: fixed;
	}
	.MHOVER
	{
	white-space: nowrap;
	text-overflow:ellipsis;
	overflow: hidden;

	}
	</style>
	<script type="text/javascript">
	$(document).ready(function()
	{
		$(".MALL").hide();
		$(".MHOVER").mouseover(function (e)
		{
			$(this).next(".MALL").css({"position":"absolute","top":e.pageY+5,"left":e.PageX+5}).show();
		}		
		);
		$(".MHOVER").mousemove(function (e)
				{
					$(this).next(".MALL").css({"color":"fff","position":"absolute","opacity":"0.8","background-color":"666","top":e.pageY+5,"left":e.PageX+5}).show();
				}		
				);
		$(".MHOVER").mouseout(function (e)
				{
			$(".MALL").hide();
				}		
				);
	}		
	);
	</script>
  </head>
  
  <body>
   <div class=container-fluid>
   <h3 class=title_index>
角色信息管理
   </h3>
       <div class="row">
           <div class="col-md-3 col-sm-3 col-xs-3" >
               <div class=row>
                   <%--  <c:if test="${role_add=='role_add' }">--%>
                   <div class="col-md-4 col-sm-4 col-xs-4" >  <a class="btn btn-primary btn-sm"  href="role/create">
                       <span class="glyphicon   glyphicon-plus" aria-hidden="true"></span>     新增</a></div>
                   <%--</c:if>
                   <c:if test="${role_delete=='role_delete' }">--%>
                   <div class="col-md-4 col-sm-4 col-xs-4"> <a class="btn btn-danger btn-sm"  href="javascript:;" onclick="DeleteBatch('role')">
                       <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                       删除</a>
                   </div>
                   <%--           </c:if>--%>
                   <%--        
                             <div class="col-md-4 col-sm-4 col-xs-4">  <a class="btn btn-info"  onclick="filter('role')" href="javascript:;">
                        <span class="glyphicon   glyphicon-filter" aria-hidden="true"></span>过滤</a>
                           </div> 
                        </div>--%>

               </div>
           </div>
           <div class="col-md-9 col-sm-9 col-xs-3">
               <form class="form-inline" action="role/getList">
                
                   <div class="form-group">
                       <label for="rolename">角色名称</label>
                       <input type="text" class="form-control" id="rolename" name="rolename" placeholder="" value=${model.rolename }>
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
  <th>
  <input type="checkbox"  class="check" id="checkall" onclick="checkall()">全选
  </th>
<!--   <th >序号</th> -->
  <th >角色名称</th>
  <th>权限</th>
  <th></th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${roleList }" var="map" varStatus="st">
  <tr>
  <td>
    <input type="checkbox" name=check class="check" value="${map.fid}">
  </td>
 
  <%-- <td>${st.count }</td> --%>
  <td>${map.rolename }</td>
  <td 	>
  <div class=MHOVER>
 <c:forEach items="${map.permissions }" var="r" varStatus="s">

${s.count }.${r.fname }
<%--  <c:if test="${s.count%4==0 }"><br></c:if> --%>
 </c:forEach>
 </div>
   <div class=MALL>
 <c:forEach items="${map.permissions }" var="r" varStatus="s">

${s.count }.${r.fname }
 <c:if test="${s.count%4==0 }"><br></c:if>
 </c:forEach>
 </div>
  <td>
    <%--<c:if test="${role_edit=='role_edit' }">--%>
   <button class="btn btn-primary btn-xs" onclick="Edit('role',${map.fid})">
        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 编辑</button>
       <%-- </c:if>
          <c:if test="${role_delete=='role_delete' }">--%>
      <button class="btn btn-danger btn-xs" id="delete" onclick="Delete('role',${map.fid})">
      <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>  删除</button>
    <%--  </c:if>
        <c:if test="${role_permit=='role_permit' }">--%>
         <button class="btn btn-warning btn-xs"  onclick="auth(${map.fid})">
      <span class="glyphicon glyphicon-leaf" aria-hidden="true"></span>  分配权限</button>   
      <%--</c:if>   --%>
  </td>
  </tr>
  </c:forEach>
  </tbody>
</table>
<jsp:include page="../../page.jsp"></jsp:include>
   </div>
  </body>
</html>
