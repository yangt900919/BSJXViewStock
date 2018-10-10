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
    <div class="modal fade" id="datardataseat" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
         <h4 class="modal-title" id="myModalLabel">资料-资料位置条件过滤</h4>
      </div>
      <div class="modal-body" >
      <div class=row>
       <div class="col-md-3 col-sm-2 col-xs-2"></div>
      <div class="col-md-6 col-sm-8 col-xs-8">

           <form  class="form-horizontal"  id=igform>
               <div class="form-group">
                   <label for="fdataid" class="col-md-4 col-sm-4 col-xs-4">物料</label>
                   <div class="col-md-8 col-sm-8 col-xs-8">
                       <div class=row>
                           <div class="col-md-10 col-sm-10 col-xs-10">
                               <div class="input-group">
                                   <input  type="text" readonly  onfocus="clearBasics('fdataid')"  class="form-control" id="data" name="dataname"  placeholder="" value=${model.material.materialname}>
                                   <input type="hidden" class="form-control" id="fdataid" name=fdataid  placeholder="" value=${model.fdataid}>
                                   <span class="input-group-btn">
                                                <button class="btn btn-primary btn-sm "  type="button" onclick="showBasics('ma','fdataid','data')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span></div>
                           </div>

                       </div>
                   </div>
               </div>
           <div class="form-group">
               <label for="fstockid" class="col-md-4 col-sm-4 col-xs-4">仓库</label>
               <div class="col-md-8 col-sm-8 col-xs-8">
                   <div class=row>
                       <div class="col-md-10 col-sm-10 col-xs-10">
                           <div class="input-group">
                               <input  type="text" readonly onfocus="clearBasics('fstockid')"  class="form-control" id="stock" name="stockname"  placeholder="" value=${model.stock.stockname}>
                               <input type="hidden" class="form-control" id="fstockid" name=fstockid  placeholder="" value=${model.fstockid}>
                               <span class="input-group-btn">
                                                <button class="btn btn-primary  btn-sm "  type="button" onclick="showBasics('stock','fstockid','stock')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span></div>
                       </div>

                   </div>
               </div>
           </div>

           <div class="form-group">
               <label for="fcabinetid" class="col-md-4 col-sm-4 col-xs-4">资料柜列</label>
               <div class="col-md-8 col-sm-8 col-xs-8">
                   <div class=row>
                       <div class="col-md-10 col-sm-10 col-xs-10">
                           <div class="input-group">
                               <input  type="text" readonly onfocus="clearBasics('fcabinetid')"  class="form-control" id="cabinet" name="cabinetname"  placeholder="" value=${model.cabinet.fname}>
                               <input type="hidden" class="form-control" id="fcabinetid" name=fcabinetid  placeholder="" value=${model.fcabinetid}>
                               <span class="input-group-btn">
                                                <button class="btn btn-primary  btn-sm "  type="button" onclick="showBasics('datacabinet','fcabinetid','cabinet')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span></div>
                       </div>

                   </div>
               </div>
           </div>

           <div class="form-group">
               <label for="fscabinetid" class="col-md-4 col-sm-4 col-xs-4">资料柜</label>
               <div class="col-md-8 col-sm-8 col-xs-8">
                   <div class=row>
                       <div class="col-md-10 col-sm-10 col-xs-10">
                           <div class="input-group">
                               <input  type="text" readonly onfocus="clearBasics('fscabinetid')"  class="form-control" id="scabinet" name="stockname"  placeholder="" value=${model.scabinet.fname}>
                               <input type="hidden" class="form-control" id="fscabinetid" name=fscabinetid  placeholder="" value=${model.fscabinetid}>
                               <span class="input-group-btn">
                                                <button class="btn btn-primary  btn-sm "  type="button" onclick="showBasics('datascabinet','fscabinetid','scabinet')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span></div>
                       </div>

                   </div>
               </div>
           </div>

           <div class="form-group">
               <label for="fdataseatid" class="col-md-4 col-sm-4 col-xs-4">资料位置</label>
               <div class="col-md-8 col-sm-8 col-xs-8">
                   <div class=row>
                       <div class="col-md-10 col-sm-10 col-xs-10">
                           <div class="input-group">
                               <input  type="text" readonly onfocus="clearBasics('fdataseatid')"  class="form-control" id="dataseat" name="dataseatname"  placeholder="" value=${model.dataseat.fnumber}>
                               <input type="hidden" class="form-control" id="fdataseatid" name=fdataseatid  placeholder="" value=${model.fdataseatid}>
                               <span class="input-group-btn">
                                                <button class="btn btn-primary  btn-sm "  type="button" onclick="showBasics('dataseat','fdataseatid','dataseat')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span></div>
                       </div>

                   </div>
               </div>
           </div>


       </form>
      </div>
      </div>
      <div class="modal-footer">
       <button type="button" class="btn btn-primary btn-sm" onclick="querySubmit('datardataseat/getList','igform','datardataseat')">
  <span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询
</button>
      </div>
    </div>
  </div>
</div>
</div>
  </body>
</html>
