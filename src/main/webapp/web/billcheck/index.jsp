<!-- xingli 2018-3-9 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">

	<title>My JSP 'condition.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<jsp:include page="../../web/shared/resource.jsp"></jsp:include>
	<script type="application/javascript" src="assets/pages/scripts/bill.js"></script>
	<script type="text/javascript">

        $(document).ready(function() {

            showCondition("billcheck",'${billchecklist }');
            if('${billchecklist }'.length==0)
            { initStartDate("sdate");
                initDate("edate");}
        });
	</script>
</head>

<body>

<div class=container-fluid>
	<h3 class=title_index>
		收货通知请检单信息管理
	</h3>
	<div >
	<div class="row">

		<%--<div class="col-md-9 col-sm-9 col-xs-9" >
		</div>--%>
		<div class="col-md-7 col-sm-7 col-xs-8" >
			<div class=row>

				<div class="col-md-2 col-sm-2 col-xs-2" >  <a class="btn btn-primary btn-sm"  href="billcheck/create">
					<span class="glyphicon   glyphicon-plus" aria-hidden="true"></span>     新增</a></div>
				<div class="col-md-2 col-sm-2 col-xs-2"> <a class="btn btn-danger btn-sm"  href="javascript:;" onclick="DeleteBatch('billcheck')">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					删除</a>
				</div>
				<div class="col-md-2 col-sm-2 col-xs-2">  <button class="btn btn-info btn-sm"  onclick="filter('billcheck')">
					<span class="glyphicon   glyphicon-filter" aria-hidden="true"></span>过滤</button>
				</div>
				<div class="col-md-2 col-sm-2 col-xs-2">

					<button class="btn btn-success btn-sm"  onclick="pushDown('billcheck','check')">
						<span class="glyphicon   glyphicon-hand-down " aria-hidden="true"></span>下推</button>
				</div>
				<div class="col-md-2 col-sm-2 col-xs-2"> <a class="btn btn-warning btn-sm"  href="javascript:;" onclick="BiiPrint('billcheck')">
					<span class="glyphicon glyphicon-qrcode" aria-hidden="true"></span>
					打印</a>
				</div>
			</div>

		</div>

	</div>
	</div>
		<hr>
	<div class="table-responsive">
		<table class="table  table-hover table-bordered ">
			<thead >
			<tr>
				<th>&nbsp;&nbsp;分录选择&nbsp;&nbsp;</th>
				<th>
					&nbsp;&nbsp;<input type="checkbox"  class="check" id="checkall" onclick="checkall()">单据选择(全选)&nbsp;&nbsp;
				</th>
				<th >单据编号</th>
				<th >业务日期</th>
				<th>单据状态</th>
				<th >供应商</th>
				<th>箱号</th>
				<%--<th>是否是齐套</th>--%>
				<th>物料编码</th>
				<th>物料名称</th>
				<th>计量单位</th>
				<th>收料数量</th>
				<th>合格数量</th>
				<th>不合格数量</th>
				<th>收料仓库</th>
				<th></th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${billchecklist }" var="map" varStatus="st">
				<c:set var="i" value="0" />
				<c:forEach items="${map.billcheckentries}" var="entry" >

						<tr >
							<td >
								<input type="checkbox" name=push class="push" value='${map.fid},${entry.fid}'>
							</td>

							<c:if test="${i==0}">
							<td rowspan="${map.billcheckentries.size()}">
								<input type="checkbox" name=check class="check" value=${map.fid}>
							</td>

						<td rowspan="${map.billcheckentries.size()}">
							${map.fnumber}
						</td>
						<td rowspan="${map.billcheckentries.size()}">
							<fmt:formatDate value="${map.fbizdate}" pattern="yyyy-MM-dd"></fmt:formatDate>
						</td>
						<td rowspan="${map.billcheckentries.size()}" id="fstate${map.fid}">
                          <%--  ${map.fstatus}--%>
								<c:choose>
									<c:when test="${map.fstatus==0}">保存</c:when>
									<c:when test="${map.fstatus==1}">审核</c:when>
                                    <c:when test="${map.fstatus==2}">检验</c:when>
								</c:choose>
						</td>
						<td rowspan="${map.billcheckentries.size()}">
								${map.supplier.suppliername}
						</td>
								<td rowspan="${map.billcheckentries.size()}">
										${map.fboxno}
								</td>

					</c:if>
							<td >
									${entry.fMaterial.materialnumber}
							</td>
							<td >
									${entry.fMaterial.materialname}
							</td>
							<td >
									${entry.fMaterial.materialunit}
							</td>
							<td >
									${entry.fqty}
							</td>
							<td >
									${entry.feligqty}
							</td>
							<td >
									${entry.funqty}
							</td>
							<td >
									${entry.fStock.stockname}
							</td>
							<c:if test="${i==0}">

								<td rowspan="${map.billcheckentries.size()}">
									<button class="btn btn-success btn-xs" onclick="Edit('billcheck',${map.fid})">
										<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 编辑</button>
									<button class="btn btn-danger btn-xs " id="delete" onclick="Delete('billcheck',${map.fid})">
										<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>  删除</button>
									<button class="btn btn-warning btn-xs "  onclick="Audit('billcheck',${map.fid})">
										<span class="glyphicon glyphicon-check" aria-hidden="true"></span>  审核</button>
									<button class="btn btn-danger btn-xs "  onclick="unAudit('billcheck',${map.fid})">
										<span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span>  反审核</button>

								</td>
							</c:if>
							<c:set var="i" value="${i+1}" />
							<%--<c:if test="${i==map.billcheckentries.size()-1}">
								<c:set var="i" value="0" />
							</c:if>--%>
						</tr>

				</c:forEach>
			</c:forEach>
			</tbody>
		</table>
	</div>
		<jsp:include page="../../page.jsp"></jsp:include>
	</div>
<jsp:include page="condition.jsp"></jsp:include>
<c:if test="${isprint>0}">
	<jsp:include page="maprint.jsp"></jsp:include>
</c:if>
</body>
</html>