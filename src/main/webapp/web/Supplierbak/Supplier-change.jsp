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
    $(function () {

        //回现
        $("option").each(function (i, l) {

            //alert(l)
            if ($(l).val() == $("#needid").val()) {
                $(l).attr('selected', 'selected')
            }
        })

    });

    function submit() {

        var result = false;
        var name = $("#suppliername").val();
        //alert(name)

        var number = $("#suppliernumber").val();
        //alert(needs)
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
        if (result) {
            alert(result);

            $("#sub").submit();
        }

    }

</script>
<body>
	<div class="search">
		<form action="/BSJX/supplier/edit" method="post" id="sub">
			<input type="hidden" name="fid" value="${supplier.fid}">
		<h3>修改供应商资料</h3>
		<table class="searchTab" border="0">
			<tr>
				<td width="15%" align="right">供应商代号:</td>
				<td><input class="inputText" type="text" name="suppliernumber" id="suppliernumber"
						   value="${supplier.suppliernumber}"/></td>
				<td width="15%" align="right">供应商名称:</td>
				<td><input class="inputText" type="text" name="suppliername" id="suppliername"
						   value="${supplier.suppliername}"/></td>
			</tr>
			<tr>
				
				<td>&nbsp;</td>
				<td height="100">
					<a href="javascript:submit();">保存</a>
					<a href="/BSJX/supplier/list" target="myFrame">返回</a>
				</td>
				<td colspan="2">&nbsp;</td>
			</tr>
		</table>
		</form>
	</div>

</body>
</html>