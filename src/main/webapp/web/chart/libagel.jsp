 <%--
  Created by IntelliJ IDEA.
  User: Yang
  Date: 2018/6/29
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="../../web/shared/resource.jsp"></jsp:include>
<script src="assets/pages/scripts/echarts.min.js"></script>
<%-- <script type="application/javascript" src="assets/pages/scripts/bill.js"></script>--%>

<link rel="stylesheet" type="text/css" href=" assets/pages/css/menu.css" />
 <link rel="stylesheet" href="assets/pages/css/page/display.css"/>
 <script type="text/javascript" src="assets/pages/scripts/bootstrap-select.js"></script>
 <link rel="stylesheet" type="text/css" href="assets/pages/css/bootstrap-select.css">
 <link rel="stylesheet" type="text/css" href="assets/pages/css/chart.css">
<html>
<head>
    <title>无动态</title>
    <script>
        $(document).ready(function() {

            if('${size}'=='3')
            initDate("fdate");
           /* $('.selectpicker').selectpicker({
                'selectedText': 'cat'
            });*/
            var x = [];
            var mark=[];
            var mark1=[];
         var data=eval('${libage}');
            x=['一年无动态','两年无动态','三年及以上无动态'];
            mark=[{xAxis:'一年无动态',yAxis:data[0].maqty_one.toFixed(2)},{xAxis:'两年无动态',yAxis:data[0].maqty_two.toFixed(2)},{xAxis:'三年及以上无动态',yAxis:data[0].maqty_three.toFixed(2)}];
            mark1=[{xAxis:'一年无动态',yAxis:data[0].macount_one},{xAxis:'两年无动态',yAxis:data[0].macount_two},{xAxis:'三年及以上无动态',yAxis:data[0].macount_three}];
            //alert(data);

        var y=[data[0].maqty_one.toFixed(2),data[0].maqty_two.toFixed(2),data[0].maqty_three.toFixed(2)];
         var y1=   [data[0].macount_one,data[0].macount_two,data[0].macount_three];

        var chart = echarts.init(document.getElementById("libage_chartl"));
        var chartopt = {
            title: {
                text: '',
                x: 'left'
            },
            tooltip: {
                trigger: 'axis'
            },
            color: ["#2ba8ff","#fd672b"],
            toolbox: {
                show: true,

            },
            calculable: true,
            legend: {
data:["数量","种类"],
                backgroundColor:'rgba(255,255,255,1)'
            },
            xAxis: [
                {
                    type: 'category',
                    data: x,
                    axisLabel: {
                        show: true,
                        interval: 0,
                        rotate: 30,
                        margin: 2,
                        textStyle: {
                            color: "#fff"
                        }

                    },
                    splitLine: {
                        show: false
                    }
                }
            ],
            yAxis: {
                splitLine: {
                    show: false
                }
                , axisLabel : {
                  
                    textStyle: {
                        color: '#fff'
                    }
                }
            },
            series: [

                {
                    name: '数量',
                    type: 'bar',
                    barWidth: 25,
                    itemStyle: {
                        normal: {
                            label: {
                                show: false,
                                labelLine: { show: false }
                            }
                        }
                    },

                    data: y,
                    markPoint: {
                        symbolSize: 65,
                        data: mark

                    }
                }
                ,
                {
                    name: '种类',
                    type: 'bar',
                    barWidth: 25,
                    itemStyle: {
                        normal: {
                            label: {
                                show: false,
                                labelLine: { show: false }
                            }
                        }
                    },

                    data: y1,
                    markPoint: {
                        symbolSize: 65,
                        data: mark1

                    }
                }
            ]
        };
        chart.setOption(chartopt);
        });
    </script>

</head>
<body >
<c:if test="${param.fstockid=='1'}">
    <jsp:include page="../../web/shared/Atop.jsp"></jsp:include>
</c:if>
<c:if test="${param.fstockid=='2'}">
    <jsp:include page="../../web/shared/Btop.jsp"></jsp:include>
</c:if>
<c:if test="${param.fstockid=='3'}">
    <jsp:include page="../../web/shared/Ctop.jsp"></jsp:include>
</c:if>
<br>
<div class="page-body">
    <div class=" container-fluid" align="center">
        <div class="row">
            <div class="chart_title">
<span>无动态</span>
            </div>
        </div>
        <br>
        <div class="row">
            <form class="form-inline" action="report/getLibAge" id="chartform">
                <div class="form-group">
                    <label for="fdate">日期</label>
                    <input type="date" class="form-control" id="fdate" name="fdate" placeholder="" value=${model.fdate }  >
                <input type="hidden" name="page" value="libagel">
                    <input type="hidden" name="fstockid" value="${param.fstockid}">
                </div>
                <%--   <div class="form-group">
                       <label for="fname">名称</label>
                       <input type="text" class="form-control" id="fname" name="fname" placeholder="" value=${model.fname }>
                   </div>--%>
             <%--   <div class="form-group">
                    <label for="manum">物料</label>
                    <div class="input-group">
                        <input $ type="text"  onfocus="clearBasics('manum')"  class="form-control" id="maname" name="maname"  placeholder="" value=${model.maname}>
                        <input type="hidden" class="form-control" id="manum" name=manum  placeholder="" value=${model.manum}>
                        <span class="input-group-btn">
           <button class="btn btn-primary" type="button" onclick="showBasics('ma','manum','maname')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
      </span>
                    </div>
                </div>--%>
                <button type="submit" class="btn btn-info btn-sm ">
                    <span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询
                </button>
            </form>
    </div>
 <%--   <div class="row">
        <div class="col-md-3 col-sm-3 col-xs-3"  align="left">
            <div class="page_title" >&nbsp;库龄分析</div>
        </div>
    </div>--%>
                                                                            <%--   <div class="row query-condition"  >
            <div class="col-md-offset-4 col-sm-offset-4 col-xs-offset-4 col-md-4 col-sm-4 col-xs-4  " >
                <form action="report/getLibAge"  class="form-horizontal" method="post" id=form>



                    <div class="form-group" >
                        <label for="fdate" class="col-sm-4 col-xs-4 col-md-4" >日期</label>
                        <div class="col-sm-8 col-xs-8 col-md-8" align="left">
                            <input type="date" class="form-control"  id="fdate" name="fdate" placeholder="" value=${model.fdate } >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="manum" class="col-sm-4 col-xs-4 col-md-4">物料</label>
                        <div class="col-sm-8 col-xs-8 col-md-8">
                            <select id="manum" 
                                    class="form-control" name="manum">
                                <option value="" >&nbsp;</option>
                                <c:forEach items="${malist}" var="map">
                                    <option value="${map.materialnumber}">${map.materialname}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <script>
                            if('${map.manum}'!=null&&'${map.manum}'!='')
                            $("#manum").val(${map.manum});
                            else $("#manum").val('');
                        </script>
                    </div>
<input type="hidden" name="type" value="libage">
                    <input type="hidden" name="page" value="libagel">


            <div class="form-group">
                <div class="col-sm-offset-8 col-sm-4" align="right">
                    <button type="submit" class="btn btn-primary btn-sm">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>   查询</button>
&lt;%&ndash;
                    <button  type="button" class="btn btn-warning  btn-sm" onclick="javascript:history.go(-1);">

                        <span class="glyphicon glyphicon-log-out" aria-hidden="true" ></span>  退出</button>&ndash;%&gt;
                </div>
            </div>
            </form>
            </div>
        </div>--%>

        <div class="row">
            <div id="libage_chartl">

            </div>
        </div>
</div>
</div>
</body>
</html>
