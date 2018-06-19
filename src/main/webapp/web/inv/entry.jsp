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
	<script type="text/javascript" src="assets/pages/scripts/tableExport.js"></script>
	<script type="text/javascript">
	function edit(ID,PID)
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
			 location.href="Basics/Inv/UpdateVsQty?FID="+ID+"&FVsQty="+$("#FQty"+ID).val()+"&FParentID="+PID;
			 }
	 }
	function exportExcel()
	{
		var date=new Date().format("yyyyMMddhhmmss");
		$('#data').tableExport({type: 'excel', escape: 'false',fileName:'盘点数据'+date});
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
   <div class=container-fluid>
   <h3 class=title_index>
盘点内容
   </h3>
   <div class="row">
    <div class="col-md-2">
      <%--  <div class=row>
        <c:if test="${invscheme_export=='invscheme_export' }">
        <div class="col-md-6 col-sm-6 col-xs-6"> <a class="btn btn-info" id="delete" href="javascript:;" onclick="exportExcel()">
    <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
        数据导出</a>
           </div>
      </c:if>  
    </div>--%>
   </div>
   </div>
   <br>
   <table class="table table-bordered table-hover table-striped " id=data width="90%">
  <thead class=thead>
  <tr>
 <!--  <th>
  <input type="checkbox"  class="check" id="checkall" onclick="checkall()">全选
  </th> -->
  <th >序号</th>
  <th >物料编码</th>
  <th>物料名称</th>
  <th>规格型号</th>
  <th>货位</th>
  <th>盘点数量</th>
 <%-- <th></th>--%>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${inventryList }" var="map" varStatus="st">
  <tr>
  
 
  <td>${st.count }</td>
  <td>${map.material.materialnumber }</td>
  <td>
${map.material.materialname }
  <td>
  ${map.material.materialmodel }
  </td>
   <td>${map.goodseat.fnumber}</td>
   <td>
   ${map.fqty }
  </td>
     <%-- <td></td>--%>
<%--   <td>
     <div class=e_show id="show${map.FID}">${map.FVsQty }</div>
   <div class=e_hidden id="hidden${map.FID}">
   <input type=number id="FQty${map.FID}" name=FQty class="form-control" value=${map.FVsQty }>
  </td>
  <td>${map.FInvQty }</td>
  <td>
  <c:if test="${invscheme_edit=='invscheme_edit' }">
  <button class="btn btn-primary btn-sm" id="edit${map.FID}" onclick="edit(${map.FID},${map.FParentID })" >
         <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑</button>
         </c:if>
  </td>--%>
  </tr>
  </c:forEach>
  </tbody>
</table>
   </div>
  </body>
</html>
