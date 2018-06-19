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
	<jsp:include page="../basics/shared/resource.jsp"></jsp:include>
	<script type="text/javascript">
	
	 $(document).ready(function() {
		 showCondition("inv",'${invrList }'); 
		 if('${invrList }'.length==0)
		 { initDate("sdate");
		 initDate("edate");}
		
	 });
	 function edit(ID)
	 {
		 var text=$("#edit"+ID).text();
		
		 if(text.trim()=='编辑')
			 {
			 //alert(text);
			 $("#show"+ID).removeClass("e_show").addClass("e_hidden");
			 $("#hidden"+ID).removeClass("e_hidden").addClass("e_show");
			// $("#edit span").removeClass("glyphicon-pencil").addClass("glyphicon-ok");
			 $("#edit"+ID).html("<span class='glyphicon glyphicon-ok' aria-hidden='true'></span>保存");
			 }
		 else
			 {
			 location.href="Basics/Inv/UpdateInvQty?FID="+ID+"&FQty="+$("#FQty"+ID).val();
			 }
	 }
	</script>
	<style type="text/css">
	.e_show
	{
	display: block;
	
	}
	.e_hidden
	{
	display:none;
	
	}
	</style>
  </head>
  
  <body>
  <jsp:include page="shared/condition.jsp"></jsp:include>
    <jsp:include page="shared/modal.jsp"></jsp:include>
   <div class=container-fluid>
   <h3 class=title_index>
盘点记录信息管理
   </h3>
    <div class="row">
       <div class="col-md-3 col-sm-3 col-xs-3" >
        <div class=row>
      <c:if test="${invr_delete=='invr_delete' }">
             <div class="col-md-4 col-sm-4 col-xs-4"> <a class="btn btn-danger" id="delete" href="javascript:;" onclick="DeleteBatch('Inv')">
    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
        删除</a>
           </div>
           </c:if>
             <div class="col-md-4 col-sm-4 col-xs-4">  <a class="btn btn-info"  onclick="filter('inv')" href="javascript:;">
        <span class="glyphicon   glyphicon-filter" aria-hidden="true"></span>过滤</a>
           </div> 
        </div>
      
    </div>
   </div> 
   <br>
   <table class="table table-bordered table-hover table-striped ">
  <thead class=thead>
  <tr>
  <th>
  <input type="checkbox"  class="check" id="checkall" onclick="checkall()">全选
  </th>
  <th>盘点方案</th>
  <th >物料编码</th>
  <th >物料名称</th>
  <th >规格型号/图号</th>
  <th>货位</th>
  <th >库房</th>
 <th>批号</th>
    <th >装机平台</th>
 <th>入库时间</th>
  <th >数量</th> 
  <th></th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${invrList }" var="map">
  <tr>
 <td>
    <input type="checkbox" name=check class="check" value=${map.FID}>
  </td>
 <td>${map.FScheme }</td>
  <td>${map.material.FNumber }</td>
  <td >${map.material.FName }</td>
  <td >${map.material.FModel }</td>
  <td>${map.goodsSeat.FNumber }</td>
  <td>${map.stock.FName }</td>
   <td>${map.FBatchNo }</td>
  <td>${map.FPlatform }</td>
 <td>${map.FSdate }</td>
   <td>
   <div class=e_show id="show${map.FID}">${map.FQty }</div>
   <div class=e_hidden id="hidden${map.FID}">
   <input type=number id="FQty${map.FID}" name=FQty class="form-control" value=${map.FQty }>
   </div>
   </td>
   <td>
    <c:if test="${invr_edit=='invr_edit' }">
   <button class="btn btn-primary btn-sm" id="edit${map.FID}" onclick="edit(${map.FID})" >
         <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑</button>
         </c:if>
          <c:if test="${invr_delete=='invr_delete' }">
      <button class="btn btn-danger btn-sm" id="delete" onclick="Delete('Inv',${map.FID})">
        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>  删除</button>
        </c:if>
          
  </td>
  </tr>
  </c:forEach>
  </tbody>
</table>
<jsp:include page="../page.jsp"></jsp:include>

   </div>
    <div class="modal fade" id="FItemIDmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">物料信息列表</h4>
      </div>
      <div class="modal-body">
        <table class="table table-bordered table-hover table-striped" id="FItemIDtable">
        <thead>
        <tr>
         <th >物料编码</th>
  <th >物料名称</th>
    <th >规格型号</th>
  <th >计量单位</th>
 
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${materialList }" var="map">
  <tr ondblclick="basicCheck('FItemID','Material','${map.FItemID}','${map.FName }')">
 <td>${map.FNumber }</td>
  <td>${map.FName }</td>
 
  <td>${map.FModel }</td>
  <td>${map.FUnit }</td>
  </tr>
  </c:forEach>
        </tbody>
        </table>
      </div>
    
    </div>
  </div>
</div>

<div class="modal fade" id="FGoodSeatIDmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">货位信息列表</h4>
      </div>
      <div class="modal-body">
        <table class="table table-bordered table-hover table-striped" id=FGoodSeatIDtable>
        <thead>
        <tr>
        <th>货位编码</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${goodsSeatList }" var="map">
  <tr ondblclick="basicCheck('FGoodSeatID','GoodsSeat','${map.FID}','${map.FNumber }')">
  <td>${map.FNumber }</td>
  
  </tr>
  </c:forEach>
        </tbody>
        </table>
      </div>
    
    </div>
  </div>
</div>

<div class="modal fade" id="FStockIDmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">库房信息列表</h4>
      </div>
      <div class="modal-body">
        <table class="table table-bordered table-hover  table-striped" id=FStockIDtable>
        <thead>
        <tr>
        <th >库房编号</th>
        <th >库房名称</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${stockList }" var="map">
  <tr ondblclick="basicCheck('FStockID','Stock','${map.FID}','${map.FName }')">
  <td>${map.FNumber }</td>
  <%-- <td>${map.FErpNumber }</td> --%>
  <td>${map.FName }</td>
 <%--   <td>${map.FErpName }</td>
  <td>${map.FDepart }</td> --%>
  </tr>
  </c:forEach>
        </tbody>
        </table>
      </div>
   
    </div>
  </div>
</div>
  </body>
</html>
