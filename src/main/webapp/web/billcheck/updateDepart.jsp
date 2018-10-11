<%--
  Created by IntelliJ IDEA.
  User: Yang
  Date: 2018/6/6
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .importing
    {
        display: none;
    }
</style>
<script>

</script>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
           <%-- <a id="modal-137535" href="#modal-container-137535" role="button" class="btn" data-toggle="modal">触发遮罩窗体</a>
--%>
               <div class="modal fade" id="modal-container-137535" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                   <div class="modal-dialog" role="document">
                       <div class="modal-content">
                           <div class="modal-header">
<%--                               <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>--%>
                               <h4 class="modal-title" >领料单位/客户</h4>
                           </div>

                          <%-- <c:choose>
                               <c:when test="${size>0}">
                                   <form class="form-horizontal" method="post"   action="billorder/updatestock">
                                       <div class="modal-body">
                                           <div class="form-group">
                                               <label for="material" class=col-sm-3>物料</label>
                                               <div class=col-sm-9>
                                                   <select  class="form-control" id=material name=material >
                                                       <c:forEach items="${malist}" var="map">
                                                           <option value="${map.fid}">${map.materialname}</option>
                                                       </c:forEach>
                                                           &lt;%&ndash; <option value='2'>检验</option>&ndash;%&gt;
                                                   </select>
                                               </div>
                                           </div>
                                           <div class="form-group">
                                               <label for="stock" class=col-sm-3>仓库</label>
                                               <div class=col-sm-9>
                                                   <select  class="form-control" id=stock name=stock >
                                                       <c:forEach items="${stlist}" var="map">
                                                           <option value="${map.fid}">${map.fname}</option>
                                                       </c:forEach>
                                                           &lt;%&ndash; <option value='2'>检验</option>&ndash;%&gt;
                                                   </select>
                                               </div>
                                           </div>
                                       </div>

                                       <div class="modal-footer">
                                           <button class="btn btn-primary" type="submit">提交</button>
                                       </div>
                                   </form>

                           </c:when>
                               <c:otherwise>--%>
                                   <form class="form-horizontal" method="get"   action="billcheck/updatedepart" >
                                       <div class="modal-body">
                                           <div class="form-group">
                                               <label for="fdepartmentid" class="col-md-4 col-sm-4 col-xs-4">领料单位</label>
                                               <div class="col-md-8 col-sm-8 col-xs-8">
                                                   <div class=row>

                                                       <div class="input-group">
                                                           <input readonly type="text"  onfocus="clearBasics('fdepartmentid')"  class="form-control" id="organization" name="organizationname"  placeholder="" >
                                                           <input type="hidden" class="form-control" id="fdepartmentid" name=fdepartmentid  placeholder="" value=${billget.fdepartmentid}>
                                                           <span class="input-group-btn">
         <button class="btn btn-primary btn-sm" ${disabled} type="button" onclick="showBasics('depart','fdepartmentid','organization')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
                                                       </div>

                                                   </div>
                                               </div>
                                           </div>

                                           <div class="form-group">
                                               <label for="fcustomid" class="col-md-4 col-sm-4 col-xs-4">客户</label>
                                               <div class="col-md-8 col-sm-8 col-xs-8">
                                                   <div class=row>

                                                       <div class="input-group">
                                                           <input readonly type="text"  onfocus="clearBasics('fcustomid')"  class="form-control" id="custom" name="organizationname"  placeholder="" >
                                                           <input type="hidden" class="form-control" id="fcustomid" name=fcustomid  placeholder="" value=${billget.fcustomid}>
                                                           <span class="input-group-btn">
         <button class="btn btn-primary btn-sm" ${disabled} type="button" onclick="showBasics('custom','fcustomid','custom')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
    </span>
                                                       </div>

                                                   </div>
                                               </div>
                                           </div>

                                           <input type="hidden" name="foid" value="${fbillid}">
                                       </div>

                                       <div class="modal-footer">
                                           <button class="btn btn-primary" type="submit">提交</button>
                                       </div>
                                   </form>

                               <%--</c:otherwise>
                           </c:choose>--%>
                        <%--     <div class="importing">
                               <div class="progress">
                                   <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
                                       &lt;%&ndash;<span class="sr-only">45% Complete</span>&ndash;%&gt;
                                   </div>
                               </div>
                             </div>--%>

                       </div>
                   </div>
               </div>
        </div>
    </div>
</div>
</body>
</html>
