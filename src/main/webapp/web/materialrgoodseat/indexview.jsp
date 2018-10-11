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

    <title>物料-货位</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <jsp:include page="../../web/shared/resource.jsp"></jsp:include>
    <link rel="stylesheet" href="assets/pages/css/page/display.css"/>

</head>

<body>
<c:if test="${param.fstockid=='1'}">
    <jsp:include page="../../web/shared/Atop.jsp"></jsp:include>
</c:if>
<c:if test="${param.fstockid=='2'}">
    <jsp:include page="../../web/shared/Btop.jsp"></jsp:include>
</c:if>
<c:if test="${param.fstockid=='3'}">
    <jsp:include page="../../web/shared/Ctop.jsp"></jsp:include>
</c:if>
<jsp:include page="conditionview.jsp"></jsp:include>
<div class=container-fluid>

    <div class="row">
        <div class="col-md-9 col-sm-9 col-xs-9" ></div>
        <div class="col-md-3 col-sm-3 col-xs-3" >


            <%-- <div class="col-md-4 col-sm-4 col-xs-4" >  <a class="btn btn-primary btn-sm"  href="materialrgoodseat/create">
             <span class="glyphicon   glyphicon-plus" aria-hidden="true"></span>     新增</a></div>


                  <div class="col-md-4 col-sm-4 col-xs-4"> <a class="btn btn-danger  btn-sm"  href="javascript:;" onclick="DeleteBatch('materialrgoodseat')">
         <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
             删除</a>
                </div>

                  <div class="buttongroups">  <a class="btn btn-info  btn-sm"  onclick="filter('materialrgoodseat')" href="javascript:;">
             <span class="glyphicon   glyphicon-filter" aria-hidden="true"></span>过滤</a>
                </div> --%>


        </div>
    </div>

    <div class="table-responsive" style="height: 70% !important;">
        <table class="table table-bordered  table-striped  table_content">
            <thead >
            <tr>

                <th >物料编码</th>
                <th >物料名称</th>
                <%--  <th >规格型号</th>--%>
                <th >货位</th>
                <th>备注</th>
                <%--  <th></th>--%>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${materialrgoodseatlist }" var="map">
                <tr>


                    <td>${map.material.materialnumber }</td>
                    <td class=wrap>${map.material.materialname }</td>
                        <%--  <td class=wrap>${map.material.FModel }</td>--%>
                    <td>${map.goodseat.fnumber }</td>
                    <td>${map.fremark }</td>
                        <%--<td>

                         <button class="btn btn-success btn-xs" onclick="Edit('materialrgoodseat',${map.fid})">
                              <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 编辑</button>

                           &lt;%&ndash;   <c:if test="${mags_delete=='mags_delete' }">&ndash;%&gt;
                            <button class="btn btn-danger btn-xs" id="delete" onclick="Delete('materialrgoodseat',${map.fid})">
                            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>  删除</button>
                          &lt;%&ndash;  </c:if>
                            <c:if test="${mags_adjust=='mags_adjust' }">&ndash;%&gt;
                          &lt;%&ndash;  <button class="btn btn-warning btn-sm"  onclick="adjust(${map.fid})">
                            <span class="glyphicon glyphicon-leaf" aria-hidden="true"></span>  货位调整</button>
                            </c:if>&ndash;%&gt;
                        </td>--%>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div align="right" style="color: #ffffff">
    <font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第
    ${page.pageNow} 页</font> <a href="${url}?pageNow=1&condition=1">首页</a>
    <c:choose>
        <c:when test="${page.pageNow - 1 > 0}">
            <a href="${url}?pageNow=${page.pageNow - 1}&condition=1">上一页</a>
        </c:when>
        <c:when test="${page.pageNow - 1 <= 0}">
            <a href="${url}?pageNow=1&condition=1">上一页</a>
        </c:when>
    </c:choose>
    <c:choose>
        <c:when test="${page.totalPageCount==0}">
            <a href="${url}?pageNow=${page.pageNow}&condition=1">下一页</a>
        </c:when>
        <c:when test="${page.pageNow + 1 < page.totalPageCount}">
            <a href="${url}?pageNow=${page.pageNow + 1}&condition=1">下一页</a>
        </c:when>
        <c:when test="${page.pageNow + 1 >= page.totalPageCount}">
            <a href="${url}?pageNow=${page.totalPageCount}&condition=1">下一页</a>
        </c:when>
    </c:choose>
    <c:choose>
        <c:when test="${page.totalPageCount==0}">
            <a href="${url}?pageNow=${page.pageNow}&condition=1">尾页</a>
        </c:when>
        <c:otherwise>
            <a href="${url}?pageNow=${page.totalPageCount}&condition=1">尾页</a>
        </c:otherwise>
    </c:choose>
</div>
<jsp:include page="../../web/shared/modal.jsp"></jsp:include>


</body>
</html>
