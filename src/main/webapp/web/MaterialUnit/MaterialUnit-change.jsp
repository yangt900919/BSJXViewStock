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

    function submit() {

        var result = false;
        var name = $("#organizationname").val();
        //alert(name)

        var number = $("#organizationnumber").val();
        //alert(needs)
        var address = $("#organizationaddress").val()

        //alert(contact);
        if (name != null) {

            result = true;
        } else {
            alert("请填写完整信息");
            return false;
        }
        if (number != null) {

            result = true;
        } else {
            alert("请填写完整信息");
            return false;
        }
        if (address != null) {

            result = true;
        } else {
            alert("请填写完整信息");
            return false;
        }

        if (result) {
            alert(result);

            $("#sub").submit();
        }

    }

</script>
<body>
	<div class="search">
		<form action="/BSJX/organization/edit" method="post" id="sub">
			<input type="hidden" name="fid" value="${organization.fid}">
		<h3>修改领料单位信息</h3>
		<table class="searchTab" border="0">
			<tr>
				<td width="15%" align="right">单位代号:</td>
				<td><input class="inputText" type="text" name="organizationnumber" id="organizationnumber" value="${organization.organizationnumber}"></td>
				<td width="15%" align="right">单位名称:</td>
				<td><input class="inputText" type="text" name="organizationname" id="organizationname" value="${organization.organizationname}"></td>
			</tr>
			<tr>
				<td width="15%" align="right">收货库位（地址）:</td>
				<td><input class="inputText" type="text" name="organizationaddress" id="organizationaddress" value="${organization.organizationaddress}"></td>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td height="100">
					<a href="javascript:submit();">保存</a>
					<a href="/BSJX/organization/list" target="myFrame">返回</a>
				</td>
				<td colspan="2">&nbsp;</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>