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
	<jsp:include page="../../basics/shared/resource.jsp"></jsp:include>
    
    <script type="text/javascript">

    </script>
  </head>
  
  <body>
     <h3 class=title>
  货位调整
   </h3>
    <div class="container-fluid  editpage-content">

   <form action="ItemRGoodsSeat/doAdjust"  class="form-horizontal" id="form">
   <c:if test="${itemrgoodsSeat.FID>0 }">  <input type="hidden" name=FID value=${itemrgoodsSeat.FID }></c:if>
 
    <div class="form-group">
    <label for="Material" class=col-sm-3 >物料</label>
     <div class="col-sm-9">
     <div class=row>
       <div class="col-md-10 col-sm-10 col-xs-10">
   
    <input type="text" disabled="disabled" class="form-control" id="Material" name="Material"  placeholder="物料" value=${itemrgoodsSeat.material.FName }>
  <input type="hidden" class="form-control" id="FItemID" name=FItemID  placeholder="" value=${itemrgoodsSeat.FItemID }>
<!--   <span class="input-group-btn">
         <button class="btn btn-info" type="button" onclick="getBaiscInfo('FItemID')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span> -->
   
    </div>
    </div>
  </div>
  </div>
  <div class="form-group">
    <label for="GoodsSeat" class=col-sm-3>调出货位</label>
     <div class="col-sm-9">
      <div class=row>
       <div class="col-md-10 col-sm-10 col-xs-10">
     
    <input type="text" disabled="disabled" class="form-control" id="sGoodsSeat" name="sGoodsSeat" placeholder="货位" value=${itemrgoodsSeat.goodsSeat.FNumber }>
    <input type="hidden" class="form-control" id="FSrc_GoodsSeatID" name=FSrc_GoodsSeatID  placeholder="" value=${itemrgoodsSeat.FGoodsSeatID }>
 <!--  <span class="input-group-btn">
         <button class="btn btn-info" type="button" onclick="getBaiscInfo('FGoodsSeatID')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span> -->
    </div>
    
  </div>
  </div>
  </div>
  <div class="form-group">
    <label for="GoodsSeat" class=col-sm-3>调入货位</label>
     <div class="col-sm-9">
      <div class=row>
       <div class="col-md-10 col-sm-10 col-xs-10">
     <div class="input-group">
    <input type="text" disabled="disabled" class="form-control" id="GoodsSeat" name="GoodsSeat" placeholder="货位">
    <input type="hidden" class="form-control" id="FGoodsSeatID" name=FGoodsSeatID  placeholder="" >
  <span class="input-group-btn">
         <button class="btn btn-info" type="button" onclick="getBaiscInfo('FGoodsSeatID')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span></div>
    </div> 
    <div class="col-md-2 col-sm-2 col-xs-2">
       <a class="btn btn-warning" title="清除数据" onclick="clearBasicInfo('GoodsSeat','FGoodsSeatID')">
     <span class="glyphicon glyphicon-trash " aria-hidden="true" ></span>
       </a>
       </div>
    </div>
  </div>
  
  </div>
   <div class="form-group">
    <label for="FSCabinetNum" class=col-sm-3>调入简易货位</label>
     <div class="col-sm-9">
     <div class=row>
       <!-- <div class="col-md-10 col-sm-10 col-xs-10"> -->
       <div class="col-md-4 col-xs-4 col-sm-4">
       <input type="text" class="form-control" id="FSCabinetNum" name="FSCabinetNum" placeholder="柜号" >
       </div>
      <div class="col-md-2 col-xs-2 col-sm-2">
       <input type="text" class="form-control" id="FRow" name="FRow" placeholder="行号" >
       </div>
       <div class="col-md-2 col-xs-2 col-sm-2">
       <input type="text" class="form-control" id="FCol" name="FCol" placeholder="列号" >
       </div>
       <div class="col-md-2 col-xs-2 col-sm-2">
       <input type="text" class="form-control" id="FPosition" name="FPosition" placeholder="仓位" >
       </div>
  <%--   <input type="text" class="form-control" id="FPlatform" name="FPlatform" placeholder="装机平台" value=${itemrgoodsSeat.FPlatform }> --%>
  </div></div><!-- </div> -->
  </div>
  <div class="form-group">
   <div class="col-sm-offset-3 col-sm-9">
  <button type="submit" class="btn btn-primary">
 <!--   <span class="glyphicon glyphicon-ok" aria-hidden="true"></span> -->  提交</button>

  <button type="button" class="btn btn-warning" onclick="javascript:history.go(-1);">
  <!--  <span class="glyphicon glyphicon-share-alt" aria-hidden="true" ></span> -->  返回</button>
   </div>
    </div>
  </form>
  </div>
   
  <jsp:include page="../../basics/itemrgoodsSeat/shared/modal.jsp"></jsp:include>
  </body>
</html>
