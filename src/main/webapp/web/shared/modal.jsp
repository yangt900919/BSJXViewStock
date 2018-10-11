<%--
  Created by IntelliJ IDEA.
  User: Yang
  Date: 2018/4/15
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="resource.jsp"></jsp:include>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="modal fade" id="erpstockmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >仓库信息列表</h4>
            </div>
            <div class="modal-body">
                <table class="table table-bordered table-hover  table-striped" id=erpstocktable>
                    <thead>
                    <tr>
                        <th >仓库编号</th>
                        <th >仓库名称</th>
                        <%--  <th>仓库地址</th>
                          <th>联系电话</th>--%>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${erpstocklist }" var="map">
                        <tr ondblclick="getBasics('erpstock','${map.fid}','${map.fnumber }')">
                            <td>${map.fnumber }</td>
                                <%-- <td>${map.FErpNumber }</td> --%>
                            <td>${map.fname }</td>
                                <%-- <td>${map.stockaddress }</td>
                               <td>${map.stocktel }</td>--%>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>
<div class="modal fade" id="stockmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >仓库信息列表</h4>
            </div>
            <div class="modal-body">
                <table class="table table-bordered table-hover  table-striped" id=stocktable>
                    <thead>
                    <tr>
                        <th >仓库编号</th>
                        <th >仓库名称</th>
                        <th>仓库地址</th>
                        <th>联系电话</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${stocklist }" var="map">
                        <tr ondblclick="getBasics('stock','${map.fid}','${map.stockname }')">
                            <td>${map.stocknumber }</td>
                                <%-- <td>${map.FErpNumber }</td> --%>
                            <td>${map.stockname }</td>
                                   <td>${map.stockaddress }</td>
                                 <td>${map.stocktel }</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="materialmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >物料信息列表</h4>
            </div>
            <div class="modal-body">
                <table class="table table-bordered table-hover  table-striped" id=materialtable>
                    <thead>
                    <tr>
                        <th >物料编码</th>
                        <th >物料名称</th>
                        <th>计量单位</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${materiallist }" var="map">
                        <tr ondblclick="materialCheck('material','${map.fid}','${map.materialnumber }','${map.materialname }','','${map.materialunit}')">
                            <td>${map.materialnumber }</td>
                                <%-- <td>${map.FErpNumber }</td> --%>
                            <td>${map.materialname }</td>
                            <td>${map.materialunit }</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="mamodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >物料信息列表</h4>
            </div>
            <div class="modal-body">
                <table class="table table-bordered table-hover  table-striped" id=matable>
                    <thead>
                    <tr>
                        <th >物料编码</th>
                        <th >物料名称</th>
                        <th>计量单位</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${materiallist }" var="map">
                        <tr ondblclick="getBasics('ma','${map.fid}','${map.materialname }')">
                            <td>${map.materialnumber }</td>
                                <%-- <td>${map.FErpNumber }</td> --%>
                            <td>${map.materialname }</td>
                            <td>${map.materialunit }</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="usermodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >用户信息列表</h4>
            </div>
            <div class="modal-body">
                <table class="table table-bordered table-hover  table-striped" id=usertable>
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th >用户名</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userlist }" var="map" varStatus="st">
                        <tr ondblclick="getBasics('user','${map.fid}','${map.username }')">
                            <td>${st.count}</td>
                                <%-- <td>${map.FErpNumber }</td> --%>
                            <td>${map.username }</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="departmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >领料单位信息列表</h4>
            </div>
            <div class="modal-body">
                <table class="table table-bordered table-hover  table-striped" id=departtable>
                    <thead>
                    <tr>
                        <th >单位编码</th>
                        <th >单位名称</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${orgnizationlist}" var="map">
                        <tr ondblclick="getBasics('depart','${map.fid}','${map.organizationname }')">
                            <td>${map.organizationnumber}</td>
<td>${map.organizationname}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="custommodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >客户信息列表</h4>
            </div>
            <div class="modal-body">
                <table class="table table-bordered table-hover  table-striped" id=customtable>
                    <thead>
                    <tr>
                        <th >客户编码</th>
                        <th >客户名称</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${customlist }" var="map">
                        <tr ondblclick="getBasics('custom','${map.fid}','${map.customname }')">
                            <td>${map.customnumber }</td>
                                <%-- <td>${map.FErpNumber }</td> --%>
                            <td>${map.customname }</td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="suppliermodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >供应商信息列表</h4>
            </div>
            <div class="modal-body">
                <table class="table table-bordered table-hover  table-striped" id=suppliertable>
                    <thead>
                    <tr>
                        <th >供应商编码</th>
                        <th >供应商名称</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${supplierlist }" var="map">
                        <tr ondblclick="getBasics('supplier','${map.fid}','${map.suppliername}')">
                            <td>${map.suppliernumber }</td>
                                <%-- <td>${map.FErpNumber }</td> --%>
                            <td>${map.suppliername }</td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="cabinetmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >柜列信息列表</h4>
            </div>
            <div class="modal-body">
                <table class="table table-bordered table-hover  table-striped" id=cabinettable>
                    <thead>
                    <tr>
                        <th >柜列编码</th>
                        <th >柜列名称</th>
                        <th>仓库编码</th>
                        <th>仓库名称</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cabinetlist }" var="map">
                        <tr ondblclick="getBasics('cabinet','${map.fid}','${map.fname }')">
                            <td>${map.fnumber }</td>
                                <%-- <td>${map.FErpNumber }</td> --%>
                            <td>${map.fname }</td>
                            <td>${map.stock.stocknumber }</td>
                                <%-- <td>${map.FErpNumber }</td> --%>
                            <td>${map.stock.stockname }</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="datacabinetmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >资料柜列信息列表</h4>
            </div>
            <div class="modal-body">
                <table class="table table-bordered table-hover  table-striped" id=datacabinettable>
                    <thead>
                    <tr>
                        <th >资料柜列编码</th>
                        <th >资料柜列名称</th>
                        <th>仓库编码</th>
                        <th>仓库名称</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cabinetlist }" var="map">
                        <tr ondblclick="getBasics('datacabinet','${map.fid}','${map.fname }')">
                            <td>${map.fnumber }</td>
                                <%-- <td>${map.FErpNumber }</td> --%>
                            <td>${map.fname }</td>
                            <td>${map.stock.stocknumber }</td>
                                <%-- <td>${map.FErpNumber }</td> --%>
                            <td>${map.stock.stockname }</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="cabinettypemodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >储柜类型信息列表</h4>
            </div>
            <div class="modal-body">
                <table class="table table-bordered table-hover  table-striped" id=cabinettypetable>
                    <thead>
                    <tr>
                        <th >储柜类型编码</th>
                        <th >储柜类型名称</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cabinettypelist }" var="map">
                        <tr ondblclick="getBasics('cabinettype','${map.fid}','${map.fname }')">
                            <td>${map.fnumber }</td>
                                <%-- <td>${map.FErpNumber }</td> --%>
                            <td>${map.fname }</td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="datacabinettypemodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >资料柜类型信息列表</h4>
            </div>
            <div class="modal-body">
                <table class="table table-bordered table-hover  table-striped" id=datacabinettypetable>
                    <thead>
                    <tr>
                        <th >资料柜类型编码</th>
                        <th >资料柜类型名称</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cabinettypelist }" var="map">
                        <tr ondblclick="getBasics('datacabinettype','${map.fid}','${map.fname }')">
                            <td>${map.fnumber }</td>
                                <%-- <td>${map.FErpNumber }</td> --%>
                            <td>${map.fname }</td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="scabinetmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >储柜信息列表</h4>
            </div>
            <div class="modal-body">
                <table class="table table-bordered table-hover  table-striped" id=scabinettable>
                    <thead>
                    <tr>
                        <th >储柜编码</th>
                        <th >储柜名称</th>
                        <th>柜列编码</th>
                        <th>柜列名称</th>
                        <th>储柜类型编码</th>
                        <th>储柜类型名称</th>
                        <th>仓库编码</th>
                        <th>仓库名称</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${scabinetlist }" var="map">
                        <tr ondblclick="getBasics('scabinet','${map.fid}','${map.fname }')">
                            <td>${map.fnumber }</td>
                                <%-- <td>${map.FErpNumber }</td> --%>
                            <td>${map.fname }</td>
                            <td>${map.cabinet.fnumber }</td>
                                <%-- <td>${map.FErpNumber }</td> --%>
                            <td>${map.cabinet.fname }</td>
                            <td>${map.cabinettype.fnumber }</td>
                                <%-- <td>${map.FErpNumber }</td> --%>
                            <td>${map.cabinettype.fname }</td>
                            <td>${map.stock.stocknumber }</td>
                                <%-- <td>${map.FErpNumber }</td> --%>
                            <td>${map.stock.stockname }</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="datascabinetmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >资料柜信息列表</h4>
            </div>
            <div class="modal-body">
                <table class="table table-bordered table-hover  table-striped" id=datascabinettable>
                    <thead>
                    <tr>
                        <th >资料柜编码</th>
                        <th >资料柜名称</th>
                        <th>资料柜列编码</th>
                        <th>资料柜列名称</th>
                        <th>资料柜类型编码</th>
                        <th>资料柜类型名称</th>
                        <th>仓库编码</th>
                        <th>仓库名称</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${scabinetlist }" var="map">
                        <tr ondblclick="getBasics('datascabinet','${map.fid}','${map.fname }')">
                            <td>${map.fnumber }</td>
                                <%-- <td>${map.FErpNumber }</td> --%>
                            <td>${map.fname }</td>
                            <td>${map.cabinet.fnumber }</td>
                                <%-- <td>${map.FErpNumber }</td> --%>
                            <td>${map.cabinet.fname }</td>
                            <td>${map.cabinettype.fnumber }</td>
                                <%-- <td>${map.FErpNumber }</td> --%>
                            <td>${map.cabinettype.fname }</td>
                            <td>${map.stock.stocknumber }</td>
                                <%-- <td>${map.FErpNumber }</td> --%>
                            <td>${map.stock.stockname }</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="goodseatmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >货位信息列表</h4>
            </div>
            <div class="modal-body">
                <table class="table table-bordered table-hover  table-striped" id=goodseattable>
                    <thead>
                    <tr>
                        <th >货位编码</th>
                        <th >储柜编码</th>
                        <th >储柜名称</th>
                        <th>柜列</th>
                        <th>储柜类型</th>
                        <th>仓库</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${goodseatlist }" var="map">
                        <tr ondblclick="getBasics('goodseat','${map.fid}','${map.fnumber }')">
                            <td>${map.fnumber }</td>
                                <%-- <td>${map.FErpNumber }</td> --%>
                            <td>${map.scabinet.fnumber }</td>
                            <td>${map.scabinet.fname }</td>
                            <td>${map.cabinet.fname }</td>
                            <td>${map.cabinettype.fname}</td>
                            <td>${map.stock.stockname }</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>


<div class="modal fade" id="dataseatmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >资料位置信息列表</h4>
            </div>
            <div class="modal-body">
                <table class="table table-bordered table-hover  table-striped" id=dataseattable>
                    <thead>
                    <tr>
                        <th >资料位置编码</th>
                        <th >资料柜编码</th>
                        <th >资料柜名称</th>
                        <th>资料柜列</th>
                        <th>资料柜类型</th>
                        <th>仓库</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${dataseatlist }" var="map">
                        <tr ondblclick="getBasics('dataseat','${map.fid}','${map.fnumber }')">
                            <td>${map.fnumber }</td>
                                <%-- <td>${map.FErpNumber }</td> --%>
                            <td>${map.scabinet.fnumber }</td>
                            <td>${map.scabinet.fname }</td>
                            <td>${map.cabinet.fname }</td>
                            <td>${map.cabinettype.fname}</td>
                            <td>${map.stock.stockname }</td>
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
