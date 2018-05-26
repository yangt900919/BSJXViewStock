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

		 showCondition("material",'${materialList }'); 
	 });
	</script>
  </head>
  
  <body>

   <div class=container-fluid>
   <h3 class=title_index>
  物料信息管理
   </h3>
    <div class="row">
       <div class="col-md-3 col-sm-3 col-xs-3" >
        <div class=row>
    <%--  <c:if test="${material_add=='material_add' }">--%>
        <div class="col-md-4 col-sm-4 col-xs-4" >  <a class="btn btn-primary btn-sm"  href="material/create">
        <span class="glyphicon   glyphicon-plus" aria-hidden="true"></span>     新增</a></div>
        <%--</c:if>
        <c:if test="${material_delete=='material_delete' }">--%>
             <div class="col-md-4 col-sm-4 col-xs-4"> <a class="btn btn-danger btn-sm"  href="javascript:;" onclick="DeleteBatch('material')">
    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
        删除</a>
           </div>
<%--           </c:if>--%>
   <%--        
             <div class="col-md-4 col-sm-4 col-xs-4">  <a class="btn btn-info"  onclick="filter('material')" href="javascript:;">
        <span class="glyphicon   glyphicon-filter" aria-hidden="true"></span>过滤</a>
           </div> 
        </div>--%>
      
    </div>
   </div>
        <div class="col-md-9 col-sm-9 col-xs-3">
            <form class="form-inline" action="material/getList">
                <div class="form-group">
                    <label for="materialnumber">物料编码</label>
                    <input type="text" class="form-control" id="materialnumber" name="materialnumber" placeholder="" value=${model.materialnumber }>
                </div>
                <div class="form-group">
                    <label for="materialname">物料名称</label>
                    <input type="text" class="form-control" id="materialname" name="materialname" placeholder="" value=${model.materialname }>
                </div>
          

                <button type="submit" class="btn btn-primary btn-sm ">
                    <span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询
                </button>
            </form>
        </div>
    </div>
   <br>
   <table class="table table-bordered table-hover  table-striped ">
  <thead class=thead>
  <tr>
  <th>
  <input type="checkbox"  class="check" id="checkall" onclick="checkall()">全选
  </th>
  <th >物料编码</th>
  <th >物料名称</th>
  <th >规格型号</th>
   <th>计量单位</th> 
  <%--<th>备注</th>--%>
  <th></th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${materialList }" var="map">
  <tr>
  <td>
    <input type="checkbox" name=check class="check" value=${map.fid}>
  </td>
  <td>${map.materialnumber }</td>
  <td>${map.materialname }</td>
  <td>${map.materialmodel }</td>
    <td>${map.materialunit }</td>
 <%-- <td>${map. }</td>--%>
  <td>
 <%-- <c:if test="${material_edit=='material_edit' }">--%>
   <button class="btn btn-success btn-xs" onclick="Edit('material',${map.fid})">
         <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>  编辑</button>
    <%--     </c:if>
         <c:if test="${material_delete=='material_delete' }">--%>
      <button class="btn btn-danger btn-xs" id="delete" onclick="Delete('material',${map.fid})">
        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>  删除</button>
<%--        </c:if>--%>
          
  </td>
  </tr>
  </c:forEach>
  </tbody>
</table>
<jsp:include page="../../page.jsp"></jsp:include>
       <jsp:include page="../../web/shared/modal.jsp"></jsp:include>
   </div>
  </body>
</html>
