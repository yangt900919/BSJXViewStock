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
    <div class="modal fade" id="cabinet" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
         <h4 class="modal-title" id="myModalLabel">柜列条件过滤</h4>
      </div>
      <div class="modal-body" >
      <div class=row>
       <div class="col-md-3 col-sm-2 col-xs-2"></div>
      <div class="col-md-6 col-sm-8 col-xs-8">
       <form  class="form-horizontal"  id=caform>
     
         <div class="form-group">
   <label for="柜列编码" class="col-md-4 col-sm-4 col-xs-4">柜列编码</label>
     
    <div class="col-md-8 col-sm-8 col-xs-8">
     <div class=row>
       <div class="col-md-10 col-sm-10 col-xs-10">
    <input type="text" class="form-control" id="FNumber" name=FNumber  placeholder="" value=${model.fnumber }>
    </div>
  </div>
  </div>
  </div>
  <div class="form-group">
   <label for="柜列名称" class="col-md-4 col-sm-4 col-xs-4">柜列名称</label>
     
    <div class="col-md-8 col-sm-8 col-xs-8">
     <div class=row>
       <div class="col-md-10 col-sm-10 col-xs-10">
  <input type="text" class="form-control" id="FName" name="FName" placeholder="" value=${model.fname }>
    </div>
  </div>
  </div>
  </div>

           <div class="form-group">
               <label for="stock" class="col-md-4 col-sm-4 col-xs-4">仓库</label>

               <div class="col-md-8 col-sm-8 col-xs-8">
                   <div class=row>
                       <div class="col-md-10 col-sm-10 col-xs-10">
                           <div class="input-group">
                               <input type="text" disabled="disabled" class="form-control" id="stock" name="stock"  placeholder="" value=${model.stock.stockname }>
                               <input type="hidden" class="form-control" id="fstockid" name=fstockid  placeholder="" value=${model.fstockid }>
                               <span class="input-group-btn">
         <button class="btn btn-info" type="button" onclick="getBaiscInfo('fstockid')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
                           </div>  </div>
                       <div class="col-md-2 col-sm-2 col-xs-2">
                           <a  class="btn btn-warning" title="清除数据" onclick="clearBasicInfo('Stock','FStockID')" href="javascript:;">
                               <span class="glyphicon glyphicon-trash " aria-hidden="true" ></span>
                           </a>
                       </div>
                   </div>
               </div>
           </div>
<%-- <div class="form-group">
   <label for="仓库编码" class="col-md-4 col-sm-4 col-xs-4">仓库编码</label>
     
    <div class="col-md-8 col-sm-8 col-xs-8">
     <div class=row>
       <div class="col-md-10 col-sm-10 col-xs-10">
  <input type="text" class="form-control" id="FStockNumber" name="FStockNumber" placeholder="" value=${model.FStockNumber }>
    </div>
  </div>
  </div>
  </div>
 <div class="form-group">
   <label for="仓库名称" class="col-md-4 col-sm-4 col-xs-4">仓库名称</label>
     
    <div class="col-md-8 col-sm-8 col-xs-8">
     <div class=row>
       <div class="col-md-10 col-sm-10 col-xs-10">
  <input type="text" class="form-control" id="FStockName" name="FStockName" placeholder="" value=${model.FStockName }>
    </div>
  </div>
  </div>
  </div>--%>

      
       </form>
      </div>
      </div>
      <div class="modal-footer">
       <button type="button" class="btn btn-primary " onclick="querySubmit('cabinet/getList','caform','cabinet')">
  <span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询
</button>
      </div>
    </div>
  </div>
</div>
</div>
  </body>
</html>
