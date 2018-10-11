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
          index=${billcheck.billcheckentries.size()};

          $("#home", parent.document).removeClass("active");
          $("#link", parent.document).empty();
          $("#link", parent.document).addClass("active");
          $("#link", parent.document).text("收货通知请检单信息管理");
      </script>
  </head>
  
  <body>
     <div class=title>
&nbsp;收货通知请检单信息管理

     </div>
    <div class="container ">

   <form action="billcheck/save"  class="form-horizontal" method="post" id=form>
   <c:if test="${billcheck.fid>0 }">  <input type="hidden" name=fid value=${billcheck.fid }></c:if>

       <div class="row">
           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fnumber" class="col-md-3 col-sm-3 col-xs-3">单据编号</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                               <input readonly type="text" class="form-control" id="fnumber" name="fnumber"  value=${billcheck.fnumber }>

                           </div>
                   </div>
               </div>
           </div>
           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fbizdate" class="col-md-3 col-sm-3 col-xs-3">业务日期</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                               <input ${readonly} type="date" class="form-control" id="fbizdate" name="fbizdate"  value="<fmt:formatDate value="${billcheck.fbizdate }" pattern="yyyy-MM-dd"></fmt:formatDate>">


                           </div>
                   </div>
               </div>
           </div>
           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fstatus" class="col-md-3 col-sm-3 col-xs-3">单据状态</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                               <select readonly class="form-control" id=fstatus name=fstatus>
                                   <option value="0">保存</option>
                                   <option value='1'>审核</option>
                                   <option value='2'>检验</option>
                               </select>
                               <script type="application/javascript">
                                   $("#fstatus").val(${billcheck.fstatus});
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
                                   <input readonly type="text"  onfocus="clearBasics('fsupplierid')"  class="form-control" id="supplier" name="suppliername"  placeholder="" value=${billcheck.supplier.suppliername}>
                                   <input type="hidden" class="form-control" id="fsupplierid" name=fsupplierid  placeholder="" value=${billcheck.fsupplierid}>
                                   <span class="input-group-btn">
         <button class="btn btn-primary btn-sm" ${disabled} type="button" onclick="showBasics('supplier','fsupplierid','supplier')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
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
                   <label for="fboxno" class="col-md-3 col-sm-3 col-xs-3">箱号</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>
                        <c:choose>
                            <c:when test="${billcheck.fisqt==1}">

                                <input ${readonly} type="text" class="form-control" id="fboxno" name="fboxno"  value=${billcheck.fboxno }>
                            </c:when>
                            <c:otherwise>
                                <input readonly type="text" class="form-control" id="fboxno" name="fboxno"  value=${billcheck.fboxno }>
                            </c:otherwise>
                        </c:choose>
                       </div>
                   </div>
               </div>
           </div>
           <div class="col-md-z col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fisqt" class="col-md-3 col-sm-3 col-xs-3">齐套</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                           <input ${disabled} type="checkbox" class="check" id="fisqt"   onchange="initBoxno('billcheck')" >
                           <input type="hidden" name="fisqt" id="fisqt1" value="${billcheck.fisqt}">
<script type="text/javascript">
    if(${billcheck.fisqt==1})
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
           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fisinout" class="col-md-3 col-sm-3 col-xs-3">快进快出</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                           <input ${disabled} type="checkbox" class="check" id="fisinout"   onchange="if($('#fisinout').prop('checked')==true){$('#fisinout1').val(1);}"  >
                           <input type="hidden" name="fisinout" id="fisinout1" value="${billcheck.fisinout}">
                           <script type="text/javascript">
                               if(${billcheck.fisinout==1})
                               {
                                   $("#fisinout").prop("checked",true);

                               }
                               else {
                                   $("#fisinout").prop("checked",false);

                               }

                           </script>
                       </div>
                   </div>
               </div>
           </div>

           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fisdata" class="col-md-3 col-sm-3 col-xs-3">资料</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                           <input ${disabled} type="checkbox" class="check" id="fisdata"   onchange="if($('#fisdata').prop('checked')==true){$('#fisdata1').val(1);}"  >
                           <input type="hidden" name="fisdata" id="fisdata1" value="${billcheck.fisdata}">
                           <script type="text/javascript">
                               if(${billcheck.fisdata==1})
                               {
                                   $("#fisdata").prop("checked",true);

                               }
                               else {
                                   $("#fisdata").prop("checked",false);

                               }

                           </script>
                       </div>
                   </div>
               </div>
           </div>
       </div>

     
       <div class="row">
           <div class="row">
               <div class="col-md-10 col-sm-10 col-xs-10" >   </div>
               <div class="col-md-1 col-sm-1 col-xs-1">
                   <button ${disabled} class="btn btn-primary btn-xs " type="button" onclick="addEntry('check',${billcheck.billcheckentries.size()})">
                       <span class="glyphicon   glyphicon-plus" aria-hidden="true"></span>     增加分录</button></div>

               <div class="col-md-1 col-sm-1 col-xs-1">
                   <button ${disabled} class="btn btn-danger btn-xs " type="button"  onclick="deleteEntry()">
                       <span class="glyphicon   glyphicon-remove" aria-hidden="true"></span>     删除分录</button></div>

           </div>
           <br>
        <div class="row" >
            <div class='table-responsive' style="height: 38% !important;">
                <table class="table table-striped table-bordered ">
                    <thead>
                    <tr>
                        <th>物料代码</th>
                        <th>物料名称</th>
                        <th>计量单位</th>

                        <th>收料数量</th>
                        <th>合格数量</th>
                        <th>不合格数量</th>
                        <th>不合格原因</th>
                        <th>处理结果</th>
                        <th>生产日期</th>
                        <th>保质期</th>
                        <th>提货时间</th>
                        <th>收料仓库</th>
                        <th>批号</th>
                        <th>源单编号</th>
                    </tr>
                    </thead>
                    <tbody id="entrys">


                <c:forEach items="${billcheck.billcheckentries}" var="map" varStatus="st">
                    <tr id="tr${st.index}">


                        <td>
                            <c:if test="${map.fid>0}">
<input type="hidden" id="fid${st.index}" name="billcheckentries[${st.index}].fid" value="${map.fid}"/>
                            </c:if>
                            <c:if test="${map.fentryid>0}">
                                <input type="hidden" id="fentryid${st.index}" name="billcheckentries[${st.index}].fentryid" value="${map.fentryid}"/>
                            </c:if>
                            <c:if test="${map.fbillid>0}">
                                <input type="hidden" id="fentryid${st.index}" name="billcheckentries[${st.index}].fbillid" value="${map.fbillid}"/>
                            </c:if>
                            <div class="input-group">
                                <input readonly type="text"  onfocus="clearBasics('fmaid${st.index}')"  class="form-control  bill_input_b" id="fMaterial${st.index}" name="billcheckentries[${st.index}].fMaterialname"  placeholder="" value="${map.fMaterial.materialnumber}">
                                <input type="hidden" class="form-control" id="fmaid${st.index}" name=billcheckentries[${st.index}].fmaid  placeholder="" value="${map.fmaid}">
                                <span class="input-group-btn">
         <button class="btn btn-primary btn-sm" ${disabled} type="button" onclick="getmaterial('material','fmaid${st.index}','fMaterial${st.index}','billcheckentries[${st.index}].materialname','','billcheckentries[${st.index}].materialunit')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
                            </div>
                        </td>
                        <td>
                            <input type="text" class="form-control  bill_input" id="materialname${st.index}" name="billcheckentries[${st.index}].materialname"  value="${map.fMaterial.materialname}" readonly>

                        </td>
                        <td>
                            <input type="text" class="form-control  bill_input" id="materialunit${st.index}" name="billcheckentries[${st.index}].materialunit"  value="${map.fMaterial.materialunit}" readonly>
                        </td>

                        <td>
                            <input ${readonly} type="text" class="form-control  bill_input" id="fqty${st.index}" name="billcheckentries[${st.index}].fqty"  value="${map.fqty}" >
                        </td>
                        <td>
                                  <input  ${readcheck} type="text" class="form-control  bill_input" id="feligqty${st.index}" name="billcheckentries[${st.index}].feligqty"  value="${map.feligqty}" onchange="getunquqty(${st.index})">
                              </td>
                              <td>
                                  <input  ${readcheck} type="text" class="form-control  bill_input" id="funqty${st.index}" name="billcheckentries[${st.index}].funqty"  value="${map.funqty}" >
                              </td>
                              <td>
                                  <textarea ${readcheck} rows="1" cols="10" class="form-control  bill_input" id="freason${st.index}" name="billcheckentries[${st.index}].freason" placeholder="" >${map.freason}</textarea>
                              </td>
                              <td>
                                  <textarea  ${readcheck} rows="1" cols="10" class="form-control  bill_input" id="fresult${st.index}" name="billcheckentries[${st.index}].fresult" placeholder="" >${map.fresult}</textarea>
                              </td>
                              <td>
                                  <input ${readonly} type="date" class="form-control  bill_input" id="fdate${st.index}" name="billcheckentries[${st.index}].fdate"  value="<fmt:formatDate value="${map.fdate}" pattern="yyyy-MM-dd"></fmt:formatDate>" >
                              </td>
                              <td>
                                  <input ${readonly} type="text" class="form-control bill_input" id="fguartime${st.index}" name="billcheckentries[${st.index}].fguartime"  value="${map.fguartime}" >
                              </td>
                              <td>
                                  <input ${readonly} type="date" class="form-control  bill_input" id="fdeltime${st.index}" name="billcheckentries[${st.index}].fdeltime"  value="<fmt:formatDate value="${map.fdeltime}" pattern="yyyy-MM-dd"></fmt:formatDate>" >
                              </td>
                              <td>
                                  <div class="input-group">
                                      <input readonly type="text"  onfocus="clearBasics('fstockid${st.index}')"  class="form-control  bill_input_b" id="stock${st.index}" name="billcheckentries[${st.index}].fname"  placeholder="" value="${map.fStock.fnumber}">
                                      <input  type="hidden" class="form-control" id="fstockid${st.index}" name=billcheckentries[${st.index}].fstockid  placeholder="" value="${map.fstockid}">
                                      <span class="input-group-btn">
               <button class="btn btn-primary btn-sm " ${disabled} type="button" onclick="showBasics('erpstock','fstockid${st.index}','stock${st.index}')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
          </span>
                                  </div>
                              </td>
                              <td>
                                  <input ${readonly} type="text" class="form-control  bill_input" id="fbatch${st.index}" name="billcheckentries[${st.index}].fbatch"  value="${map.fbatch}" >
                              </td>
      <td>
          <input readonly type="text " class="form-control  bill_input" id="fonumber${st.index}" name="billcheckentries[${st.index}].fonumber" value="${map.fonumber}">
          <input  type="hidden"  id="fobillid${st.index}" name="billcheckentries[${st.index}].fobillid" value="${map.fobillid}">
          <input  type="hidden"  id="foid${st.index}" name="billcheckentries[${st.index}].foid" value="${map.foid}">
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
                   <label for="fcruid" class="col-md-3 col-sm-3 col-xs-3">制单人</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                           <div class="input-group">
                               <input type="text"  readonly onfocus="clearBasics('fcruid')"  class="form-control" id="creator" name="creatorname"  placeholder="" value=${billcheck.creator.username}>
                               <input type="hidden" class="form-control" id="fcruid" name=fcruid  placeholder="" value=${billcheck.fcruid}>
                               <span class="input-group-btn">
         <button class="btn btn-primary btn-sm"disabled type="button" >&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
                           </div>

                       </div>
                   </div>
               </div>

           </div>
           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fcretime" class="col-md-3 col-sm-3 col-xs-3">制单日期</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                           <input type="date" readonly class="form-control" id="fcretime" name="fcretime"  value="<fmt:formatDate value="${billcheck.fcretime }" pattern="yyyy-MM-dd"></fmt:formatDate>">


                       </div>
                   </div>
               </div>
           </div>
           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fchuid" class="col-md-3 col-sm-3 col-xs-3">审核人</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                           <div class="input-group">
                               <input type="text"  readonly onfocus="clearBasics('fchuid')"  class="form-control" id="auditor" name="auditorname"  placeholder="" value=${billcheck.auditor.username}>
                               <input type="hidden" class="form-control" id="fchuid" name=fchuid  placeholder="" value=${billcheck.fchuid}>
                               <span class="input-group-btn">
         <button class="btn btn-primary btn-sm" disabled type="button" >&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
                           </div>

                       </div>
                   </div>
               </div>

           </div>
           <div class="col-md-3 col-sm-3 col-xs-3">
               <div class="form-group">
                   <label for="fchetime" class="col-md-3 col-sm-3 col-xs-3">审核日期</label>
                   <div class="col-md-9 col-sm-9 col-xs-9">
                       <div class=row>

                           <input type="date" readonly class="form-control" id="fchetime" name="fchetime"  value="<fmt:formatDate value="${billcheck.fchetime }" pattern="yyyy-MM-dd"></fmt:formatDate>">

                       </div>
                   </div>
               </div>
           </div>
       </div>




       <div class="form-group">
           <div class="col-sm-offset-5 col-sm-7">
               <button ${readcheck} type="submit" class="btn btn-primary btn-sm">
                   <span class="glyphicon glyphicon-saved" aria-hidden="true"></span>   保存</button>
               <c:if test="${billcheck.fid>0}">
                   <button  type="button" class="btn btn-success btn-sm" id="btn-print" onclick="billprint('billcheck',${billcheck.fid})">
                       <span class="glyphicon glyphicon-print" aria-hidden="true" ></span>  打印</button>
               </c:if>
               <button  type="button" class="btn btn-warning btn-sm" onclick="location.href='billcheck/getList'">

                   <span class="glyphicon glyphicon-log-out" aria-hidden="true" ></span>  退出</button>
           </div>
       </div>
  </form>
  
  </div>
     <c:if test="${iscprint==1}">

         <jsp:include page="checkprint.jsp"></jsp:include>
     </c:if>
  <jsp:include page="../shared/modal.jsp"></jsp:include>
  </body>
</html>
