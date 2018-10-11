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
      <script type="text/javascript">
          $("#home", parent.document).removeClass("active");
          $("#link", parent.document).empty();
          $("#link", parent.document).addClass("active");
          $("#link", parent.document).text("盘点内容");
      </script>
  </head>
  
  <body>
   <div class=container-fluid>
   <div class=title_index>
&nbsp;盘点内容
   </div>
   <div class="row">
       <div class="col-md-11 col-sm-11 col-xs-11">
       </div>
       <div class="col-md-1 col-sm-1 col-xs-1" >
           <div class="buttongroups" >
               <a class="btn btn-success btn-sm" onclick="location.href='inventory/getExportList'"
                  href="javascript:;"> <span
                       class="glyphicon   glyphicon-export" aria-hidden="true"></span>导出
               </a>
           </div>


       </div>
   </div>
   <br>
       <div class="table-responsive">
   <table class="table table-bordered table-hover table-striped " id=data width="90%">
  <thead class=thead>
  <tr>
 <!--  <th>
  <input type="checkbox"  class="check" id="checkall" onclick="checkall()">全选
  </th> -->
  <th >序号</th>
  <th >物料编码</th>
  <th>物料名称</th>
  <th>单位</th>
  <th>货位</th>
  <th>盘点数量</th>
  <th>即时库存</th>
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
      <td>${map.finvqty}</td>
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
   </div>
  </body>
</html>
