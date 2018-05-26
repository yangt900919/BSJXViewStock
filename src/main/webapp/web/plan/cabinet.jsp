<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
		<link rel="stylesheet" type="text/css" href="../../css/plan.css">
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../js/plan.js"></script>
<script type="text/javascript" src="../../js/zeroModal.min.js"></script>
<link rel="stylesheet" type="text/css" href="../../css/zeroModal.css" />
<script type="text/javascript" src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript">
    function _iframe(fnum) {
        zeroModal.show({
            title: 'hello world',
            iframe: true,
            url: '/BSJX/material/auto-list?fnumber='+fnum,
            width: '80%',
            height: '80%',
            cancel: true
        });
    }
</script>
	<body>
		<table border="1" align="center">
			<tr>
				<th></th>
				<th>第一列</th>
				<th>第二列</th>
				<th>第三列</th>
				<th>第四列</th>
				<th>第五列</th>
				<th>第六列</th>
			</tr>
			<tr>
				<td>1</td>
				<td><a></a></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>2</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>3</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>4</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</body>	
</html>
