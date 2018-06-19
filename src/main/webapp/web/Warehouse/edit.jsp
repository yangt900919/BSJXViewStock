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
	<jsp:include page="../shared/resource.jsp"></jsp:include>
    
    <script type="text/javascript">
    $(document).ready(function() {
	    $('#form').bootstrapValidator({
//      live: 'disabled',
     message: 'This value is not valid',
            feedbackIcons: {/*输入框不同状态，显示图片的样式*/
    valid: 'glyphicon glyphicon-ok',
    invalid: 'glyphicon glyphicon-remove',
    validating: 'glyphicon glyphicon-refresh'
},
fields: {
stocknumber: {
  validators: {
      notEmpty: {
          message: '编码不能为空'
      }
      ,
      /*  threshold : 4, */
      remote:
          {
              url: 'stock/CheckOnly',//验证地址
              message: '编码已存在',//提示消息
              delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
              type: 'POST',//请求方式
              data: function(validator) {
                  return {
                      param: $('[name="stocknumber"]').val(),
                      ID:${stock.fid}
                  };
              }

          }
  }
},

stockname: {
  validators: {
      notEmpty: {
          message: '名称不能为空'
      }

  }
},

    flag: {
        validators: {
            notEmpty: {
                message: '标识不能为空'
            }

        }
    }
/* ,
FErpNumber: {
	  validators: {
	      notEmpty: {
	          message: 'K3系統编码不能为空'
	      }
	  }
	},
	FErpName: {
		  validators: {
		      notEmpty: {
		          message: 'K3系统名称不能为空'
		      }
		  }
		} */

}
});
});
    </script>
  </head>
  
  <body>
     <h3 class=title>
库房信息管理
   </h3>
    <div class="container-fluid  editpage-content">

   <form action="stock/save"  class="form-horizontal" method="post" id="form">
   <c:if test="${stock.fid>0 }">  <input type="hidden" name=fid value=${stock.fid }></c:if>
 
    <div class="form-group">
    <label for="stocknumber" class=col-sm-3 >仓库编码</label>
     <div class="col-sm-9">
    <input type="text" class="form-control" id="stocknumber" name="stocknumber" placeholder="库方编码" value=${stock.stocknumber }>
    </div>
  </div>

  <div class="form-group">
    <label for="stockname" class=col-sm-3>仓库名称</label>
     <div class="col-sm-9">
    <input type="text" class="form-control" id="stockname" name="stockname" placeholder="仓库名称" value=${stock.stockname }>
  </div>
  </div>

       <div class="form-group">
           <label for="stockaddress" class=col-sm-3>仓库地址</label>
           <div class="col-sm-9">
               <input type="text" class="form-control" id="stockaddress" name="stockaddress" placeholder="仓库地址" value=${stock.stockaddress }>
           </div>
       </div>

       <div class="form-group">
           <label for="stocktel" class=col-sm-3>联系电话</label>
           <div class="col-sm-9">
               <input type="text" class="form-control" id="stocktel" name="stocktel" placeholder="联系电话" value=${stock.stocktel }>
           </div>
       </div>

       <div class="form-group">
           <label for="flag" class=col-sm-3>标识</label>
           <div class="col-sm-9">
               <input type="text" class="form-control" id="flag" name="flag" placeholder="标识" value=${stock.flag }>
           </div>
       </div>

  <div class="form-group">
   <div class="col-sm-offset-3 col-sm-10">
       <button type="submit" class="btn btn-primary">
           <span class="glyphicon glyphicon-saved" aria-hidden="true"></span>   保存</button>

       <button  type="button" class="btn btn-warning" onclick="javascript:history.go(-1);">

           <span class="glyphicon glyphicon-log-out" aria-hidden="true" ></span>  退出</button>
   </div>
    </div>
  </form>
  </div>

  </body>
</html>
