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
/*
	 $(document).ready(function() {
		 showCondition("icStockBill",'${icStockBillList }'); 
		 if('${icStockBillList }'.length==0)
		 { initDate("sdate");
		 initDate("edate");}
		
	 });*/
	</script>
  </head>
  
  <body>
  <jsp:include page="condition.jsp"></jsp:include>
    <jsp:include page="../shared/modal.jsp"></jsp:include>
   <div class=container-fluid>
   <h3 class=title_index>
&nbsp;异常出入库信息管理
   </h3>
       <div class="row">

           <div class="col-md-9 col-sm-9 col-xs-9" >
               <form class="form-inline" action="icstockbill/getList">
                   <div class="form-group">
                       <label for="FNumber">单据编号</label>
                       <input type="text" class="form-control" id="FNumber" name="FNumber" placeholder="" value=${model.FNumber }>
                   </div>


                   <button type="submit" class="btn btn-primary btn-sm ">
                       <span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询
                   </button>
               </form>
           </div>
           <div class="col-md-3 col-sm-3 col-xs-3" >

               <div class="buttongroups">  <button class="btn btn-info btn-sm"  onclick="filter('icstockbill')">
                   <span class="glyphicon   glyphicon-filter" aria-hidden="true"></span>过滤</button>
               </div>
               <div class="buttongroups"> <a class="btn btn-danger btn-sm"  href="javascript:;" onclick="DeleteBatch('icstockbill')">
                   <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                   删除</a>
               </div>
               <div class="buttongroups" >  <a class="btn btn-primary btn-sm"  href="icstockbill/create">
                   <span class="glyphicon   glyphicon-plus" aria-hidden="true"></span>     新增</a></div>




           </div>

       </div>
<div class="table-responsive">
   <table class="table table-bordered table-hover table-striped ">
  <thead class=thead>
  <tr>
      <th  >
          &nbsp;<input type="checkbox"  class="check" id="checkall" onclick="checkall()">&nbsp;
      </th>
      <th>单据编号</th>
  <th>出入库类型</th>
  <th >物料编码</th>
  <th >物料名称</th>
  <th >计量单位</th>
  <th>货位</th>
  <th >库房</th>
 
  <th >数量</th> 
<th></th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${icstockbilllist }" var="map">
  <tr>
      <td >
          &nbsp;<input type="checkbox" name=check class="check" value=${map.FID}>&nbsp;
      </td>
      <td>${map.FNumber}</td>
<td>
<c:choose>
<c:when test="${map.FBillType==0 }">异常入库</c:when>
<c:otherwise>异常出库</c:otherwise>
</c:choose>
</td>
 
 <td>${map.material.materialnumber }</td>
  <td >${map.material.materialname }</td>
           <td >${map.material.materialunit }</td>
           <td>${map.goodseat.fnumber }</td>
           <td>${map.stock.fnumber }</td>
            <td>${map.FQty }</td>
      <td>
          <button class="btn btn-success btn-xs" onclick="Edit('icstockbill',${map.FID})">
              <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 编辑</button>
          <button class="btn btn-danger btn-xs" id="delete" onclick="Delete('icstockbill',${map.FID})">
              <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> 删除</button>

      </td>
  </tr>
  </c:forEach>
  </tbody>
</table>
</div>
<jsp:include page="../../page.jsp"></jsp:include>

   </div>

  </body>
</html>
