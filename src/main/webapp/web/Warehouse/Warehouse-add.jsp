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
        var name = $("#stockname").val();
        //alert(name)

        var number = $("#stocknumber").val();
        //alert(needs)
        var address = $("#stockaddress").val()
        var tel = $("#stocktel").val()
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
        if (tel != null) {

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
<form action="/BSJX/stock/create" method="post" id="sub">
	<div class="search">
		<h3>新增仓库</h3>
		<table class="searchTab" border="0">
			<tr>
				<td width="15%" align="right">仓库代号:</td>
				<td><input class="inputText" type="text" name="stocknumber" id="stocknumber" value=""></td>
				<td width="15%" align="right">仓库名称:</td>
				<td><input class="inputText" type="text" name="stockname" id="stockname" value=""></td>
			</tr>
			<tr>
				<td width="15%" align="right">仓库地址:</td>
				<td><input class="inputText" type="text" name="stockaddress" id="stockaddress" value=""></td>
				<td width="15%" align="right">电话:</td>
				<td><input class="inputText" type="text" name="stocktel" id="stocktel" value=""></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td height="100">
					<a href="javascript:submit();">保存</a>
					<a href="/BSJX/stock/list" target="myFrame">返回</a>
				</td>
				<td colspan="2">&nbsp;</td>
			</tr>
		</table>
	</div>
</form>
</body>
</html>