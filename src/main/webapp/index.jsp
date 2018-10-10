<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'index.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href=" assets/global/plugins/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" href="assets/global/plugins/bootstrapValidator/css/bootstrapValidator.css"/>
    <link rel="stylesheet" type="text/css" href="assets/pages/css/basics.css" />
    <link rel="stylesheet" type="text/css" href="assets/pages/css/fixed-table.css" />
    <link rel="stylesheet" type="text/css" href="assets/pages/css/home.css" />
    <script type="text/javascript" src=" assets/global/plugins/jquery.min.js"></script>
    <script type="text/javascript" src=" assets/global/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="assets/global/plugins/bootstrapValidator/js/bootstrapValidator.js"></script>
    <script type="text/javascript" src="assets/pages/scripts/basics.js"></script>
    <script type="text/javascript" src="assets/pages/scripts/jquery.dataTables.js"></script>
    <script type="text/javascript" src="assets/pages/scripts/dataTables.bootstrap.js"></script>
    <script type="text/javascript" src="assets/pages/scripts/fixed-table.js"></script>
    <style type="text/css">
        /*body
        {
            text-align: center;
        }*/
        img
        {
            margin:auto;
            width:100%;
            height: 100%;
        }
    </style>
    <script type="text/javascript">
        //alert( $("#home", parent.document));
        $("#home", parent.document).addClass("active");
        $("#link", parent.document).empty();
        $("#link", parent.document).removeClass("active");
        $("#link", parent.document).text("");
    </script>
</head>

<body>
<img alt="" src="assets/pages/img/menu/welcome.jpg">
</body>
</html>
