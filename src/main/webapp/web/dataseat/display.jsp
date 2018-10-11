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
    
    <title>物料明细</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<jsp:include page="../../web/shared/resource.jsp"></jsp:include>
    <link rel="stylesheet" href="assets/pages/css/page/display.css"/>
    <script type="text/javascript">
    $(function () {
    	  $('[data-toggle="popover"]').popover();
    		$("#goodsseat").modal({backdrop:'static',keyborad:false});

   /*     $('#table').dataTable( {
            "language":{
                "url":"assets/pages/scripts/Chinese.json"
            },
            "bLengthChange": false,
            "bProcessing": true,
            "bSortClasses":true,
            "sPaginationType": "full_numbers",
            "pageLength":15,
            "bSort":true
        });*/
    	});



    </script>
  </head>
  
  <body >
  <div >
      <jsp:include page="../../web/shared/Atop.jsp"></jsp:include>

     <div class="row " style="margin: 20px">
         <div class="col-md-12 col-xs-12 col-sm-12">
             <%--<div class="table-responsive">--%>
      <table class="table table-bordered  table-striped table_content" id="table">
          <thead >
          <tr>

              <th >物料编码</th>
              <th >物料名称</th>
           <%--     <th >规格型号</th>--%>
              <th>计量单位</th>

              <th>数量</th>

          </tr>
          </thead>
          <tbody>
          <c:forEach items="${gdlist }" var="map">
              <tr>


                  <td>${map.materialnumber }</td>
                  <td class=wrap>${map.materialname }</td>
                      <%--  <td class=wrap>${map.materialmodel }</td>--%>
                  <td class=wrap>${map.materialunit }</td>

                  <td>${map.maqty }</td>

              </tr>
          </c:forEach>
          </tbody>
      </table>
         </div>
     </div>
  </div>
<%--  </div>--%>
  </body>
</html>
