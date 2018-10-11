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

		 showCondition("datacabinettype",'${datacabinettypeList }'); 
	 });
     $("#home", parent.document).removeClass("active");
     $("#link", parent.document).empty();
     $("#link", parent.document).addClass("active");
     $("#link", parent.document).text("资料柜类型信息管理");
	</script>
  </head>
  
  <body>

   <div class=container-fluid>
   <div class=title_index>
   &nbsp;资料柜类型信息管理
   </div>
    <div class="row">
        <div class="col-md-6 col-sm-6 col-xs-6">
            <form class="form-inline" action="datacabinettype/getList">
                <div class="form-group">
                    <label for="fnumber">资料柜类型编码</label>
                    <input type="text" class="form-control" id="fnumber" name="fnumber" placeholder="" value=${model.fnumber }>
                </div>
                <div class="form-group">
                    <label for="fname">资料柜类型名称</label>
                    <input type="text" class="form-control" id="fname" name="fname" placeholder="" value=${model.fname }>
                </div>


                <button type="submit" class="btn btn-primary btn-sm ">
                    <span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询
                </button>
            </form>
        </div>
       <div class="col-md-6 col-sm-6 col-xs-6" >
           <div class="buttongroups"> <a class="btn btn-danger btn-sm"  href="javascript:;" onclick="DeleteBatch('datacabinettype')">
               <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
               删除</a>
           </div>
            <div class="buttongroups" >  <a class="btn btn-primary btn-sm"  href="datacabinettype/create">
        <span class="glyphicon   glyphicon-plus" aria-hidden="true"></span>     新增</a></div>
        <%--</c:if>
        <c:if test="${datacabinettype_delete=='datacabinettype_delete' }">--%>

<%--           </c:if>--%>
   <%--        
             <div class="col-md-4 col-sm-4 col-xs-4">  <a class="btn btn-info"  onclick="filter('datacabinettype')" href="javascript:;">
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
  <th >资料柜类型编码</th>
  <th >资料柜类型名称</th>
  <th >行数</th>
   <th>列数</th> 
  <th>备注</th>
  <th></th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${cabinetTypeList }" var="map">
  <tr>
  <td>
    <input type="checkbox" name=check class="check" value=${map.fid}>
  </td>
  <td>${map.fnumber }</td>
  <td>${map.fname }</td>
  <td>${map.frows }</td>
    <td>${map.fcolumns }</td>
  <td>${map.fremark }</td>
  <td>
 <%-- <c:if test="${datacabinettype_edit=='datacabinettype_edit' }">--%>
   <button class="btn btn-success btn-xs" onclick="Edit('datacabinettype',${map.fid})">
         <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>  编辑</button>
    <%--     </c:if>
         <c:if test="${datacabinettype_delete=='datacabinettype_delete' }">--%>
      <button class="btn btn-danger btn-xs" id="delete" onclick="Delete('datacabinettype',${map.fid})">
        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>  删除</button>
<%--        </c:if>--%>
          
  </td>
  </tr>
  </c:forEach>
  </tbody>
   </table></div>
<jsp:include page="../../page.jsp"></jsp:include>
       <jsp:include page="../../web/shared/modal.jsp"></jsp:include>
   </div>
  </body>
</html>
