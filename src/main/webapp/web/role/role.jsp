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
</head>
<link rel="stylesheet" type="text/css" href="../../css/outside.css">
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../js/bsjx-all-js.js"></script>

<body>
	<div class="search">
		<h3>角色管理</h3>
		<table class="searchTab" border="0">
			<tr>
				<td width="10%" align="right">角色:</td>
				<td width="20%"><input class="inputText" type="text" name=""></td>
				<td width="10%" align="right">
					<input class="mySubmit" type="submit" value="查询">
				</td>
				<td>&nbsp;</td>
			</tr>
		</table>
	</div>
	<!-- 表格展示 -->
	<div class="MainTable marginTop10">
		<div class="MainTableTitle">角色列表</div>
		<div class="MainTableInput">
			<a href="role-add.jsp"><img src="../../img/add.png" width="27" /><span>新增</span></a>
		</div>
		<table class="tableIn" width="100%" border="0" cellspacing="0" cellpadding="0">
			<thead>
			  <tr class="tableTitleName">
				<td width="50%" align="center">角色</td>
				<td>操作</td>
			  </tr>
		  </thead>
		  <tbody>
			  <tr>
				<td align="center">管理员</td>
				<td>
					<a href="role-change.jsp">
						<img src="../../img/changePen.png" width="20" align="absmiddle" />修改</a>
					<a class="marginLeft10" href="javascript:;">
						<img src="../../img/delete.png" width="20" align="absmiddle" />删除</a>
				</td>
			  </tr>
		  </tbody>
		</table>
		<div class="tablePag">
			<img src="../../img/pag01.png" title="首页" />
			<img src="../../img/pag02.png" title="上一页" />
			第<input class="pagInput" name="" type="text" />页
			<img src="../../img/pag03.png" title="下一页" />
			<img src="../../img/pag04.png" title="尾页" />
			共<span class="red">11</span>页
		</div>
		<div class="tableBottom"></div>
	</div>
	<!-- 表格展示END -->
</body>
</html>