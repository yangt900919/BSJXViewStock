<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'condition.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <jsp:include page="../../web/shared/resource.jsp"></jsp:include>

  </head>
  
  <body>
    <div class="modal fade" id="stock" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
         <h4 class="modal-title" id="myModalLabel">仓库条件过滤</h4>
      </div>
      <div class="modal-body" >
      <div class=row>
       <div class="col-md-3 col-sm-2 col-xs-2"></div>
      <div class="col-md-6 col-sm-8 col-xs-8">
       <form  class="form-horizontal"  id=stform>
     
         <div class="form-group">
   <label for="库房编码" class="col-md-4 col-sm-4 col-xs-4">仓库编码</label>
     
    <div class="col-md-8 col-sm-8 col-xs-8">
     <div class=row>
       <div class="col-md-10 col-sm-10 col-xs-10">
    <input type="text" class="form-control" id="stocknumber" name=stocknumber  placeholder="" value=${model.stocknumber }>
    </div>
  </div>
  </div>
  </div>
  <div class="form-group">
   <label for="库房名称" class="col-md-4 col-sm-4 col-xs-4">仓库名称</label>
     
    <div class="col-md-8 col-sm-8 col-xs-8">
     <div class=row>
       <div class="col-md-10 col-sm-10 col-xs-10">
  <input type="text" class="form-control" id="stockname" name="stockname" placeholder="" value=${model.stockname }>
    </div>
  </div>
  </div>
  </div>

           <div class="form-group">
               <label for="地址" class="col-md-4 col-sm-4 col-xs-4">仓库地址</label>

               <div class="col-md-8 col-sm-8 col-xs-8">
                   <div class=row>
                       <div class="col-md-10 col-sm-10 col-xs-10">
                           <input type="text" class="form-control" id="stockaddress" name="stockaddress" placeholder="" value=${model.stockaddress }>
                       </div>
                   </div>
               </div>
           </div>
           <div class="form-group">
               <label for="联系电话" class="col-md-4 col-sm-4 col-xs-4">联系电话</label>

               <div class="col-md-8 col-sm-8 col-xs-8">
                   <div class=row>
                       <div class="col-md-10 col-sm-10 col-xs-10">
                           <input type="text" class="form-control" id="stocktel" name="stocktel" placeholder="" value=${model.stocktel }>
                       </div>
                   </div>
               </div>
           </div>

      
       </form>
      </div>
      </div>
      <div class="modal-footer">
       <button type="button" class="btn btn-primary " onclick="querySubmit('stock/list','stform','stock')">
  <span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询
</button>
      </div>
    </div>
  </div>
</div>
</div>
  </body>
</html>
