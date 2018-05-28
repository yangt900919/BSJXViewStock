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
          index=${billstock.billstockentries.size()}
      </script>
  </head>
  
  <body>
     <h3 class=title>
入库单信息管理

     </h3>
    <div class="container ">

   <form action="billstock/save"  class="form-horizontal" method="post" id=form>
   <c:if test="${billstock.fid>0 }">  <input type="hidden" name=fid value=${billstock.fid }></c:if>

       <div class="row">
           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fnumber" class="col-md-3 col-sm-3 col-xs-3">单据编号</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                               <input readonly type="text" class="form-control" id="fnumber" name="fnumber"  value=${billstock.fnumber }>

                           </div>
                   </div>
               </div>
           </div>
           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fbizdate" class="col-md-3 col-sm-3 col-xs-3">业务日期</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                               <input ${readonly} type="date" class="form-control" id="fbizdate" name="fbizdate"  value="<fmt:formatDate value="${billstock.fbizdate }" pattern="yyyy-MM-dd"></fmt:formatDate>">

                           </div>
                   </div>
               </div>
           </div>
           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fstatus" class="col-md-3 col-sm-3 col-xs-3">单据状态</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                               <select ${readonly} class="form-control" id=fstatus name=fstatus>
                                   <option value="0">保存</option>
                                   <option value='1'>审核</option>
                               </select>
                               <script type="application/javascript">
                                   $("#fstatus").val(${billstock.fstatus});
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
                                   <input ${readonly} type="text"  onfocus="clearBasics('fsupplierid')"  class="form-control" id="supplier" name="suppliername"  placeholder="" value=${billstock.supplier.suppliername}>
                                   <input type="hidden" class="form-control" id="fsupplierid" name=fsupplierid  placeholder="" value=${billstock.fsupplierid}>
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
                   <label for="fstockid" class="col-md-3 col-sm-3 col-xs-3">仓库</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                           <div class="input-group">
                               <input type="text"  ${readonly} onfocus="clearBasics('fstockid')"  class="form-control" id="stock" name="stockname"  placeholder="" value=${billstock.stock.stockname}>
                               <input type="hidden" class="form-control" id="fstockid" name=fstockid  placeholder="" value=${billstock.fstockid}>
                               <span class="input-group-btn">
         <button class="btn btn-primary" type="button" onclick="showBasics('stock','fstockid','stock')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
                           </div>

                       </div>
                   </div>
               </div>
           </div>
           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fkeeperid" class="col-md-3 col-sm-3 col-xs-3">库管</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                           <div class="input-group">
                               <input type="text" required  ${readonly} onfocus="clearBasics('fkeeperid')"  class="form-control" id="keeper" name="keepername"  placeholder="" value=${billstock.keeper.username}>
                               <input type="hidden" class="form-control" id="fkeeperid" name=fkeeperid  placeholder="" value=${billstock.fkeeperid}>
                               <span class="input-group-btn">
         <button class="btn btn-primary" type="button" onclick="showBasics('user','fkeeperid','keeper')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
                           </div>

                       </div>
                   </div>
               </div>
           </div>
           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fboxno" class="col-md-3 col-sm-3 col-xs-3">箱号</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>
                           <c:choose>
                               <c:when test="${billstock.fisqt==1}">

                                   <input ${readonly} type="text" class="form-control" id="fboxno" name="fboxno"  value=${billstock.fboxno }>
                               </c:when>
                               <c:otherwise>
                                   <input readonly type="text" class="form-control" id="fboxno" name="fboxno"  value=${billstock.fboxno }>
                               </c:otherwise>
                           </c:choose>
                       </div>
                   </div>
               </div>
           </div>
           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fisqt" class="col-md-3 col-sm-3 col-xs-3">齐套</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                           <input ${disabled} type="checkbox" class="check" id="fisqt" name="fisqt"  onchange="initBoxno('billstock')" value="${billstock.fisqt}">
                           <script type="text/javascript">
                               if(${billstock.fisqt==1})
                               {
                                   $("#fisqt").prop("checked",true);

                               }
                               else {
                                   $("#fisqt").prop("checked",false);

                               }
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
                   <a class="btn btn-primary btn-xs "  href="javaScript:void(0)" onclick="addEntry('stock')">
                       <span class="glyphicon   glyphicon-plus" aria-hidden="true"></span>     增加分录</a></div>

           <div class="col-md-4 col-sm-4 col-xs-4">
               <a class="btn btn-danger btn-xs " href="javaScript:void(0)" onclick="deleteEntry()">
                   <span class="glyphicon   glyphicon-remove" aria-hidden="true"></span>     删除分录</a></div>
           </div>
           </div>
           <br>
        <div class="row" >
<div class="table-responsive">
                <table class="table table-striped table-bordered ">
                    <thead>
                    <tr>
                        <th>物料代码</th>
                        <th>物料名称</th>
                        <th>计量单位</th>
                        <th>批号</th>
                        <th>申请数量</th>
                        <th>已入数量</th>

                        <th>仓库</th>
                        <th>源单编号</th>
                    </tr>
                    </thead>
                    <tbody id="entrys">


                <c:forEach items="${billstock.billstockentries}" var="map" varStatus="st">
                    <tr id="tr${st.index}">

                        <td>
                            <c:if test="${map.fid>0}">
                                <input type="hidden" id="fid${st.index}" name="billstockentries[${st.index}].fid" value="${map.fid}"/>
                            </c:if>
                            <c:if test="${map.fentryid>0}">
                                <input type="hidden" id="fentryid${st.index}" name="billstockentries[${st.index}].fentryid" value="${map.fentryid}"/>
                            </c:if>
                            <div class="input-group">
                                <input ${readonly} type="text"  onfocus="clearBasics('fmaterialid${st.index}')"  class="form-control bill_input_b" id="material${st.index}" name="billstockentries[${st.index}].maname"  placeholder="" value="${map.material.materialnumber}">
                                <input type="hidden" class="form-control" id="fmaterialid${st.index}" name=billstockentries[${st.index}].fmaterialid  placeholder="" value="${map.fmaterialid}">
                                <span class="input-group-btn">
         <button class="btn btn-primary" ${disabled} type="button" onclick="getmaterial('material','fmaterialid${st.index}','material${st.index}','materialname${st.index}','','materialunit${st.index}')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
                            </div>
                        </td>
                        <td>
                            <input type="text" class="form-control bill_input" id="materialname${st.index}" name="billstockentries[${st.index}].materialname"  value="${map.material.materialname}" readonly>

                        </td>
                        <td>
                            <input type="text" class="form-control bill_input" id="materialunit${st.index}" name="billstockentries[${st.index}].materialunit"  value="${map.material.materialunit}" readonly>
                        </td>
                           <td>
                                 <input ${readonly} type="text" class="form-control bill_input" id="fbatch${st.index}" name="billstockentries[${st.index}].flot"  value="${map.fbatch}" >
                             </td>
                             <td>
                                 <input ${readonly} type="number" class="form-control bill_input" id="fqty${st.index}" name="billstockentries[${st.index}].fqty"  value="${map.fqty}" >
                             </td>
                            <td>
                                 <input ${readonly}  type="number" class="form-control bill_input" id="factqty${st.index}" name="billstockentries[${st.index}].factqty"  value="${map.factqty}" >
                             </td>

                                <td>
                                 <div class="input-group">
                                     <input ${readonly} type="text"  onfocus="clearBasics('fstockid${st.index}')"  class="form-control bill_input_b" id="stock${st.index}" name="billstockentries[${st.index}].stockname"  placeholder="" value="${map.stock.stockname}">
                                     <input  type="hidden" class="form-control" id="fstockid${st.index}" name=billstockentries[${st.index}].fstockid  placeholder="" value="${map.fstockid}">
                                     <span class="input-group-btn">
              <button class="btn btn-primary" ${disabled} type="button" onclick="showBasics('stock','fstockid${st.index}','stock${st.index}')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
         </span>
                                 </div>
                             </td>
                             <td>
                                 <input readonly type="text " class="form-control  bill_input" id="fonumber${st.index}" name="billstockentries[${st.index}].fonumber" value="${map.fonumber}">
                                 <input  type="hidden"  id="fobillid${st.index}" name="billstockentries[${st.index}].fobillid" value="${map.fobillid}">
                                 <input  type="hidden"  id="foid${st.index}" name="billstockentries[${st.index}].foid" value="${map.foid}">

                                 <input  type="hidden"  id="fbillid${st.index}" name="billstockentries[${st.index}].fbillid" value="${map.fbillid}">
                             </td>

                    </tr>
                </c:forEach>

        
    
                    </tbody>
                </table>
</div>
        </div>

       </div>

       <div class="row">
           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fuserid" class="col-md-3 col-sm-3 col-xs-3">制单人</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                           <div class="input-group">
                               <input type="text"  readonly onfocus="clearBasics('fuserid')"  class="form-control" id="creator" name="creatorname"  placeholder="" value=${billstock.creator.username}>
                               <input type="hidden" class="form-control" id="fuserid" name=fuserid  placeholder="" value=${billstock.fuserid}>
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
                   <label for="fdate" class="col-md-3 col-sm-3 col-xs-3">制单日期</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                           <input type="date" readonly class="form-control" id="fdate" name="fdate"  value="<fmt:formatDate value="${billstock.fdate }" pattern="yyyy-MM-dd"></fmt:formatDate>">

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
                               <input type="text"  readonly onfocus="clearBasics('fchuserid')"  class="form-control" id="auditor" name="auditorname"  placeholder="" value=${billstock.auditor.username}>
                               <input type="hidden" class="form-control" id="fchuserid" name=fchuserid  placeholder="" value=${billstock.fchuserid}>
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
                   <label for="fchedate" class="col-md-3 col-sm-3 col-xs-3">审核日期</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                           <input type="date" readonly class="form-control" id="fchedate" name="fchedate"  value="<fmt:formatDate value="${billstock.fchedate }" pattern="yyyy-MM-dd"></fmt:formatDate>">

                       </div>
                   </div>
               </div>
           </div>
       </div>




       <div class="form-group">
           <div class="col-sm-offset-5 col-sm-7">
               <button ${disabled} type="submit" class="btn btn-primary">
                   <span class="glyphicon glyphicon-saved" aria-hidden="true"></span>   提交</button>
               <c:if test="${billstock.fid>0}">
                   <button  type="button" class="btn btn-success" id="btn-print" onclick="billprint('billstock',${billstock.fid})">
                       <span class="glyphicon glyphicon-print" aria-hidden="true" ></span>  打印</button>
               </c:if>
               <button  type="button" class="btn btn-warning" onclick="javascript:history.go(-1);">

                   <span class="glyphicon glyphicon-log-out" aria-hidden="true" ></span>  返回</button>
           </div>
       </div>
  </form>
  
  </div>
     <c:if test="${issprint==1}">

         <jsp:include page="stockprint.jsp"></jsp:include>
     </c:if>
  <jsp:include page="../shared/modal.jsp"></jsp:include>
  </body>
</html>
