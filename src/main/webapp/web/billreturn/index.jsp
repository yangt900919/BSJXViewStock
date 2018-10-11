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

            showCondition("billreturn",'${billreturnlist }');
            if('${billreturnlist }'.length==0)
            { initStartDate("sdate");
                initDate("edate");}
        });
        $("#home", parent.document).removeClass("active");
        $("#link", parent.document).empty();
        $("#link", parent.document).addClass("active");
        $("#link", parent.document).text("退换货单信息管理");
	</script>
</head>

<body>
<jsp:include page="condition.jsp"></jsp:include>
<div class=container-fluid>
	<div class=title_index>
		&nbsp;退换货单信息管理
	</div>
	<div >
	<div class="row">

		<div class="col-md-9 col-sm-9 col-xs-9" >
			<form class="form-inline" action="billreturn/getList">
				<div class="form-group">
					<label for="fnumber">单据编号</label>
					<input type="text" class="form-control" id="fnumber" name="fnumber" placeholder="" value=${model.fnumber }>
				</div>


				<input type="hidden" name="fstate" value="-1"/>
				<button type="submit" class="btn btn-primary btn-sm ">
					<span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询
				</button>
			</form>
		</div>
		<div class="col-md-3 col-sm-3 col-xs-3" >


			<div class="buttongroups" >  <button class="btn btn-info btn-sm"  onclick="filter('billreturn')">
				<span class="glyphicon   glyphicon-filter" aria-hidden="true"></span>过滤</button>
			</div>
			<div class="buttongroups" > <a class="btn btn-danger btn-sm"  href="javascript:;" onclick="DeleteBatch('billreturn')">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
				删除</a>
			</div>
				<div class="buttongroups" >  <a class="btn btn-primary btn-sm"  href="billreturn/create">
					<span class="glyphicon   glyphicon-plus" aria-hidden="true"></span>     新增</a></div>




		</div>

	</div>
	</div>

	<div class="table-responsive" style="height: 70% !important;">

		<table class="table  table-hover           table-bordered ">
			<thead >
			<tr>

               <%-- <th  >&nbsp;&nbsp;分录选择&nbsp;&nbsp;</th>--%>
                <th  >
					&nbsp;<input type="checkbox"  class="check" id="checkall" onclick="checkall()">&nbsp;
                </th>
                <th  data-fixed="true">单据编号</th>
                <th >业务日期</th>
                <th >单据状态</th>
                <th >&nbsp;供应商&nbsp;</th>
           <%--     <th >&nbsp;&nbsp;客户&nbsp;&nbsp;</th>
                <th >发货仓库</th>
                <th >&nbsp;&nbsp;部门&nbsp;&nbsp;</th>--%>
           
                <th >物料编码</th>
                <th >物料名称</th>
                <th >计量单位</th>
                <th >&nbsp;&nbsp;申请数量&nbsp;&nbsp;</th>
                <th >数量</th>
                <th >&nbsp;&nbsp;仓库&nbsp;&nbsp;</th>
                <th ></th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${billreturnlist }" var="map" varStatus="st">
				<c:set var="i" value="0" />
				<c:forEach items="${map.billreturnentries}" var="entry" >

						<tr >
							<td >
								<input type="checkbox" name=check class="check" value=${map.fid}>
							</td>
					<c:if test="${i==0}">


						<td rowspan="${map.billreturnentries.size()}">
							${map.fnumber}
						</td>
						<td rowspan="${map.billreturnentries.size()}">
								<fmt:formatDate value="${map.fbizdate}" pattern="yyyy-MM-dd"></fmt:formatDate>
						</td>
						<td rowspan="${map.billreturnentries.size()}" ">
								<c:choose>
									<c:when test="${map.fstate==0}">保存</c:when>
									<c:when test="${map.fstate==1}">审核</c:when>

								</c:choose>
						</td>
						<td rowspan="${map.billreturnentries.size()}" id="supplier${map.fid}">
								${map.supplier.suppliername}
						</td>


					</c:if>
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
									${entry.freqty}
							</td>
							<td >
									${entry.fqty}
							</td>
						
							<td >
									${entry.stock.fnumber}
							</td>
							<c:if test="${i==0}">

								<td rowspan="${map.billreturnentries.size()}">
									<button class="btn btn-success btn-xs" onclick="Edit('billreturn',${map.fid})">
										<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 编辑</button>
									<button class="btn btn-danger btn-xs " id="delete" onclick="Delete('billreturn',${map.fid})">
										<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>  删除</button>
									<button class="btn btn-warning btn-xs "  onclick="Audit('billreturn',${map.fid})">
										<span class="glyphicon glyphicon-check" aria-hidden="true"></span>  审核</button>

									<button class="btn btn-danger btn-xs "  onclick="unAudit('billreturn',${map.fid})">
										<span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span>  反审核</button>

								</td>
							</c:if>
							<c:set var="i" value="${i+1}" />
							<%--<c:if test="${i==map.billreturnentries.size()-1}">
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
<jsp:include page="../shared/modal.jsp"></jsp:include>

</body>
</html>