<%--
  Created by IntelliJ IDEA.
  User: Yang
  Date: 2018/6/28
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>宝石机械精益仓储信息平台</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href=" assets/global/plugins/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href=" assets/pages/css/rmenu.css" />
    <link rel="stylesheet" href="assets/global/plugins/bootstrapValidator/css/bootstrapValidator.css"/>
    <script type="text/javascript" src=" assets/global/plugins/jquery.min.js"></script>
    <script type="text/javascript" src=" assets/global/plugins/jquery.cookie.js"></script>
    <script type="text/javascript" src=" assets/global/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="assets/global/plugins/bootstrapValidator/js/bootstrapValidator.js"></script>
</head>
<body>
<div class="page-head">
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid" >

       <div class="row">
           <div class="col-sm-1 col-xs-1 col-md-1">
               <%-- <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">--%>

               <ul class="nav navbar-nav">
                   <li ><a href="javascript:;" onclick="javascript:history.go(-1);">
                       <span class="glyphicon glyphicon-menu-left"></span></a>
                   </li>


               </ul>
           </div>
           <div class="col-sm-10 col-xs-10 col-md-10 nav_title" align="center">
               宝石机械精益仓储信息平台
           </div>
       </div>
    </div>
</nav>
</div>
<div class="page-body">
<div class=" container-fluid" align="center">
    <div class="row">
        <div class="col-md-3 col-xs-3 col-sm-3"  onclick="location.href='report/getLibAge?page=libage'">
            <div class="menu" id="libage">
                <img src="assets/pages/img/menu/sage.png">
            </div>
            <div class="rname">无动态</div>
        </div>
        <div class="col-md-3 col-xs-3 col-sm-3" onclick="location.href='report/getFrenqucy?page=frenqucy'">
            <div class="menu" id="frequency_a">
                <img src="assets/pages/img/menu/frenqucy.png">
            </div>
            <div class="rname">高频次采购</div>
        </div>
        <div class="col-md-3 col-xs-3 col-sm-3" onclick="location.href='report/getFrenqucy?page=frenqucyb'">
            <div class="menu" id="frequency_b">
                <img src="assets/pages/img/menu/frenqucy.png">
            </div>
            <div class="rname">长期缺货</div>
        </div>
        <div class="col-md-3 col-xs-3 col-sm-3" onclick="location.href='report/getQualified?page=qrate'">
            <div class="menu" id="qualified">
                <img src="assets/pages/img/menu/quatitied.png">
            </div>
            <div class="rname">合格率分析</div>
        </div>
    </div>
</div>
</div>
</body>
</html>
