<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<!-- xingli 2018-3-9 -->
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    String date= format.format(new Date());
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<style type="text/css">
    .materialDiv{width: 100%; height: 100%; position:absolute;top:0;left:0;background:#000000;display: none;opacity:0.5;z-index: 5;}
    .materialTable{z-index: 999;position: absolute;top:30px;left:50px;right: auto;background: #ffffff;width:700px;display: none;}
    .materialcloDiv{position: absolute;right:5px;top:5px;width: 25px;height: 25px;background: grey;color:#fff;text-align: center;line-height: 25px;cursor: pointer;border-radius:25px;font-weight: bold;}
    .materialcloDiv:hover{background: red;}
    .stockDiv{width: 100%; height: 100%; position:absolute;top:0;left:0;background:#000000;display: none;opacity:0.5;z-index: 5;}
    .stockTable{z-index: 999;position: absolute;top:30px;left:50px;right: auto;background: #ffffff;width:700px;display: none;}
    .stockcloDiv{position: absolute;right:5px;top:5px;width: 25px;height: 25px;background: grey;color:#fff;text-align: center;line-height: 25px;cursor: pointer;border-radius:25px;font-weight: bold;}
    .stockcloDiv:hover{background: red;}
    .supplierDiv{width: 100%; height: 100%; position:absolute;top:0;left:0;background:#000000;display: none;opacity:0.5;z-index: 5;}
    .supplierTable{z-index: 999;position: absolute;top:30px;left:50px;right: auto;background: #ffffff;width:700px;display: none;}
    .suppliercloDiv{position: absolute;right:5px;top:5px;width: 25px;height: 25px;background: grey;color:#fff;text-align: center;line-height: 25px;cursor: pointer;border-radius:25px;font-weight: bold;}
    .suppliercloDiv:hover{background: red;}
    .depDiv{width: 100%; height: 100%; position:absolute;top:0;left:0;background:#000000;display: none;opacity:0.5;z-index: 5;}
    .depTable{z-index: 999;position: absolute;top:30px;left:50px;right: auto;background: #ffffff;width:700px;display: none;}
    .depcloDiv{position: absolute;right:5px;top:5px;width: 25px;height: 25px;background: grey;color:#fff;text-align: center;line-height: 25px;cursor: pointer;border-radius:25px;font-weight: bold;}
    .depcloDiv:hover{background: red;}
</style>
<link rel="stylesheet" type="text/css" href="../css/outside.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/bsjx-all-js.js"></script>
<script type="text/javascript" src="../js/jquery.form.js"></script>
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">

    function showMsgCreate(msg) {
        //top.$('context-msg').style.display = "block";
        //top.$('context-msg-text').innerHTML=msg;

        //top.lock.show();
        //alert(msg);
        if (confirm(msg)) {
            $(function(){
                $("#formsub").ajaxForm(function(data){
                    if(data=="ok"){
                        alert("保存成功！");
                        window.location.href("/BSJX/bill/list");
                    }else{
                        alert("保存失败");
                    }
                });
            });
        }
    }

</script>

<body>
<form action="/BSJX/bill/create" method="post" id="formsub" name="formsub">
<div class="search">
    <h3>单据</h3>
    <table class="searchTab" border="0">
        <tr>
            <td width="10%" >单据编号:</td>
            <td width="10%"><input class="inputText" type="text" name="fnumber" id="fnumber" VALUE="${billnumber}"></td>
            <td>供应商:</td>
            <td width="10%"><input style="width: 60%;" class="inputText" type="text" name="fsupplierid" id="fsupplierid" /><a class="marginLeft10" href="javascript:;" onclick="supplierDiv(this)"><img src="../img/changePen.png" width="20" align="absmiddle" /></a></td>
            <td>收货方:</td>
            <td width="10%"><input class="inputText" type="text" name="fcustomid" id="fcustomid"/></td>
            <td>发料仓库:</td>
            <td width="10%"><input style="width: 60%;" class="inputText" type="text" name="fstockid" id="fstockid"/> <a class="marginLeft10" href="javascript:;" onclick="stockDiv(this)"><img src="../img/changePen.png" width="20" align="absmiddle" /></a></td>
        </tr>
        <tr>
            <td>创建日期:</td>
            <td width="10%"><input class="inputText" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" type="text" name="fcreatetime" id="fcreatetime" value="<%=date%>" readonly unselectable="on" /></td>
            <td>创建用户:</td>
            <td width="10%"><input class="inputText"  type="text" name="fcruserid" id="fcruserid" readonly unselectable="on" /></td>
            <td>审核日期:</td>
            <td width="10%"><input class="inputText"  type="text" name="fcheckdate" id="fcheckdate"  readonly unselectable="on" /></td>
            <td>审核用户:</td>
            <td width="10%"><input class="inputText" type="text" name="fchuserid" id="fchuserid" readonly unselectable="on" /></td>
            <td>状态:</td>
            <td width="10%"><input class="inputText" type="text" name="fstatus" id="fstatus" readonly unselectable="on" value="0"/></td>
            <td>&nbsp;</td>
        </tr>
    </table>
</div>
<!-- 表格展示 -->
<div class="MainTable marginTop10">
    <div class="MainTableTitle">单据列表</div>
    <div class="MainTableInput">
        <a onclick="add()" href="javascript:;"><img src="../img/add.png" width="27" /><span>新增</span></a>
    </div>
    <table class="tableIn" width="100%" border="0" cellspacing="0" cellpadding="0">
        <thead>
        <tr class="tableTitleName">
            <td width="7%" length="10%" align="left">物料ID</td>
            <td width="7%" length="10%">物料编号</td>
            <td width="7%" length="10%">物料名称</td>
            <td width="7%" length="10%">品牌</td>
            <td width="7%" length="10%">质量标准</td>
            <td width="7%" length="10%">数量</td>
            <td width="7%" length="10%">交货日期</td>
            <td width="7%" length="10%">合同号</td>
            <td width="7%" length="10%">收料数量</td>
            <td width="7%" length="10%">退料数量</td>
            <td width="7%" length="10%">入库数量</td>
            <td width="7%" length="10%">行业务关闭标志</td>
            <td width="7%" length="10%">备注</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody id="addTr">

        </tbody>
    </table>


    <div class="tableBottom"></div>
</div>
 <div align="center">
    <tr align="center">

        <td>&nbsp;</td>
        <td height="100">
            <a href="javascript:void(0)" onclick="showMsgCreate('是否保存单据')" >保存</a>
            <%--<button type="submit">保存</button>--%>
            <a href="/BSJX/bill/list" target="myFrame">返回</a>
        </td>
        <td colspan="2">&nbsp;</td>
    </tr>
 </div>
</form>
<!-- 物料表格展示END -->
<div class="materialDiv"></div>
<div class="materialTable">
    <div class="materialcloDiv" onclick="materialcloDiv()">X</div>
    <div class="search altSearch">
        <br>
        <table class="searchTab" border="0">
            <tr>
                <td width="10%" align="right">物料:</td>
                <td width="20%"><input class="inputText" type="text" name=""></td>
                <td width="10%" align="right">
                    <input class="mySubmit" type="submit" value="查询">
                </td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </div>
    <!-- 表格展示 -->
    <div class="MainTable marginTop10 paddingLeft5 paddingBottom5">
        <div class="MainTableTitle">物料列表</div>

        <table class="tableIn" width="100%" border="0" cellspacing="0" cellpadding="0">
            <thead>
            <tr class="tableTitleName">
                <td width="20%" align="center">物料ID</td>
                <td width="20%">物料代码</td>
                <td width="20%">物料名称</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${materiallist}" var="material" begin="1" end="10">
            <tr>
                <td align="center">${material.fid}</td>
                <td>${material.materialnumber}</td>
                <td>${material.materialname}</td>
                <td>
                    <a href="javascript:;" class="infoList" onclick="materialcho(this)">
                        <img src="../img/changePen.png" width="20" align="absmiddle" />选择</a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="tablePag">
            <img src="../img/pag01.png" title="首页" />
            <img src="../img/pag02.png" title="上一页" />
            第<input class="pagInput" name="" type="text" />页
            <img src="../img/pag03.png" title="下一页" />
            <img src="../img/pag04.png" title="尾页" />
            共<span class="red">11</span>页
        </div>
        <div class="tableBottom"></div>
    </div>
</div>

<!--仓库-->
<div class="stockDiv"></div>
<div class="stockTable">
    <div class="stockcloDiv" onclick="stockcloDiv()">X</div>
    <div class="search altSearch">
        <br>
        <table class="searchTab" border="0">
            <tr>
                <td width="10%" align="right">仓库:</td>
                <td width="20%"><input class="inputText" type="text" name=""></td>
                <td width="10%" align="right">
                    <input class="mySubmit" type="submit" value="查询">
                </td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </div>
    <!-- 表格展示 -->
    <div class="MainTable marginTop10 paddingLeft5 paddingBottom5">
        <div class="MainTableTitle">仓库列表</div>

        <table class="tableIn" width="100%" border="0" cellspacing="0" cellpadding="0">
            <thead>
            <tr class="tableTitleName">
                <td width="20%" align="center">仓库ID</td>
                <td width="20%">仓库代码</td>
                <td width="20%">仓库名称</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${stocklist}" var="stock">
                <tr>
                    <td align="center">${stock.fid}</td>
                    <td>${stock.stocknumber}</td>
                    <td>${stock.stocknumber}</td>
                    <td>
                        <a href="javascript:;" onclick="changeStockValue(this)">选择</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="tablePag">
            <img src="../img/pag01.png" title="首页" />
            <img src="../img/pag02.png" title="上一页" />
            第<input class="pagInput" name="" type="text" />页
            <img src="../img/pag03.png" title="下一页" />
            <img src="../img/pag04.png" title="尾页" />
            共<span class="red">11</span>页
        </div>
        <div class="tableBottom"></div>
    </div>
</div>
<!--供应商-->
<div class="supplierDiv"></div>
<div class="supplierTable">
    <div class="suppliercloDiv" onclick="suppliercloDiv()">X</div>
    <div class="search altSearch">
        <br>
        <table class="searchTab" border="0">
            <tr>
                <td width="10%" align="right">供应商:</td>
                <td width="20%"><input class="inputText" type="text" name=""></td>
                <td width="10%" align="right">
                    <input class="mySubmit" type="submit" value="查询">
                </td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </div>
    <!-- 表格展示 -->
    <div class="MainTable marginTop10 paddingLeft5 paddingBottom5">
        <div class="MainTableTitle">供应商列表</div>

        <table class="tableIn" width="100%" border="0" cellspacing="0" cellpadding="0">
            <thead>
            <tr class="tableTitleName">
                <td width="20%" align="center">供应商ID</td>
                <td width="20%">供应商代码</td>
                <td width="20%">供应商名称</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${supplierlist}" var="supplier">
                <tr>
                    <td align="center">${supplier.fid}</td>
                    <td>${supplier.suppliernumber}</td>
                    <td>${supplier.suppliername}</td>
                    <td>
                        <a href="javascript:;" onclick="changeSupplierValue(this)">选择</a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
        <div class="tablePag">
            <img src="../img/pag01.png" title="首页" />
            <img src="../img/pag02.png" title="上一页" />
            第<input class="pagInput" name="" type="text" />页
            <img src="../img/pag03.png" title="下一页" />
            <img src="../img/pag04.png" title="尾页" />
            共<span class="red">11</span>页
        </div>
        <div class="tableBottom"></div>
    </div>
</div>
<!--部门 -->
<div class="depDiv"></div>
<div class="depTable">
    <div class="depcloDiv" onclick="depcloDiv()">X</div>
    <div class="search altSearch">
        <br>
        <table class="searchTab" border="0">
            <tr>
                <td width="10%" align="right">部门:</td>
                <td width="20%"><input class="inputText" type="text" name=""></td>
                <td width="10%" align="right">
                    <input class="mySubmit" type="submit" value="查询">
                </td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </div>
    <!-- 表格展示 -->
    <div class="MainTable marginTop10 paddingLeft5 paddingBottom5">
        <div class="MainTableTitle">部门列表</div>

        <table class="tableIn" width="100%" border="0" cellspacing="0" cellpadding="0">
            <thead>
            <tr class="tableTitleName">
                <td width="20%" align="center">部门ID</td>
                <td width="20%">部门代码</td>
                <td width="20%">部门名称</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${supplierlist}" var="supplier">
                <tr>
                    <td align="center">${supplier.fid}</td>
                    <td>${supplier.suppliernumber}</td>
                    <td>${supplier.suppliername}</td>
                    <td>
                        <a href="javascript:;" onclick="changeSupplierValue(this)">选择</a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
        <div class="tablePag">
            <img src="../img/pag01.png" title="首页" />
            <img src="../img/pag02.png" title="上一页" />
            第<input class="pagInput" name="" type="text" />页
            <img src="../img/pag03.png" title="下一页" />
            <img src="../img/pag04.png" title="尾页" />
            共<span class="red">11</span>页
        </div>
        <div class="tableBottom"></div>
    </div>
</div>

</body>
</html>