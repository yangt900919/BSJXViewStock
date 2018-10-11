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

		 showCondition("maprint",'${maprintList }');
         pageNow=${page.pageNow};
	 });

     $("#home", parent.document).removeClass("active");
     $("#link", parent.document).empty();
     $("#link", parent.document).addClass("active");
     $("#link", parent.document).text("物料二维码打印管理");
	</script>
  </head>
  
  <body>
<%--  <jsp:include page="condition.jsp"></jsp:include>--%>
   <div class=container-fluid>
   <div class=title_index>
  &nbsp;物料二维码打印管理
   </div>
   <div class="row">
       <div class="col-md-6 col-sm-6 col-xs-6">
           <form class="form-inline" action="maprint/getList">
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
       <div class="col-md-6 col-sm-6 col-xs-6" >
           <div class="buttongroups"> <a class="btn btn-warning btn-sm"  href="javascript:;" onclick="PrintqrCode('maprint')">
               <span class="glyphicon glyphicon-qrcode" aria-hidden="true"></span>
               打印</a>
           </div>
           <div class="buttongroups"> <a class="btn btn-danger btn-sm"  href="javascript:;" onclick="DeleteBatch('maprint')">
               <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
               删除</a>
           </div>
        <div class="buttongroups" >  <a class="btn btn-primary btn-sm"  href="maprint/create">
        <span class="glyphicon   glyphicon-plus" aria-hidden="true"></span>     新增</a></div>
     <%--   </c:if>
        <c:if test="${maprint_delete=='maprint_delete' }">--%>


      

   </div>

   </div>

       <div class="table-responsive">
   <table class="table table-bordered table-hover  ">
  <thead class=thead>
  <tr>
  <th>
      &nbsp;<input type="checkbox"  class="check" id="checkall" onclick="checkall()"> &nbsp;
  </th>

  <th >编号</th>
   <th >物料编码</th>
  <th >物料名称</th>
<%--  <th >规格型号</th>--%>
  <th >批号</th>
  <th >保质期</th>
  <th >生产日期</th>
  <th>到货单位</th>
  <th>合格数量</th>
 <th>供货单位</th>
  <th></th>
  </tr>
  </thead>
  <tbody>

  <c:forEach items="${maprintlist }" var="map">
  <tr>
  <td>
    <input type="checkbox" name=check class="check" value=${map.fid}>
  </td>
  <td>${map.fbillno }</td>
  <td>${map.material.materialnumber }</td>
  <td>${map.material.materialname }</td>
 <%-- <td>${map.material.materialmodel }</td>--%>
  <td>${map.fbatch }</td>
  <td>${map.fgperiod }</td>
  <td>${map.fmdate }</td>
  <td>${map.fadate }</td>
  <td>${map.fquqty }</td>
      <td>${map.supplier.suppliername}</td>
  <td>
 <%-- <c:if test="${maprint_edit=='maprint_edit' }">--%>
   <button class="btn btn-success btn-xs" onclick="Edit('maprint',${map.fid})">
         <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑</button>
       <%--  </c:if>
         <c:if test="${maprint_delete=='maprint_delete' }">--%>
      <button class="btn btn-danger btn-xs" id="delete" onclick="Delete('maprint',${map.fid})">
       <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> 删除</button>
    <%--   </c:if>--%>
          
  </td>
  </tr>
  </c:forEach>
  </tbody>
</table>
       </div>

<jsp:include page="../../page.jsp"></jsp:include>
       <jsp:include page="../../web/shared/modal.jsp"></jsp:include>
       <c:if test="${isprint>0}">
           <jsp:include page="maprint.jsp"></jsp:include>
       </c:if>
   </div>
  </body>
</html>
