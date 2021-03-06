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
<%--  <script type="text/javascript">
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
suppliernumber: {
validators: {
    notEmpty: {
        message: '编码不能为空'
    }
,
regexp: {/* 只需加此键值对，包含正则表达式，和提示 */
    regexp: /^[a-zA-Z0-9]+$/,
    message: '编码只能是数字和字母'
}
,
remote:
 {
 url: 'Basics/supplier/CheckOnly',//验证地址
message: '编码已存在',//提示消息
delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
type: 'POST',//请求方式
data: function(validator) {
   return {
       param: $('[name="suppliernumber"]').val(),
	      ID:${supplier.fid}
   };
}
 }
}
},

suppliername: {
validators: {
    notEmpty: {
        message: '名称不能为空'
    }
}
},
frows: {
	  validators: {
	      notEmpty: {
	          message: '行数不能为空'
	      }
	  }
	}

}
});
});
  </script>--%>
  </head>
  
  <body>
   <h3 class=title>
  供应商信息管理
   </h3>
    <div class="container-fluid editpage-content">
  
   <form action="supplier/save"  class="form-horizontal" method="post" id=form>
   <c:if test="${supplier.fid>0 }">  <input type="hidden" name=fid value=${supplier.fid }></c:if>
 

  <div class="form-group">
    <label for="suppliernumber" class=col-sm-3>供应商编码</label>
    <div class=col-sm-9>
    <input type="text" class="form-control" id="suppliernumber" name="suppliernumber" placeholder="供应商编码" value=${supplier.suppliernumber }>
  </div>
  </div>
  <div class="form-group">
    <label for="suppliername" class=col-sm-3>供应商名称</label>
    <div class=col-sm-9>
    <input type="text" class="form-control" id="suppliername" name="suppliername" placeholder="供应商名称" value=${supplier.suppliername }>
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
