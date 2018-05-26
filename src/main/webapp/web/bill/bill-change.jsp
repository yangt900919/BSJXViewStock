
<!-- xingli 2018-3-9 -->
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
</style>
<link rel="stylesheet" type="text/css" href="../css/outside.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/bsjx-all-js.js"></script>
<script type="text/javascript">

    function submit() {


        var result = true;
        if (result) {
            alert(result);

            $("#sub").submit();
        }

    }
</script>
<body>
<form action="/BSJX/bill/update" method="post" id="sub">
    <input type="hidden" id="fbillid" name="fbillid" value="${bill.fbillid}" />
<div class="search">
    <h3>单据</h3>
    <table class="searchTab" border="0">
        <tr>
            <td width="10%" align="right">单据编号:</td>
            <td width="20%"><input class="inputText" type="text" name="fnumber" id="fnumber" VALUE="${bill.fnumber}"></td>

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
            <td width="8%" length="10%" align="left">物料ID</td>
            <td width="8%" length="10%">物料编号</td>
            <td width="8%" length="10%">物料名称</td>
            <td width="8%" length="10%">仓库ID</td>
            <td width="8%" length="10%">仓库编号</td>
            <td width="8%" length="10%">仓库名称</td>
            <td width="8%" length="10%">供应商ID</td>
            <td width="8%" length="10%">供应商编号</td>
            <td width="8%" length="10%">供应商名称</td>
            <td width="8%" length="10%">数量</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody id="addTr">
        <c:forEach items="${bill.mEntries}" var="entry">
            <tr name="material" id="'+trId+'">
            <td width="8%" length="10%"><input class="tdv1" name="materialid" id="materialid" value="${entry.fmaid}"/><a class="marginLeft10" href="javascript:;" onclick="altmaterial(this)"><img src="../img/changePen.png" width="20" align="absmiddle" /></a></td>
            <td width="8%" length="10%"><input class="tdv2" name="materialnumber" id="materialnumber" value="${entry.material.materialnumber}"/></td>
            <td width="8%" length="10%"><input class="tdv2" name="materialname" id="materialname" value="${entry.material.materialname}"/></td>
            <td width="8%" length="10%"><input class="tdv4" name="stockid" id="stockid" value="${entry.fstockid}"/><a class="marginLeft10" href="javascript:;" onclick="altstock(this)"><img src="../img/changePen.png" width="20" align="absmiddle" /></a></td>
            <td width="8%" length="10%"><input class="tdv5" name="stocknumber" id="stocknumber" value="${entry.stock.stocknumber}"/></td>
            <td width="8%" length="10%"><input class="tdv6" name="stockname" id="stockname" value="${entry.stock.stockname}"/></td>
            <td width="8%" length="10%"><input class="tdv7" name="suplierid" id="suplierid" value="${entry.fsupplierid}"/><a class="marginLeft10" href="javascript:;" onclick="altsupplier(this)"><img src="../img/changePen.png" width="20" align="absmiddle" /></a></td>
            <td width="8%" length="10%"><input class="tdv8" name="supllernumber" id="supllernumber" value="${entry.supplier.suppliernumber}"/></td>
            <td width="8%" length="10%"><input class="tdv9" name="suppliername" id="suppliername" value="${entry.supplier.suppliername}"/></td>
            <td width="8%" length="10%"><input class="tdv9" name="fqty" id="fqty" value="${entry.fqty}"/></td>
            <td width="8%" length="10%"><a class="marginLeft10" href="javascript:;" onclick="del(this)"><img src="../img/delete.png" width="20" align="absmiddle" />删除</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>


    <div class="tableBottom"></div>
</div>
 <div align="center">
    <tr align="center">

        <td>&nbsp;</td>
        <td height="100">
            <a href="javascript:submit();">保存</a>
            <a href="/BSJX/bill/list" target="myFrame">返回</a>
        </td>
        <td colspan="2">&nbsp;</td>
    </tr>
 </div>
</form>
<!-- 物料表格展示END -->
<div class="materialDiv"></div>
<div class="materialTable">
    <div class="materialcloDiv">X</div>
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
            <c:forEach items="${materiallist}" var="material">
            <tr>
                <td align="center">${material.fid}</td>
                <td>${material.materialnumber}</td>
                <td>${material.materialnumber}</td>
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
    <div class="stockcloDiv">X</div>
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
                        <a href="javascript:;" class="infoList" onclick="stockcho(this)">
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
<!--供应商-->
<div class="supplierDiv"></div>
<div class="supplierTable">
    <div class="suppliercloDiv">X</div>
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
                        <a href="javascript:;" class="infoList" onclick="suppliercho(this)">
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
</body>
</html>