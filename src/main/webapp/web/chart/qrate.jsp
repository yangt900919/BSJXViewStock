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
    <title>一次校验合格率分析</title>
    <script>
        $(document).ready(function() {

            //alert('${model}');
            if('${size}'=='2')
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

            x = [];
            y = [];
         var data=eval('${qrate}');

         for(var i=0;i<data.length;i++)
         {
             x.push(data[i].sname);
             y.push({
                 name: data[i].sname, value: data[i].qrate, itemStyle: {
                     normal: { color: colorList[i] },
                     show: true, formatter: '{b} : {c} ({d}%)'
                 }});
         }

        var chart = echarts.init(document.getElementById("qrate"));
        var chartopt = {
            title: {
                text: '',
                x: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                y: 'bottom',
                x: 'center',
                data: x
            },
            restore: { show: true },
            saveAsImage: { show: true }
            ,
            calculable: true,
            series: [
                {
                    name: '访问来源',
                    type: 'pie',
                    radius: '55%',
                    center: ['50%', '40%'],
                    itemStyle: {
                        normal: {
                            label: {
                                show: false
                            },
                            labelLine: {
                                show: false
                            }
                        },
                        emphasis: {
                            label: {
                                show: true,
                                position: 'center',
                                textStyle: {
                                    fontSize: '50',
                                    fontWeight: 'bold'
                                }
                            }
                        }
                    },
                    data: y,
                    labelLine: {
                        normal: {
                            length: 30,
                            length2: 20
                        }
                    },
                    itemStyle: {
                        normal: {
                            label: {
                                show: true,
                                formatter: '{b}:({d}%)',
                                textStyle: {
                                    color: '#000000'
                                }
                            },
                            labelLine: { show: true }
                        }
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
            <div class="page_title" >&nbsp;一次校验合格率分析</div>
        </div>
    </div>
        <div class="row query-condition"  >
            <div class=" col-md-12 col-sm-12 col-xs-12 " >
                <form action="/report/getQualified"  class="form-horizontal" method="post" id=form>



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
<input type="hidden" name="type" value="qrate">
                    <input type="hidden" name="page" value="qrate">


            <div class="form-group">
                <div class="col-sm-offset-8 col-sm-3" >
                    <button type="submit" class="btn btn-primary btn-sm">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>   查询</button>
<%--
                    <button  type="button" class="btn btn-warning  btn-sm" onclick="javascript:history.go(-1);">

                        <span class="glyphicon glyphicon-log-out" aria-hidden="true" ></span>  退出</button>--%>
                </div>
            </div>
            </form>
            </div>
        </div>

        <div class="row">
            <div id="qrate">

            </div>
        </div>
</div>
</div>
</body>
</html>
