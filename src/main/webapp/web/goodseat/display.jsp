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
    
    <title>货位展示</title>
    
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
    	});
    </script>
  </head>
  
  <body >
  <div class=container-fluid>
      <jsp:include page="../../web/shared/top.jsp"></jsp:include>

      <br>
      <table class="table table-bordered table-hover table-striped ">
          <thead >
          <tr>

              <th >物料编码</th>
              <th >物料名称</th>
                <th >规格型号</th>
              <th>计量单位</th>

              <th>数量</th>

          </tr>
          </thead>
          <tbody>
          <c:forEach items="${gdlist }" var="map">
              <tr>


                  <td>${map.materialnumber }</td>
                  <td class=wrap>${map.materialname }</td>
                        <td class=wrap>${map.materialmodel }</td>
                  <td class=wrap>${map.materialunit }</td>

                  <td>${map.maqty }</td>

              </tr>
          </c:forEach>
          </tbody>
      </table>

  </div>
  </body>
</html>
