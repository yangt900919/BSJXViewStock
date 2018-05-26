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
	<jsp:include page="../../web/shared/resource.jsp"></jsp:include>
  <script type="text/javascript">
  $(document).ready(function() {
	    $('#form').bootstrapValidator({
//    live: 'disabled',
   message: 'This value is not valid',
          feedbackIcons: {/*输入框不同状态，显示图片的样式*/
  valid: 'glyphicon glyphicon-ok',
  invalid: 'glyphicon glyphicon-remove',
  validating: 'glyphicon glyphicon-refresh'
},
fields: {
customnumber: {
validators: {
    notEmpty: {
        message: '编码不能为空'
    }
,
remote:
 {
 url: 'custom/CheckOnly',//验证地址
message: '编码已存在',//提示消息
delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
type: 'POST',//请求方式
data: function(validator) {
   return {
       param: $('[name="customnumber"]').val(),
	      ID:${custom.fid}
   };
}
 }
}
},

customname: {
validators: {
    notEmpty: {
        message: '名称不能为空'
    }
}
}

}
});
});
  </script>
  </head>
  
  <body>
   <h3 class=title>
   客户信息管理
   </h3>
    <div class="container-fluid editpage-content">
  
   <form action="custom/save"  class="form-horizontal" method="post" id=form>
   <c:if test="${custom.fid>0 }">  <input type="hidden" name=fid value=${custom.fid }></c:if>
 

  <div class="form-group">
    <label for="customnumber" class=col-sm-3>客户编码</label>
    <div class=col-sm-9>
    <input type="text" class="form-control" id="customnumber" name="customnumber" placeholder="客户编码" value=${custom.customnumber }>
  </div>
  </div>
  <div class="form-group">
    <label for="customname" class=col-sm-3>客户名称</label>
    <div class=col-sm-9>
    <input type="text" class="form-control" id="customname" name="customname" placeholder="客户名称" value=${custom.customname }>
  </div>
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
