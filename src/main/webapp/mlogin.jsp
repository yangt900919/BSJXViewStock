<%--
  Created by IntelliJ IDEA.
  User: Yang
  Date: 2018/6/28
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>宝石机械库房管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href=" assets/global/plugins/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href=" assets/pages/css/mlogin.css" />
    <link rel="stylesheet" href="assets/global/plugins/bootstrapValidator/css/bootstrapValidator.css"/>
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
<div class="page-head">
    <img alt="" src="assets/pages/img/login/mlogo.png">

</div>
<%--<div class=container-fluid>
    <div class="row">
        <div class="col-md-4 col-md-offset-4 col-sm-4 col-sm-offset-4 col-xs-4 col-md-offset-4">--%>
<div class=page-content>

        <c:if test="${msg!=''&&msg!=null }">
            <div class="alert alert-danger alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    ${msg }
            </div>
        </c:if>


        <form action="mLogin" class="form-horizontal" id="defaultForm" method="post">
            <div class="form-group has-feedback">
                <input type="text" class="form-control" id="FName" name=FName placeholder="用户名" autofocus required value="${username }">
                <span class="glyphicon glyphicon-user form-control-feedback" aria-hidden="true"></span>

            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" id="FPassword" name=FPassword placeholder="密码" required>
                <span class="glyphicon glyphicon glyphicon-lock form-control-feedback" aria-hidden="true"></span>

            </div>

           <%-- <div class="form-group">
                <input type="checkbox" value="" id="checkbox" onclick="saveUserInfo()" >记住密码
            </div>--%>
            <div class="form-group">
                <button type="submit" class="btn">登录</button>
            </div>
        </form>
    </div>

<div class="page-foot">
    2018&nbsp;©&nbsp; <a href="http://www.linkpal.cn" title="技术支持：陕西立邦软件有限公司" target="_blank">陕西立邦软件有限公司</a>&nbsp;&nbsp;版权所有
</div>
<%--</div>
    </div></div>--%>
</body>
</html>
