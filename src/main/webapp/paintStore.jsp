<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>宝石机械-油漆库平面图</title>
</head>
<!-- 2018-3-19  ----------- -->
<link rel="stylesheet" type="text/css" href="css/plan.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/plan.js"></script>
<script src="assets/pages/scripts/display.js"></script>
<body>
<!-- 头部 -->
<div class="header">
    <p style="margin-left: 4%">油漆库平面图</p>
    <div class="south"><img src="./img/nan.png" alt=""></div>
</div>
<div class="allBlock">
    <!-- 内容块1 -->
    <ul class="block-8 allblock">
        <li onclick="gotoCabinet('Q01','Q01','C')" class="listLi-8-li1 qu" style="background: #ff7a1a">稀料区</li>
        <li onclick="gotoCabinet('Q02','Q02','C')" class="listLi-8-li1">底漆</li>
        <li onclick="gotoCabinet('Q03','Q03','C')" class="listLi-8-li1">中漆</li>
        <li onclick="gotoCabinet('Q04','Q04','C')" class="listLi-8-li2">面漆</li>
        <li class="listLi-8-li3 disabled"></li>
    </ul>
    <!-- 内容块2 -->
    <h1 class="warning">安全</h1>
    <h1 class="warning">通道</h1>

    <!-- 内容块3 -->
    <ul class="block-9 allblock">
        <li onclick="gotoCabinet('Q05','Q05','C')" class="listLi-9-li1 "style="background: #ff7a1a">报废区</li>
        <li onclick="gotoCabinet('Q02','Q02','C')" class="listLi-8-li1">底漆</li>
        <li onclick="gotoCabinet('Q03','Q03','C')" class="listLi-8-li1">中漆</li>
        <li onclick="gotoCabinet('Q04','Q04','C')" class="listLi-8-li2">面漆</li>
        <li class="listLi-9-li2 disabled"></li>
    </ul>
</div>
<!-- 2018-3-19  ----------- -->
</body>
</html>