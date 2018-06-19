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
	<link rel="stylesheet" type="text/css" href=" assets/pages/css/bill.css" />
	<script type="application/javascript" src="assets/pages/scripts/bill.js"></script>

	<script type="text/javascript">

        $(document).ready(function() {

            showCondition("billorder",'${billorderlist }');
            if('${billorderlist }'.length==0)
            { initStartDate("sdate");
                initDate("edate");}
        });
	</script>
</head>

<body>

<div class=container-fluid>
	<h3 class=title_index>
		采购订单信息管理
	</h3>
	<div >
	<div class="row">

		<%--<div class="col-md-9 col-sm-9 col-xs-9" >
		</div>--%>
		<div class="col-md-8 col-sm-8 col-xs-7" >
			<div class=row>

				<div class="col-md-2 col-sm-2 col-xs-2" >  <a class="btn btn-primary btn-sm"  href="billorder/create">
					<span class="glyphicon   glyphicon-plus" aria-hidden="true"></span>     新增</a></div>
				<div class="col-md-2 col-sm-2 col-xs-2"> <a class="btn btn-danger btn-sm"  href="javascript:;" onclick="DeleteBatch('billorder')">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					删除</a>
				</div>
				<div class="col-md-2 col-sm-2 col-xs-2">  <button class="btn btn-info btn-sm"  onclick="filter('billorder')">
					<span class="glyphicon   glyphicon-filter" aria-hidden="true"></span>过滤</button>
				</div>
				<div class="col-md-2 col-sm-2 col-xs-2">

					<button class="btn btn-success btn-sm"  onclick="pushDown('billorder','order')">
					<span class="glyphicon   glyphicon-hand-down " aria-hidden="true"></span>下推</button>
				<%--	<div class="btn-group">
					<button type="button" class="btn btn-success btn-sm dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<span class="glyphicon   glyphicon-hand-down"></span>下推 <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="1">收货通知请捡单</a></li>
					&lt;%&ndash;	<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Separated link</a></li>&ndash;%&gt;
					</ul></div>--%>

					<!-- Single button -->
					<%--<div class="btn-group open">
						<button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">Success <span class="caret"></span></button><div class="dropdown-backdrop"></div>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul>
					</div>--%>
				</div>
				<div class="col-md-2 col-sm-2 col-xs-2">  <button class="btn btn-warning btn-sm"  onclick="$('#modal-container-137535').modal({backdrop: 'static', keyboard: false});">
					<span class="glyphicon glyphicon-import" aria-hidden="true"></span>导入</button>
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

                <th  >&nbsp;&nbsp;分录选择&nbsp;&nbsp;</th>
                <th  >
					&nbsp;&nbsp;   <input type="checkbox"  class="check" id="checkall" onclick="checkall()">单据选择(全选)&nbsp;&nbsp;
                </th>
                <th  data-fixed="true">单据编号</th>
                <th >业务日期</th>
                <th >单据状态</th>
                <th >&nbsp;供应商&nbsp;</th>
                <th >&nbsp;&nbsp;客户&nbsp;&nbsp;</th>
                <th >发货仓库</th>
                <th >&nbsp;&nbsp;部门&nbsp;&nbsp;</th>
                <th >&nbsp;行状态&nbsp;</th>
                <th >物料编码</th>
                <th >物料名称</th>
                <th >计量单位</th>
                <th >&nbsp;&nbsp;数量&nbsp;&nbsp;</th>
                <th >收料数量</th>
                <th >退料数量</th>
                <th >入库数量</th>
                <th >&nbsp;合同号&nbsp;</th>
                <th >&nbsp;&nbsp;仓库&nbsp;&nbsp;</th>
                <th ></th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${billorderlist }" var="map" varStatus="st">
				<c:set var="i" value="0" />
				<c:forEach items="${map.billorderentries}" var="entry" >

						<tr >
							<td >
								<input type="checkbox" name=push class="push" value='${map.fbillid},${entry.fid}'>
							</td>

					<c:if test="${i==0}">

						<td rowspan="${map.billorderentries.size()}">
							<input type="checkbox" name=check class="check" value=${map.fbillid}>
						</td>
						<td rowspan="${map.billorderentries.size()}">
							${map.fnumber}
						</td>
						<td rowspan="${map.billorderentries.size()}">
								<fmt:formatDate value="${map.fbizdate}" pattern="yyyy-MM-dd"></fmt:formatDate>
						</td>
						<td rowspan="${map.billorderentries.size()}" id="fstate${map.fbillid}">
								<c:choose>
									<c:when test="${map.fstatus==0}">保存</c:when>
									<c:when test="${map.fstatus==1}">审核</c:when>

								</c:choose>
						</td>
						<td rowspan="${map.billorderentries.size()}" id="supplier${map.fbillid}">
								${map.supplier.suppliername}
						</td>

						<td rowspan="${map.billorderentries.size()}">
								${map.custom.customname}
						</td>

						<td rowspan="${map.billorderentries.size()}">
								${map.restock.stockname}
						</td>

						<td rowspan="${map.billorderentries.size()}">
								${map.organization.organizationname}
						</td>

					</c:if>
                            <td >
                                <c:choose>
                                    <c:when test="${entry.fstate==0||entry.fstate==null}">未关闭</c:when>
                                    <c:when test="${entry.fstate==1}">关闭</c:when>

                                </c:choose>
                            </td>
							<td >
									${entry.material.materialnumber}
							</td>
							<td >
									${entry.material.materialname}
							</td>
							<td >
									${entry.material.materialunit}
							</td>
							<td >
									${entry.fqty}
							</td>
							<td >
									${entry.freceiptqty}
							</td>
							<td >
									${entry.frefoundqty}
							</td>
                            <td >
                                    ${entry.fstoredqty}
                            </td>
							<td >
									${entry.fcontnum}
							</td>
							<td >
									${entry.stock.stockname}
							</td>
							<c:if test="${i==0}">

								<td rowspan="${map.billorderentries.size()}">
									<button class="btn btn-success btn-xs" onclick="Edit('billorder',${map.fbillid})">
										<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 编辑</button>
									<button class="btn btn-danger btn-xs " id="delete" onclick="Delete('billorder',${map.fbillid})">
										<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>  删除</button>
									<button class="btn btn-warning btn-xs "  onclick="Audit('billorder',${map.fbillid})">
										<span class="glyphicon glyphicon-check" aria-hidden="true"></span>  审核</button>

									<button class="btn btn-danger btn-xs "  onclick="unAudit('billorder',${map.fbillid})">
										<span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span>  反审核</button>

								</td>
							</c:if>
							<c:set var="i" value="${i+1}" />
							<%--<c:if test="${i==map.billorderentries.size()-1}">
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
<jsp:include page="orderimport.jsp"></jsp:include>
</body>
</html>