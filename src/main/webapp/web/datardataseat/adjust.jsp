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

    </script>
  </head>
  
  <body>
     <h3 class=title>
  货位调整
   </h3>
    <div class="container-fluid  editpage-content">

   <form action="materialrgoodseat/doadjust"  class="form-horizontal" id="form">
   <c:if test="${materialrgoodseat.fid>0 }">  <input type="hidden" name=FID value=${materialrgoodseat.fid }></c:if>

       <div class="form-group">
           <label for="Material" class=col-sm-3 >物料</label>
           <div class="col-sm-9">
               <div class=row>
                   <div class="col-md-10 col-sm-10 col-xs-10">
                       <div class="input-group">
                           <input  type="text" readonly onfocus="clearBasics('fmaterialid')"  class="form-control" id="material" name="materialname"  placeholder="" value=${materialrgoodseat.material.materialname}>
                           <input type="hidden" class="form-control" id="fmaterialid" name=fmaterialid  placeholder="" value=${materialrgoodseat.fmaterialid}>
                           <span class="input-group-btn">
                                                <button class="btn btn-primary  btn-sm"  type="button" onclick="showBasics('ma','fmaterialid','material')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span></div>
                   </div>

               </div>
           </div>
       </div>
       <div class="form-group">
           <label for="fsrc_goodseatid" class=col-sm-3>调出货位</label>
           <div class="col-sm-9">
               <div class=row>
                   <div class="col-md-10 col-sm-10 col-xs-10">
                       <div class="input-group">
                           <input  type="text" readonly onfocus="clearBasics('fsrc_goodseatid')"  class="form-control" id="src_goodseat" name="goodseatname"  placeholder="" value=${materialrgoodseat.goodseat.fnumber}>
                           <input type="hidden" class="form-control" id="fsrc_goodseatid" name=fsrc_goodseatid  placeholder="" value=${materialrgoodseat.fgoodseatid}>
                           <span class="input-group-btn">
                                                <button class="btn btn-primary  btn-sm "  type="button" onclick="showBasics('goodseat','fsrc_goodseatid','src_goodseat')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span></div> </div>

               </div></div>
       </div>


       <div class="form-group">
           <label for="fdes_goodseatid" class=col-sm-3>调入货位</label>
           <div class="col-sm-9">
               <div class=row>
                   <div class="col-md-10 col-sm-10 col-xs-10">
                       <div class="input-group">
                           <input  type="text" readonly onfocus="clearBasics('fdes_goodseatid')"  class="form-control" id="des_goodseat" name="goodseatname"  placeholder="" value=>
                           <input type="hidden" class="form-control" id="fdes_goodseatid" name=fdes_goodseatid  placeholder="" value=>
                           <span class="input-group-btn">
                                                <button class="btn btn-primary  btn-sm "  type="button" onclick="showBasics('goodseat','fdes_goodseatid','des_goodseat')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span></div> </div>

               </div></div>
       </div>

  <div class="form-group">
   <div class="col-sm-offset-3 col-sm-9">
  <button type="submit" class="btn btn-primary btn-sm">
    <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>  提交</button>

  <button type="button" class="btn btn-warning btn-sm" onclick="javascript:history.go(-1);">
    <span class="glyphicon glyphicon-log-out" aria-hidden="true" ></span>  返回</button>
   </div>
    </div>
  </form>
  </div>

     <jsp:include page="../../web/shared/modal.jsp"></jsp:include>
  </body>
</html>
