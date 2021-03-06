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
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<jsp:include page="../../web/shared/resource.jsp"></jsp:include>
	<script type="text/javascript">
	
	 $(document).ready(function() {

		 showCondition("goodsseat",'${goodsSeatList }'); 
	 });
     $("#home", parent.document).removeClass("active");
     $("#link", parent.document).empty();
     $("#link", parent.document).addClass("active");
     $("#link", parent.document).text("货位信息管理");
	</script>
  </head>
  
  <body>

   <div class=container-fluid>
   <div class=title_index>
  &nbsp;资料位置信息管理
   </div>
   <div class="row">
       <div class="col-md-9 col-sm-9 col-xs-9">
           <form class="form-inline" action="dataseat/getList">
               <div class="form-group">
                   <label for="fnumber">编码</label>
                   <input type="text" class="form-control" id="fnumber" name="fnumber" placeholder="" value=${model.fnumber }>
               </div>
               <div class="form-group">
                   <label for="fscabinetid">资料柜</label>
                   <div class="input-group">
                       <input $ type="text" readonly  onfocus="clearBasics('fscabinetid')"  class="form-control" id="scabinet" name="scabinetname"  placeholder="" value=${model.scabinet.fname}>
                       <input type="hidden" class="form-control" id="fscabinetid" name=fscabinetid  placeholder="" value=${model.fscabinetid}>
                       <span class="input-group-btn">
           <button class="btn btn-primary btn-sm " type="button" onclick="showBasics('datascabinet','fscabinetid','scabinet')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
      </span>
                   </div>
               </div>
               <div class="form-group">
                   <label for="fcabinetid">资料柜列</label>
                   <div class="input-group">
                       <input $ type="text" readonly  onfocus="clearBasics('fcabinetid')"  class="form-control" id="cabinet" name="cabinetname"  placeholder="" value=${model.cabinet.fname}>
                       <input type="hidden" class="form-control" id="fcabinetid" name=fcabinetid  placeholder="" value=${model.fcabinetid}>
                       <span class="input-group-btn">
           <button class="btn btn-primary btn-sm " type="button" onclick="showBasics('datacabinet','fcabinetid','cabinet')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
      </span>
                   </div>
               </div>

               <div class="form-group">
                   <label for="fstockid">仓库</label>
                   <div class="input-group">
                       <input $ type="text" readonly onfocus="clearBasics('fstockid')"  class="form-control" id="stock" name="stockname"  placeholder="" value=${model.stock.stockname}>
                       <input type="hidden" class="form-control" id="fstockid" name=fstockid  placeholder="" value=${model.fstockid}>
                       <span class="input-group-btn">
           <button class="btn btn-primary btn-sm " type="button" onclick="showBasics('stock','fstockid','stock')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
      </span>
                   </div>
               </div>

               <button type="submit" class="btn btn-primary btn-sm ">
                   <span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询
               </button>
           </form>
       </div>
       <div class="col-md-3 col-sm-3 col-xs-3" >
        <div class=row>
            <div class="col-md-8 col-sm-8 col-xs-8"></div>
     <%-- <c:if test="${goodsSeat_delete=='goodsSeat_delete' }">--%>
             <div class="col-md-4 col-sm-4 col-xs-4"> <a class="btn btn-danger btn-sm"  href="javascript:;" onclick="DeleteBatch('dataseat')">
    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
        删除</a>
           </div>
  <%--       <div class="col-md-4 col-sm-4 col-xs-4"> <a class="btn btn-warning btn-sm"  href="javascript:;" onclick="PrintqrCode()">
         <span class="glyphicon glyphicon-qrcode" aria-hidden="true"></span>
         二维码打印</a>
        </div>--%>
         <%--  </c:if>--%>
      
      
    </div>
   </div>

   </div>

   <table class="table table-bordered table-hover table-striped ">
  <thead class=thead>
  <tr>
  <th>
      &nbsp;<input type="checkbox"  class="check" id="checkall" onclick="checkall()"> &nbsp;
  </th>
  <th >货位编码</th>
<!--   <th >货位名称</th> -->
  <th>所属储柜</th>
      <th>柜列</th>
      <th>仓库</th>
  <th></th>
  </tr>
  </thead>
  <tbody>

  <c:forEach items="${dataseatlist }" var="map">
  <tr>
  <td>
    <input type="checkbox" name=check class="check" value=${map.fid}>
  </td>
  <td>${map.fnumber }</td>
 <%--  <td>${map.FName }</td> --%>
  <td>${map.scabinet.fname }</td>
      <td>${map.cabinet.fname }</td>
      <td>${map.stock.stockname }</td>
  <td>
   <%-- <button class="btn btn-primary btn-sm" onclick="Edit('dataseat',${map.fid})">
         编辑</button> --%>
       <%--  <c:if test="${goodsSeat_delete=='goodsSeat_delete' }">--%>
      <button class="btn btn-danger btn-xs" id="delete" onclick="Delete('dataseat',${map.fid})">
       <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
        删除</button>
       <%-- </c:if>
        <c:if test="${goodsSeat_close=='goodsSeat_close' }">--%>
   <%-- <button class="btn btn-warning btn-sm" id="delete" onclick="Close('dataseat',${map.fid})">
       <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
       关闭</button> 
       </c:if>   --%>  
  </td>
  </tr>
  </c:forEach>
  </tbody>
</table>
<jsp:include page="../../page.jsp"></jsp:include>
<jsp:include page="../../web/shared/modal.jsp"></jsp:include>
   </div>
  </body>
</html>
