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
          index=${billreturn.billreturnentries.size()};
      </script>

  </head>

  <body>
     <h3 class=title>
退换货信息管理

     </h3>
    <div class="container " >

   <form action="billreturn/save"  class="form-horizontal" method="post" id=form>
   <c:if test="${billreturn.fid>0 }">  <input type="hidden" name=fid value=${billreturn.fid }></c:if>

       <div class="row">
           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fnumber" class="col-md-3 col-sm-3 col-xs-3">单据编号</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                               <input readonly type="text" class="form-control" id="fnumber" name="fnumber"  value=${billreturn.fnumber }>

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
                                                  value="<fmt:formatDate value="${billreturn.fbizdate}" pattern="yyyy-MM-dd"></fmt:formatDate>" >

                  <%--         ${billreturn.fbizdate}--%>
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
                   <label for="fstate" class="col-md-3 col-sm-3 col-xs-3">单据状态</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                               <select ${readonly} class="form-control" id=fstate name=fstate readonly>
                                   <option value="0">保存</option>
                                   <option value='1'>审核</option>
                                  <%-- <option value='2'>检验</option>--%>
                               </select>
                               <script type="application/javascript">
                                   $("#fstate").val(${billreturn.fstate});
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
                                   <input ${readonly} type="text"  required onfocus="clearBasics('fsupplierid')"  class="form-control" id="supplier" name="suppliername"  placeholder="" value=${billreturn.supplier.suppliername}>
                                   <input type="hidden" class="form-control" id="fsupplierid" name=fsupplierid  placeholder="" value=${billreturn.fsupplierid}>
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
            <label for="fbiztype" class="col-md-3 col-sm-3 col-xs-3">业务类型</label>
            <div class="col-md-9 col-sm-9 col-xs-9">
                <div class=row>

                    <select ${readonly} class="form-control" id=fbiztype name=fbiztype readonly>
                        <option value="0">退货</option>
                        <option value='1'>换货</option>
                        <%-- <option value='2'>检验</option>--%>
                    </select>
                    <script type="application/javascript">
                        $("#fbiztype").val(${billreturn.fbiztype});
                    </script>
                </div>
            </div>
        </div>
    </div>
</div>
       <div class="row">
           <div class="row">
               <div class="col-md-4 col-sm-4 col-xs-4" >
               <div class="col-md-4 col-sm-4 col-xs-4">
                   <button ${disabled} class="btn btn-primary btn-xs "  onclick="addEntry('return')">
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
                        <th>申请数量</th>
                        <th>数量</th>
                          <th>退货日期</th>
                       <th>备注</th>
                        
                    </tr>

                    </thead>
                    <tbody id="entrys">

                    <c:forEach items="${billreturn.billreturnentries}" var="map" varStatus="st">
                        <tr id="tr${st.index}">
                            <td>
                                <input type="hidden" class="form-control" id="fid${st.index}" name=billreturnentries[${st.index}].fid  placeholder="" value="${map.fid}">


                                <input type="hidden" class="form-control" id="fbillid${st.index}" name=billreturnentries[${st.index}].fbillid  placeholder="" value="${map.fbillid}">
                                <input type="hidden" class="form-control" id="fentryid${st.index}" name=billreturnentries[${st.index}].fentryid  placeholder="" value="${map.fentryid}">
                                      <div class="input-group">
                                          <input  ${readonly} type="text"  onfocus="clearBasics('fmaterialid${st.index}')"  class="form-control bill_input_b" id="material${st.index}" name="materialname${st.index}"  placeholder="" value="${map.material.materialnumber}">
                                          <input type="hidden" class="form-control" id="fmaterialid${st.index}" name=billreturnentries[${st.index}].fmaterialid  placeholder="" value="${map.fmaterialid}">
                                          <span class="input-group-btn">
                   <button class="btn btn-primary" ${disabled} type="button" onclick="getmaterial('material','fmaterialid${st.index}','material${st.index}','materialname${st.index}','','materialunit${st.index}')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
              </span>
                                      </div>
                            </td>

                                                        <td>
                                                            <input type="text" class="form-control bill_input" id="materialname${st.index}" name="billreturnentries[${st.index}].materialname"  value="${map.material.materialname}" readonly>

                                                        </td>
                                                        <td>
                                                            <input type="text" class="form-control bill_input" id="materialunit${st.index}" name="billreturnentries[${st.index}].materialunit"  value="${map.material.materialunit}" readonly>
                                                        </td>
                                                        <td>
                                                            <div class="input-group">
                                                                <input ${readonly} type="text"  onfocus="clearBasics('fstockid${st.index}')"  class="form-control bill_input_b" id="stock${st.index}" name="stockname${st.index}"  placeholder="" value="${map.stock.stockname}">
                                                                <input  type="hidden" class="form-control" id="fstockid${st.index}" name=billreturnentries[${st.index}].fstockid  placeholder="" value="${map.stock.fid}">
                                                                <span class="input-group-btn">
                                         <button class="btn btn-primary" ${disabled} type="button" onclick="showBasics('stock','fstockid${st.index}','stock${st.index}')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                    </span>
                                                            </div>
                                                        </td>
                                                        <td>
                                                            <input ${readonly} type="number" class="form-control bill_input" id="freqty${st.index}" name="billreturnentries[${st.index}].freqty"  value="${map.freqty}" >
                                                        </td>
                                                        <td>
                                                            <input ${readonly} type="number" class="form-control bill_input" id="fqty${st.index}" name="billreturnentries[${st.index}].fqty"  value="${map.fqty}" >
                                                        </td>

                                                                <td>
                                                                   <input ${readonly} type="date" class="form-control bill_input" id="fredate${st.index}" name="billreturnentries[${st.index}].fredate"  value="<fmt:formatDate value="${map.fredate}" pattern="yyyy-MM-dd"></fmt:formatDate>" >
                                                               </td>


                                                               <td>
                                                                   <textarea ${readonly} rows="1" cols="10" class="form-control bill_input" id="fnote${st.index}" name="billreturnentries[${st.index}].fnote" placeholder="" >${map.fnote}</textarea>
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
                   <label for="fcreatorid" class="col-md-3 col-sm-3 col-xs-3">制单人</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                           <div class="input-group">
                               <input type="text"  readonly onfocus="clearBasics('fcreatorid')"  class="form-control" id="creator" name="creatorname"  placeholder="" value=${billreturn.creator.username}>
                               <input type="hidden" class="form-control" id="fcreatorid" name=fcreatorid  placeholder="" value=${billreturn.fcreatorid}>
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
                   <label for="fcreatedate" class="col-md-3 col-sm-3 col-xs-3">制单日期</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                           <input type="date" readonly class="form-control" id="fcreatedate" name="fcreatedate"  value="<fmt:formatDate value="${billreturn.fcreatedate}" pattern="yyyy-MM-dd"></fmt:formatDate>">

                       </div>
                   </div>
               </div>
           </div>
           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fauditorid" class="col-md-3 col-sm-3 col-xs-3">审核人</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                           <div class="input-group">
                               <input type="text"  readonly onfocus="clearBasics('fauditorid')"  class="form-control" id="auditor" name="auditorname"  placeholder="" value=${billreturn.auditor.username}>
                               <input type="hidden" class="form-control" id="fauditorid" name=fauditorid  placeholder="" value=${billreturn.fauditorid}>
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
                   <label for="fauditdate" class="col-md-3 col-sm-3 col-xs-3">审核日期</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                           <input type="date" readonly class="form-control" id="fauditdate" name="fauditdate"  value="<fmt:formatDate value="${billreturn.fauditdate}" pattern="yyyy-MM-dd"></fmt:formatDate>">

                       </div>
                   </div>
               </div>
           </div>
       </div>




   <div class="form-group">
  <div class="col-sm-offset-5 col-sm-7">
  <button ${disabled} type="submit" class="btn btn-primary">
  <span class="glyphicon glyphicon-saved" aria-hidden="true"></span>   保存</button>
<c:if test="${billreturn.fid>0}">
      <button  type="button" class="btn btn-success" id="btn-print" onclick="billprint('billreturn',${billreturn.fid})">
          <span class="glyphicon glyphicon-print" aria-hidden="true" ></span>  打印</button>
</c:if>
   <button  type="button" class="btn btn-warning" onclick="javascript:history.go(-1);">

 <span class="glyphicon glyphicon-log-out" aria-hidden="true" ></span>  退出</button>
   </div>
   </div>
  </form>
  
  </div>
<c:if test="${isrprint==1}">
    <jsp:include page="orderprint.jsp"></jsp:include>
</c:if>
     <%--<c:if test="${billreturn.fbillid>0}">--%>
         <%--ewrwe--%>
         <%--<jsp:include page="returnprint.jsp"></jsp:include>--%>
     <%--</c:if>--%>
  <jsp:include page="../shared/modal.jsp"></jsp:include>

  </body>
</html>
