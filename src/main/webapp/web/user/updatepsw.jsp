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
    
    <title>My JSP 'edit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<jsp:include page="/web/shared/resource.jsp"></jsp:include>
    <style type="text/css">
    .aside
    {
    display: inline-block;
    }
    </style>
    

  </head>
  <script type="text/javascript">

      function checkpsw()
      {
          if($("#npsw").val().trim()!=$("#userpassword").val().trim())
          {
              alert("两次密码输入不一致，请重新输入!");
              $("#userpassword").val("");
          }
          else if($("#npsw").val().trim()==$("#opsw").val().trim())
          {
              alert("新旧密码不能一样!");
              $("#userpassword").val("");
          }
      }
  </script>
  <body>
     <h3 class=title>
修改密码
   </h3>
    <div class="container-fluid editpage-content">

   <form   class="form-horizontal" action="user/updatepsw" id="form" method="post">

       <c:if test="${pswmsg!=''&&pswmsg!=null }">
           <div class="alert alert-danger alert-dismissible" role="alert">
               <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                   ${pswmsg }
           </div>
       </c:if>

       <div class="form-group">
           <label for="opsw" class=col-sm-3>旧密码</label>
           <div class=col-sm-9>
               <input type="password"  class="form-control" id="opsw" name="opsw" placeholder="旧密码" >
           </div>
       </div>


       <div class="form-group">
           <label for="npsw" class=col-sm-3>新密码</label>
           <div class=col-sm-9>
               <input type="password"  class="form-control" id="npsw" name="npsw" placeholder="新密码" >
           </div>
       </div>

       <div class="form-group">
           <label for="userpassword" class=col-sm-3>重复密码</label>
           <div class=col-sm-9>
               <input type="password" onblur="checkpsw()"  class="form-control" id="userpassword" name="userpassword" placeholder="重复密码" >
           </div>
       </div>





       <div class="form-group">
  <div class="col-sm-offset-3 col-sm-9">
      <button type="submit" class="btn btn-primary">
          <!--  <span class="glyphicon glyphicon-ok" aria-hidden="true"></span> -->  提交</button>
   <button type="button" class="btn btn-warning" onclick="javascript:history.go(-1);">
  <!--  <span class="glyphicon glyphicon-share-alt" aria-hidden="true" ></span> -->  返回</button>
   </div>
   </div>
</form>
  </body>

</html>
