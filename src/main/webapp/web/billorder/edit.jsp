<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
	<jsp:include page="../shared/resource.jsp"></jsp:include>

      <link rel="stylesheet" type="text/css" href=" assets/pages/css/bill.css" />
      <script type="application/javascript" src="assets/pages/scripts/bill.js"></script>

      <script type="text/javascript">
          index=${billorder.billorderentries.size()};
      </script>

  </head>

  <body>
     <h3 class=title>
采购订单信息管理

     </h3>
    <div class="container " >

   <form action="billorder/save"  class="form-horizontal" method="post" id=form>
   <c:if test="${billorder.fbillid>0 }">  <input type="hidden" name=fbillid value=${billorder.fbillid }></c:if>

       <div class="row">
           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fnumber" class="col-md-3 col-sm-3 col-xs-3">单据编号</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                               <input readonly type="text" class="form-control" id="fnumber" name="fnumber"  value=${billorder.fnumber }>

                           </div>
                   </div>
               </div>
           </div>
           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fbizdate" class="col-md-3 col-sm-3 col-xs-3">业务日期</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                               <input ${readonly} type="date" class="form-control" id="fbizdate" name="fbizdate"
                                                  value="<fmt:formatDate value="${billorder.fbizdate}" pattern="yyyy-MM-dd"></fmt:formatDate>" >

                  <%--         ${billorder.fbizdate}--%>
                           </div>
                   </div>
                   <script type="text/javascript">
                       /*var bizdate=
                       $("#fbizdate")*/
                   </script>
               </div>
           </div>
           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fstatus" class="col-md-3 col-sm-3 col-xs-3">单据状态</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                               <select ${readonly} class="form-control" id=fstatus name=fstatus readonly>
                                   <option value="0">保存</option>
                                   <option value='1'>审核</option>
                                  <%-- <option value='2'>检验</option>--%>
                               </select>
                               <script type="application/javascript">
                                   $("#fstatus").val(${billorder.fstatus});
                               </script>
                           </div>
                   </div>
               </div>
           </div>
          <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fsupplierid" class="col-md-3 col-sm-3 col-xs-3">供应商</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                               <div class="input-group">
                                   <input ${readonly} type="text"  required onfocus="clearBasics('fsupplierid')"  class="form-control" id="supplier" name="suppliername"  placeholder="" value=${billorder.supplier.suppliername}>
                                   <input type="hidden" class="form-control" id="fsupplierid" name=fsupplierid  placeholder="" value=${billorder.fsupplierid}>
                                   <span class="input-group-btn">
         <button class="btn btn-primary" ${disabled} type="button" onclick="showBasics('supplier','fsupplierid','supplier')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
                           </div>

                       </div>
                   </div>
               </div>

           </div>
       </div>

       <div class="row">
           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fcustomid" class="col-md-3 col-sm-3 col-xs-3">客户</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                           <div class="input-group">
                               <input ${readonly} type="text"  onfocus="clearBasics('fcustomid')"  class="form-control" id="custom" name="customname"  placeholder="" value=${billorder.custom.customname}>
                               <input type="hidden" class="form-control" id="fcustomid" name=fcustomid  placeholder="" value=${billget.fcustomid}>
                               <span class="input-group-btn">
           <button class="btn btn-primary" ${disabled} type="button" onclick="showBasics('custom','fcustomid','custom')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
      </span>
                           </div>

                       </div>
                   </div>
               </div>

           </div>
           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="frestockid" class="col-md-3 col-sm-3 col-xs-3">仓库</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                           <div class="input-group">
                               <input ${readonly} type="text" required onfocus="clearBasics('frestockid')"  class="form-control" id="stock" name="stockname"  placeholder="" value=${billorder.restock.stockname}>
                               <input type="hidden" class="form-control" id="frestockid" name=frestockid  placeholder="" value=${billorder.frestockid}>
                               <span class="input-group-btn">
           <button class="btn btn-primary" ${disabled} type="button" onclick="showBasics('stock','frestockid','stock')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
      </span>
                           </div>

                       </div>
                   </div>
               </div>

           </div>
           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fdepartmentid" class="col-md-3 col-sm-3 col-xs-3">部门</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                           <div class="input-group">
                               <input ${readonly} type="text"  onfocus="clearBasics('fdepartmentid')"  class="form-control" id="organization" name="organizationname"  placeholder="" value=${billorder.organization.organizationname}>
                               <input type="hidden" class="form-control" id="fdepartmentid" name=fdepartmentid  placeholder="" value=${billorder.fdepartmentid}>
                               <span class="input-group-btn">
         <button class="btn btn-primary" ${disabled} type="button" onclick="showBasics('depart','fdepartmentid','organization')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
                           </div>

                       </div>
                   </div>
               </div>

           </div>
           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fnote" class="col-md-3 col-sm-3 col-xs-3">备注</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                           <textarea ${readonly} rows="1" cols="10" class="form-control" id="fnote" name="fnote" placeholder="" >${billorder.fnote}</textarea>

                       </div>
                   </div>
               </div>

           </div>
       </div>
     
       <div class="row">
           <div class="row">
               <div class="col-md-4 col-sm-4 col-xs-4" >
               <div class="col-md-4 col-sm-4 col-xs-4">
                   <button ${disabled} class="btn btn-primary btn-xs "  onclick="addEntry('order')">
                       <span class="glyphicon   glyphicon-plus" aria-hidden="true"></span>     增加分录</button></div>

           <div class="col-md-4 col-sm-4 col-xs-4">
               <button ${disabled} class="btn btn-danger btn-xs "  onclick="deleteEntry()">
                   <span class="glyphicon   glyphicon-remove" aria-hidden="true"></span>     删除分录</button></div>
           </div>
           </div>
           <br>
        <div class="row" >


<%--            <div class='table-cont' id='table-cont'>--%>
                <div class="table-responsive">
                <table class="table  table-hover table-bordered">
                    <thead>
                    <tr>
                        <th>&nbsp;&nbsp;物料代码&nbsp;&nbsp;</th>
                        <th>物料名称</th>
                        <th>计量单位</th>
                        <th>仓库</th>
                        <th>数量</th>
                        <th>品牌</th>
                     <th>质量标准</th>
                          <th>交货日期</th>
                       <th>合同号</th>
                       <th>收料数量</th>
                       <th>退料数量</th>
                       <th>入库数量</th>
                       <th>评估类型</th>
                       <th>备注</th>
                        
                    </tr>
                    </thead>
                    <tbody id="entrys">

                <c:forEach items="${billorder.billorderentries}" var="map" varStatus="st">
                    <tr>

                        <td>
                            <input type="hidden" class="form-control" id="fid${st.index}" name=billorderentries[${st.index}].fid  placeholder="" value="${map.fid}">

                            <input type="hidden" class="form-control" id="fbillid${st.index}" name=billorderentries[${st.index}].fbillid  placeholder="" value="${map.fbillid}">
                            <input type="hidden" class="form-control" id="fentriyid${st.index}" name=billorderentries[${st.index}].fentriyid  placeholder="" value="${map.fentriyid}">

                            <div class="input-group">
                                <input  ${readonly} type="text"  onfocus="clearBasics('fmaid${st.index}')"  class="form-control bill_input_b" id="material${st.index}" name="materialname${st.index}"  placeholder="" value="${map.material.materialnumber}">
                                <input type="hidden" class="form-control" id="fmaid${st.index}" name=billorderentries[${st.index}].fmaid  placeholder="" value="${map.material.fid}">
                                <span class="input-group-btn">
         <button class="btn btn-primary" ${disabled} type="button" onclick="getmaterial('material','fmaid${st.index}','material${st.index}','materialname${st.index}','','materialunit${st.index}')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
                            </div>
                        </td>

                        <td>
                            <input type="text" class="form-control bill_input" id="billorderentries${st.index}.materialname" name="billorderentries[${st.index}].materialname"  value="${map.material.materialname}" readonly>

                        </td>
                        <td>
                            <input type="text" class="form-control bill_input" id="billorderentries${st.index}.materialunit" name="billorderentries[${st.index}].materialunit"  value="${map.material.materialunit}" readonly>
                        </td>
                        <td>
                            <div class="input-group">
                                <input ${readonly} type="text"  onfocus="clearBasics('fstockid${st.index}')"  class="form-control bill_input_b" id="stock${st.index}" name="stockname${st.index}"  placeholder="" value="${map.stock.stockname}">
                                <input  type="hidden" class="form-control" id="fstockid${st.index}" name=billorderentries[${st.index}].fstockid  placeholder="" value="${map.stock.fid}">
                                <span class="input-group-btn">
         <button class="btn btn-primary" ${disabled} type="button" onclick="showBasics('stock','fstockid${st.index}','stock${st.index}')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
                            </div>
                        </td>
                        <td>
                            <input ${readonly} type="number" class="form-control bill_input" id="fqty${st.index}" name="billorderentries[${st.index}].fqty"  value="${map.fqty}" >
                        </td>
                        <td>
                            <input ${readonly} type="text" class="form-control bill_input" id="fbrand${st.index}" name="billorderentries[${st.index}].fbrand"  value="${map.fbrand}" >
                        </td>
                       <td>
                            <input ${readonly}  type="text" class="form-control bill_input" id="fqulity${st.index}" name="billorderentries[${st.index}].fqulity"  value="${map.fqulity}" >
                        </td>
                                <td>
                                   <input ${readonly} type="date" class="form-control bill_input" id="fdeldate${st.index}" name="billorderentries[${st.index}].fdeldate"  value="  <fmt:formatDate value="${map.fdeldate}" pattern="yyyy-MM-dd"></fmt:formatDate>" >
                               </td>
                               <td>
                                   <input ${readonly} type="text" class="form-control bill_input" id="fcontnum${st.index}" name="billorderentries[${st.index}].fcontnum"  value="${map.fcontnum}" >
                               </td>
                               <td>
                                   <input readonly type="number" class="form-control bill_input" id="freceiptqty${st.index}" name="billorderentries[${st.index}].freceiptqty"  value="${map.freceiptqty}" >
                               </td>
                               <td>
                                   <input readonly type="number" class="form-control bill_input" id="frefoundqty${st.index}" name="billorderentries[${st.index}].frefoundqty"  value="${map.frefoundqty}" >
                               </td>
                               <td>
                                   <input readonly type="number" class="form-control bill_input" id="fstoredqty${st.index}" name="billorderentries[${st.index}].fstoredqty"  value="${map.fstoredqty}" >
                               </td>
                               <td>
                                   <textarea ${readonly} rows="1" cols="10" class="form-control bill_input" id="fjudgetype${st.index}" name="billorderentries[${st.index}].fjudgetype" placeholder="" >${map.fjudgetype}</textarea>
                               </td>
                               <td>
                                   <textarea ${readonly} rows="1" cols="10" class="form-control bill_input" id="fnote${st.index}" name="billorderentries[${st.index}].fnote" placeholder="" >${map.fnote}</textarea>
                               </td>

                    </tr>
                </c:forEach>

        
    
                    </tbody>
                </table>
            </div>
   <%--         </div>--%>
        </div>

       </div>

       <div class="row">
           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fcruserid" class="col-md-3 col-sm-3 col-xs-3">制单人</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                           <div class="input-group">
                               <input type="text"  readonly onfocus="clearBasics('fcruserid')"  class="form-control" id="creator" name="creatorname"  placeholder="" value=${billorder.creator.username}>
                               <input type="hidden" class="form-control" id="fcruserid" name=fcruserid  placeholder="" value=${billorder.fcruserid}>
                               <span class="input-group-btn">
         <button class="btn btn-primary"disabled type="button" >&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
                           </div>

                       </div>
                   </div>
               </div>

           </div>
           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fcreatetime" class="col-md-3 col-sm-3 col-xs-3">制单日期</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                           <input type="date" readonly class="form-control" id="fcreatetime" name="fcreatetime"  value="<fmt:formatDate value="${billorder.fcreatetime}" pattern="yyyy-MM-dd"></fmt:formatDate>">

                       </div>
                   </div>
               </div>
           </div>
           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fchuserid" class="col-md-3 col-sm-3 col-xs-3">审核人</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                           <div class="input-group">
                               <input type="text"  readonly onfocus="clearBasics('fchuserid')"  class="form-control" id="auditor" name="auditorname"  placeholder="" value=${billorder.auditor.username}>
                               <input type="hidden" class="form-control" id="fchuserid" name=fchuserid  placeholder="" value=${billorder.fchuserid}>
                               <span class="input-group-btn">
         <button class="btn btn-primary" disabled type="button" >&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
                           </div>

                       </div>
                   </div>
               </div>

           </div>
           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fcheckdate" class="col-md-3 col-sm-3 col-xs-3">审核日期</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                           <input type="date" readonly class="form-control" id="fcheckdate" name="fcheckdate"  value="<fmt:formatDate value="${billorder.fcheckdate}" pattern="yyyy-MM-dd"></fmt:formatDate>">

                       </div>
                   </div>
               </div>
           </div>
       </div>




   <div class="form-group">
  <div class="col-sm-offset-5 col-sm-7">
  <button ${disabled} type="submit" class="btn btn-primary">
  <span class="glyphicon glyphicon-saved" aria-hidden="true"></span>   提交</button>
<c:if test="${billorder.fbillid>0}">
      <button  type="button" class="btn btn-success" id="btn-print" onclick="billprint('billorder',${billorder.fbillid})">
          <span class="glyphicon glyphicon-print" aria-hidden="true" ></span>  打印</button>
</c:if>
   <button  type="button" class="btn btn-warning" onclick="javascript:history.go(-1);">

 <span class="glyphicon glyphicon-log-out" aria-hidden="true" ></span>  返回</button>
   </div>
   </div>
  </form>
  
  </div>
<c:if test="${isoprint==1}">
    <jsp:include page="orderprint.jsp"></jsp:include>
</c:if>
     <%--<c:if test="${billorder.fbillid>0}">--%>
         <%--ewrwe--%>
         <%--<jsp:include page="orderprint.jsp"></jsp:include>--%>
     <%--</c:if>--%>
  <jsp:include page="../shared/modal.jsp"></jsp:include>

  </body>
</html>
