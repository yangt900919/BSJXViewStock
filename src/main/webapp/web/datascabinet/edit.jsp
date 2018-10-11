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
		  url: 'datascabinet/CheckOnly',//验证地址
	    message: '编码已存在',//提示消息
	    delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
	    type: 'POST',//请求方式
	    data: function(validator) {
	        return {
	            param: $('[name="fnumber"]').val(),
			      ID:${datascabinet.fid}
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
     <div class=title>
  &nbsp;资料柜信息管理
   </div>
    <div class="container-fluid editpage-content">

   <form action="datascabinet/save"  class="form-horizontal" method="post" id=form>
   <c:if test="${datascabinet.fid>0 }">  <input type="hidden" name=fid value=${datascabinet.fid }></c:if>
  
  <div class="form-group">
    <label for="fnumber" class=col-sm-3>编码</label>
    <div class=col-sm-9>


    <input type="text"  class="form-control" id="fnumber" name="fnumber" placeholder="编码" value=${datascabinet.fnumber }>

  </div>
  </div>
  <div class="form-group">
    <label for="fname" class=col-sm-3>名称</label>
    <div class=col-sm-9>


    <input type="text" class="form-control" id="fname" name="fname" placeholder="名称" value=${datascabinet.fname }>
  </div>
  </div>
   <div class="form-group ">
    <label for="fcabinetid" class=col-sm-3>资料柜列</label>
    <div class=col-sm-9>
        <div class="input-group">
            <input $ type="text" readonly  onfocus="clearBasics('fcabinetid')"  class="form-control" id="cabinet" name="cabinetname"  placeholder="柜列" value=${datascabinet.cabinet.fname}>
            <input type="hidden" class="form-control" id="fcabinetid" name=fcabinetid  placeholder="" value=${datascabinet.fcabinetid}>
            <span class="input-group-btn">
           <button class="btn btn-primary btn-sm" type="button" onclick="showBasics('datacabinet','fcabinetid','cabinet')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
      </span>
        </div>

  </div>
  </div>
 <div class="form-group ">
    <label for="fcabinettypeid" class=col-sm-3>资料柜类型</label>
     <div class=col-sm-9>
     <div class="input-group">
         <input $ type="text" readonly  onfocus="clearBasics('fcabinettypeid')"  class="form-control" id="cabinettype" name="cabinettypename"  placeholder="储柜类型" value=${datascabinet.cabinettype.fname}>
         <input type="hidden" class="form-control" id="fcabinettypeid" name=fcabinettypeid  placeholder="" value=${datascabinet.fcabinettypeid}>
         <span class="input-group-btn">
           <button class="btn btn-primary btn-sm" type="button" onclick="showBasics('datacabinettype','fcabinettypeid','cabinettype')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
      </span>
     </div>
     </div>
     
  </div>

    

    


  <div class="form-group ">
    <label for="fstockid" class=col-sm-3>仓库</label>
     <div class=col-sm-9>
         <div class="input-group">
             <input $ type="text" readonly onfocus="clearBasics('fstockid')"  class="form-control" id="stock" name="stockname"  placeholder="仓库" value=${datascabinet.stock.stockname}>
             <input type="hidden" class="form-control" id="fstockid" name=fstockid  placeholder="" value=${datascabinet.fstockid}>
             <span class="input-group-btn">
           <button class="btn btn-primary btn-sm" type="button" onclick="showBasics('stock','fstockid','stock')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
      </span>
         </div>
  </div></div>
    


   <div class="form-group">
    <label for="fremark" class=col-sm-3>备注</label>
    <div class=col-sm-9>

    <textarea rows="3" cols="10" class="form-control" id="fremark" name="fremark" placeholder="备注" >${datascabinet.fremark }</textarea>
  </div>
  
  </div>
       <div class="form-group">
           <div class="col-sm-offset-3 col-sm-9">
               <button type="submit" class="btn btn-primary btn-sm">
                   <span class="glyphicon glyphicon-saved" aria-hidden="true"></span>   保存</button>

               <button  type="button" class="btn btn-warning  btn-sm" onclick="javascript:history.go(-1);">

                   <span class="glyphicon glyphicon-log-out" aria-hidden="true" ></span>  退出</button>
           </div>
       </div>
  </form>
  
  </div>
  <jsp:include page="../../web/shared/modal.jsp"></jsp:include>
  </body>
</html>
