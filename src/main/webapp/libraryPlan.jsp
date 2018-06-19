<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>宝鸡石油机械有限公司-新区标准件库平面图</title>
</head>
<!-- 2018-2-24 xingli ----------- -->
<link rel="stylesheet" type="text/css" href="css/plan.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/plan.js"></script>
<script type="text/javascript" src="js/zeroModal.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/zeroModal.css" />
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
<script src="assets/pages/scripts/display.js"></script>
<style>
	li{
		cursor: hand;
	}
</style>
<body>
	<!-- 头部 -->
	<div class="header">
		新区标准件库平面图
	</div>
	<div class="allBlock">
		<!-- 内容块1 -->
		<ul class="block-1 allblock">
			<li class="liWid" onclick="_iframe()"><p>应急</p><p>物资</p></li>
			<li onclick="gotoCabinet('Q12','Q12','A')"><div>12区</div></li>
			<li onclick="gotoCabinet('Q11','Q11','A')"><div>11区</div><p>铜管地磅秤</p><p>铜管地磅秤</p></li>
			<li onclick="gotoCabinet('Q10','Q10','A')"><div>10区</div><p>气缸柱塞泵</p></li>
			<li onclick="gotoCabinet('Q09','Q09','A')"><div>9区</div><p>气控箱</p></li>
			<li onclick="gotoCabinet('Q08','Q08','A')"><div>8区</div><p>千斤顶</p><p>电缆<br>电热器</p></li>
			<li onclick="gotoCabinet('Q07','Q07','A')"><div>7区</div><p>荧光灯</p><p>压力表</p></li>
			<li onclick="gotoCabinet('Q05','Q06','A')"><div>5-6区</div><p>空调</p><p>暖风机</p></li>
		</ul>
		<!-- 内容块2 -->
		<ul class="block-2 allblock">
			<li class="disabled"><p class="bloTit">轴承检验机</p></li>
			<li class="listLi1" onclick="gotoCabinet('Q01','Q04','A')"><div>1-4区</div><p>轴承</p></li>
			<li class="disabled"><p class="bloTit">待处理区</p></li>
			<li class="disabled"><p class="bloTit">待验区</p></li>
			<li class="disabled"><p class="bloTit">办公室</p></li>
		</ul>
		<h1 class="warning">安全</h1>
		<h1 class="warning">通道</h1>
		<!-- 内容块3 -->
		<ul class="block-3 allblock">
			<li class="disabled greenWord"><p class="bloTit">紧密设备房</p></li>
			<li class="listLi2" onclick="gotoCabinet('Q13','Q14','A')"><div><span>13-14区</span></div><p>钢管</p></li>
			<li onclick="gotoCabinet('Q15','Q15','A')"><div>15区</div><p>滤油器</p><p>阀组<br>组成</p></li>
			<li onclick="gotoCabinet('Q16','Q16','A')"><div>16区</div><p>齿轮<br>马达<p>电控液压阀组</p></li>
			<li onclick="gotoCabinet('Q17','Q18','A')"><div><span>17-18区</span></div></li>
			<li onclick="gotoCabinet('P39','P40','A')"><div><span>39-40排</span></div></li>
			<li onclick="gotoCabinet('P37','P38','A')"><div><span>37-38排</span></div><p>标准件</p><p>球阀</p><p>水暖管件</p></li>
			<li onclick="gotoCabinet('P27','P36','A')"><div><span>27-36排</span></div><p>电器配件</p><p>压力表</p><p>轴承</p></li>
			<li onclick="gotoCabinet('P21','P26','A')"><div><span>21-26排</span></div><p>接头</p><p>手动换向阀</p></li>
			<li onclick="gotoCabinet('P17','P20','A')"><div><span>17-20排</span></div><p>多路阀接头</p></li>
			<li onclick="gotoCabinet('P09','P16','A')"><div><span>9-16排</span></div><p>气动元件</p><p>滤油器</p><p>齿轮泵</p><p>组合垫</p></li>
			<li onclick="gotoCabinet('P01','P08','A')"><div><span>1-8排</span></div><p>费斯托接头</p><p>快速接头力士乐阀</p></li>
			<li class="disabled greenWord"><p class="bloTit">待送区</p></li>
			<li class="disabled greenWord"><p class="bloTit">待验区</p></li>
			<li class="disabled greenWord"><p class="bloTit">办公室资料室</p></li>
		</ul>
	</div>
<!-- 2018-2-24 xingli ----------- -->
</body>
</html>