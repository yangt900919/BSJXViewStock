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
<%--	<script type="text/javascript">
	 $(document).ready(function() {
	 	    $('#form').bootstrapValidator({
//	       live: 'disabled',
	      message: 'This value is not valid',
	             feedbackIcons: {/*输入框不同状态，显示图片的样式*/
	     valid: 'glyphicon glyphicon-ok',
	     invalid: 'glyphicon glyphicon-remove',
	     validating: 'glyphicon glyphicon-refresh'
	 },
	 fields: {
	 fnumber: {
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
	 stringLength: {/*长度提示*/
	     min: 4,
	     max: 4,
	     message: '编码长度为4'
	 }/*最后一个没有逗号*/
	 ,
		 remote:
		  {
		  url: 'Basics/SCabinet/CheckOnly',//验证地址
	    message: '编码已存在',//提示消息
	    delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
	    type: 'POST',//请求方式
	    data: function(validator) {
	        return {
	            param: $('[name="fnumber"]').val(),
			      ID:${dsprint.fid}
	        };
	     }
		  }
	 }
	 },

	 fname: {
	   validators: {
	       notEmpty: {
	           message: '名称不能为空'
	       }
	   }
	 }
	 }
	 });
	 });
	</script>--%>
  </head>
  
  <body>
     <div class=title>
  &nbsp;资料二维码打印管理
   </div>
    <div class="container-fluid editpage-content">

   <form action="dsprint/save"  class="form-horizontal" method="post" id=form>
   <c:if test="${dsprint.fid>0 }">  <input type="hidden" name=fid value=${dsprint.fid }></c:if>


     <div class="form-group">
         <label for="dataseat" class=col-sm-3>资料位置</label>
         <div class=col-sm-9>
           <div class="input-group">
               <input  type="text"  readonly onfocus="clearBasics('fdataseatid')"  class="form-control" id="dataseat" name="dataseatname"  placeholder="资料位置" value="${dsprint.dataseat.fnumber}" required>
               <input type="hidden" class="form-control" id="fdataseatid" name=fdataseatid  placeholder="" value="${dsprint.fdataseatid}">
               <span class="input-group-btn">
         <button class="btn btn-primary btn-sm" type="button" onclick="showBasics('dataseat','fdataseatid','dataseat')" >&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
           </div></div>
     </div>
   <%--  <div class="form-group">
         <label for="fcharge" class=col-sm-3>厂区负责人</label>
         <div class=col-sm-9>
             <textarea rows="3" cols="10" class="form-control" id="fcharge" name="fcharge" placeholder="厂区负责人" >${dsprint.fcharge }</textarea> </div>
     </div>

     <div class="form-group">
         <label for="fmatype" class=col-sm-3>产品类型</label>
         <div class=col-sm-9>
             <textarea rows="3" cols="10" class="form-control" id="fmatype" name="fmatype" placeholder="产品类型" >${dsprint.fmatype}</textarea>
         </div>
     </div>--%>



       <div class="form-group">
           <div class="col-sm-offset-3 col-sm-9">
               <button type="submit" class="btn btn-primary btn-sm">
                   <span class="glyphicon glyphicon-saved" aria-hidden="true"></span>   保存</button>

               <button  type="button" class="btn btn-warning btn-sm" onclick="javascript:history.go(-1);">

                   <span class="glyphicon glyphicon-log-out" aria-hidden="true" ></span>  退出</button>
           </div>
       </div>
  </form>
  
  </div>
  <jsp:include page="../../web/shared/modal.jsp"></jsp:include>
  </body>
</html>
