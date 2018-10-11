<%--
<!-- xingli 2018-3-9 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<jsp:include page="../../web/shared/resource.jsp"></jsp:include>
	<script type="text/javascript">

        $(document).ready(function() {

            showCondition("stock",'${stockList }');
        });
        $("#home", parent.document).removeClass("active");
        $("#link", parent.document).empty();
        $("#link", parent.document).addClass("active");
        $("#link", parent.document).text("仓库信息管理");
	</script>
</head>

<body>
<div class=container-fluid>
	<div class=title_index>
		&nbsp;仓库信息管理
	</div>

	<div class="row">

		&lt;%&ndash;<div class="col-md-9 col-sm-9 col-xs-9" >
		</div>&ndash;%&gt;

		<div class="col-md-9 col-sm-9 col-xs-9">
			<form class="form-inline" action="stock/getList">
				<div class="form-group">
					<label for="仓库编码">仓库编码</label>
					<input type="text" class="form-control" id="stocknumber" name="stocknumber" placeholder="" value=${model.stocknumber }>
				</div>
				<div class="form-group">
					<label for="仓库名称">仓库名称</label>
					<input type="text" class="form-control" id="stockname" name="stockname" placeholder="" value=${model.stockname }>
				</div>
				<div class="form-group">
					<label for="仓库地址">仓库地址</label>
					<input type="text" class="form-control" id="stockaddress" name="stockaddress" placeholder="" value=${model.stockaddress }>
				</div>
				<div class="form-group">
					<label for="联系电话">联系电话</label>
					<input type="text" class="form-control" id="stocktel" name="stocktel" placeholder="" value=${model.stocktel }>
				</div>
				<button type="submit" class="btn btn-primary btn-sm ">
					<span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询
				</button>
			</form>
		</div>
			<div class="col-md-3 col-sm-3 col-xs-3" >
				<div class=row>

					<div class="col-md-4 col-sm-4 col-xs-4" ></div>
					<div class="col-md-4 col-sm-4 col-xs-4" >  <a class="btn btn-primary btn-sm"  href="stock/create">
						<span class="glyphicon   glyphicon-plus" aria-hidden="true"></span>     新增</a></div>
					<div class="col-md-4 col-sm-4 col-xs-4"> <a class="btn btn-danger btn-sm"  href="javascript:;" onclick="DeleteBatch('stock')">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
						删除</a>
					</div>
					&lt;%&ndash;	<div class="col-md-4 col-sm-4 col-xs-4">  <button class="btn btn-blue"  onclick="filter('stock')">
                            <span class="glyphicon   glyphicon-filter" aria-hidden="true"></span>过滤</button>
                        </div>&ndash;%&gt;
				</div>

			</div>
	</div>

	<div class="table-responsive">
		<table class="table table-bordered table-hover  table-striped ">
			<thead >
			<tr>
				<th>
					<input type="checkbox"  class="check" id="checkall" onclick="checkall()">全选
				</th>
				<th >仓库编码</th>
				<th >仓库名称</th>
				<th >仓库地址</th>
				<th >联系电话</th>
				<th >标识</th>
				<th></th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${stocklist }" var="map">
				<tr>
					<td>
						<input type="checkbox" name=check class="check" value=${map.fid}>
					</td>

					<td>${map.stocknumber }</td>
						&lt;%&ndash;  <td>${map.FErpNumber }</td> &ndash;%&gt;
					<td>${map.stockname }</td>
						&lt;%&ndash;  <td>${map.FErpName }</td>
                       <td>${map.FDepart }</td>
                         <td>${map.area.FName }</td> &ndash;%&gt;
					<td>${map.stockaddress }</td>
					<td>${map.stocktel }</td>
					<td>${map.flag }</td>
					<td>
						<button class="btn btn-success btn-xs" onclick="Edit('stock',${map.fid})">
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 编辑</button>
						<button class="btn btn-danger btn-xs" id="delete" onclick="Delete('stock',${map.fid})">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>  删除</button>

					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>

	</div>
	<jsp:include page="../../page.jsp"></jsp:include>
</div>

</body>
</html>--%>
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
		&nbsp;仓库信息管理
	</div>

	<div class="row">
<%--

		&lt;%&ndash;<div class="col-md-9 col-sm-9 col-xs-9" >
	</div>&ndash;%&gt;
--%>

		<div class="col-md-10 col-sm-10 col-xs-10">
			<form class="form-inline" action="stock/getList">
				<div class="form-group">
					<label for="仓库编码">仓库编码</label>
					<input type="text" class="form-control" id="stocknumber" name="stocknumber" placeholder="" value=${model.stocknumber }>
				</div>
				<div class="form-group">
					<label for="仓库名称">仓库名称</label>
					<input type="text" class="form-control" id="stockname" name="stockname" placeholder="" value=${model.stockname }>
				</div>
			<%--	<div class="form-group">
					<label for="仓库地址">仓库地址</label>
					<input type="text" class="form-control" id="stockaddress" name="stockaddress" placeholder="" value=${model.stockaddress }>
				</div>
				<div class="form-group">
					<label for="联系电话">联系电话</label>
					<input type="text" class="form-control" id="stocktel" name="stocktel" placeholder="" value=${model.stocktel }>
				</div>--%>
				<button type="submit" class="btn btn-primary btn-sm ">
					<span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询
				</button>
			</form>
		</div>
		<div class="col-md-2 col-sm-2 col-xs-2" >

			<div class="buttongroups"> <a class="btn btn-danger btn-sm"  href="javascript:;" onclick="DeleteBatch('stock')">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
				删除</a>
			</div>
				<div class="buttongroups" >  <a class="btn btn-primary btn-sm"  href="stock/create">
					<span class="glyphicon   glyphicon-plus" aria-hidden="true"></span>     新增</a></div>

				<%--&lt;%&ndash;	<div class="col-md-4 col-sm-4 col-xs-4">  <button class="btn btn-blue"  onclick="filter('stock')">
				<span class="glyphicon   glyphicon-filter" aria-hidden="true"></span>过滤</button>
			</div>&ndash;%&gt;--%>
			</div>


	</div>

	<div class="table-responsive">
		<table class="table table-bordered table-hover  table-striped ">
			<thead >
			<tr>
				<th>
					&nbsp;<input type="checkbox"  class="check" id="checkall" onclick="checkall()"> &nbsp;
				</th>
				<th >仓库编码</th>
				<th >仓库名称</th>
				<th >仓库地址</th>
				<th >联系电话</th>
				<th >标识</th>
				<th></th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${stocklist }" var="map">
				<tr>
					<td>
						<input type="checkbox" name=check class="check" value=${map.fid}>
					</td>

					<td>${map.stocknumber }</td>
					<td>${map.stockname }</td>
					<%--&lt;%&ndash;  <td>${map.FErpNumber }</td> &ndash;%&gt;

					&lt;%&ndash;  <td>${map.FErpName }</td>
					<td>${map.FDepart }</td>
					<td>${map.area.FName }</td> &ndash;%&gt;--%>
					<td>${map.stockaddress }</td>
					<td>${map.stocktel }</td>
					<td>${map.flag }</td>
					<td>
						<button class="btn btn-success btn-xs" onclick="Edit('stock',${map.fid})">
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 编辑</button>
						<button class="btn btn-danger btn-xs" id="delete" onclick="Delete('stock',${map.fid})">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>  删除</button>

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
