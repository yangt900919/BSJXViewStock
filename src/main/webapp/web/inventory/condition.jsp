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
	
	<script type="text/javascript">

	
	</script>
	
  </head>
  
  <body>
<!-- <button class=btn data-toggle="modal" data-target="#operateLog">show</button> -->
      <div class="modal fade" id="inventory" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
         <h4 class="modal-title" id="myModalLabel">即时库存条件过滤</h4>
      </div>
      <div class="modal-body" >
      <div class=row>
       <div class="col-md-3 col-sm-2 col-xs-2"></div>
      <div class="col-md-6 col-sm-8 col-xs-8">
       <form action=""  class="form-horizontal"  id=inform>
     
     <%--    <div class="form-group">
    <label for="sdate" class="col-md-4 col-sm-4 col-xs-4">开始时间</label>
     
    <div class="col-md-8 col-sm-8 col-xs-8">
     <div class=row>
       <div class="col-md-10 col-sm-10 col-xs-10">
    <input type="date" class="form-control" id="sdate" name="sdate" placeholder="开始时间" value=${model.sdate }>
    </div>
  </div>
  </div>
  </div>
      <div class="form-group">
    <label for="edate" class="col-md-4 col-sm-4 col-xs-4">结束时间</label>
    <div class="col-md-8 col-sm-8 col-xs-8">
     <div class=row>
       <div class="col-md-10 col-sm-10 col-xs-10">
    <input type="date" class="form-control" id="edate" name="edate" placeholder="结束时间" value=${model.edate }>
    </div>
    </div></div>
  </div>--%>
           <div class="form-group">
               <label for="fmaid" class="col-md-4 col-sm-4 col-xs-4">物料</label>
               <div class="col-md-8 col-sm-8 col-xs-8">
                   <div class=row>
                       <div class="col-md-10 col-sm-10 col-xs-10">
                           <div class="input-group">
                               <input  type="text" readonly onfocus="clearBasics('fmaid')"  class="form-control" id="material" name="materialname"  placeholder="" value=${model.materialname}>
                               <input type="hidden" class="form-control" id="fmaid" name=fmaid  placeholder="" value=${model.fmaid}>
                               <span class="input-group-btn">
                                                <button class="btn btn-primary btn-sm"  type="button" onclick="showBasics('ma','fmaid','material')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span></div>
                       </div>

                   </div>
               </div>
           </div>

           <div class="form-group">
               <label for="ferpstockid" class="col-md-4 col-sm-4 col-xs-4">仓库</label>
               <div class="col-md-8 col-sm-8 col-xs-8">
                   <div class=row>
                       <div class="col-md-10 col-sm-10 col-xs-10">
                           <div class="input-group">
                               <input  type="text" readonly onfocus="clearBasics('ferpstockid')"  class="form-control" id="erpstock" name="stockname"  placeholder="" value=${model.stockname}>
                               <input type="hidden" class="form-control" id="ferpstockid" name=ferpstockid  placeholder="" value=${model.ferpstockid}>
                               <span class="input-group-btn">
                                                <button class="btn btn-primary btn-sm"  type="button" onclick="showBasics('erpstock','ferpstockid','erpstock')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span></div>
                       </div>

                   </div>
               </div>
           </div>

         <div class="form-group">
             <label for="fstate" class="col-md-4 col-sm-4 col-xs-4">库存状态</label>
             <div class="col-md-8 col-sm-8 col-xs-8">
                 <div class=row>
                     <div class="col-md-10 col-sm-10 col-xs-10">
                         <select class="form-control" id="fstate" name="fstate" >
                             <option value="zj">质检</option>
                             <option value="hg">合格</option>
                             <option value="rk">入库</option>
                         </select>
                     </div></div>
                 <script type="text/javascript">
                     $("#fstate").val("${model.fstate}");
                 </script>
                     </div>

                 </div>


           <div class="form-group">
               <label for="fcabinetid" class="col-md-4 col-sm-4 col-xs-4">柜列</label>
               <div class="col-md-8 col-sm-8 col-xs-8">
                   <div class=row>
                       <div class="col-md-10 col-sm-10 col-xs-10">
                           <div class="input-group">
                               <input  type="text" readonly onfocus="clearBasics('fcabinetid')"  class="form-control" id="cabinet" name="cabinetname"  placeholder="" value=${model.cabinetname}>
                               <input type="hidden" class="form-control" id="fcabinetid" name=fcabinetid  placeholder="" value=${model.fcabinetid}>
                               <span class="input-group-btn">
                                                <button class="btn btn-primary btn-sm"  type="button" onclick="showBasics('cabinet','fcabinetid','cabinet')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span></div>
                       </div>

                   </div>
               </div>
           </div>

           <div class="form-group">
               <label for="fscabinetid" class="col-md-4 col-sm-4 col-xs-4">储柜</label>
               <div class="col-md-8 col-sm-8 col-xs-8">
                   <div class=row>
                       <div class="col-md-10 col-sm-10 col-xs-10">
                           <div class="input-group">
                               <input  type="text" readonly onfocus="clearBasics('fscabinetid')"  class="form-control" id="scabinet" name="scabinetname"  placeholder="" value=${model.scabinetname}>
                               <input type="hidden" class="form-control" id="fscabinetid" name=fscabinetid  placeholder="" value=${model.fscabinetid}>
                               <span class="input-group-btn">
                                                <button class="btn btn-primary btn-sm"  type="button" onclick="showBasics('scabinet','fscabinetid','scabinet')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span></div>
                       </div>

                   </div>
               </div>
           </div>

           <div class="form-group">
               <label for="fgoodseatid" class="col-md-4 col-sm-4 col-xs-4">货位</label>
               <div class="col-md-8 col-sm-8 col-xs-8">
                   <div class=row>
                       <div class="col-md-10 col-sm-10 col-xs-10">
                           <div class="input-group">
                               <input  type="text" readonly onfocus="clearBasics('fgoodseatid')"  class="form-control" id="goodseat" name="goodseatname"  placeholder="" value=${model.goodseatname}>
                               <input type="hidden" class="form-control" id="fgoodseatid" name=fgoodseatid  placeholder="" value=${model.fgoodseatid}>
                               <span class="input-group-btn">
                                                <button class="btn btn-primary btn-sm"  type="button" onclick="showBasics('goodseat','fgoodseatid','goodseat')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span></div>
                       </div>

                   </div>
               </div>
           </div>


       </form>
      </div>
      </div></div>
      <div class="modal-footer">
      <button class="btn btn-primary btn-sm" onclick="querySubmit('inventory/getList','inform','inventory')"><span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询</button>
      </div>
    </div>
  </div>
</div>


  </body>
</html>
