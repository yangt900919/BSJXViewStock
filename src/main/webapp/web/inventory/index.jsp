<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
		showCondition("inventory", '${inventorylist }');
		if ('${inventorylist }'.length == 0) {
            initStartDate("sdate");
            initDate("edate");
		}

	});
	function edit(ID) {
		var text = $("#edit" + ID).text();
		var fqty = $("#FQty" + ID).val();
		
		if (text.trim() == '编辑') {
			//alert(text);
			$("#show" + ID).removeClass("e_show").addClass("e_hidden");
			$("#hidden" + ID).removeClass("e_hidden").addClass("e_show");
			// $("#edit span").removeClass("glyphicon-pencil").addClass("glyphicon-ok");
			$("#edit" + ID)
					.html(
							"<span class='glyphicon glyphicon-ok' aria-hidden='true'></span>保存");
		} else {
			if(fqty >= 0 ){
				location.href = "Inventory/UpdateQty?FID=" + ID + "&FQty="
				+ $("#FQty" + ID).val();
			}else{
				alert("数量不能小于0");
			}
			
			
			

			
			
		}
	}
	function exportData() {
		$("#inform").attr('action', "Inventory/Export"); //通过jquery为action属性赋值
		$("#inform").submit();
	}
</script>
<style type="text/css">
.e_show {
	display: block;
}

.e_hidden {
	display: none;
}
</style>
</head>

<body>

	<div class=container-fluid>
		<h3 class=title_index>即时库存信息管理</h3>
		<div class="row">
			<div class=col-md-2>
				<div class=row>
					<div class="col-md-4 col-sm-4 col-xs-4">
						<a class="btn btn-info" onclick="filter('inventory')"
							href="javascript:;"> <span
							class="glyphicon   glyphicon-filter" aria-hidden="true"></span>过滤
						</a>
					</div>
				<%--	<c:if test="${invscheme_export=='invscheme_export' }">
						<div class="col-md-4 col-sm-4 col-xs-4">
							<a class="btn btn-info" id="delete" href="javascript:;"
								onclick="exportData()"> <span
								class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
								数据导出
							</a>
						</div>
					</c:if>
				</div>--%>
			</div>
		</div>
		</div>
		<br>
		<div class="table-responsive">
		<table class="table table-bordered table-hover table-striped ">
			<thead class=thead>
				<tr>

					<th>物料编码</th>
					<th>物料名称</th>
					<th>规格型号</th>
					<th>货位</th>
					<th>仓库</th>
					  <th>批号</th>
					 <th>入库日期</th>
					<th>生产日期</th>
					<th>保质期</th>
					<th>数量</th>
				<%--	<th></th>--%>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${inventorylist }" var="map">
					<tr>


						<td>${map.material.materialnumber }</td>
						<td>${map.material.materialname }</td>
						<td>${map.material.materialmodel }</td>
						<td>${map.goodseat.fnumber }</td>
						<td>${map.stock.stockname }</td>
						   <td>${map.fbatch }</td>
						<td>
							<fmt:formatDate value="${map.fdate}" pattern="yyyy-MM-dd"></fmt:formatDate>
						</td>
						<td>
							<fmt:formatDate value="${map.fmdate}" pattern="yyyy-MM-dd"></fmt:formatDate>
						</td>
						<td>${map.fgperiod}</td>
						<td>
							${map.fqty}
						</td>
						<%-- <td>${map.FSdate }</td> --%>
						<%--<td><div class=e_show id="show${map.FID}">${map.FQty }</div>
							<div class=e_hidden id="hidden${map.FID}">
								<input type=number id="FQty${map.FID}" name=FQty
									class="form-control" value=${map.FQty }>
							</div></td>--%>
						<%--<td>&lt;%&ndash;<c:if test="${inventory_edit=='inventory_edit' }">&ndash;%&gt;
								<button class="btn btn-primary btn-sm" id="edit${map.FID}"
									onclick="edit(${map.FID})">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑
								</button>
							</c:if></td>--%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
		<jsp:include page="../../page.jsp"></jsp:include>

	</div>
	<jsp:include page="condition.jsp"></jsp:include>
	<jsp:include page="../../web/shared/modal.jsp"></jsp:include>
</body>
</html>
