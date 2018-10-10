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
    
    <title>My JSP 'modal.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<jsp:include page="../../../basics/shared/resource.jsp"></jsp:include>

  </head>
  
  <body>
   <div class="modal fade" id="FItemIDmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">物料信息列表</h4>
      </div>
      <div class="modal-body">
        <table class="table table-bordered table-hover table-striped" id="FItemIDtable">
        <thead>
        <tr>
         <th >物料编码</th>
  <th >物料名称</th>
    <th >规格型号</th>
  <th >计量单位</th>
 
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${materialList }" var="map">
  <tr ondblclick="basicCheck('FItemID','Material','${map.FItemID}','${map.FNumber }')">
 <td>${map.FNumber }</td>
  <td>${map.FName }</td>
 
  <td>${map.FModel }</td>
  <td>${map.FUnit }</td>
  </tr>
  </c:forEach>
        </tbody>
        </table>
      </div>
    
    </div>
  </div>
</div>

<div class="modal fade" id="FGoodsSeatIDmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">货位信息列表</h4>
      </div>
      <div class="modal-body">
        <table class="table table-bordered table-hover table-striped" id=FGoodsSeatIDtable>
        <thead>
        <tr>
        <th>货位编码</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${goodsSeatList }" var="map">
  <tr ondblclick="basicCheck('FGoodsSeatID','GoodsSeat','${map.FID}','${map.FNumber }')">
  <td>${map.FNumber }</td>
  
  </tr>
  </c:forEach>
        </tbody>
        </table>
      </div>
    
    </div>
  </div>
</div>
<div class="modal fade" id="FStockIDmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">库房信息列表</h4>
      </div>
      <div class="modal-body">
        <table class="table table-bordered table-hover  table-striped" id=FStockIDtable>
        <thead>
        <tr>
        <th >库房编号</th>
        <th >库房名称</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${stockList }" var="map">
  <tr ondblclick="basicCheck('FStockID','Stock','${map.FID}','${map.FName }')">
  <td>${map.FNumber }</td>
  <%-- <td>${map.FErpNumber }</td> --%>
  <td>${map.FName }</td>
 <%--   <td>${map.FErpName }</td>
  <td>${map.FDepart }</td> --%>
  </tr>
  </c:forEach>
        </tbody>
        </table>
      </div>
   
    </div>
  </div>
</div>
<div class="modal fade" id="FSCabinetIDmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">储柜信息列表</h4>
      </div>
      <div class="modal-body">
        <table class="table table-bordered table-hover table-striped" id="FSCabinetIDtable">
        <thead>
        <tr>
        
  <th >编码</th>
  <th >名称</th>
  <th >储柜</th>
  <th >储柜类型</th>
  <th >料盒类型</th>
  <th >仓库</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${scabinetList }" var="map">
  <tr ondblclick="basicCheck('FSCabinetID','SCabinet','${map.FID}','${map.FName }')"> 
  <td>${map.FNumber }</td>
  <td>${map.FName }</td> 
  <td>${map.cabinet.FName }</td>
  <td>${map.cabinetType.FName }</td>
  <td>${map.containerType.FName }</td>
  <td>${map.stock.FNumber }</td>

  </tr>
  </c:forEach>
        </tbody>
        </table>
      </div>
    
    </div>
  </div>
</div>

<div class="modal fade" id="FCabinetIDmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">柜列信息列表</h4>
      </div>
      <div class="modal-body">
        <table class="table table-bordered table-hover table-striped" id="FCabinetIDtable">
        <thead>
        <tr>
        <th >顺序号</th>
  <th >编码</th>
  <th >名称</th>
  <th>所属仓库编码</th>
  <th>所属仓库名称</th>
  <th>备注</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cabinetList }" var="map">
  <tr ondblclick="basicCheck('FCabinetID','Cabinet','${map.FID}','${map.FName }')">
  <td>${map.FSeq }</td>
  <td>${map.FNumber }</td>
  <td>${map.FName }</td>
  <td>${map.FStockNumber }</td>
  <td>${map.FStockName }</td>
  <td>${map.FRemark }</td>
  </tr>
  </c:forEach>
        </tbody>
        </table>
      </div>
    
    </div>
  </div>
</div>
  </body>
</html>
