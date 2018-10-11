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
	<%--<link rel="stylesheet" type="text/css" href=" assets/pages/css/bill.css" />--%>
	<script type="application/javascript" src="assets/pages/scripts/bill.js"></script>
	<script type="text/javascript">

        $(document).ready(function() {

            showCondition("billget",'${billgetlist }');
            if('${billgetlist }'.length==0)
            { initStartDate("sdate");
                initDate("edate");}
        });
        $("#home", parent.document).removeClass("active");
        $("#link", parent.document).empty();
        $("#link", parent.document).addClass("active");
        $("#link", parent.document).text("出库单信息管理");
	</script>
</head>

<body>
<jsp:include page="condition.jsp"></jsp:include>
<div class=container-fluid>
	<div class=title_index>
		&nbsp;出库单信息管理
	</div>
	<div >
	<div class="row">

		<div class="col-md-9 col-sm-9 col-xs-9" >
			<form class="form-inline" action="billget/getList">
				<div class="form-group">
					<label for="fnumber">单据编号</label>
					<input type="text" class="form-control" id="fnumber" name="fnumber" placeholder="" value=${model.fnumber }>
				</div>

				<div class="form-group">
					<label for="fdepartmentid1" >领料单位</label>

							<div class="input-group">
								<input readonly type="text"  onfocus="clearBasics('fdepartmentid1')"  class="form-control" id="organization1" name="organizationname"  placeholder="" value=${billget.organization.organizationname}>
								<input type="hidden" class="form-control" id="fdepartmentid1" name=fdepartmentid  placeholder="" value=${billget.fdepartmentid}>
								<span class="input-group-btn">
         <button class="btn btn-primary btn-sm" ${disabled} type="button" onclick="showBasics('depart','fdepartmentid1','organization1')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>

					</div>
				</div>

				<div class="form-group">
					<label for="fcustomid1" >客户</label>

								<div class="input-group">
									<input readonly type="text"  onfocus="clearBasics('fcustomid1')"  class="form-control" id="custom1" name="customname"  placeholder="" value=${model.customname}>
									<input type="hidden" class="form-control" id="fcustomid1" name=fcustomid  placeholder="" value=${model.fcustomid}>
									<span class="input-group-btn">
                                                <button class="btn btn-primary btn-sm"  type="button" onclick="showBasics('custom','fcustomid1','custom1')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span></div>



				</div>

				<input type="hidden" name="fstate" value="-1"/>
				<button type="submit" class="btn btn-primary btn-sm ">
					<span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询
				</button>
			</form>
		</div>
		<div class="col-md-3 col-sm-3 col-xs-3" >

			<div class="buttongroups">  <button class="btn btn-info btn-sm"  onclick="filter('billget')">
				<span class="glyphicon   glyphicon-filter" aria-hidden="true"></span>过滤</button>
			</div>
			<div class="buttongroups"> <a class="btn btn-danger btn-sm"  href="javascript:;" onclick="DeleteBatch('billget')">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
				删除</a>
			</div>
			<div class="buttongroups" >  <a class="btn btn-primary btn-sm"  href="billget/create">
					<span class="glyphicon   glyphicon-plus" aria-hidden="true"></span>     新增</a></div>



		</div>

	</div>
	</div>

	<div class="table-responsive" style="height: 70% !important;">
		<table class="table  table-hover table-bordered ">
			<thead >
			<tr>
				<th>
					&nbsp;<input type="checkbox"  class="check" id="checkall" onclick="checkall()">&nbsp;
				</th>
				<th >单据编号</th>

				<th>领料单位</th>
				<th>客户</th>
				<th>物料编码</th>
				<th>物料名称</th>
				<th>单位</th>

				<th>申请数量</th>
				<th>实发数量</th>
				<th >发料仓库</th>
				<th >业务日期</th>
				<th>单据状态</th>

				<th>发料人</th>
				<th></th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${billgetlist }" var="map" varStatus="st">
				<c:set var="i" value="0" />
				<c:forEach items="${map.billgetentries}" var="entry" >

						<tr >
							<td >
								<input type="checkbox" name=check class="check" value=${map.fid}>
							</td>
					<c:if test="${i==0}">


						<td rowspan="${map.billgetentries.size()}">
							${map.fnumber}
						</td>

						<td rowspan="${map.billgetentries.size()}">
								${map.organization.organizationname}
						</td>
						<td rowspan="${map.billgetentries.size()}">
								${map.custom.customname}
						</td>
						<%--<td rowspan="${map.billgetentries.size()}">
								${map.stock.fnumber}
						</td>--%>

					</c:if>
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
									${entry.fapplyqty}
							</td>
							<td >
									${entry.frealqty}
							</td>
							<td >
									${entry.estock.fnumber}
							</td>
							<c:if test="${i==0}">
								<td rowspan="${map.billgetentries.size()}">
									<fmt:formatDate value="${map.fdodate}" pattern="yyyy-MM-dd"></fmt:formatDate>
								</td>
								<td rowspan="${map.billgetentries.size()}" id="fstate${map.fid}">
									<c:choose>
										<c:when test="${map.fstate==0}">保存</c:when>
										<c:otherwise>审核</c:otherwise>
									</c:choose>
								</td>
								<td rowspan="${map.billgetentries.size()}">
										${map.getuser.username}
								</td>
								<td rowspan="${map.billgetentries.size()}">
									<button class="btn btn-success btn-xs" onclick="Edit('billget',${map.fid})">
										<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 编辑</button>
									<button class="btn btn-danger btn-xs " id="delete" onclick="Delete('billget',${map.fid})">
										<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>  删除</button>
									<button class="btn btn-warning btn-xs "  onclick="Audit('billget',${map.fid})">
										<span class="glyphicon glyphicon-check" aria-hidden="true"></span>  审核</button>
									<button class="btn btn-danger btn-xs "  onclick="unAudit('billget',${map.fid})">
										<span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span>  反审核</button>
								</td>
							</c:if>
							<c:set var="i" value="${i+1}" />
							<%--<c:if test="${i==map.billgetentries.size()-1}">
								<c:set var="i" value="0" />
							</c:if>--%>
						</tr>

				</c:forEach>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<jsp:include page="../../page.jsp"></jsp:include>
<jsp:include page="../shared/modal.jsp"></jsp:include>

</body>
</html>