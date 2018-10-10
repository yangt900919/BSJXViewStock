<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>宝石机械-新区配套库平面图</title>
</head>
<!-- 2018-2-24 ----------- -->
<link rel="stylesheet" type="text/css" href="css/plan.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/plan.js"></script>
<script src="assets/pages/scripts/display.js"></script>
<body>
<!-- 头部 -->
<div class="header">
    <p style="margin-left: 4%">新区配套库平面图</p>
    <div class="south"><img src="./img/nan.png" alt=""></div>
</div>
<div class="allBlock">
    <!-- 内容块4 -->
    <ul class="block-4 allblock">
        <li onclick="gotoCabinet('Q12','Q12','B')"><div>12区</div><p>波纹管</p><p>拨叉离合机构</p><p>防爆电热柜</p></li>
        <li onclick="gotoCabinet('Q11','Q11','B')"><div>11区</div><p>绞车</p><p>万向轴</p></li>
        <li onclick="gotoCabinet('Q10','Q10','B')"><div>10区</div><p>联轴器</p></li>
        <li onclick="gotoCabinet('Q09','Q09','B')"><div>9区</div><p>链条</p></li>
        <li onclick="gotoCabinet('Q07','Q08','B')"><div>7-8区</div><p>泵</p></li>
        <li onclick="gotoCabinet('Q06','Q06','B')"><div>6区</div><p>自动送钻</p><p>伊顿刹车</p></li>
        <li onclick="gotoCabinet('Q05','Q05','B')"><div>5区</div><p>剪绳器</p><p>引绳</p></li>
    </ul>
    <!--<div class="block-cs"><span>安<br>全</span></div>-->
    <!-- 内容块5 -->
    <ul class="block-5 allblock">
        <li onclick="gotoCabinet('Q04','Q04','B')"><div>4区</div><p>油缸<br>(临时)</p></li>
        <li class="listLi1" onclick="gotoCabinet('Q02','Q03','B')"><div>2-3区</div><p>电机</p><p>胶管</p></li>
        <li onclick="gotoCabinet('Q01','Q01','B')"><div>1区</div><p>风机</p><p>电机</p><p>柴油机</p></li>
        <li class="listLi3 disabled"><p>待验区</p></li>
    </ul>
    <h1 class="warning">安全</h1>
    <h1 class="warning">通道</h1>
    <img src="img/door-one.png" alt="" class="door">
    <!-- 内容块6 -->
    <ul class="block-6 allblock">
        <li onclick="gotoCabinet('Q13','Q13','B')"><div>13区</div><p>钻头</p><p>制动器</p><p>排绳器</p><p>油缸</p></li>
        <li onclick="gotoCabinet('Q14','Q14','B')"><div>14区</div><p>绞车</p></li>
        <li onclick="gotoCabinet('Q15','Q15','B')"><div>15区</div><p>指重表</p><p>死绳固定器</p></li>
        <li onclick="gotoCabinet('Q16','Q16','B')"><div>16区</div><p>滚子补芯</p></li>
        <li onclick="gotoCabinet('Q17','Q17','B')"><div>17区</div><p>转盘补芯</p></li>
        <li onclick="gotoCabinet('Q18','Q19','B')"><div><span>19-18区</span></div><p>盘刹</p></li>
        <li onclick="gotoCabinet('Q20','Q20','B')"><div>20区</div><p>对讲机</p><p>电控阀组</p><p>推盘离合器</p></li>
    </ul>
    <div class="block-cs2"><span>通<br>道</span></div>
    <!-- 内容块7 -->
    <ul class="block-7 allblock">
        <li onclick="gotoCabinet('Q21','Q21','B')"><div>21区</div><p>电机</p><p>空压机</p></li>
        <li onclick="gotoCabinet('Q22','Q22','B')"><div>22区</div><p>防喷盒</p><p>吹风机</p><p>液压猫头</p></li>
        <li onclick="gotoCabinet('Q15','Q15','B')"><div>15区</div><p>指重表</p><p>死绳固定器</p></li>
        <li onclick="gotoCabinet('Q16','Q16','B')"><div>16区</div><p>滚子补芯</p></li>
        <li class="disabled greenWord noWork">
            <p class="bloTit " style="margin-top: 20%;">待送区</p>
            <p class="bloTit ">待处理区</p>
            <p class="bloTit ">办公室</p>
        </li>
        <!--<li class="disabled greenWord"><p class="bloTit">待处理区</p></li>-->
        <!--<li class="disabled greenWord"><p class="bloTit">办公室</p>-->
    </ul>
    </ul>
</div>
<!-- 2018-2-24  ----------- -->
</body>
</html>