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
			      ID:${maprint.fid}
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
  物料二维码打印管理
   </h3>
    <div class="container-fluid editpage-content">

   <form action="maprint/save"  class="form-horizontal" method="post" id=form>
   <c:if test="${maprint.fid>0 }">  <input type="hidden" name=fid value=${maprint.fid }></c:if>

       <div class="form-group">
           <label for="fbillno" class=col-sm-3>编码</label>
           <div class=col-sm-9>
               <input type="text" readonly class="form-control" id="fbillno" name="fbillno" placeholder="编码" value=${maprint.fbillno }>
           </div>
       </div>

     <div class="form-group">
         <label for="material" class=col-sm-3>物料</label>
         <div class=col-sm-9>
           <div class="input-group">
               <input  type="text"  onfocus="clearBasics('fmaterialid')"  class="form-control" id="ma" name="materialname"  placeholder="" value="${maprint.material.materialname}">
               <input type="hidden" class="form-control" id="fmaterialid" name=fmaterialid  placeholder="" value="${maprint.fmaterialid}">
               <span class="input-group-btn">
         <button class="btn btn-primary" type="button" onclick="showBasics('ma','fmaterialid','ma')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
           </div></div>
     </div>
     <div class="form-group">
         <label for="fbatch" class=col-sm-3>批号</label>
         <div class=col-sm-9>
             <input type="text" class="form-control" id="fbatch" name="fbatch" placeholder="批号" value=${maprint.fbatch }>
         </div>
     </div>

     <div class="form-group">
         <label for="fgperiod" class=col-sm-3>保质期</label>
         <div class=col-sm-9>
             <input type="number" class="form-control" id="fgperiod" name="fgperiod" placeholder="保质期" value=${maprint.fgperiod }>
         </div>
     </div>

     <div class="form-group">
         <label for="fmdate" class=col-sm-3>生产日期</label>
         <div class=col-sm-9>
             <input type="date" class="form-control" id="fmdate" name="fmdate" placeholder="生产日期" value=${maprint.fmdate }>
         </div>
     </div>

     <div class="form-group">
         <label for="fadate" class=col-sm-3>到货日期</label>
         <div class=col-sm-9>
             <input type="date" class="form-control" id="fadate" name="fadate" placeholder="到货日期" value=${maprint.fadate }>
         </div>
     </div>

     <div class="form-group">
         <label for="fquqty" class=col-sm-3>合格数量</label>
         <div class=col-sm-9>
             <input type="text" class="form-control" id="fquqty" name="fquqty" placeholder="合格数量" value=${maprint.fquqty }>
         </div>
     </div>

     <div class="form-group">
         <label for="supplier" class=col-sm-3>供货单位</label>
         <div class=col-sm-9>
         <div class="input-group">
             <input  type="text"  onfocus="clearBasics('fsupplierid')"  class="form-control" id="supplier" name="suppliername"  placeholder="供货单位" value="${maprint.supplier.suppliername}">
             <input type="hidden" class="form-control" id="fsupplierid" name=fsupplierid  placeholder="" value="${maprint.fsupplierid}">
             <span class="input-group-btn">
         <button class="btn btn-primary" type="button" onclick="showBasics('supplier','fsupplierid','supplier')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
         </div></div>
     </div>

   <div class="form-group">
  <div class="col-sm-offset-3 col-sm-9">
      <button type="submit" class="btn btn-primary">
          <span class="glyphicon glyphicon-saved" aria-hidden="true"></span>   保存</button>

      <button  type="button" class="btn btn-warning" onclick="javascript:history.go(-1);">

          <span class="glyphicon glyphicon-log-out" aria-hidden="true" ></span>  退出</button>
   </div>
   </div>
    </div>
  </form>
  
  </div>
  <jsp:include page="../../web/shared/modal.jsp"></jsp:include>
  </body>
</html>
