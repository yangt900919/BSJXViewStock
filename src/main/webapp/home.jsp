<%--
  Created by IntelliJ IDEA.
  User: Yang
  Date: 2018/6/26
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>宝石机械库房管理系统</title>

    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <link rel="stylesheet" type="text/css" href=" assets/global/plugins/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" href="assets/global/plugins/bootstrapValidator/css/bootstrapValidator.css"/>
    <link rel="stylesheet" type="text/css" href="assets/pages/css/basics.css" />
    <link rel="stylesheet" type="text/css" href="assets/pages/css/fixed-table.css" />
    <link rel="stylesheet" type="text/css" href="assets/pages/css/home.css" />
    <link rel="stylesheet" href="css/demo.css">
    <link rel="stylesheet" href="css/iconfont.css">
    <script type="text/javascript" src=" assets/global/plugins/jquery.min.js"></script>
    <script type="text/javascript" src=" assets/global/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="assets/global/plugins/bootstrapValidator/js/bootstrapValidator.js"></script>
    <script type="text/javascript" src="assets/pages/scripts/basics.js"></script>
    <script type="text/javascript" src="assets/pages/scripts/jquery.dataTables.js"></script>
    <script type="text/javascript" src="assets/pages/scripts/dataTables.bootstrap.js"></script>
    <script type="text/javascript" src="assets/pages/scripts/fixed-table.js"></script>
</head>
<style>
    .submenu_check
    {
        /* background-color: #467fea !important; */
        background-color: #ebf2fb !important;
    }
</style>
<body >

<div class="page-head ">
    <nav class="navbar ">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header ">
               <%-- <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>--%>
                <a class="navbar-brand" href="index.jsp">
                    <img alt="Brand" src="assets/pages/img/menu/logo.png" id="brandlogo">

                </a>

            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div >

                <ul class="nav navbar-nav navbar-right">
                    <li id="menu"><a href="javaScript:;" class="navbar-side  username">
                        <i class="icon iconfont icon-home_shousuo_h_icon"></i>
                    </a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle username" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${username } <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="web/user/updatepsw.jsp"  title="修改密码" target="myiframe" >
                                    <span class="glyphicon glyphicon-lock" aria-hidden="true" ></span>
                                    修改密码
                                </a>
                            </li>
                            <li>
                                <a href="Loginout">
                                    <span class="glyphicon glyphicon-log-out" aria-hidden="true" ></span>  退出登录
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</div>

<div class="page-body ">


<div class="  page-left "  >

        <ul class="sidenav animated fadeInUp" >
            <c:forEach items="#{menuList }" var="map">
              <%--  ${plist}--%>
            <c:choose>
                    <c:when test="${fn:length(map.sub)==0 }">
                        <c:choose>
                            <c:when test="${map.main.name=='管理首页' }">
                                <c:if test="${plist.contains(map.main.permission)}">
                                <li><a class="withripple hover" href="${map.main.url }" title="${map.main.info }" target="myiframe">
                                    <i class="${map.main.icon }"></i><span class="sidespan" >${map.main.name }</span></a></li>
                                </c:if>
                            </c:when>
                            <c:otherwise>
                                <c:if test="${plist.contains(map.main.permission)}">
                                <li><a class="withripple" href="${map.main.url }" title="${map.main.info }" target="myiframe">
                                <i class="${map.main.icon }"></i><span class="sidespan">${map.main.name }</span></a></li>
                           </c:if>
                            </c:otherwise>

                        </c:choose>

                    </c:when>
                    <c:otherwise>
                        <c:if test="${plist.contains(map.main.permission)}">
                        <li><a class="withripple" href="javascript:;" title="${map.main.info }">
                            <i class="${map.main.icon }"></i><span class="sidespan">${map.main.name }</span><i class="iright pull-right">
                            <i class="icon iconfont icon-jiantouyou icon-flag"></i>

                           <%-- &lt;%&ndash;    <span class="glyphicon glyphicon-triangle-bottom hidden"></span>&ndash;%&gt;--%>
                        </i></a>
                            <ul class="sidebar-dropdown">
                                <c:forEach items="#{map.sub }" var="sm">
                                    <c:if test="${plist.contains(sm.permission)}">
                                    <li class="sub_menu_item"><a href="${sm.url }" class="withripple" title="${sm.info }" target="myiframe">${sm.name }</a></li>
                                </c:if>
                                </c:forEach>
                            </ul>
                        </li>
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </ul>
<div id="supply" style="height: 80px;"></div>

</div>
        <div class=" page-right">
          <%-- <div class="page-content-top">
                <nav class="navbar ">
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                        <ul class="nav navbar-nav" id="subnav">

                            <li class="active" id="home"><a href="index.jsp" target="myiframe">
                                <span class="glyphicon glyphicon-home"></span>
                            </a></li>
                            <li id="link"></li>


                        </ul>

                    </div><!-- /.navbar-collapse -->
                </nav>
            </div>--%>

               <div class="page-content">
                  <iframe id=iframe frameborder="0" src="index.jsp" scrolling="yes" name=myiframe sc >

                  </iframe>
              </div>
        </div>


</div>
<div id="footer" ></div>
<div class="page-foot">
    <div class="page-foot-inner">
        2018 ©
        <a href="http://www.linkpal.cn" title="技术支持：陕西立邦软件有限公司" target="_blank">陕西立邦软件有限公司</a>
    </div>
</div>
</body>
<script>
    var height=$(document.body).height();


    $(document).ready(function() {

       /* $(".page-body").height(height-$(".page-head").height()-$(".page-foot").height());
        $(".page-left").height($(".page-body").height());
        $(".page-right").height($(".page-body").height());
        //$(".page-right").width((width-$(".page-left").width())-1);
        $(".page-content").height($(".page-right").height()   );

        //$("#iframe").width($(".page-content").width());
        */

      /*  alert($(window).height());*/
       // alert((width-$(".page-left").width())-1);
        $("#iframe").height(height-$(".page-head").height()-$(".page-foot").height());

     /*  if($("#footer").height()==0)
       {
           $("#footer").height((height-$(".page-head").height()-$(".page-foot").height())*1.1);
       }
       else {
           $("#footer").height();
       }*/
    });

    $(".sidenav>li>a").click(function(){



        $(this).addClass("hover");
        $(this).next().slideToggle();
        $(this).parent().siblings().children("a").removeClass("hover").next().slideUp();

     /*   alert($(".sidebar-dropdown").length)
      if($(".sidebar-dropdown").length>0)
      {
          $("#supply").css("display","block");
      }
      else
      {
          $("#supply").css("display","none");
      }*/
/*
if($("#footer").height()==0)
{
    $("#footer").height(100);
}
*/

          });

    $(".navbar-side").click(function(){
        $(".page-body").toggleClass("sidebar-collapse");

         //

        if($(".page-body").hasClass("sidebar-collapse"))
        {
            //width=$(document.body).width();
            //$(".page-right").width((width-$(".page-left").width())-1);
            $(".sidebar-dropdown").css("left",$(".page-left").width());
           // $(".page-right").width((width-$(".page-left").width())-1);
           // $("#iframe").width($(".page-content").width());
            $("#iframe").height($(".page-content").height());

        }



        //$("#supply").css("display","block");

        //alert();
        //$("#supply").css("")
        //alert(parseInt($(".sidebar-dropdown").css("left")));
        /*alert(width);
*/
        return false;
    });

    $(".sub_menu_item").click(function()
        {
            $(".sub_menu_item").removeClass("submenu_check");
            $(this).addClass("submenu_check");
        }
    );
</script>
</html>
