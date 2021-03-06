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
<link rel="stylesheet" type="text/css" href="../css/outside.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/bsjx-all-js.js"></script>
<script type="text/javascript">
    function showMsg(msg, fid) {
        //top.$('context-msg').style.display = "block";
        //top.$('context-msg-text').innerHTML=msg;
        //top.$('hid-action').value="${base }/supplier/delSupplier.do?uuid="+uuid;
        //top.lock.show();
        //alert(msg);
        if (confirm(msg)) {
            $.post("/BSJX/supplier/delete", {"fid": fid}, function (data) {
                if (data == "ok") {
                    window.location.reload();
                    alert("删除成功");
                } else {
                    alert("删除失败");
                }
            });
        }
    }
    function formSubmit()
    {
        document.getElementById("forms").submit()
    }
</script>
<body>
<form action="/BSJX/supplier/auto-list" method="post" id="forms">
	<div class="search">
		<h3>供应商</h3>
		<table class="searchTab" border="0">
			<tr>
				<td width="10%" align="right">供应商查询:</td>
				<td width="20%"><input class="inputText" type="text" id="fnumber" name="fnumber" value=""></td>
				<td width="10%" align="right">
					<input class="mySubmit" type="button" onclick="formSubmit()" value="查询">
				</td>
				<td>&nbsp;</td>
			</tr>
		</table>
	</div>
</form>
	<!-- 表格展示 -->
	<div class="MainTable marginTop10">
		<div class="MainTableTitle">供应商列表</div>
		<div class="MainTableInput">
			<a href="/BSJX/supplier/add"><img src="../img/add.png" width="27" /><span>新增</span></a>
		</div>
		<table class="tableIn" width="100%" border="0" cellspacing="0" cellpadding="0">
			<thead>
			  <tr class="tableTitleName">
				<td width="38%" align="center">供应商代码</td>
				<td width="38%">供应商名称</td>
				<td>操作</td>
			  </tr>
		  </thead>
		  <tbody>
		  <c:forEach items="${supplierlist}" var="supplier">
			  <tr>
				<td align="center">${supplier.suppliernumber}</td>
				<td>${supplier.suppliername}</td>
				<td>
					<a href="/BSJX/supplier/detail?suppliernumber=${supplier.suppliernumber}">
						<img src="../img/changePen.png" width="20" align="absmiddle" />修改</a>
					<a href="javascript:void(0)" class="xiu"
					   onclick="showMsg('是否删除该项数据？',${supplier.fid })">
						<img src="../img/delete.png" width="20" align="absmiddle" />删除</a>
				</td>
			  </tr>
		  </c:forEach>
		  </tbody>
		</table>
		<div class="tablePag">
			<img src="../img/pag01.png" title="首页" />
			<img src="../img/pag02.png" title="上一页" />
			第<input class="pagInput" name="" type="text" />页
			<img src="../img/pag03.png" title="下一页" />
			<img src="../img/pag04.png" title="尾页" />
			共<span class="red">11</span>页
		</div>
		<div class="tableBottom"></div>
	</div>
	<!-- 表格展示END -->
</body>
</html>