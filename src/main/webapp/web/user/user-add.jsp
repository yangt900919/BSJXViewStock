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
        var name = $("#username").val();
        //alert(name)

        var password = $("#userpassword").val();
        //alert(needs)
        var role = $("#userrole").val()
        //alert(contact);
        if (name != null) {

            result = true;
        } else {
            alert("请填写完整信息");
            return false;
        }
        if (password != null) {

            result = true;
        } else {
            alert("请填写完整信息");
            return false;
        }
        if (role != null) {

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
<form action="/BSJX/user/create" method="post" id="sub">
	<div class="search">
		<h3>新增用户</h3>
		<table class="searchTab" border="0">
			<tr>
				<td width="15%" align="right">用户名称:</td>
				<td><input class="inputText" type="text" name="username" id="username" value=""/></td>
				<td width="15%" align="right">用户密码:</td>
				<td><input class="inputText" type="text" name="userpassword" id="userpassword" value=""/></td>
				<td width="15%" align="right">用户角色:</td>
				<td><input class="inputText" type="text" name="userrole" id="userrole" value=""/></td>
			</tr>
			<tr>
				
				<td>&nbsp;</td>
				<td height="100">
					<a href="javascript:submit();">保存</a>
					<a href="/BSJX/user/list" target="myFrame">返回</a>
				</td>
				<td colspan="2">&nbsp;</td>
			</tr>
		</table>
	</div>
</form>
</body>
</html>