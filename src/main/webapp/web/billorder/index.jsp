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
	<script type="text/javascript" src="assets/pages/scripts/jquery.sticky.js"></script>
	<script type="text/javascript" src="assets/pages/scripts/jquery.ba-throttle-debounce.min.js"></script>

	<script type="text/javascript">

        $(document).ready(function() {

            showCondition("billorder",'${billorderlist }');
            if('${billorderlist }'.length==0)
            { initStartDate("sdate");
                initDate("edate");
                //initDate("sdate");
            }
        });
        $("#home", parent.document).removeClass("active");
        $("#link", parent.document).empty();
        $("#link", parent.document).addClass("active");
        $("#link", parent.document).text("采购订单信息管理");
	</script>
	<style type="text/css">
		.sticky-wrap {
			overflow-x: auto;
			position: relative;
			margin-bottom: 1.5em;
			width: 100%;
		}
		.sticky-wrap .sticky-thead,
		.sticky-wrap .sticky-col,
		.sticky-wrap .sticky-intersect {
			opacity: 0;
			position: absolute;
			top: 0;
			left: 0;
			transition: all .125s ease-in-out;
			z-index: 50;
			width: auto; /* Prevent table from stretching to full size */
		}
		.sticky-wrap .sticky-thead {
			box-shadow: 0 0.25em 0.1em -0.1em rgba(0,0,0,.125);
			z-index: 100;
			width: 100%; /* Force stretch */
		}
		.sticky-wrap .sticky-intersect {
			opacity: 1;
			z-index: 150;
		}
		.sticky-wrap .sticky-intersect th {
			background-color: #666;
			color: #eee;
		}
		.sticky-wrap td,
		.sticky-wrap th {
			box-sizing: border-box;
		}
	</style>
</head>

<body>
<jsp:include page="condition.jsp"></jsp:include>
<div class=container-fluid>

	<div class=title_index>
		&nbsp;采购订单信息管理
	</div>
	<div >
	<div class="row">

		<%--<div class="col-md-9 col-sm-9 col-xs-9" >
		</div>--%>
		<div class="col-md-7 col-sm-7 col-xs-7" >
			<form class="form-inline" action="billorder/getList">
				<div class="form-group">
					<label for="fnumber">单据编号</label>
					<input type="text" class="form-control" id="fnumber" name="fnumber" placeholder="" value=${model.fnumber }>
				</div>
				<div class="form-group">
					<label for="fsupplierid1" >供应商</label>

								<div class="input-group">
									<input  type="text" readonly  onfocus="clearBasics('fsupplierid')"  class="form-control" id="supplier1" name="suppliername"  placeholder="" value=${model.suppliername}>
									<input type="hidden" class="form-control" id="fsupplierid1" name=fsupplierid  placeholder="" value=${model.fsupplierid}>
									<span class="input-group-btn">
                                                <button class="btn btn-primary btn-sm"  type="button" onclick="showBasics('supplier','fsupplierid1','supplier1')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span>
							</div>

				</div>
				<input type="hidden" name="fstatus" value="-1"/>
				<button type="submit" class="btn btn-primary btn-sm ">
					<span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询
				</button>
			</form>
		</div>
		<div class="col-md-5 col-sm-5 col-xs-5 ">
			<div class="buttongroups">  <button class="btn btn-warning btn-sm"  onclick="$('#modal-container-137535').modal('show');">
				<span class="glyphicon glyphicon-import" aria-hidden="true"></span>导入</button>
			</div>
			<div class="buttongroups">

				<button class="btn btn-success btn-sm"  onclick="pushDown('billorder','order')">
					<span class="glyphicon   glyphicon-hand-down " aria-hidden="true"></span>关联生成</button>

			</div>
			<div class="buttongroups">  <button class="btn btn-info btn-sm"  onclick="filter('billorder')">
				<span class="glyphicon   glyphicon-filter" aria-hidden="true"></span>过滤</button>
			</div>
			<div class="buttongroups"> <a class="btn btn-danger btn-sm"  href="javascript:;" onclick="DeleteBatch('billorder')">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
			删除</a>
		</div>
		<%--<div class="col-md-2 col-sm-2 col-xs-2" ></div>--%>
				<div class="buttongroups" >  <a class="btn btn-primary btn-sm"  href="billorder/create">
					<span class="glyphicon   glyphicon-plus" aria-hidden="true"></span>     新增</a></div>





		</div>

	</div>
	</div>

	<div class="table-responsive" style="height: 70% !important;">

		<table class="table  table-hover table-bordered ">
			<thead >
			<tr>
				<%--<th  >
					&nbsp;&nbsp;   <input type="checkbox"  class="check" id="checkall" onclick="checkall()">整单
				</th>--%>
                <th  >&nbsp;<input type="checkbox"  class="check" id="checkall" onclick="checkall()">&nbsp;</th>

                <th  data-fixed="true">单据编号</th>

                <th >&nbsp;供应商&nbsp;</th>
               <%-- <th >&nbsp;&nbsp;客户&nbsp;&nbsp;</th>--%>
               <%-- <th >发货仓库</th>--%>
               <%-- <th >&nbsp;&nbsp;部门&nbsp;&nbsp;</th>--%>
               <%-- <th >&nbsp;行状态&nbsp;</th>--%>
                <th >物料编码</th>
                <th >物料名称</th>
                <th >单位</th>
                <th >数量</th>
                <th >收料数量</th>
                <th>未收料数量</th>
                <th >入库数量</th>
				<th >退料数量</th>
              <%--  <th >&nbsp;合同号&nbsp;</th>--%>
                <th >仓库</th>
				<th >制单人</th>
				<th >业务日期</th>
				<th >单据状态</th>
                <th ></th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${billorderlist }" var="map" varStatus="st">
				<c:set var="i" value="0" />
				<c:forEach items="${map.billorderentries}" var="entry" >

						<tr >
							<%--<c:if test="${i==0}">
								<td rowspan="${map.billorderentries.size()}">
									<input type="checkbox" name=check class="check" value=${map.fbillid}>
								</td>
							</c:if>--%>
							<td >
								<input type="checkbox" name=check class="push check" value='${map.fbillid},${entry.fid}'>
							</td>

					<c:if test="${i==0}">


						<td rowspan="${map.billorderentries.size()}">
							${map.fnumber}
						</td>

						<td rowspan="${map.billorderentries.size()}" id="supplier${map.fbillid}">
								${map.supplier.suppliername}
						</td>

						<%--<td rowspan="${map.billorderentries.size()}">
								${map.custom.customname}
						</td>
--%><%--
						<td rowspan="${map.billorderentries.size()}">
								${map.restock.fnumber}
						</td>--%>

						<%--<td rowspan="${map.billorderentries.size()}">
								${map.organization.organizationname}
						</td>--%>

					</c:if>
                            <%--<td >
                                <c:choose>
                                    <c:when test="${entry.fstate==0||entry.fstate==null}">未关闭</c:when>
                                    <c:when test="${entry.fstate==1}">关闭</c:when>

                                </c:choose>
                            </td>--%>
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
							<td>${entry.funreceiptqty}</td>

                            <td >
                                    ${entry.fstoredqty}
                            </td>
							<td >
									${entry.frefoundqty}
							</td>
						<%--	<td >
									${entry.fcontnum}
							</td>--%>
							<td >
									${entry.stock.fnumber}
							</td>
							<c:if test="${i==0}">
								<td rowspan="${map.billorderentries.size()}">
										${map.creator.username}
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

<c:choose>
	<c:when test="${msg!='' && msg!=null}">
		<script type="text/javascript">
            alert("${msg}");
		</script>
	</c:when>
<%--	<c:otherwise>
		<script type="text/javascript">
			alert("导入成功");
		</script>
	</c:otherwise>--%>
</c:choose>
<c:if test="${msg!='' && msg!=null}">

</c:if>


	<%--	<script type="">
			alert(${msg});
		</script>--%>
      <%--  <c:if test="${malist!=null}">
            <script type="text/javascript">
                $('#modal-container-137535').modal({backdrop: 'static', keyboard: false});
            </script>
        </c:if>--%>


<jsp:include page="orderimport.jsp"></jsp:include>
<jsp:include page="../shared/modal.jsp"></jsp:include>
</body>
</html>