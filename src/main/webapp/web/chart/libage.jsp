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
<link rel="stylesheet" type="text/css" href="assets/pages/css/chart.css">
<link rel="stylesheet" type="text/css" href=" assets/pages/css/rmenu.css" />
 <script type="text/javascript" src="assets/pages/scripts/bootstrap-select.js"></script>
 <link rel="stylesheet" type="text/css" href="assets/pages/css/bootstrap-select.css">

<html>
<head>
    <title>库龄分析</title>
    <script>
        $(document).ready(function() {

            if('${size}'=='2')
            initDate("fdate");
            $('.selectpicker').selectpicker({
                'selectedText': 'cat'
            });
            var x = [];
            var mark=[];
            var mark1=[];
         var data=eval('${libage}');
            x=['一年无动态','两年无动态','三年及以上无动态'];
            mark=[{xAxis:'一年无动态',yAxis:data[0].maqty_one},{xAxis:'两年无动态',yAxis:data[0].maqty_two},{xAxis:'三年及以上无动态',yAxis:data[0].maqty_three}];
            mark1=[{xAxis:'一年无动态',yAxis:data[0].macount_one},{xAxis:'两年无动态',yAxis:data[0].macount_two},{xAxis:'三年及以上无动态',yAxis:data[0].macount_three}];
            //alert(data);

        var y=[data[0].maqty_one,data[0].maqty_two,data[0].maqty_three];
         var y1=   [data[0].macount_one,data[0].macount_two,data[0].macount_three];

        var chart = echarts.init(document.getElementById("libage_chart"));
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
data:["数量","种类"]
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
                            color: "#222"
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
<body>
<jsp:include page="../../web/shared/mtop.jsp"></jsp:include>
<div class="page-body">
    <div class=" container-fluid" align="center">
    <div class="row">
        <div class="col-md-3 col-sm-3 col-xs-3"  align="left">
            <div class="page_title" >&nbsp;库龄分析</div>
        </div>
    </div>
        <div class="row query-condition"  >
            <div class=" col-md-12 col-sm-12 col-xs-12 " >
                <form action="report/getLibAge"  class="form-horizontal" method="post" id=form>



                    <div class="form-group" >
                        <label for="fdate" class="col-sm-4 col-xs-4 col-md-4" >日期</label>
                        <div class="col-sm-8 col-xs-8 col-md-8" align="left">
                            <input type="date" class="form-control" onblur="$('#form').submit()" id="fdate" name="fdate" placeholder="" value=${model.fdate } >
                            <input type="hidden" name="page" value="libagel">
                        </div>
                    </div>
                   <%-- <div class="form-group">
                        <label for="manum" class="col-sm-4 col-xs-4 col-md-4">物料</label>
                        <div class="col-sm-6 col-xs-6 col-md-6">
                            <select id="manum" multiple data-live-search="true"
                                    class="selectpicker show-tick form-control" name="manum">
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
                    </div>--%>
<input type="hidden" name="type" value="libage">
                    <input type="hidden" name="page" value="libage">


         <%--   <div class="form-group">
                <div class="col-sm-offset-8 col-sm-3" >
                    <button type="submit" class="btn btn-primary btn-sm">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>   查询</button>
&lt;%&ndash;
                    <button  type="button" class="btn btn-warning  btn-sm" onclick="javascript:history.go(-1);">

                        <span class="glyphicon glyphicon-log-out" aria-hidden="true" ></span>  退出</button>&ndash;%&gt;
                </div>
            </div>--%>
            </form>
            </div>
        </div>

        <div class="row">
            <div id="libage_chart">

            </div>
        </div>
</div>
</div>
</body>
</html>
