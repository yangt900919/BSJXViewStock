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

		 showCondition("gsprint",'${gsprintList }');
         pageNow=${page.pageNow};
	 });


	</script>
  </head>
  
  <body>
<%--  <jsp:include page="condition.jsp"></jsp:include>--%>
   <div class=container-fluid>
   <h3 class=title_index>
 货位二维码打印管理
   </h3>
   <div class="row">
       <div class="col-md-3 col-sm-3 col-xs-4" >
        <div class=row>
      <%--<c:if test="${gsprint_add=='gsprint_add' }">--%>
        <div class="col-md-4 col-sm-4 col-xs-4" >  <a class="btn btn-primary btn-sm"  href="gsprint/create">
        <span class="glyphicon   glyphicon-plus" aria-hidden="true"></span>     新增</a></div>
     <%--   </c:if>
        <c:if test="${gsprint_delete=='gsprint_delete' }">--%>
             <div class="col-md-4 col-sm-4 col-xs-4"> <a class="btn btn-danger btn-sm"  href="javascript:;" onclick="DeleteBatch('gsprint')">
    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
        删除</a>
           </div>
          <div class="col-md-4 col-sm-4 col-xs-4"> <a class="btn btn-warning btn-sm"  href="javascript:;" onclick="PrintqrCode('gsprint')">
              <span class="glyphicon glyphicon-qrcode" aria-hidden="true"></span>
              打印</a>
          </div>
      
    </div>
   </div>
       <div class="col-md-9 col-sm-9 col-xs-3">

       </div>
   </div>
       <br>
       <div class="row">
           <div class="col-md-12">
           <form class="form-inline" action="gsprint/getList">
               <div class="form-group">
                   <label for="fgoodseatid" >货位</label>

                               <div class="input-group">
                                   <input  type="text"  onfocus="clearBasics('fgoodseatid')"  class="form-control" id="goodseat" name="goodseatname"  placeholder="" value=${model.goodseat.fnumber}>
                                   <input type="hidden" class="form-control" id="fgoodseatid" name=fgoodseatid  placeholder="" value=${model.fgoodseatid}>
                                   <span class="input-group-btn">
                                                <button class="btn btn-primary"  type="button" onclick="showBasics('goodseat','fgoodseatid','goodseat')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span></div>

               </div>

               <div class="form-group">
                   <label for="fscabinetid">储柜</label>
                   <div class="input-group">
                       <input $ type="text"  onfocus="clearBasics('fscabinetid')"  class="form-control" id="scabinet" name="scabinetname"  placeholder="" value=${model.scabinet.fname}>
                       <input type="hidden" class="form-control" id="fscabinetid" name=fscabinetid  placeholder="" value=${model.fscabinetid}>
                       <span class="input-group-btn">
           <button class="btn btn-primary" type="button" onclick="showBasics('scabinet','fscabinetid','scabinet')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
      </span>
                   </div>
               </div>
               <div class="form-group">
                   <label for="fcabinetid">柜列</label>
                   <div class="input-group">
                       <input $ type="text"  onfocus="clearBasics('fcabinetid')"  class="form-control" id="cabinet" name="cabinetname"  placeholder="" value=${model.cabinet.fname}>
                       <input type="hidden" class="form-control" id="fcabinetid" name=fcabinetid  placeholder="" value=${model.fcabinetid}>
                       <span class="input-group-btn">
           <button class="btn btn-primary" type="button" onclick="showBasics('cabinet','fcabinetid','cabinet')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
      </span>
                   </div>
               </div>

               <div class="form-group">
                   <label for="fcabinettypeid">储柜类型</label>
                   <div class="input-group">
                       <input $ type="text"  onfocus="clearBasics('fcabinettypeid')"  class="form-control" id="cabinettype" name="cabinettypename"  placeholder="" value=${model.cabinettype.fname}>
                       <input type="hidden" class="form-control" id="fcabinettypeid" name=fcabinettypeid  placeholder="" value=${model.fcabinettypeid}>
                       <span class="input-group-btn">
           <button class="btn btn-primary" type="button" onclick="showBasics('cabinettype','fcabinettypeid','cabinettype')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
      </span>
                   </div>
               </div>

               <div class="form-group">
                   <label for="fstockid">仓库</label>
                   <div class="input-group">
                       <input $ type="text"  onfocus="clearBasics('fstockid')"  class="form-control" id="stock" name="stockname"  placeholder="" value=${model.stock.stockname}>
                       <input type="hidden" class="form-control" id="fstockid" name=fstockid  placeholder="" value=${model.fstockid}>
                       <span class="input-group-btn">
           <button class="btn btn-primary" type="button" onclick="showBasics('stock','fstockid','stock')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
      </span>
                   </div>
               </div>
               <button type="submit" class="btn btn-primary btn-sm ">
                   <span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询
               </button>
           </form>
       </div>
       </div>
  <hr>
       <div class="table-responsive">
   <table class="table table-bordered table-hover  ">
  <thead class=thead>
  <tr>
  <th>
  <input type="checkbox"  class="check" id="checkall" onclick="checkall()">全选
  </th>

  <th >货位</th>
   <th >区位负责人</th>
  <th >产品类型</th>
  <th></th>
  </tr>
  </thead>
  <tbody>

  <c:forEach items="${gsprintlist }" var="map">
  <tr>
  <td>
    <input type="checkbox" name=push class="check" value=${map.fid}>
  </td>
  <td>${map.goodseat.fnumber }</td>
  <td>${map.fcharge}</td>
  <td>${map.fmatype }</td>
     <%-- ${map.}--%>
<td>
 <c:if test="${map.goodseat.cabinettype.frows==1 && map.goodseat.cabinettype.fcolumns==1 }">
   <button class="btn btn-success btn-xs" onclick="Edit('gsprint',${map.fid})">
         <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑</button>
         </c:if>
          <%-- <c:if test="${gsprint_delete=='gsprint_delete' }">--%>
      <button class="btn btn-danger btn-xs" id="delete" onclick="Delete('gsprint',${map.fid})">
       <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> 删除</button>
    <%--   </c:if>--%>
          
  </td>
  </tr>
  </c:forEach>
  </tbody>
</table>
       </div>

<jsp:include page="../../page.jsp"></jsp:include>
       <jsp:include page="../../web/shared/modal.jsp"></jsp:include>
      <%-- ${isgprint}--%>
       <c:if test="${isgprint>0}">
           <jsp:include page="gsprint.jsp"></jsp:include>
       </c:if>
   </div>
  </body>
</html>
