<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>宝石机械库房管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
      <link rel="stylesheet" type="text/css" href=" assets/global/plugins/bootstrap/css/bootstrap.css" />
      <link rel="stylesheet" href="assets/global/plugins/bootstrapValidator/css/bootstrapValidator.css"/>
      <link rel="stylesheet" type="text/css" href="assets/pages/css/basics.css" />
      <link rel="stylesheet" type="text/css" href="assets/pages/css/fixed-table.css" />
      <link rel="stylesheet" type="text/css" href="assets/pages/css/home.css" />
      <script type="text/javascript" src=" assets/global/plugins/jquery.min.js"></script>
      <script type="text/javascript" src=" assets/global/plugins/bootstrap/js/bootstrap.min.js"></script>
      <script type="text/javascript" src="assets/global/plugins/bootstrapValidator/js/bootstrapValidator.js"></script>
      <script type="text/javascript" src="assets/pages/scripts/basics.js"></script>
      <script type="text/javascript" src="assets/pages/scripts/jquery.dataTables.js"></script>
      <script type="text/javascript" src="assets/pages/scripts/dataTables.bootstrap.js"></script>
      <script type="text/javascript" src="assets/pages/scripts/fixed-table.js"></script>
	 <link rel="stylesheet" href="assets/pages/css/page/mainMenu.css"/>

  </head>
  
  <body class=main_body>
       <div  >

           <div class="page-head" align="left">
 <%--<div class="row" align="left">
    <div class="col-md-12 col-xs-12 col-sm-12">--%>
        <img src="assets/pages/img/page/logo.png" alt="" height="80%">
    <%--</div>--%>
 </div></div>

<div class="menu_body " align="center">
<div class="row " align="center" >
<div class="col-md-4 col-sm-4 col-ms-4" >

 
    <div id=storage onclick="location.href='paintStore.jsp'" class=menu_box align="center">
   <img alt="" src="assets/pages/img/page/total.png" width="40%" height="40%" style="margin-top: 15%;"/>
   <div class=box_title>总体展示</div>
    </div> 
</div>
<div class="col-md-4 col-sm-4 col-ms-4">
  <div id="chat" onclick="$('#myModal').modal('show')" class=menu_box>
    <img alt="" src="assets/pages/img/page/report.png" width="40%" height="40%" style="margin-top: 15%;"/>
    <div class=box_title>图形报表</div>
    </div>
</div>
<div class="col-md-4 col-sm-4 col-ms-4">
<div id=query onclick="$('#querys').modal('show')" class=menu_box>

   <img alt="" src="assets/pages/img/page/query.png" width="40%" height="40%" style="margin-top: 15%;"/>
  <div class=box_title>查询</div>
   </div>
</div>
</div>


  </div>

         <%--  <div class="row ">--%>
               <footer class="fixed-foot">
                   <div class="row">
                       <div class="col-md-12 col-xs-12 col-sm-12" align="right">
                           <img src="assets/pages/img/page/clogo.png" alt="" height="44px">
                       </div>
                   </div>
               </footer>
         <%--  </div>--%>
  
  <!-- 图表展示子菜单 -->
    <div class="modal fade " id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog sub_menu" role="document"  id=dialog >
    <div class="modal-content">
      <!-- <div class="modal-header headers" >
      <h4>图表报表</h4>&nbsp;
      </div> -->
      <div class="modal-body">
    <div class=row align="center">
    <div class="col-md-3 col-sm-3 col-xs-3">
    <div class=sub style="background-color: #2ba8ff;cursor: hand" onclick="location.href='report/getLibAge?page=libagel&fstockid=3'">
        <img alt="" src="assets/pages/img/menu/sage.png" width="40%" height="40%" style="margin-top: 15%;"/>
     <div>   无动态</div>
        </div>
    </div>
        <div class="col-md-3 col-sm-3 col-xs-3">
            <div class=sub style="background-color: #fd672b;cursor: hand" onclick="window.location.href='report/getFrenqucy?page=frenqucyl&fstockid=3'">
                <img alt="" src="assets/pages/img/menu/frenqucy.png" width="40%" height="40%" style="margin-top: 15%;"/>
                <div>   高频次采购</div>
            </div>
        </div>


        <div class="col-md-3 col-sm-3 col-xs-3">
            <div class=sub style="background-color: #6fcc41;cursor: hand" onclick="window.location.href='report/getFrenqucy?page=frenqucya&fstockid=3'">
                <img alt="" src="assets/pages/img/menu/frenqucy.png" width="40%" height="40%" style="margin-top: 15%;"/>
                <div>   长期缺货</div>
            </div>
        </div>

        <div class="col-md-3 col-sm-3 col-xs-3">
            <div class=sub style="background-color: #ea5e56;cursor: hand" onclick="window.location.href='report/getQualified?page=qratel&fstockid=3'">
                <img alt="" src="assets/pages/img/menu/quatitied.png" width="40%" height="40%" style="margin-top: 15%;"/>
                <div>   合格率分析</div>
            </div>
        </div>
     <%-- <div class="col-md-6 col-sm-6 col-xs-6">
       <div class=sub style="background-color:#1FA333 ;cursor: hand" onclick="window.location.href='CA/Index'">
        <img alt="" src="assets/pages/img/page/rl.png" width="40%" height="40%" style="margin-top: 15%;"/>
     <div>   容量余量</div>
        </div>
      </div>--%>
    </div>
      </div>
    </div>
  </div>
</div>

<!-- 查询子菜单 -->
    <div class="modal fade " id="querys" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog sub_menu" role="document"  id=dialog >
    <div class="modal-content">
      <!-- <div class="modal-header headers" >
      <h4>图表报表</h4>&nbsp;
      </div> -->
      <div class="modal-body">
    <div class=row>
    <div class="col-md-3 col-sm-3 col-xs-3">
    <div class=sub  style="background-color: #E047B3;cursor: hand" onclick="window.location.href='report/getmgList?fstockid=3'">
        <img alt="" src="assets/pages/img/page/xn.png" width="40%" height="40%" style="margin-top: 15%;"/>
     <div>  物料-货位</div>
        </div>
    </div>
        <div class="col-md-3 col-sm-3 col-xs-3">
            <div class=sub style="background-color: #2ba8ff;cursor: hand" onclick="location.href='report/getInventoryBalance?flag=1&fstockid=3'">
                <img alt="" src="assets/pages/img/menu/kc.png" width="40%" height="40%" style="margin-top: 15%;"/>
                <div>   库存台账</div>
            </div>
        </div>
        <div class="col-md-3 col-sm-3 col-xs-3">
            <div class=sub style="background-color: #fd672b;cursor: hand" onclick="window.location.href='report/getInventoryBalance_date?flag=1&fstockid=3'">
                <img alt="" src="assets/pages/img/menu/kc.png" width="40%" height="40%" style="margin-top: 15%;"/>
                <div>   物料收发<br>日报表</div>
            </div>
        </div>


        <div class="col-md-3 col-sm-3 col-xs-3">
            <div class=sub style="background-color: #6fcc41;cursor: hand" onclick="window.location.href='report/getInventorySummary?flag=1&fstockid=3'">
                <img alt="" src="assets/pages/img/menu/kc.png" width="40%" height="40%" style="margin-top: 15%;"/>
                <div>   物料收发<br>汇总表</div>
            </div>
        </div>
        <%--  <div class="col-md-6 col-sm-6 col-xs-6">
         <!--   <div class=sub style="background-color:#1FA333 ;cursor: hand" onclick="window.location.href='ReportChat?flag=stock.jsp'"">
            <img alt="" src="assets/pages/img/page/rl.png" width="40%" height="40%" style="margin-top: 15%;"/>
         <div>   容量余量</div>
            </div> -->
          </div>--%>
    </div>

          <div class=row>
              <div class="col-md-3 col-sm-3 col-xs-3">
                  <div class=sub  style="background-color: #E047B3;cursor: hand" onclick="window.location.href='report/getICstockSummary?flag=1&fstockid=3'">
                      <img alt="" src="assets/pages/img/menu/kc.png" width="40%" height="40%" style="margin-top: 15%;"/>
                      <div>  异常收发<br>汇总表</div>
                  </div>
              </div>
              <div class="col-md-3 col-sm-3 col-xs-3">
                  <div class=sub  style="background-color: #2ba8ff;cursor: hand" onclick="window.location.href='report/getGuaranteePeriod?flag=1&fstockid=3'">
                      <img alt="" src="assets/pages/img/menu/kc.png" width="40%" height="40%" style="margin-top: 15%;"/>
                      <div>  保质期清单</div>
                  </div>
              </div>
          </div>
    </div>
      </div>
    </div>
  </div>
</div>
  </body>
</html>
