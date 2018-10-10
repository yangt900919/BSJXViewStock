<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
       parent.index=${billget.billgetentries.size()};
        var dstock="${dstock}";
        var dstockid="${dstockid}";

       $(document).ready(function()
       {
           if(${billget.billgetentries.size()==0})
           {
               addEntry('get',${billget.billgetentries.size()});
           }

       });
        function save()
        {
            if($("#fbiztype").val()=='')
            {
                alert("请选择业务类型!");
            }
            else
            {
                var biztype=$("#fbiztype").val();
                var depart=$("#organization").val();
                var custom=$("#custom").val();
                if(biztype=='生产领料')
                {
                    if(depart=='')
                    {
                        alert("请选择领料单位!");
                    }
                    else {
                        if(index>0)
                        {
                            //alert(index);
                            var flag=false;
                            var msg="";
                            for(var i=0;i<index;i++)
                            {
                                //alert(Number($("#finventory"+i).val()));
                                if($("#material"+i).val()=='')
                                {
                                    msg="第"+(Number(i)+1)+"行请选择物料!";
                                    flag=true;
                                    break;
                                }
                                else if(!isNaN($("#fapplyqty"+i).val()))
                                {
                                    if(Number($("#fapplyqty"+i).val())<=0)
                                    {
                                        msg="第"+(Number(i)+1)+"行申请数量需大于0!";
                                        flag=true;
                                        break;
                                    }
                                }
                                else if(isNaN($("#fapplyqty"+i).val()))
                                {

                                    msg="第"+(Number(i)+1)+"行申请数量为非法数字!";
                                    flag=true;
                                    break;
                                }
                            /*    else if(Number($("#finventory"+i).val())<Number($("#fapplyqty"+i).val()))
                                {

                                    msg="第"+(Number(i)+1)+"行库存不足!";
                                    flag=true;
                                    break;
                                }*/

                            }

                            if(flag)alert(msg);
                            else
                                $("#form").submit();
                        }

                        else
                            alert("请至少添加一行!");
                    }
                }
                else
                {
                    if(custom=="")
                    {
                        alert("请选择客户!");
                    }
                    else
                    {
                        if(index>0)

                        {
                            var flag=false;
                            var msg="";
                            for(var i=0;i<index;i++)
                            {

                                if($("#material"+i).val()=='')
                                {

                                    msg="第"+(Number(i)+1)+"行请选择物料!";
                                    flag=true;
                                    break;
                                }
                                else if(!isNaN($("#fapplyqty"+i).val()))
                                {

                                    if(Number($("#fapplyqty"+i).val())<=0)
                                    { msg="第"+(Number(i)+1)+"行申请数量需大于0!";
                                    flag=true;
                                    break;}
                                }
                                else if(isNaN($("#fapplyqty"+i).val()))
                                {

                                    msg="第"+(Number(i)+1)+"行申请数量为非法数字!";
                                    flag=true;
                                    break;
                                }
                           /*     else if(Number($("#finventory"+i).val())<Number($("#fapplyqty"+i).val()))
                                {

                                    msg="第"+(Number(i)+1)+"行库存不足!";
                                    flag=true;
                                    break;
                                }
*/

                            }
                            if(flag)alert(msg);
                            else
                                $("#form").submit();
                        }
                        else
                            alert("请至少添加一行!");
                    }
                }
            }

        }
    </script>
</head>

<body>
<h3 class=title>
    &nbsp;出库单信息管理

</h3>
<div class="container ">

    <form action="billget/save"  class="form-horizontal" method="post" id=form>
        <c:if test="${billget.fid>0 }">  <input type="hidden" name=fid value=${billget.fid }></c:if>

        <div class="row">
            <div class="col-md-3 col-sm-3 col-xs-3">
                <div class="form-group">
                    <label for="fnumber" class="col-md-3 col-sm-3 col-xs-3">单据编号</label>
                    <div class="col-md-9 col-sm-9 col-xs-9">
                        <div class=row>

                            <input readonly type="text" class="form-control" id="fnumber" name="fnumber"  value=${billget.fnumber }>

                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-3 col-xs-3">
                <div class="form-group">
                    <label for="fdodate" class="col-md-3 col-sm-3 col-xs-3">业务日期</label>
                    <div class="col-md-9 col-sm-9 col-xs-9">
                        <div class=row>

                            <input ${readonly} type="date" class="form-control" id="fdodate" name="fdodate"  value="<fmt:formatDate value="${billget.fdodate}" pattern="yyyy-MM-dd"></fmt:formatDate>">

                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-3 col-xs-3">
                <div class="form-group">
                    <label for="fbiztype" class="col-md-3 col-sm-3 col-xs-3">业务类型</label>
                    <div class="col-md-9 col-sm-9 col-xs-9">
                        <div class=row>

                            <select ${readonly} class="form-control" id=fbiztype name=fbiztype required>
                                <option value=""></option>
                                <option value='生产领料'>生产领料</option>
                                <option value='调拨出库'>调拨出库</option>
                            </select>
                            <script type="application/javascript">
                                $("#fbiztype").val("${billget.fbiztype}");
                            </script>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-3 col-xs-3">
                <div class="form-group">
                    <label for="fdepartmentid" class="col-md-3 col-sm-3 col-xs-3">领料单位</label>
                    <div class="col-md-9 col-sm-9 col-xs-9">
                        <div class=row>

                            <div class="input-group">
                                <input readonly type="text"  onfocus="clearBasics('fdepartmentid')"  class="form-control" id="organization" name="organizationname"  placeholder="" value=${billget.organization.organizationname}>
                                <input type="hidden" class="form-control" id="fdepartmentid" name=fdepartmentid  placeholder="" value=${billget.fdepartmentid}>
                                <span class="input-group-btn">
         <button class="btn btn-primary btn-sm" ${disabled} type="button" onclick="showBasics('depart','fdepartmentid','organization')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
                            </div>

                        </div>
                    </div>
                </div>

            </div>
        </div>
        <div class="row">
            <%--             <div class="col-md-3 col-sm-3 col-xs-3">
                             <div class="form-group">
                                 <label for="fsendstockid" class="col-md-3 col-sm-3 col-xs-3">仓库</label>
                                 <div class="col-md-9 col-sm-9 col-xs-9">
                                     <div class=row>

                                         <div class="input-group">
                                             <input ${readonly} type="text"  onfocus="clearBasics('fsendstockid')"  class="form-control" id="stock" name="fname"  placeholder="" value=${billget.stock.fname}>
                                             <input type="hidden" class="form-control" id="fsendstockid" name=fsendstockid  placeholder="" value=${billget.fsendstockid}>
                                             <span class="input-group-btn">
                       <button class="btn btn-primary" ${disabled} type="button" onclick="showBasics('erpstock','fsendstockid','erpstock')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                  </span>
                                         </div>

                                     </div>
                                 </div>
                             </div>

                         </div>--%>
            <div class="col-md-3 col-sm-3 col-xs-3">
                <div class="form-group">
                    <label for="fcustomid" class="col-md-3 col-sm-3 col-xs-3">客户</label>
                    <div class="col-md-9 col-sm-9 col-xs-9">
                        <div class=row>

                            <div class="input-group">
                                <input readonly type="text"  onfocus="clearBasics('fcustomid')"  class="form-control" id="custom" name="customname"  placeholder="" value=${billget.custom.customname}>
                                <input type="hidden" class="form-control" id="fcustomid" name=fcustomid  placeholder="" value=${billget.fcustomid}>
                                <span class="input-group-btn">
           <button class="btn btn-primary btn-sm" ${disabled} type="button" onclick="showBasics('custom','fcustomid','custom')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
      </span>
                            </div>

                        </div>
                    </div>
                </div>

            </div>
            <div class="col-md-3 col-sm-3 col-xs-3">
                <div class="form-group">
                    <label for="fgeterid" class="col-md-3 col-sm-3 col-xs-3">发料人</label>
                    <div class="col-md-9 col-sm-9 col-xs-9">
                        <div class=row>

                            <div class="input-group">
                                <input readonly type="text"  onfocus="clearBasics('fgeterid')"  class="form-control" id="getuser" name="getusername"  placeholder="" value=${billget.getuser.username}>
                                <input  type="hidden" class="form-control" id="fgeterid" name=fgeterid  placeholder="" value=${billget.fgeterid}>
                                <span class="input-group-btn">
           <button class="btn btn-primary btn-sm" ${disabled} type="button" onclick="showBasics('user','fgeterid','getuser')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
      </span>
                            </div>

                        </div>
                    </div>
                </div>

            </div>
            <%--     <div class="col-md-3 col-sm-3 col-xs-3">
                     <div class="form-group">
                         <label for="fsenderid" class="col-md-3 col-sm-3 col-xs-3">领料人</label>
                         <div class="col-md-9 col-sm-9 col-xs-9">
                             <div class=row>

                                 <div class="input-group">
                                     <input readonly type="text"  onfocus="clearBasics('fsenderid')"  class="form-control" id="senduser" name="sendusername"  placeholder="" value=${billget.senduser.username}>
                                     <input type="hidden" class="form-control" id="fsenderid" name=fsenderid  placeholder="" value=${billget.fsenderid}>
                                     <span class="input-group-btn">
               <button class="btn btn-primary btn-sm" ${disabled} type="button" onclick="showBasics('user','fsenderid','senduser')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
          </span>
                                 </div>

                             </div>
                         </div>
                     </div>

                 </div>--%>
            <div class="col-md-3 col-sm-3 col-xs-3">
                <div class="form-group">
                    <label for="fstate" class="col-md-3 col-sm-3 col-xs-3">单据状态</label>
                    <div class="col-md-9 col-sm-9 col-xs-9">
                        <div class=row>

                            <select ${readonly} class="form-control" id=fstate name=fstate>
                                <option value="0">保存</option>
                                <option value='1'>审核</option>
                            </select>
                            <script type="application/javascript">
                                $("#fstate").val(${billget.fstate});
                            </script>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-3 col-xs-3">
                <div class="form-group">
                    <label for="fisqt" class="col-md-3 col-sm-3 col-xs-3">齐套</label>
                    <div class="col-md-9 col-sm-9 col-xs-9">
                        <div class=row>

                            <input ${disabled} type="checkbox" class="check" id="fisqt" name="fisqt"  onchange="if($('#fisqt').prop('checked')==true) $('#fisqt').val(1);else $('#fisqt').val(0);" value="${billget.fisqt}">
                            <script type="text/javascript">
                                if(${billget.fisqt==1})
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



        </div>
        <div class="row">
            <div class="row">
                <div class="col-md-10 col-sm-10 col-xs-10" >   </div>
                <div class="col-md-1 col-sm-1 col-xs-1">
                    <button ${disabled} class="btn btn-primary btn-xs " type="button"  onclick="addEntry('get',${billget.billgetentries.size()})">
                        <span class="glyphicon   glyphicon-plus" aria-hidden="true"></span>     增加分录</button></div>

                <div class="col-md-1 col-sm-1 col-xs-1">
                    <button ${disabled} class="btn btn-danger btn-xs " type="button" onclick="deleteEntry()">
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

                            <th>申请数量</th>
                            <th>实发数量</th>
                            <th>即时库存</th>
                            <th>发料仓库</th>
                            <th>备注</th>
                            <th>批号</th>
                        </tr>
                        </thead>
                        <tbody id="entrys">

                        <c:forEach items="${billget.billgetentries}" var="map" varStatus="st">
                            <tr id="tr${st.index}">

                                <td>
                                    <c:if test="${map.fid>0}">
                                        <input type="hidden" id="fid${st.index}" name="billgetentries[${st.index}].fid" value="${map.fid}"/>
                                    </c:if>
                                    <c:if test="${map.fentryid>0}">
                                        <input type="hidden" id="fentryid${st.index}" name="billgetentries[${st.index}].fentryid" value="${map.fentryid}"/>
                                    </c:if>

                                    <c:if test="${map.fbillid>0}">
                                        <input type="hidden" id="fbillid${st.index}" name="billgetentries[${st.index}].fbillid" value="${map.fbillid}"/>
                                    </c:if>
                                    <div class="input-group">
                                        <input readonly type="text"  onfocus="clearBasics('fmaterialid${st.index}')"  class="form-control bill_input_b" id="material${st.index}" name="materialn${st.index}"  placeholder="" value="${map.material.materialnumber}">
                                        <input type="hidden" class="form-control" id="fmaterialid${st.index}" name=billgetentries[${st.index}].fmaterialid  placeholder="" value="${map.material.fid}">
                                        <span class="input-group-btn">
         <button class="btn btn-primary btn-sm" ${disabled} type="button" onclick="getmaterial('material','fmaterialid${st.index}','material${st.index}','materialname${st.index}','finventory${st.index}','materialunit${st.index}')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
                                    </div>
                                </td>
                                <td>
                                    <input type="text" class="form-control bill_input" id="materialname${st.index}" name="billgetentries[${st.index}].materialname"  value="${map.material.materialname}" readonly>

                                </td>
                                <td>
                                    <input type="text" class="form-control bill_input" id="materialunit${st.index}" name="billgetentries[${st.index}].materialunit"  value="${map.material.materialunit}" readonly>
                                </td>

                                <td>
                                    <input ${readonly} type="text" class="form-control bill_input" id="fapplyqty${st.index}" name="billgetentries[${st.index}].fapplyqty"  value="${map.fapplyqty}" >
                                </td>
                                <td>
                                    <input readonly  type="text" class="form-control bill_input" id="frealqty${st.index}" name="billgetentries[${st.index}].frealqty"  value="${map.frealqty}" >
                                </td>
                                <td>
                                    <input readonly type="text" class="form-control bill_input" id="finventory${st.index}"   value="${map.finventory}" >
                                </td>
                                <td>
                                    <div class="input-group">
                                        <input readonly type="text"  onfocus="clearBasics('fsendstockid${st.index}')"  class="form-control bill_input_b" id="stock${st.index}" name="billgetentries[${st.index}].efname"  placeholder="" value="${map.estock.fnumber}">
                                        <input  type="hidden" class="form-control" id="fsendstockid${st.index}" name=billgetentries[${st.index}].fsendstockid  placeholder="" value="${map.estock.fid}">
                                        <span class="input-group-btn">
         <button class="btn btn-primary btn-sm" ${disabled} type="button" onclick="showBasics('erpstock','fsendstockid${st.index}','stock${st.index}')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
                                    </div>
                                </td>
                                <td>
                                    <textarea ${readonly} rows="1" cols="10" class="form-control bill_input" id="fnote${st.index}" name="billgetentries[${st.index}].fnote" placeholder="" >${map.fnote}</textarea>
                                </td>
                                <td>
                                    <input ${readonly} type="text" class="form-control bill_input" id="flot${st.index}" name="billgetentries[${st.index}].flot"  value="${map.flot}" >
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
                    <label for="fcreaterid" class="col-md-3 col-sm-3 col-xs-3">制单人</label>
                    <div class="col-md-9 col-sm-9 col-xs-9">
                        <div class=row>

                            <div class="input-group">
                                <input type="text"  readonly onfocus="clearBasics('fcreaterid')"  class="form-control" id="creator" name="creatorname"  placeholder="" value=${billget.creator.username}>
                                <input type="hidden" class="form-control" id="fcreaterid" name=fcreaterid  placeholder="" value=${billget.fcreaterid}>
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
                    <label for="fcreatedate" class="col-md-3 col-sm-3 col-xs-3">制单日期</label>
                    <div class="col-md-9 col-sm-9 col-xs-9">
                        <div class=row>

                            <input type="date" readonly class="form-control" id="fcreatedate" name="fcreatedate"  value="<fmt:formatDate value="${billget.fcreatedate }" pattern="yyyy-MM-dd"></fmt:formatDate>">

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
                                <input type="text"  readonly onfocus="clearBasics('fauditorid')"  class="form-control" id="auditor" name="auditorname"  placeholder="" value=${billget.auditor.username}>
                                <input type="hidden" class="form-control" id="fauditorid" name=fauditorid  placeholder="" value=${billget.fauditorid}>
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
                    <label for="fauditdate" class="col-md-3 col-sm-3 col-xs-3">审核日期</label>
                    <div class="col-md-9 col-sm-9 col-xs-9">
                        <div class=row>

                            <input type="date" readonly class="form-control" id="fauditdate" name="fauditdate"  value="<fmt:formatDate value="${billget.fauditdate }" pattern="yyyy-MM-dd"></fmt:formatDate>">

                        </div>
                    </div>
                </div>
            </div>
        </div>





        <div class="form-group">
            <div class="col-sm-offset-5 col-sm-7">
                <button ${disabled} type="button" class="btn btn-primary btn-sm" onclick="save()">
                    <span class="glyphicon glyphicon-saved" aria-hidden="true"></span>   保存</button>
                <c:if test="${billget.fid>0}">
                    <button  type="button" class="btn btn-success btn-sm" id="btn-print" onclick="billprint('billget',${billget.fid})">
                        <span class="glyphicon glyphicon-print" aria-hidden="true" ></span>  打印</button>
                </c:if>
                <button  type="button" class="btn btn-warning btn-sm" onclick="javascript:history.go(-1);">

                    <span class="glyphicon glyphicon-log-out" aria-hidden="true" ></span>  退出</button>
            </div>
        </div>
    </form>

</div>
<c:if test="${isgprint==1}">
    <jsp:include page="getprint.jsp"></jsp:include>
</c:if>
<jsp:include page="../shared/modal.jsp"></jsp:include>
</body>

</html>
