<%--
  Created by IntelliJ IDEA.
  User: Yang
  Date: 2018/9/18
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>保质期清单</title>
    <jsp:include page="../../web/shared/resource.jsp"></jsp:include>
   <c:if test="${model.flag==1}">
       <link rel="stylesheet" href="assets/pages/css/page/display.css"/>
       <link rel="stylesheet" href="assets/pages/css/chart.css"/>
   </c:if>
</head>
<script>
    $(document).ready(function()
    {
        $('#balance').dataTable( {
            "language":{
                "url":"assets/pages/scripts/Chinese.json"
            },
            "bLengthChange": false,
            "bProcessing": true,
            "bSortClasses":true,
            "sPaginationType": "full_numbers",
            "pageLength":10,
            "bSort":true,
            searching : false,
        });
    });
</script>
<body>

    <c:if test="${model.flag==1}">
        <c:if test="${model.fstockid=='1'}">
            <jsp:include page="../../web/shared/Atop.jsp"></jsp:include>
        </c:if>
        <c:if test="${model.fstockid=='2'}">
            <jsp:include page="../../web/shared/Btop.jsp"></jsp:include>
        </c:if>
        <c:if test="${model.fstockid=='3'}">
            <jsp:include page="../../web/shared/Ctop.jsp"></jsp:include>
        </c:if>
    </c:if>
<div class=container-fluid>
    <c:if test="${model.flag!=1}">
        <div class=title_index>
            &nbsp;保质期清单
        </div>
    </c:if>
<%--    <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <form class="form-inline" action="report/getICstockSummary?flag=${model.flag}&fstockid=${model.fstockid}" method="post">
                <div class="form-group">
                    <label for="sdate">开始日期</label>
                    <input type="date" class="form-control" id="sdate" name="sdate" placeholder="开始时间" value=${model.sdate }>
                </div>
                <div class="form-group">
                    <label for="edate">结束日期</label>
                    <input type="date" class="form-control" id="edate" name="edate" placeholder="结束日期" value=${model.edate }>
                </div>
                <div class="form-group">
                    <label for="fmaid" >物料</label>

                    <div class="input-group">
                        <input  type="text" readonly onfocus="clearBasics('fmaid')"  class="form-control" id="material" name="materialname"  placeholder="" value=${model.materialname}>
                        <input type="hidden" class="form-control" id="fmaid" name=fmaid  placeholder="" value=${model.fmaid}>
                        <span class="input-group-btn">
                                                <button class="btn btn-primary btn-sm"  type="button" onclick="showBasics('ma','fmaid','material')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span></div>

                </div>

                <div class="form-group">
                    <label for="ferpstockid" >仓库</label>

                                <div class="input-group">
                                    <input  type="text" readonly onfocus="clearBasics('ferpstockid')"  class="form-control" id="erpstock" name="fstock"  placeholder="" value=${model.fstock}>
                                    <input type="hidden" class="form-control" id="ferpstockid" name=ferpstockid  placeholder="" value=${model.ferpstockid}>
                                    <span class="input-group-btn">
                                                <button class="btn btn-primary btn-sm"  type="button" onclick="showBasics('erpstock','ferpstockid','erpstock')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span></div>
                            </div>

                <div class="form-group">
                    <label for="batchno">批号</label>
                    <input type="text" class="form-control" id="batchno" name="batchno" placeholder="批号" value=${model.batchno }>
                </div>

<c:if test="${model.flag==1}">   <button type="submit" class="btn btn-info btn-sm ">
                    <span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询
                </button>
</c:if>
                <c:if test="${model.flag!=1}">   <button type="submit" class="btn btn-primary btn-sm ">
                    <span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询
                </button>
                </c:if>

            </form>

        </div>

    </div>--%>

    <table class="table table-bordered  table-striped  table_content" id="balance">
        <thead >
        <tr>

            <th >物料编码</th>
            <th >物料名称</th>
                <%--  <th >规格型号</th>--%>
            <th >计量单位</th>
            <th >数量</th>
            <th >生产日期</th>
            <th >保质期</th>
            <th >备注</th>
                <%--  <th></th>--%>
        </tr>

        </thead>
        <tbody>
        <c:forEach items="${balance_list}" var="map">
            <tr>
           <td>${map.materialNumber}</td>
            <td>${map.materialName}</td>
            <td>${map.materialUnit}</td>

            <td>
                <c:if test="${map.fqty>0}">
                    ${map.fqty}
                </c:if>
            </td>
                <td>${map.fmdate}</td>
                <td>${map.fgperiod}</td>
                <td>${map.fnote}</td>

   </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

    <jsp:include page="../../web/shared/modal.jsp"></jsp:include>

</body>
</html>
