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
		showCondition("dataoperatelog", '${dataoperateloglist }');
		if ('${dataoperateloglist }'.length == 0) {
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
    $("#home", parent.document).removeClass("active");
    $("#link", parent.document).empty();
    $("#link", parent.document).addClass("active");
    $("#link", parent.document).text("操作记录信息管理");
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
		<div class=title_index>&nbsp;资料操作记录信息管理</div>
		<div class="row">


			<div class="col-md-11 col-sm-11 col-xs-11">
				<form class="form-inline" action="dataoperatelog/getList">

					<div class="form-group">
						<label for="fnumer" >入库/领料单据编码</label>

									<input type="text" class="form-control" id="fnumer" name="fnumer"  value=${model.fnumer }>

					</div>

					<div class="form-group">
						<label for="fmaid" >物料</label>

						<div class="input-group">
							<input  type="text" readonly onfocus="clearBasics('fmaid1')"  class="form-control" id="material1" name="materialname"  placeholder="" value=${model.materialname}>
							<input type="hidden" class="form-control" id="fmaid1" name=fmaid  placeholder="" value=${model.fmaid}>
							<span class="input-group-btn">
                                                <button class="btn btn-primary btn-sm"  type="button" onclick="showBasics('ma','fmaid1','material1')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span></div>

					</div>


					<button type="submit" class="btn btn-primary btn-sm ">
						<span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询
					</button>

				</form>
			</div>
			<div class="col-md-1 col-sm-1 col-xs-1">
				<div class="buttongroups"><a class="btn btn-info btn-sm" onclick="filter('dataoperatelog')"
				   href="javascript:;"> <span
						class="glyphicon   glyphicon-filter" aria-hidden="true"></span>过滤
				</a></div>

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
		<table class="table table-bordered table-hover table-striped ">
			<thead class=thead>
				<tr>

					<th >入库/领料单单据编号</th>
					<th >操作人</th>
					<th >操作时间</th>
					<th>单据类型</th>
					<th >物料编码</th>
					<th>物料名称</th>
					<th >计量单位</th>
					<%--<th>上/下架数量</th>
					<th >已上/下架数量</th>--%>
					<th >仓库</th>
					<th>资料位置</th>
					<%--<th>生产日期</th>
					<th>保质期</th>
					<th>批号</th>--%>
				<%--	<th >源单编号</th>--%>
				<%--	<th></th>--%>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${dataoperateloglist }" var="map">
					<tr>


						<td>${map.fnumer }</td>
						<td>${map.fuser }</td>
						<td>	<fmt:formatDate value="${map.fdate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
						<td>${map.ftype}</td>
						<td>${map.material.materialnumber }</td>
						   <td>${map.material.materialname }</td>
						<td>
						${map.material.materialunit}
						</td>
						<%--<td>
							${map.fqty}
						</td>
						<td>${map.facqty}</td>--%>

						<td>${map.ferpstock}</td>
						<td>${map.fdataseat}</td>
						<td>	<fmt:formatDate value="${map.fmdate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
						<td>
                            <c:if test="${map.fgperiod!=null && map.fgperiod>0 }">
                              ${map.fgperiod}
                            </c:if>
                        </td>
						<td>${map.fbatch}</td>
					<%--	<td>${map.fsrc_number}</td>--%>
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
