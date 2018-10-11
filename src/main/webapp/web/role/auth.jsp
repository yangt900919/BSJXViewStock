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
    
    <title>My JSP 'edit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<jsp:include page="/web/shared/resource.jsp"></jsp:include>
 <script type="text/javascript">
     $("#home", parent.document).removeClass("active");
     $("#link", parent.document).empty();
     $("#link", parent.document).addClass("active");
     $("#link", parent.document).text("角色权限分配");
 </script>
  </head>
  
  <body>
   <div class=title>
&nbsp;角色权限分配
   </div>
    <div class="container-fluid editpage-content">
  
   <form action=""  class="form-horizontal" >
   <c:if test="${role.fid>0 }">  <input type="hidden" name=fid id=fid value=${role.fid }></c:if>
 
    
  <div class="form-group">
    <label for="rolename" class=col-sm-3>角色名称</label>
     <div class="col-sm-9">
    <input type="text" readonly="readonly"  class="form-control" id="rolename" name="rolename" placeholder="角色名称" value=${role.rolename }>
  </div>
  </div>
  
     <div class="form-group ">
  <%--  <label for="fpermission" class=col-sm-3>权限</label>--%>
       <div class="col-sm-12 col-md-12 col-xs-12">
           <c:forEach begin="0" end="${permissionList.size()-1}" step="4" var="i">

               <div class=row >
                   <div class="col-sm-3 " >
                       <div class="row">
                       <label for="fpermission${permissionList[i].fid }" class=col-sm-8>${permissionList[i].fname }</label>
                       <div class=col-sm-3 >
                           <c:choose>
                               <c:when test="${permissionList[i].fname=='管理首页' }">
                                   <input type="checkbox" class="check" id="fpermission${permissionList[i].fid }" name="check" value="${permissionList[i].fid }" checked="checked"/>
                               </c:when>
                               <c:otherwise>
                                   <input type="checkbox" class="check" id="fpermission${permissionList[i].fid }" name="check" value="${permissionList[i].fid }"/>
                               </c:otherwise>
                           </c:choose>

                       </div>
                       </div>
                   </div>
                   <div class="col-sm-3">
                       <div class="row">
                       <label for="fpermission${permissionList[i+1].fid }" class=col-sm-8>${permissionList[i+1].fname }</label>
                       <div class=col-sm-3 >
                           <c:choose>
                               <c:when test="${permissionList[i+1].fname=='管理首页' }">
                                   <input type="checkbox" class="check" id="fpermission${permissionList[i+1].fid }" name="check" value="${permissionList[i+1].fid }" checked="checked"/>
                               </c:when>
                               <c:otherwise>
                                   <input type="checkbox" class="check" id="fpermission${permissionList[i+1].fid }" name="check" value="${permissionList[i+1].fid }"/>
                               </c:otherwise>
                           </c:choose>

                       </div>
                       </div>
                   </div>
                   <div class="col-sm-3">
                       <div class="row">
                       <label for="fpermission${permissionList[i+2].fid }" class=col-sm-8>${permissionList[i+2].fname }</label>
                       <div class=col-sm-3 >
                           <c:choose>
                               <c:when test="${permissionList[i+2].fname=='管理首页' }">
                                   <input type="checkbox" class="check" id="fpermission${permissionList[i+2].fid }" name="check" value="${permissionList[i+2].fid }" checked="checked"/>
                               </c:when>
                               <c:otherwise>
                                   <input type="checkbox" class="check" id="fpermission${permissionList[i+2].fid }" name="check" value="${permissionList[i+2].fid }"/>
                               </c:otherwise>
                           </c:choose>
                       </div>
                       </div>
                   </div>
                   <div class="col-sm-3">
                       <div class="row">
                       <label for="fpermission${permissionList[i+3].fid }" class=col-sm-8>${permissionList[i+3].fname }</label>
                       <div class=col-sm-3 >
                           <c:choose>
                               <c:when test="${permissionList[i+3].fname=='管理首页' }">
                                   <input type="checkbox" class="check" id="fpermission${permissionList[i+3].fid }" name="check" value="${permissionList[i+3].fid }" checked="checked"/>
                               </c:when>
                               <c:otherwise>
                                   <input type="checkbox" class="check" id="fpermission${permissionList[i+3].fid }" name="check" value="${permissionList[i+3].fid }"/>
                               </c:otherwise>
                           </c:choose>
                       </div>
                       </div>
                   </div>
               </div>

           </c:forEach>
       </div>

</div>
        <c:forEach items="${role.permissions }" var="p">
    <script type="text/javascript">
    var id='${p.fid}';
    //alert()
	  $("#fpermission"+id).prop("checked",true) ;
    </script>
    </c:forEach>
  </div>


       <div class="form-group">
           <div class="col-sm-offset-3 col-sm-9">
               <a  class="btn btn-primary btn-sm" onclick="doAuth()" href="javaScript:;">
                   <span class="glyphicon glyphicon-saved" aria-hidden="true"></span>   保存</a>

               <button  type="button" class="btn btn-warning btn-sm" onclick="javascript:history.go(-1);">

                   <span class="glyphicon glyphicon-log-out" aria-hidden="true" ></span>  退出</button>
           </div>
       </div>
  </form>
  </div>
  </body>
</html>
