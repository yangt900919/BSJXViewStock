<!-- xingli 2018-3-9 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>宝石机械</title>
	<base href="<%=basePath%>">
</head>
<link rel="stylesheet" type="text/css" href="css/outside.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bsjx-all-js.js"></script>
<body>
	<div class="title">
		<h1>宝石机械管理系统</h1>
		<h2>BAOJI Mechanical management system</h2>
	</div>
	<div class="menu">
	<!-- 首页 -->
		<a class="menuAll" href="../WelcomePage.jsp" target="myFrame"><img src="img/leftMenuICO_00.png" align="absmiddle">首页</a>
	<!-- 基础资料 -->	
		<a class="menuAll" href="javascript:;" target="myFrame"><img src="img/leftMenuICO_01.png" align="absmiddle">基础资料</a>
		<div class="secondMenu">
			<a href="/BSJX/material/list" target="myFrame">物料</a>
			<a href="/BSJX/custom/list" target="myFrame">客户</a>
			<a href="/BSJX/supplier/list" target="myFrame">供应商</a>
			<a href="/BSJX/stock/list" target="myFrame">仓库</a>
			<a href="/BSJX/organization/list" target="myFrame">领料单位</a>
			<a href="/BSJX/user/list" target="myFrame">用户</a>
			<!--<a href="role/role.jsp" target="myFrame">角色</a>-->
		</div>
	<!-- 更多 -->
		<a class="menuAll" href="javascript:;" target="myFrame"><img src="img/leftMenuICO_02.png" align="absmiddle">单据信息</a>
		<div class="secondMenu">
			<a href="/BSJX/bill/list" target="myFrame">采购订单</a>
			<a href="javascript:;" target="myFrame">----</a>
		</div>
	<!-- 更多 -->
		<a class="menuAll" href="javascript:;" target="myFrame"><img src="img/leftMenuICO_03.png" align="absmiddle">平面展示</a>
		<div class="secondMenu">
			<a href="/BSJX/display/stock/list" target="myFrame">HEHE</a>
			<a href="javascript:;" target="myFrame">----</a>
		</div>
	<!-- 版权 -->
	<div class="copright">
		技术支持：<br>陕西立邦科技有限公司<br>版本号:LB-V-01
	</div>
	</div>

	<div class="main">
		<iframe name="myFrame" class="mainIframe" src="../WelcomePage.jsp"></iframe>
	</div>
</body>
</html>