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
			      ID:${maboxprint.fid}
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
     <h3 class=title>
  齐套二维码打印管理
   </h3>
    <div class="container-fluid editpage-content">

   <form action="maboxprint/save"  class="form-horizontal" method="post" id=form>
   <c:if test="${maboxprint.fid>0 }">  <input type="hidden" name=fid value=${maboxprint.fid }></c:if>

       <div class="form-group">
           <label for="fbillno" class=col-sm-3>编码</label>
           <div class=col-sm-9>
               <input type="text" readonly class="form-control" id="fbillno" name="fbillno" placeholder="编码" value=${maboxprint.fbillno }>
           </div>
       </div>

       <div class="form-group">
           <label for="fboxno" class=col-sm-3>箱号</label>
           <div class=col-sm-9>
               <input type="text" class="form-control" id="fboxno" name="fboxno" placeholder="箱号" value=${maboxprint.fboxno }>
           </div>
       </div>


     <div class="form-group">
         <label for="fbatch" class=col-sm-3>批号</label>
         <div class=col-sm-9>
             <input type="text" class="form-control" id="fbatch" name="fbatch" placeholder="批号" value=${maboxprint.fbatch }>
         </div>
     </div>


     <div class="form-group">
         <label for="supplier" class=col-sm-3>供货单位</label>
         <div class=col-sm-9>
         <div class="input-group">
             <input  type="text"  onfocus="clearBasics('fsupplierid')"  class="form-control" id="supplier" name="suppliername"  placeholder="供货单位" value="${maboxprint.supplier.suppliername}">
             <input type="hidden" class="form-control" id="fsupplierid" name=fsupplierid  placeholder="" value="${maboxprint.fsupplierid}">
             <span class="input-group-btn">
         <button class="btn btn-primary" type="button" onclick="showBasics('supplier','fsupplierid','supplier')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
         </div></div>
     </div>

   <div class="form-group">
  <div class="col-sm-offset-3 col-sm-9">
  <button type="submit" class="btn btn-primary">
  <!--  <span class="glyphicon glyphicon-ok" aria-hidden="true"></span> -->  提交</button>
   <button type="button" class="btn btn-warning" onclick="javascript:history.go(-1);">
  <!--  <span class="glyphicon glyphicon-share-alt" aria-hidden="true" ></span> -->  返回</button>
   </div>
   </div>
    </div>
  </form>
  
  </div>
  <jsp:include page="../../web/shared/modal.jsp"></jsp:include>
  </body>
</html>
