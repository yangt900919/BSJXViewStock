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
	<jsp:include page="../../basics/shared/resource.jsp"></jsp:include>
	<script type="text/javascript">
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
	 FNumber: {
	   validators: {
	       notEmpty: {
	           message: '编码不能为空'
	       }
	 ,
	 regexp: {/* 只需加此键值对，包含正则表达式，和提示 */
	     regexp: /^[a-zA-Z0-9]+$/,
	     message: '编码只能是数字和字母'
	 }
	 /*最后一个没有逗号*/
	 ,
		 remote:
		  {
		  url: 'Basics/GoodsSeat/CheckOnly',//验证地址
	    message: '编码已存在',//提示消息
	    delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
	    type: 'POST',//请求方式
	    data: function(validator) {
	        return {
	            param: $('[name="FNumber"]').val(),
			      ID:${goodsSeat.FID}
	        };
	     }
		  }
	 }
	 },

	 FName: {
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
货位信息管理
   </h3>
    <div class="container-fluid editpage-content">
 
   <form action="Basics/GoodsSeat/Save"  class="form-horizontal" method="post" id=form>
   <c:if test="${goodsSeat.FID>0 }">  <input type="hidden" name=FID value=${goodsSeat.FID }></c:if>
  
 
    <div class="form-group">
    <label for="FNumber" class=col-sm-2>编码</label>
    <div class=col-sm-10>
    <input type="text" class="form-control" id="FNumber" name="FNumber" placeholder="编码" value=${goodsSeat.FNumber }>
  </div>
  </div>
  <div class="form-group">
    <label for="FName" class=col-sm-2>名称</label>
    <div class=col-sm-10>
    <input type="text" class="form-control" id="FName" name="FName" placeholder="名称" value=${goodsSeat.FName }>
  </div>
  </div>
   <div class="form-group ">
    <label for="FStock" class=col-sm-2>所属储柜</label>
    <div class=col-sm-10>
    <div class="input-group">
     <input type="text" disabled class="form-control" id="SCabinet" name="SCabinet" placeholder="所属储柜" value=${goodsSeat.scabinet.FName } >
     <!-- <div class="input-group-addon  basics-search" > 
    </div> -->
     <span class="input-group-btn">
         <button class="btn btn-info" type="button" onclick="getBaiscInfo('FSCabinetID')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
    </div>
   </div>
     <input type="hidden" class="form-control" id="FSCabinetID" name="FSCabinetID" placeholder="所属储柜" value=${goodsSeat.FSCabinetID }>

 </div>
  
  <div class="form-group">
    <label for="FRemark" class=col-sm-2>备注</label>
    <div class=col-sm-10>
    <textarea rows="3" cols="10" class="form-control" id="FRemark" name="FRemark" placeholder="备注" >${goodsSeat.FRemark }</textarea>
  </div>
  
  </div>
   <div class="form-group">
  <div class="col-sm-offset-2 col-sm-10">
  <button type="submit" class="btn btn-primary">
  <!--  <span class="glyphicon glyphicon-ok" aria-hidden="true"></span> -->  提交</button>
   <button type="button" class="btn btn-warning" onclick="javascript:history.go(-1);">
  <!--  <span class="glyphicon glyphicon-share-alt" aria-hidden="true" ></span> -->  返回</button>
   </div>
   </div>
  </form>
  </div>
 <jsp:include page="../../basics/goodsSeat/shared/modal.jsp"></jsp:include>
  </body>
</html>
