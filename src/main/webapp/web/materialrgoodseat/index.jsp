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

		 showCondition("materialrgoodseat",'${materialrgoodseatlist }');
	 });
     $("#home", parent.document).removeClass("active");
     $("#link", parent.document).empty();
     $("#link", parent.document).addClass("active");
     $("#link", parent.document).text("物料-货位信息管理");
	</script>
  </head>
  
  <body>
   <jsp:include page="condition.jsp"></jsp:include>
   <div class=container-fluid>
   <div class=title_index>
   &nbsp;物料-货位信息管理
   </div>
  <div class="row">
      <div class="col-md-9 col-sm-9 col-xs-9" ></div>
       <div class="col-md-3 col-sm-3 col-xs-3" >

             <div class="buttongroups">  <a class="btn btn-info  btn-sm"  onclick="filter('materialrgoodseat')" href="javascript:;">
        <span class="glyphicon   glyphicon-filter" aria-hidden="true"></span>过滤</a>
           </div>
           <div class="buttongroups"> <a class="btn btn-danger  btn-sm"  href="javascript:;" onclick="DeleteBatch('materialrgoodseat')">
               <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
               删除</a>
           </div>
           <div class="buttongroups" >  <a class="btn btn-primary btn-sm"  href="materialrgoodseat/create">
               <span class="glyphicon   glyphicon-plus" aria-hidden="true"></span>     新增</a></div>
    </div>
   </div> 
<br>
       <div class="table-responsive">
   <table class="table table-bordered table-hover table-striped ">
  <thead >
  <tr>
  <th>
      &nbsp;<input type="checkbox"  class="check" id="checkall" onclick="checkall()"> &nbsp;
  </th>
  <th >物料编码</th>
  <th >物料名称</th>
<%--  <th >规格型号</th>--%>
  <th >货位</th>
  <th>备注</th>
  <th></th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${materialrgoodseatlist }" var="map">
  <tr>
  <td>
    <input type="checkbox" name=check class="check" value=${map.fid}>
  </td>

  <td>${map.material.materialnumber }</td>
    <td class=wrap>${map.material.materialname }</td>
<%--  <td class=wrap>${map.material.FModel }</td>--%>
    <td>${map.goodseat.fnumber }</td>
    <td>${map.fremark }</td>
  <td>

   <button class="btn btn-success btn-xs" onclick="Edit('materialrgoodseat',${map.fid})">
        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 编辑</button>

     <%--   <c:if test="${mags_delete=='mags_delete' }">--%>
      <button class="btn btn-danger btn-xs" id="delete" onclick="Delete('materialrgoodseat',${map.fid})">
      <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>  删除</button>
    <%--  </c:if>
      <c:if test="${mags_adjust=='mags_adjust' }">--%>
    <%--  <button class="btn btn-warning btn-sm"  onclick="adjust(${map.fid})">
      <span class="glyphicon glyphicon-leaf" aria-hidden="true"></span>  货位调整</button>    
      </c:if>--%>
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
