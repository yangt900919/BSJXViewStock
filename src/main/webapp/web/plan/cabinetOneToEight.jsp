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
	<h1 align="center">安全通道</h1>
	<div class="allBlock">
		<ul class="block-3 allblock" >
			<li><p>第八排</p></li>
			<li><p>第七排</p></li>
			<li><p>第六排</p></li>
			<li><p>第五排</p></li>
			<li><p>第四排</p></li>
			<li><p>第三排</p></li>
			<li><p>第二排</p></li>
			<li><p>第一排</p></li>
		</ul>
	</div>
	</body>

</html>
