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

		 showCondition("maboxprint",'${maboxprintList }');
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
  &nbsp;齐套二维码打印管理
   </div>
   <div class="row">
       <div class="col-md-6 col-sm-6 col-xs-6" >
           <form class="form-inline" action="maboxprint/getList">
               <div class="form-group">
                   <label for="fboxno">箱号</label>
                   <input type="text" class="form-control" id="fboxno" name="fboxno" placeholder="" value=${model.fboxno }>
               </div>
               <div class="form-group">
                   <label for="supplier">供货单位</label>
                   <div class="input-group">
                       <input  type="text"  onfocus="clearBasics('fsupplierid')"  class="form-control" id="supplier" name="suppliername"  placeholder="" value="${model.supplier.suppliername}">
                       <input type="hidden" class="form-control" id="fsupplierid" name=fsupplierid  placeholder="" value="${maboxprint.fsupplierid}">
                       <span class="input-group-btn">
         <button class="btn btn-primary btn-sm" type="button" onclick="showBasics('supplier','fsupplierid','supplier')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
                   </div>
               </div>


               <button type="submit" class="btn btn-primary btn-sm ">
                   <span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询
               </button>
           </form>
       </div>

       <div class="col-md-6 col-sm-6 col-xs-6" >
           <div class="buttongroups"> <a class="btn btn-warning btn-sm"  href="javascript:;" onclick="PrintqrCode('maboxprint')">
               <span class="glyphicon glyphicon-qrcode" aria-hidden="true"></span>
               打印</a>
           </div>
           <div class="buttongroups"> <a class="btn btn-danger btn-sm"  href="javascript:;" onclick="DeleteBatch('maboxprint')">
               <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
               删除</a>
           </div>
        <div class="buttongroups" >  <a class="btn btn-primary btn-sm"  href="maboxprint/create">
        <span class="glyphicon   glyphicon-plus" aria-hidden="true"></span>     新增</a></div>
     <%--   </c:if>
        <c:if test="${maboxprint_delete=='maboxprint_delete' }">--%>


      
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
   <th >箱号</th>
  <th >批号</th>
 <th>供货单位</th>
  <th></th>
  </tr>
  </thead>
  <tbody>

  <c:forEach items="${maboxprintlist }" var="map">
  <tr>
  <td>
    <input type="checkbox" name=check class="check" value=${map.fid}>
  </td>
  <td>${map.fbillno }</td>
  <td>${map.fboxno }</td>
  <td>${map.fbatch }</td>
      <td>${map.supplier.suppliername}</td>
  <td>
 <%-- <c:if test="${maboxprint_edit=='maboxprint_edit' }">--%>
   <button class="btn btn-success btn-xs" onclick="Edit('maboxprint',${map.fid})">
         <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑</button>
       <%--  </c:if>
         <c:if test="${maboxprint_delete=='maboxprint_delete' }">--%>
      <button class="btn btn-danger btn-xs" id="delete" onclick="Delete('maboxprint',${map.fid})">
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
       <c:if test="${isboxprint>0}">
           <jsp:include page="maprint.jsp"></jsp:include>
       </c:if>
   </div>
  </body>
</html>
