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
		showCondition("inventory", '${inventorymalist }');
		/*if ('<%--${inventorylist }--%>'.length == 0) {
            initStartDate("sdate");
            initDate("edate");
		}*/

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
    $("#home", parent.document).removeClass("active");
    $("#link", parent.document).empty();
    $("#link", parent.document).addClass("active");
    $("#link", parent.document).text("即时库存信息管理");
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
		<div class=title_index>&nbsp;即时库存信息管理</div>
		<div class="row">


					<div class="col-md-6 col-sm-6 col-xs-6">
						<form class="form-inline" action="inventory/getMaList">
							<div class="form-group">
								<label for="fmaid1" >物料</label>

											<div class="input-group">
												<input  type="text" readonly onfocus="clearBasics('fmaid1')"  class="form-control" id="material1" name="materialname"  placeholder="" value=${model.materialname}>
												<input type="hidden" class="form-control" id="fmaid1" name=fmaid  placeholder="" value=${model.fmaid}>
												<span class="input-group-btn">
                                                <button class="btn btn-primary btn-sm"  type="button" onclick="showBasics('ma','fmaid1','material1')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span></div>

								</div>


							<div class="form-group">
								<label for="fstate2" >库存状态</label>

								<select class="form-control" id="fstate2" name="fstate" >
									<option value="zj">质检</option>
									<option value="hg">合格</option>
									<option value="rk">入库</option>
								</select>

								<script type="text/javascript">
                                    $("#fstate2").val("${model.fstate}");
								</script>
							</div>
			<button type="submit" class="btn btn-primary btn-sm ">
				<span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询
			</button>

						</form>
					</div>
					<div class="col-md-6 col-sm-6 col-xs-6">


						<div class="buttongroups" >
							<a class="btn btn-info btn-sm" onclick="location.href='inventory/getMgList'"
							   href="javascript:;"> <span
									class="glyphicon   glyphicon-leaf" aria-hidden="true"></span>按物料货位汇总
							</a>
						</div>
						<div class="buttongroups" >
							<a class="btn btn-info btn-sm" onclick="location.href='inventory/getList'"
							   href="javascript:;"> <span
									class="glyphicon   glyphicon-leaf" aria-hidden="true"></span>即时库存明细
							</a>
						</div>
						<div class="buttongroups" >
							<a class="btn btn-success btn-sm" onclick="location.href='inventory/getMaExportList'"
							   href="javascript:;"> <span
									class="glyphicon   glyphicon-export" aria-hidden="true"></span>导出
							</a>
						</div>

						<div class="buttongroups" >
						<a class="btn btn-info btn-sm" onclick="filter('inventory')"
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

		<div class="table-responsive">
	<c:choose>
		<c:when test="${model.fstate=='rk'}">
			<table class="table table-bordered table-hover table-striped ">
				<thead class=thead>
				<tr>

					<th>物料编码</th>
					<th>物料名称</th>
					<th>单位</th>
						<%--<th>货位</th>
                        <th>仓库</th>
                          <th>批号</th>
                         <th>入库日期</th>
                        <th>生产日期</th>
                        <th>保质期</th>--%>
					<th>数量</th>
					<th></th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${inventorymalist }" var="map">
					<tr>


						<td>${map.material.materialnumber }</td>
						<td>${map.material.materialname }</td>
						<td>${map.material.materialunit }</td>

						<td>
								${map.fqty}
						</td>
							<%-- <td>${map.FSdate }</td> --%>
							<%--<td><div class=e_show id="show${map.FID}">${map.FQty }</div>
                                <div class=e_hidden id="hidden${map.FID}">
                                    <input type=number id="FQty${map.FID}" name=FQty
                                        class="form-control" value=${map.FQty }>
                                </div></td>--%>
						<td>
							<button class="btn btn-primary btn-xs"
									onclick="location.href='inventory/getInventoryDetail?materialnumber=${map.material.materialnumber}'">
								<span class="glyphicon glyphicon-search" aria-hidden="true"></span>库存明细
							</button>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<table class="table table-bordered table-hover table-striped ">
				<thead class=thead>
				<tr>

					<th>物料编码</th>
					<th>物料名称</th>
					<th>单位</th>
						<%--<th>货位</th>
                        <th>仓库</th>
                          <th>批号</th>
                         <th>入库日期</th>
                        <th>生产日期</th>
                        <th>保质期</th>--%>
					<th>数量</th>

				</tr>
				</thead>
				<tbody>
				<c:forEach items="${inventorymalist }" var="map">
					<tr>


						<td>${map.materialNumber }</td>
						<td>${map.materialName }</td>
						<td>${map.materialUnit }</td>

						<td>
								${map.fqty}
						</td>
							<%-- <td>${map.FSdate }</td> --%>
							<%--<td><div class=e_show id="show${map.FID}">${map.FQty }</div>
                                <div class=e_hidden id="hidden${map.FID}">
                                    <input type=number id="FQty${map.FID}" name=FQty
                                        class="form-control" value=${map.FQty }>
                                </div></td>--%>

					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
		</div>
		<jsp:include page="../../page.jsp"></jsp:include>

	</div>
	<jsp:include page="condition.jsp"></jsp:include>
	<jsp:include page="../../web/shared/modal.jsp"></jsp:include>
</body>
</html>
