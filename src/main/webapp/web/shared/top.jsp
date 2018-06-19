<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>凌云可视化仓库</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <jsp:include page="resource.jsp"></jsp:include>
    <link rel="stylesheet" href="assets/pages/css/page/page.css"/>
    <link rel="stylesheet" href="assets/pages/css/page/stock_layout.css"/>

    <style type="text/css">

    </style>
</head>

<body>
<!--   <nav class="navbar navbar-default page-navbar">
  <div class="container-fiuld">
  <div class=" navbar-header">
  <div class="navbar-brand">
  <img alt="" src="assets/pages/img/page/title.png" class="logo-default">
  </div>
          <ul class="nav navbar-nav navbar-right">
           <li><a href="mainMenu" class="top-a">首页</a></li>
            <li><a href="javaScript:void(0)" class="top-a" onclick="javascript:history.go(-1);">上一级</a></li>
        </ul>
  </div>
  </div>
</nav> -->
<div class=container-fiuld align="center">
    <div class="row main-top">
        <div class=box_bp ><div class="page_title" >
           宝鸡石油机械有限公司-物资公司精益化库房
        </div></div>
        <div class="box_bp flag" >
            <div class="page_button ">
               <%-- <a class="btn btn-default " id=home href="mainMenu">首页</a>--%>
                <a class="btn btn-default" id=back href="javaScript:void(0)" onclick="javascript:history.go(-1);">返回</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
