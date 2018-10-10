
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
	<jsp:include page="../../web/shared/resource.jsp"></jsp:include>
	<script type="text/javascript">

        $(document).ready(function() {

            showCondition("organization",'${organizationList }');
        });

	</script>
</head>

<body>

<div class=container-fluid>
	<div class=title_index>
		&nbsp;ERP仓库信息管理
	</div>

	<div class="row">

		<div class="col-md-10 col-sm-10 col-xs-10">
			<form class="form-inline" action="erpstock/getList" method="post">
				<div class="form-group">
					<label for="ERP仓库编码">ERP仓库编码</label>
					<input type="text" class="form-control" id="fnumber" name="fnumber" placeholder="" value=${model.fnumber }>
				</div>
				<div class="form-group">
					<label for="ERP仓库名称">ERP仓库名称</label>
					<input type="text" class="form-control" id="fname" name="fname" placeholder="" value=${model.fname }>
				</div>
				<button type="submit" class="btn btn-primary btn-sm ">
					<span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询
				</button>
			</form>
		</div>
		<div class="col-md-2 col-sm-2 col-xs-2" >

			<div class="buttongroups"> <a class="btn btn-danger btn-sm"  href="javascript:;" onclick="DeleteBatch('erpstock')">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
				删除</a>
			</div>
				<div class="buttongroups" >  <a class="btn btn-primary btn-sm"  href="erpstock/create">
					<span class="glyphicon   glyphicon-plus" aria-hidden="true"></span>     新增</a></div>
			</div>


	</div>

	<div class="table-responsive">
		<table class="table table-bordered table-hover  table-striped ">
			<thead >
			<tr>
				<th>
					<input type="checkbox"  class="check" id="checkall" onclick="checkall()">全选
				</th>
				<th >ERP仓库编码</th>
				<th >ERP仓库名称</th>
				<th >仓库</th>
				<th></th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${erpstocklist }" var="map">
				<tr>
					<td>
						<input type="checkbox" name=check class="check" value=${map.fid}>
					</td>
					<td>${map.fnumber }</td>
					<td>${map.fname }</td>
					<td>${map.stock.stockname }</td>
					<td>
						<button class="btn btn-success btn-xs" onclick="Edit('erpstock',${map.fid})">
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 编辑</button>
						<button class="btn btn-danger btn-xs" id="delete" onclick="Delete('erpstock',${map.fid})">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> 删除</button>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<jsp:include page="../../page.jsp"></jsp:include>
</div>


</body>
</html>
