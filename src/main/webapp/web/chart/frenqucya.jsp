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
    <title>长期缺货</title>
    <script>
        $(document).ready(function() {


            if('${size}'=='3')
            { initStartDate("sdate");
            initDate("edate");}


            var colorList = ['#90c320', '#89acd8', '#f09a79', '#53b5e6',
                '#5793ed', '#a68dc7', '#ee9595', '#fff100',
                '#e96a79', '#b4d26b', '#ef794b', '#81cef2',
                '#fcb800', '#739e20', '#cde09b',
                '#4f87bd', '#c0504d', '#9bbb59', '#8064a2', '#4bacc6',
                '#FE8463', '#9BCA63', '#FAD860', '#F3A43B', '#60C0DD',
                '#D7504B', '#C6E579', '#F4E001', '#F0805A', '#26C0C0'
            ];

          var  x = [];
           var  y = [];
           var  mark=[];
         var data=${frenqucy};

        /* for(var i=0;i<data.length;i++)
         {
             if(data[i].flag==0) {
                 x.push(data[i].maname);
                 y.push(data[i].macount);
                 mark.push({xAxis:data[i].maname,yAxis:data[i].macount});
             }

         }

            var chart = echarts.init(document.getElementById("frenqucy_top"));
            var chartopt = {
                title: {
                    text: '高频次采购',
                    x: 'right'
                },
                tooltip: {
                    trigger: 'axis'
                },
                color: ["#2ba8ff"],
                toolbox: {
                    show: true,

                },
                calculable: true,
                legend: {
                    data:["采购次数"]
                },
                xAxis: [
                    {
                        type: 'category',
                        data: x,
                        axisLabel: {
                            show: true,
                            interval: 0,
                            rotate: 45,
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
                },
                series: [

                    {
                        name: '采购次数',
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

                ]
            };
            chart.setOption(chartopt);

            x=[];
            y=[];
            mark=[];*/
            for(var i=0;i<data.length;i++)
            {
                if(data[i].flag==1) {
                    x.push(data[i].maname);
                    y.push(data[i].macount);
                    mark.push({xAxis:data[i].maname,yAxis:data[i].macount});
                }

            }

            var chart = echarts.init(document.getElementById("frenqucy_bottom"));
            var chartopt = {
                title: {
                    text: '',
                    x: 'right'
                },
                tooltip: {
                    trigger: 'axis'
                },
                color: ["#2ba8ff"],
                toolbox: {
                    show: true,

                },
                calculable: true,
                legend: {
                    data:["长期缺货"],
                    backgroundColor:'rgba(255,255,255,1)'
                },
                xAxis: [
                    {
                        type: 'category',
                        data: x,
                        axisLabel: {
                            show: true,
                            interval: 0,
                            rotate: 45,
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
                    }, axisLabel : {

                        textStyle: {
                            color: '#fff'
                        }
                    }
                },
                series: [

                    {
                        name: '长期缺货',
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

                ]
            };
            chart.setOption(chartopt);
        });
    </script>
</head>
<body>
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
                <span>长期缺货</span>
            </div>
        </div>
<br>
        <div class="row">
            <form class="form-inline" action="report/getFrenqucy" id="chartform">

                <div class="form-group" >
                    <label for="sdate" class="col-sm-4 col-xs-4 col-md-4" >开始日期</label>
                    <div class="col-sm-8 col-xs-8 col-md-8" align="left">
                        <input type="date" class="form-control"  id="sdate" name="sdate" placeholder="" value=${model.sdate } >
                    </div>
                </div>
                <div class="form-group" >
                    <label for="edate" class="col-sm-4 col-xs-4 col-md-4" >结束日期</label>
                    <div class="col-sm-8 col-xs-8 col-md-8" align="left">
                        <input type="date" class="form-control"  id="edate" name="edate" placeholder="" value=${model.edate } >
                    </div>
                </div>

                <input type="hidden" name="type" value="frenqucy">
                <input type="hidden" name="page" value="frenqucya">
                <input type="hidden" name="fstockid" value="${param.fstockid}">

                <button type="submit" class="btn btn-info btn-sm ">
                    <span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询
                </button>
            </form>
        </div>



        <div class="row">
            <%--<div class="col-md-6">
                <div id="frenqucy_top">

                </div>
            </div>--%>

            <div class="col-md-12">
                <div id="frenqucy_bottom">

                </div>
            </div>
        </div>


</div>
</div>
</body>
</html>
