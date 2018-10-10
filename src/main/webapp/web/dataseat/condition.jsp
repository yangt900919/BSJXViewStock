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
    <div class="modal fade" id="goodsseat" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
         <h4 class="modal-title" id="myModalLabel">货位条件过滤</h4>
      </div>
      <div class="modal-body" >
      <div class=row>
       <div class="col-md-3 col-sm-2 col-xs-2"></div>
      <div class="col-md-6 col-sm-8 col-xs-8">
       <form  class="form-horizontal"  id=gsform>
     
         <div class="form-group">
   <label for="货位编码" class="col-md-4 col-sm-4 col-xs-4">货位编码</label>
     
    <div class="col-md-8 col-sm-8 col-xs-8">
     <div class=row>
       <div class="col-md-10 col-sm-10 col-xs-10">
    <input type="text" class="form-control" id="FNumber" name=FNumber  placeholder="" value=${model.FNumber }>
    </div>
  </div>
  </div>
  </div>
   <div class="form-group">
   <label for="柜列" class="col-md-4 col-sm-4 col-xs-4">储柜</label>
     
    <div class="col-md-8 col-sm-8 col-xs-8">
     <div class=row>
       <div class="col-md-10 col-sm-10 col-xs-10">
   <div class="input-group">
    <input type="text" disabled="disabled" class="form-control" id="SCabinet" name="SCabinet"  placeholder="" value=${model.scabinet.FName }>
  <input type="hidden" class="form-control" id="FSCabinetID" name=FSCabinetID  placeholder="" value=${model.FSCabinetID }>
  <span class="input-group-btn">
         <button class="btn btn-info" type="button" onclick="getBaiscInfo('FSCabinetID')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
    </div>
    </div>
     <div class="col-md-2 col-sm-2 col-xs-2">
       <a class="btn btn-warning" title="清除数据" onclick="clearBasicInfo('SCabinet','FSCabinetID')">
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
       <button type="button" class="btn btn-primary " onclick="querySubmit('Basics/GoodsSeat/getList','gsform','goodsseat')">
  <span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询
</button>
      </div>
    </div>
  </div>
</div>
</div>

  </body>
</html>
