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
    <jsp:include page="../../basics/shared/resource.jsp"></jsp:include>

  </head>
  
  <body>
    <div class="modal fade" id="scabinet" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
         <h4 class="modal-title" id="myModalLabel">储柜条件过滤</h4>
      </div>
      <div class="modal-body" >
      <div class=row>
       <div class="col-md-3 col-sm-2 col-xs-2"></div>
      <div class="col-md-6 col-sm-8 col-xs-8">
       <form  class="form-horizontal"  id=scaform>
     
         <div class="form-group">
   <label for="储柜编码" class="col-md-4 col-sm-4 col-xs-4">储柜编码</label>
     
    <div class="col-md-8 col-sm-8 col-xs-8">
     <div class=row>
       <div class="col-md-10 col-sm-10 col-xs-10">
    <input type="text" class="form-control" id="FNumber" name=FNumber  placeholder="" value=${model.FNumber }>
    </div>
  </div>
  </div>
  </div>
  <div class="form-group">
   <label for="储柜名称" class="col-md-4 col-sm-4 col-xs-4">储柜名称</label>
     
    <div class="col-md-8 col-sm-8 col-xs-8">
     <div class=row>
       <div class="col-md-10 col-sm-10 col-xs-10">
  <input type="text" class="form-control" id="FName" name="FName" placeholder="" value=${model.FName }>
    </div>
  </div>
  </div>
  </div>
 <div class="form-group">
   <label for="柜列" class="col-md-4 col-sm-4 col-xs-4">柜列</label>
     
    <div class="col-md-8 col-sm-8 col-xs-8">
     <div class=row>
       <div class="col-md-10 col-sm-10 col-xs-10">
    <div class="input-group">
    <input type="text" disabled="disabled" class="form-control" id="Cabinet" name="Cabinet"  placeholder="" value=${model.cabinet.FName }>
  <input type="hidden" class="form-control" id="FCabinetID" name=FCabinetID  placeholder="" value=${model.FCabinetID }>
  <span class="input-group-btn">
         <button class="btn btn-info" type="button" onclick="getBaiscInfo('FCabinetID')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
    </div>
    </div>
     <div class="col-md-2 col-sm-2 col-xs-2">
       <a class="btn btn-warning" title="清除数据" onclick="clearBasicInfo('Cabinet','FCabinetID')">
     <span class="glyphicon glyphicon-trash " aria-hidden="true" ></span>
       </a>
       </div>
  </div>
  </div>
  </div>
 <div class="form-group">
   <label for="储柜类型" class="col-md-4 col-sm-4 col-xs-4">储柜类型</label>
     
    <div class="col-md-8 col-sm-8 col-xs-8">
     <div class=row>
       <div class="col-md-10 col-sm-10 col-xs-10">
  <div class="input-group">
    <input type="text" disabled="disabled" class="form-control" id="CabinetType" name="CabinetType"  placeholder="" value=${model.cabinetType.FName }>
  <input type="hidden" class="form-control" id="FCabinetTypeID" name=FCabinetTypeID  placeholder="" value=${model.FCabinetTypeID }>
  <span class="input-group-btn">
         <button class="btn btn-info" type="button" onclick="getBaiscInfo('FCabinetTypeID')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
    </div>  </div>
     <div class="col-md-2 col-sm-2 col-xs-2">
       <a class="btn btn-warning" title="清除数据" onclick="clearBasicInfo('CabinetType','FCabinetTypeID')">
     <span class="glyphicon glyphicon-trash " aria-hidden="true" ></span>
       </a>
       </div>
  </div>
  </div>
  </div>

       <div class="form-group">
   <label for="容器类型" class="col-md-4 col-sm-4 col-xs-4">容器类型</label>
     
    <div class="col-md-8 col-sm-8 col-xs-8">
     <div class=row>
       <div class="col-md-10 col-sm-10 col-xs-10">
 <div class="input-group">
    <input type="text" disabled="disabled" class="form-control" id="ContainerType" name="ContainerType"  placeholder="" value=${model.containerType.FName }>
  <input type="hidden" class="form-control" id="FContainerTypeID" name=FContainerTypeID  placeholder="" value=${model.FContainerTypeID }>
  <span class="input-group-btn">
         <button class="btn btn-info" type="button" onclick="getBaiscInfo('FContainerTypeID')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
    </div>  </div>
     <div class="col-md-2 col-sm-2 col-xs-2">
       <a class="btn btn-warning" title="清除数据" onclick="clearBasicInfo('ContainerType','FContainerTypeID')">
     <span class="glyphicon glyphicon-trash " aria-hidden="true" ></span>
       </a>
       </div>
  </div>
  </div>
  </div>
   <div class="form-group">
   <label for="库房" class="col-md-4 col-sm-4 col-xs-4">库房</label>
     
    <div class="col-md-8 col-sm-8 col-xs-8">
     <div class=row>
       <div class="col-md-10 col-sm-10 col-xs-10">
 <div class="input-group">
    <input type="text" disabled="disabled" class="form-control" id="Stock" name="Stock"  placeholder="" value=${model.stock.FName }>
  <input type="hidden" class="form-control" id="FStockID" name=FStockID  placeholder="" value=${model.FStockID }>
  <span class="input-group-btn">
         <button class="btn btn-info" type="button" onclick="getBaiscInfo('FStockID')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
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
       </form>
      </div>
      </div>
      <div class="modal-footer">
       <button type="button" class="btn btn-primary " onclick="querySubmit('Basics/SCabinet/getList','scaform','scabinet')">
  <span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询
</button>
      </div>
    </div>
  </div>
</div>
</div>
  </body>
</html>
