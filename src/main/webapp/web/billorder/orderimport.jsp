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
                               <h4 class="modal-title" >采购订单导入  </h4>
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
                                   <form class="form-inline" method="post"  enctype="multipart/form-data" action="billorder/import">
                                       <div class="modal-body">

                                           <fieldset>
                                               <input type="file" name="file"/>

                                           </fieldset>
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
