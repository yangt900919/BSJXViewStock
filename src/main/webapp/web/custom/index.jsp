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
	<jsp:include page="../../web/shared/resource.jsp"></jsp:include>
	<script type="text/javascript">
	
	 $(document).ready(function() {

		 showCondition("custom",'${customList }'); 
	 });
     $("#home", parent.document).removeClass("active");
     $("#link", parent.document).empty();
     $("#link", parent.document).addClass("active");
     $("#link", parent.document).text("客户信息管理");
	</script>
  </head>
  
  <body>

   <div class=container-fluid>
   <div class=title_index>
  &nbsp;客户信息管理
   </div>
    <div class="row">

        <div class="col-md-9 col-sm-9 col-xs-9">
            <form class="form-inline" action="custom/getList">
                <div class="form-group">
                    <label for="customnumber">客户编码</label>
                    <input type="text" class="form-control" id="customnumber" name="customnumber" placeholder="" value=${model.customnumber }>
                </div>
                <div class="form-group">
                    <label for="customname">客户名称</label>
                    <input type="text" class="form-control" id="customname" name="customname" placeholder="" value=${model.customname }>
                </div>
          

                <button type="submit" class="btn btn-primary btn-sm ">
                    <span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询
                </button>
            </form>
        </div>
        <div class="col-md-3 col-sm-3 col-xs-3" >

            <div class="buttongroups"> <a class="btn btn-danger btn-sm"  href="javascript:;" onclick="DeleteBatch('custom')">
                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                删除</a>
            </div>
                <%--  <c:if test="${custom_add=='custom_add' }">--%>
                <div class="buttongroups" >  <a class="btn btn-primary btn-sm"  href="custom/create">
                    <span class="glyphicon   glyphicon-plus" aria-hidden="true"></span>     新增</a></div>
                <%--</c:if>
                <c:if test="${custom_delete=='custom_delete' }">--%>

                <%--           </c:if>--%>
                <%--
                          <div class="col-md-4 col-sm-4 col-xs-4">  <a class="btn btn-info"  onclick="filter('custom')" href="javascript:;">
                     <span class="glyphicon   glyphicon-filter" aria-hidden="true"></span>过滤</a>
                        </div>
                     </div>--%>


        </div>
    </div>

       <div class="table-responsive">
   <table class="table table-bordered table-hover  table-striped ">
  <thead class=thead>
  <tr>
  <th>
      &nbsp;<input type="checkbox"  class="check" id="checkall" onclick="checkall()"> &nbsp;
  </th>
  <th >客户编码</th>
  <th >客户名称</th>
 
  <th></th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${customList }" var="map">
  <tr>
  <td>
    <input type="checkbox" name=check class="check" value=${map.fid}>
  </td>
  <td>${map.customnumber }</td>
  <td>${map.customname }</td>
  <%--<td>${map.frows }</td>
    <td>${map.fcolumns }</td>
  <td>${map.fremark }</td>--%>
  <td>
 <%-- <c:if test="${custom_edit=='custom_edit' }">--%>
   <button class="btn btn-success btn-xs" onclick="Edit('custom',${map.fid})">
         <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>  编辑</button>
    <%--     </c:if>
         <c:if test="${custom_delete=='custom_delete' }">--%>
      <button class="btn btn-danger btn-xs" id="delete" onclick="Delete('custom',${map.fid})">
        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>  删除</button>
<%--        </c:if>--%>
          
  </td>
  </tr>
  </c:forEach>
  </tbody>
</table>
       </div>
<jsp:include page="../../page.jsp"></jsp:include>
       <jsp:include page="../../web/shared/modal.jsp"></jsp:include>
   </div>
  </body>
</html>
