<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>宝鸡石油机械有限责任公司物资公司库房管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	
	 <!-- Begin 全局必须样式 -->
    <link rel="stylesheet" type="text/css" href=" assets/global/plugins/font-awesome/css/font-awesome.min.css" />

    <link rel="stylesheet" type="text/css" href=" assets/global/plugins/bootstrap/css/bootstrap.min.css" />

    <!-- End 全局必须样式 -->
    <!-- Begin 全局主题样式 -->
    <link rel="stylesheet" type="text/css" href=" assets/global/css/components.css" />
    <link rel="stylesheet" type="text/css" href=" assets/global/css/plugins.min.css" />
<!--     End 全局主题样式
    Begin 主题布局样式 -->
    <link rel="stylesheet" type="text/css" href=" assets/layouts/css/layout.css" />
    <link rel="stylesheet" type="text/css" id="style_color" href=" assets/layouts/css/themes.css" />
    <link rel="stylesheet" type="text/css" href=" assets/layouts/css/custom.css" />
    <link rel="stylesheet" type="text/css" href="assets/pages/css/home.css" />
    <!-- End 主题布局样式 -->
<!--     <link rel="shortcut icon" href="favicon.ico" /> -->

    
    <style type="text/css">
       .page-foot
       {
       width:100%;
	height:48px;
	background-color: #efeeef;
	line-height: 48px;
	font-size:14px;
	color:#909090;
	font-weight: bold;
       }
      /*  .page-sidebar
       {
       height:1000px;
       } */

/*     @media screen and (min-width:1367px) and (max-width:1920px){
     body
       {
       height:87% !important;
       }
    @media screen and (min-width:1008px) and  (max-width:1071px){
     body
       {
       height:10% !important;
       }
    @media screen and (max-width:1007px)
    {
      body
       {
      
       height:50% !important;
       }
    }
} */
    .submenu_check
    {
    /* background-color: #467fea !important; */
    color: #37a8a1 !important;
    }
     #brandlogo{
       width: 60%;
         transform:translateY(-20%);

       }
        .brandtitle
        {
            display: inline;
            color: #ffffff;
            font-weight: bold;
            font-size:24px;
            line-height: 66px;
         /*   font-style: oblique;*/

        }
        .menu-check
        {
            background: #2b9b98 !important;
            color: #fffcff !important;
        }
    </style>

</head>

<body class="page-header-fixed page-sidebar-closed-hide-logo">
    <!-- Begin 页面头部 -->
    <div class="page-header navbar navbar-fixed-top">
        <!-- Begin 顶部导航栏 -->

<div class="page-header-inner ">
    <!-- Begin Logo -->
    <div class="page-logo">

        <div class="navbar-header ">
            <a class="navbar-brand" href="index.jsp">
                <img alt="Brand" src="assets/pages/img/menu/logo.png" id="brandlogo">

            </a>

        </div>
    \
       <div class="brandtitle">
           物资公司库房管理系统
       </div>
<%--        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active">Link </li>
            </ul></div>--%>
       <%-- <a href="/Account/Auth/Index">
            <img src="assets/pages/img/menu/logo.png" alt="logo" class="logo-default" />
        </a>--%>
    </div>
    <!-- End Logo -->
    <!-- Begin 响应式菜单开关 -->
    <a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse"> </a>
    <!-- End 响应式菜单开关 -->
    <!-- Begin 顶部导航菜单 -->
    <div class="top-menu">
        <ul class="nav navbar-nav pull-right">
            <!-- Begin 用户信息 -->
            <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
            <li class="dropdown dropdown-user">
                <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                    <span class="username username-hide-on-mobile">${username }</span>
                    <i class="fa fa-angle-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-menu-default">
                     <li>
                        <a href="web/user/updatepsw.jsp"  title="修改密码" target="myiframe" >
                            <i class=" icon-lock">
                            </i> 修改密码
                        </a>
                    </li>
                    <li>
                        <a href="Loginout">
                            <i class="icon-key"></i> 退出登录
                        </a>
                    </li>
                </ul>
            </li>
            <!-- End 用户信息 -->
        </ul>
    </div>
    <!-- End 顶部导航菜单 -->
</div>
        <!-- End 顶部导航栏 -->
    </div>
    <!-- End 页面头部 -->
    <!-- Begin 头部与主体分界线 -->
    <div class="clearfix"> </div>
    <!-- End 头部与主体分界线 -->
    <!-- Begin 页面主体 -->
    <div class="page-container">
        <!-- Begin 侧边栏 -->
        

<div class="page-sidebar-wrapper">
    <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
    <!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
    <div class="page-sidebar navbar-collapse collapse">
        <!-- Begin 侧边栏菜单 -->
        <!-- DOC: Apply "page-sidebar-menu-light" class right after "page-sidebar-menu" to enable light sidebar menu style(without borders) -->
        <!-- DOC: Apply "page-sidebar-menu-hover-submenu" class right after "page-sidebar-menu" to enable hoverable(hover vs accordion) sub menu mode -->
        <!-- DOC: Apply "page-sidebar-menu-closed" class right after "page-sidebar-menu" to collapse("page-sidebar-closed" class must be applied to the body element) the sidebar sub menu mode -->
        <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
        <!-- DOC: Set data-keep-expand="true" to keep the submenues expanded -->
        <!-- DOC: Set data-auto-speed="200" to adjust the sub menu slide up/down speed -->
        <ul class="page-sidebar-menu  page-header-fixed " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
            <!-- DOC: To remove the sidebar toggler from the sidebar you just need to completely remove the below "sidebar-toggler-wrapper" LI element -->
   <%--       <li class="sidebar-toggler-wrapper">
                Begin 响应式开关
                <div class="sidebar-toggler"></div>
                End 响应式开关
            </li>--%>
            
            <c:forEach items="#{menuList }" var="map">
            
            <c:choose>
            <c:when test="${fn:length(map.sub)==0 }">
                 <li class="">


                             <a href="${map.main.url }" title="${map.main.info }" class="nav-link nav-toggle " target="myiframe" >
                                 <i class="${map.main.icon } fa-"></i>
                                 <span class="title">${map.main.name }</span>
                             </a>


     </li>
            </c:when>
            <c:otherwise>
              <li class="nav-item">
                <a href="javascript:;" title="${map.main.info }" class="nav-link nav-toggle ">
                        <i class="${map.main.icon }"></i>
                        <span class="title">${map.main.name }</span>
                        <span class='arrow'></span>
                    </a>
                     <ul class="sub-menu">
                    <c:forEach items="#{map.sub }" var="sm">
                    <li class="nav-item start ">
                                   <a href="${sm.url }" class="nav-link sub_menu_item" title="${sm.info }" target="myiframe">•&nbsp;&nbsp;&nbsp;${sm.name }</a>
                                </li>
                   </c:forEach>
                     </ul>
              </li>
            </c:otherwise>
            </c:choose>
            </c:forEach>


<%--            <c:forEach items="${menuList }" var="map">
                <c:set var="flag" value="${fn:length(menuList) }"></c:set>
                <c:forEach items="${ pList}" var="per">
                    <c:if test="${per.fname==map.main.name  }">
                        <c:set var="flag" value="${fn:length(menuList)-1 }"></c:set>
                    </c:if>
                </c:forEach>
                <c:if test="${flag==fn:length(menuList)-1 }">
                    <c:choose>
                        <c:when test="${fn:length(map.sub)==0 }">

                            <li class="">

                                <a href="${map.main.url }" title="${map.main.info }" class="nav-link nav-toggle " target="myiframe" >
                                    <i class="${map.main.icon }"></i>
                                    <span class="title">${map.main.name }</span>
                                </a>
                            </li>

                        </c:when>
                        <c:otherwise>

                            <li class="nav-item">
                                <a href="javascript:;" title="${map.main.info }" class="nav-link nav-toggle ">
                                    <i class="${map.main.icon }"></i>
                                    <span class="title">${map.main.name }</span>
                                    <span class='arrow'></span>
                                </a>
                                <ul class="sub-menu">
                                    <c:forEach items="#{map.sub }" var="sm">
                                        <c:set var="flag_sub" value="${fn:length(map.sub) }"></c:set>
                                        <c:forEach items="${ pList}" var="per">
                                            <c:if test="${per.fname==sm.name  }">
                                                <c:set var="flag_sub" value="${fn:length(map.sub)-1 }"></c:set>
                                            </c:if>
                                        </c:forEach>
                                        <c:if test="${flag_sub==fn:length(map.sub)-1 }">
                                            <li class="nav-item start ">
                                                <a href="${sm.url }" class="nav-link sub_menu_item" title="${sm.info }" target="myiframe">•&nbsp;&nbsp;&nbsp;${sm.name }</a>
                                            </li>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                            </li>

                        </c:otherwise>
                    </c:choose>
                </c:if>
            </c:forEach>--%>



        </ul>
        <!-- End 侧边栏菜单 -->
    </div>
</div>

        <!-- End 侧边栏 -->
        <!-- Begin 页面 -->
        <div class="page-content-wrapper">
            <div class="page-content-box">
            <!-- <div class=page-content-title>
            
            </div> -->
                <!-- <div class="page-content">
             
            </div> -->
              <iframe id=iframe frameborder="0" src="index.jsp" scrolling="yes" name=myiframe>
               
               </iframe>
        </div>
  
    </div>
    <!-- End 页面主体 -->
    <!-- Begin 页脚 -->
    
   <!--   <nav class="navbar navbar-default navbar-fixed-bottom page-foot">
  <div class="container-fluid">
   2017©  <a href="http://www.linkpal.cn" title="技术支持：陕西立邦软件有限公司" target="_blank">陕西立邦软件有限公司</a>
  </div>
</nav> -->
<div class="page-footer ">
    <div class="page-footer-inner">
         2018 ©
        <a href="http://www.linkpal.cn" title="技术支持：陕西立邦软件有限恭喜" target="_blank">陕西立邦软件有限公司</a>
    </div>
    <div class="scroll-to-top">
        <i class="icon-arrow-up"></i>
    </div>
</div>
    
    <!-- End 页脚 -->
    <!--[if lt IE 9]>
    <script src=" assets/global/plugins/respond.min.js"></script>
    <script src=" assets/global/plugins/excanvas.min.js"></script>
    <![endif]-->
    <!-- Begin 核心插件 -->
    <script type="text/javascript" src=" assets/global/plugins/jquery.min.js"></script>
    <script type="text/javascript" src=" assets/global/plugins/bootstrap/js/bootstrap.min.js"></script>
 <!-- End 核心插件 -->
    <!-- Begin 全局主题 -->
   <script type="text/javascript" src=" assets/global/scripts/app.js"></script>
  <!--   End 全局主题
    Begin 主题布局 -->
     <script type="text/javascript" src=" assets/layouts/scripts/layout.js"></script>
    <script type="text/javascript" src=" assets/layouts/scripts/demo.js"></script>
    <script type="text/javascript" src=" assets/pages/scripts/custom.js"></script>
    <!-- End 主题布局 -->

  
    
    
    <script type="text/javascript">
$(".page-sidebar-menu>li").click(function ()
		{
	if(!$(this).hasClass("nav-item"))
{
	$(".page-sidebar-menu>li").removeClass("open");
	$(this).addClass("open");
	$(".sub-menu").css("display","none");
}
		}
		);
$(".sub_menu_item").click(function()
		{
	$(".sub_menu_item").removeClass("submenu_check");
	$(this).addClass("submenu_check");
		}
		);
</script>



</body>
<!-- END BODY -->
</html>
