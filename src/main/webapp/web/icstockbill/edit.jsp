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

  </head>
  
  <body>
     <h3 class=title>
&nbsp;出入库信息管理
   </h3>
    <div class="container-fluid editpage-content">

   <form action="icstockbill/save"  class="form-horizontal" method="post" id=form>
   <c:if test="${icstockbill.FID>0 }">  <input type="hidden" name=FID value=${icstockbill.FID }></c:if>

       <div class="form-group">
           <label for="FNumber" class=col-sm-3>单据编号</label>
           <div class=col-sm-9>
               <input type="text" class="form-control" id="FNumber" name="FNumber" placeholder="" value=${icstockbill.FNumber }>
           </div>
       </div>

    <div class="form-group">
    <label for="FBillType" class="col-md-3 col-sm-3 col-xs-3">出入库类型</label>
    <div class="col-md-9 col-sm-9 col-xs-9">

      <select class="form-control" id=FBillType name=FBillType>
      <option value=0>异常入库</option>
      <option value=1>异常出库</option>
      </select>

     </div>
  </div>
       <div class="form-group">
           <label for="material" class=col-sm-3>物料</label>
           <div class=col-sm-9>
               <div class="input-group">
                   <input  type="text" readonly onfocus="clearBasics('FMaterialID')"  class="form-control" id="ma" name="materialname"  placeholder="" value="${icstockbill.material.materialname}">
                   <input type="hidden" class="form-control" id="FMaterialID" name=FMaterialID  placeholder="" value="${icstockbill.FMaterialID}">
                   <span class="input-group-btn">
         <button class="btn btn-primary btn-sm" type="button" onclick="showBasics('ma','FMaterialID','ma')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
               </div></div>
       </div>

       <div class="form-group">
           <label for="FGoodSeatID" class=col-sm-3>货位</label>
           <div class="col-sm-9">
               
                       <div class="input-group">
                           <input  type="text" readonly onfocus="clearBasics('FGoodSeatID')"  class="form-control" id="goodseat" name="goodseatname"  placeholder="" value=${icstockbill.goodseat.fnumber}>
                           <input type="hidden" class="form-control" id="FGoodSeatID" name=FGoodSeatID  placeholder="" value=${icstockbill.FGoodSeatID}>
                           <span class="input-group-btn">
                                                <button class="btn btn-primary  btn-sm "  type="button" onclick="showBasics('goodseat','FGoodSeatID','goodseat')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span></div> </div>

               
       </div>

       <div class="form-group">
           <label for="FStockID" class=col-sm-3>仓库</label>
           <div class="col-sm-9">
            
                       <div class="input-group">
                           <input  type="text" readonly onfocus="clearBasics('FStockID')"  class="form-control" id="stock" name="stockname"  placeholder="" value=${icstockbill.stock.fnumber}>
                           <input type="hidden" class="form-control" id="FStockID" name=FStockID  placeholder="" value=${icstockbill.FStockID}>
                           <span class="input-group-btn">
                                                <button class="btn btn-primary  btn-sm "  type="button" onclick="showBasics('erpstock','FStockID','stock')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span></div> </div>

               
       </div>

       <div class="form-group">
           <label for="FBatchNo" class=col-sm-3>批号</label>
           <div class=col-sm-9>
               <input type="text" class="form-control" id="FBatchNo" name="FBatchNo" placeholder="" value=${icstockbill.FBatchNo }>
           </div>
       </div>

       <div class="form-group">
           <label for="FGperiod" class=col-sm-3>保质期</label>
           <div class=col-sm-9>
               <input type="text" class="form-control" id="FGperiod" name="FGperiod" placeholder="" value=${icstockbill.FGperiod }>
           </div>
       </div>

       <div class="form-group">
           <label for="FMdate" class=col-sm-3>生产日期</label>
           <div class=col-sm-9>
               <input type="date" class="form-control" id="FMdate" name="FMdate" placeholder="" value=${icstockbill.FMdate }>
           </div>
       </div>

       <div class="form-group">
           <label for="FQty" class=col-sm-3>数量</label>
           <div class=col-sm-9>
               <input type="text" class="form-control" id="FQty" name="FQty" placeholder="" value=${icstockbill.FQty }>
           </div>
       </div>
   <div class="form-group">
    <label for="FRemark" class=col-sm-3>备注</label>
    <div class=col-sm-9>

    <textarea rows="3" cols="10" class="form-control" id="FRemark" name="FRemark" placeholder="" >${icstockbill.FRemark }</textarea>
  </div>
  
  </div>

       <div class="form-group">
           <label for="FcreatorID" class=col-sm-3>制单人</label>
           <div class="col-sm-9">
               
                       <div class="input-group">
                           <input  type="text" readonly onfocus="clearBasics('FcreatorID')"  class="form-control" id="creator" name="creatorname"  placeholder="" value=${icstockbill.creator.username}>
                           <input type="hidden" class="form-control" id="FcreatorID" name=FcreatorID  placeholder="" value=${icstockbill.fcreatorID
                           }>
                           <span class="input-group-btn">
                                                <button disabled class="btn btn-primary  btn-sm "  type="button" onclick="showBasics('user','FcreatorID','creator')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span></div> </div>

               </div>
       </div>
   <div class="form-group">
  <div class="col-sm-offset-3 col-sm-9">
  <button type="submit" class="btn btn-primary btn-sm">
  <!--  <span class="glyphicon glyphicon-ok" aria-hidden="true"></span> -->  提交</button>
   <button type="button" class="btn btn-warning btn-sm" onclick="javascript:history.go(-1);">
  <!--  <span class="glyphicon glyphicon-share-alt" aria-hidden="true" ></span> -->  返回</button>
   </div>
   </div>
  </form>
  
  </div>
  <jsp:include page="../shared/modal.jsp"></jsp:include>
  </body>
</html>
