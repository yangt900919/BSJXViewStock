<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>宝石机械库房管理系统</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href=" assets/global/plugins/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href=" assets/pages/css/login.css" />
    <link rel="stylesheet" href="assets/global/plugins/bootstrapValidator/css/bootstrapValidator.css"/>
    <link rel="stylesheet" href="css/demo.css">
    <link rel="stylesheet" href="css/iconfont.css">
    <script type="text/javascript" src=" assets/global/plugins/jquery.min.js"></script>
    <script type="text/javascript" src=" assets/global/plugins/jquery.cookie.js"></script>
    <script type="text/javascript" src=" assets/global/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="assets/global/plugins/bootstrapValidator/js/bootstrapValidator.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {

            $('#defaultForm').bootstrapValidator({
//	        live: 'disabled',
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: '',
                    invalid: '',
                    validating: ''
                },
                fields: {
                    FName: {
                        validators: {
                            notEmpty: {
                                message: '用户名不能为空'
                            }
                        }

                    },

                    FPassword: {
                        validators: {
                            notEmpty: {
                                message: '密码不能为空'
                            }
                        }
                    },


                }
            });

            // alert($.cookie("checkbox"));
            if ($.cookie("checkbox") == "true") {
                $("#checkbox").attr("checked", true);
                $("#FName").val($.cookie("userName"));
                $("#FPassword").val($.cookie("passWord"));
            }

        });

        function saveUserInfo()
        {

            if ($("#checkbox").prop('checked')) {
                var userName = $("#FName").val();
                var passWord = $("#FPassword").val();
                $.cookie("checkbox", "true", { expires: 7 }); // 存储一个带7天期限的 cookie
                $.cookie("userName", userName, { expires: 7 }); // 存储一个带7天期限的 cookie
                $.cookie("passWord", passWord, { expires: 7 }); // 存储一个带7天期限的 cookie
                //alert($.cookie("userName"));
            }
            else {
                $.cookie("checkbox", "false", { expires: -1 });        // 删除 cookie
                $.cookie("userName", '', { expires: -1 });
                $.cookie("passWord", '', { expires: -1 });
            }
        }
    </script>
</head>

<body>
<!--    <div class="container-fluid"> -->
<div class="page-head">
    <img alt="" src="assets/pages/img/login/logo.png">

</div>
<div class=container-fluid>
<div class="row">
    <div class="col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xs-8 col-md-offset-2">
<div class=page-content>

        <c:if test="${msg!=''&&msg!=null }">
            <div class="alert alert-danger alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    ${msg }
            </div>
        </c:if>


        <form action="Login" class="form-inline " id="defaultForm" method="post">
            <div class="form-group has-icon">
                <i class="icon iconfont icon-yonghu form-icon"></i>
                <%--<span class="glyphicon glyphicon-user form-control-feedback" aria-hidden="true"></span>--%> <input type="text" class="form-control" id="FName" name=FName placeholder="用户名" autofocus required value="${username }">
            </div>
            <div class="form-group has-icon">
                <i class="icon iconfont icon-icon2 form-icon"></i>
                <input type="password" class="form-control" id="FPassword" name=FPassword placeholder="密码" required>
              <%--  <span class="glyphicon glyphicon glyphicon-lock form-control-feedback" aria-hidden="true"></span>--%>

            </div>

            <div class="form-group">
                 <input type="checkbox" value="" id="checkbox" onclick="saveUserInfo()" >记住密码
             </div>
             <div class="form-group">
                <button type="submit" class="btn">登&nbsp;录</button>
            </div>
        </form>
    </div>
</div>
    </div>
</div>
<div class="page-foot">
    2018&nbsp;©&nbsp; <a href="http://www.linkpal.cn" title="技术支持：陕西立邦软件有限公司" target="_blank">陕西立邦软件有限公司</a>&nbsp;&nbsp;版权所有
</div>
<%--<nav class="navbar navbar-default navbar-fixed-bottom page-foot">
    <div class="container">
        2018&nbsp;©&nbsp;陕西立邦软件有限公司
    </div>
</nav>--%>
</body>
</html>
