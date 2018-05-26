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
//	       live: 'disabled',
	      message: 'This value is not valid',
	  /*           feedbackIcons: {/!*输入框不同状态，显示图片的样式*!/
	     valid: 'glyphicon glyphicon-ok',
	     invalid: 'glyphicon glyphicon-remove',
	     validating: 'glyphicon glyphicon-refresh'
	 },*/
	 fields: {
	 fnumber: {
	   validators: {
	       notEmpty: {
	           message: '编码不能为空'
	       }


	 /*,
		 remote:
		  {
		  url: 'scabinet/CheckOnly',//验证地址
	    message: '编码已存在',//提示消息
	    delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
	    type: 'POST',//请求方式
	    data: function(validator) {
	        return {
	            param: $('[name="fnumber"]').val(),
			      ID:${scabinet.fid}
	        };
	     }
		  }*/
	 }
	 },

	 fname: {
	   validators: {
	       notEmpty: {
	           message: '名称不能为空'
	       }
	   }
	 }/*,
         cabinetname: {
             validators: {
                 notEmpty: {
                     message: '柜列不能为空'
                 }
             }
         },
         cabinettypename: {
             validators: {
                 notEmpty: {
                     message: '储柜类型不能为空'
                 }
             }
         },
         stockname: {
             validators: {
                 notEmpty: {
                     message: '仓库不能为空'
                 }
             }
         }*/
	 }
	 });
	 });
	</script>
  </head>
  
  <body>
     <h3 class=title>
  储柜信息管理
   </h3>
    <div class="container-fluid editpage-content">

   <form action="scabinet/save"  class="form-horizontal" method="post" id=form>
   <c:if test="${scabinet.fid>0 }">  <input type="hidden" name=fid value=${scabinet.fid }></c:if>
  
  <div class="form-group">
    <label for="fnumber" class=col-sm-3>编码</label>
    <div class=col-sm-9>


    <input type="text"  class="form-control" id="fnumber" name="fnumber" placeholder="编码" value=${scabinet.fnumber }>

  </div>
  </div>
  <div class="form-group">
    <label for="fname" class=col-sm-3>名称</label>
    <div class=col-sm-9>


    <input type="text" class="form-control" id="fname" name="fname" placeholder="名称" value=${scabinet.fname }>
  </div>
  </div>
   <div class="form-group ">
    <label for="fcabinetid" class=col-sm-3>柜列</label>
    <div class=col-sm-9>
        <div class="input-group">
            <input $ type="text"  onfocus="clearBasics('fcabinetid')"  class="form-control" id="cabinet" name="cabinetname"  placeholder="柜列" value=${scabinet.cabinet.fname}>
            <input type="hidden" class="form-control" id="fcabinetid" name=fcabinetid  placeholder="" value=${scabinet.fcabinetid}>
            <span class="input-group-btn">
           <button class="btn btn-primary" type="button" onclick="showBasics('cabinet','fcabinetid','cabinet')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
      </span>
        </div>

  </div>
  </div>
 <div class="form-group ">
    <label for="fcabinettypeid" class=col-sm-3>储柜类型</label>
     <div class=col-sm-9>
     <div class="input-group">
         <input $ type="text"  onfocus="clearBasics('fcabinettypeid')"  class="form-control" id="cabinettype" name="cabinettypename"  placeholder="储柜类型" value=${scabinet.cabinettype.fname}>
         <input type="hidden" class="form-control" id="fcabinettypeid" name=fcabinettypeid  placeholder="" value=${scabinet.fstockid}>
         <span class="input-group-btn">
           <button class="btn btn-primary" type="button" onclick="showBasics('cabinettype','fcabinettypeid','cabinettype')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
      </span>
     </div>
     </div>
     
  </div>

    

    


  <div class="form-group ">
    <label for="fstockid" class=col-sm-3>仓库</label>
     <div class=col-sm-9>
         <div class="input-group">
             <input $ type="text"  onfocus="clearBasics('fstockid')"  class="form-control" id="stock" name="stockname"  placeholder="仓库" value=${scabinet.stock.stockname}>
             <input type="hidden" class="form-control" id="fstockid" name=fstockid  placeholder="" value=${scabinet.fstockid}>
             <span class="input-group-btn">
           <button class="btn btn-primary" type="button" onclick="showBasics('stock','fstockid','stock')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
      </span>
         </div>
  </div></div>
    


   <div class="form-group">
    <label for="fremark" class=col-sm-3>备注</label>
    <div class=col-sm-9>

    <textarea rows="3" cols="10" class="form-control" id="fremark" name="fremark" placeholder="备注" >${scabinet.fremark }</textarea>
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
    </div>
  </form>
  
  </div>
  <jsp:include page="../../web/shared/modal.jsp"></jsp:include>
  </body>
</html>
