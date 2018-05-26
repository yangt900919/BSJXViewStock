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
        var name = $("#materialname").val();
        //alert(name)

        var number = $("#materialnumber").val();
        //alert(needs)
        var model = $("#materialmodel").val()
        var unit = $("#materialunit").val()
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
        if (model != null) {

            result = true;
        } else {
            alert("请填写完整信息");
            return false;
        }
        if (unit != null) {

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
		<form action="/BSJX/material/edit" method="post" id="sub">
			<input type="hidden" name="fid" value="${material.fid}">
		<h3>修改物料</h3>
		<table class="searchTab" border="0">
			<tr>
				<td width="15%" align="right">物料代号:</td>
				<td><input type="text" size="82" name="materialnumber" id="materialnumber"
						   value="${material.materialnumber}"/></td>
				<td width="15%" align="right">物料名称:</td>
				<td><input type="text" size="82" name="materialname" id="materialname"
						   value="${material.materialname}"/></td>
			</tr>
			<tr>
				<td align="right">规格型号:</td>
				<td><input type="text" size="82" name="materialmodel" id="materialmodel"
						   value="${material.materialmodel}"/></td>
				<td align="right">单位:</td>
				<td><input type="text" size="82" name="materialunit" id="materialunit"
						   value="${material.materialunit}"/></td>
			</tr>
			<tr>
				
				<td>&nbsp;</td>
				<td height="100">
					<a href="javascript:submit();">保存</a>
					<a href="/BSJX/material/list" target="myFrame">返回</a>
				</td>
				<td colspan="2">&nbsp;</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>