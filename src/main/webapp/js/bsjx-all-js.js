/* ----xingli 2018-3-9----  */


$(function(){
	// ********table js********
	changeTd();
	function changeTd(){
		var changeTd = $('.MainTable tbody tr');
		for(var i=0;i<changeTd.length;i++){
			if(i%2 == 0){
				changeTd[i].style.backgroundColor="#ffffff"; 
			}else{changeTd[i].style.backgroundColor="#ececec";}
		}
	}
	$('.MainTable tbody tr').click(function(){
		changeTd();
		$(this).css('background','#7dcbff');
	});
	// ********table js END!********
	// ********index js********
	function distance(){
		//获取分辨率
		var windowHei = $(window).height();
		var windowWid = $(window).width();
		$('.menu').css('height',windowHei-90);
		var menuWid = $('.menu').outerWidth();

		$('.main').css('height',windowHei-90);
		$('.main').css('width',windowWid-menuWid);
		$('.mainIframe').css('height',windowHei-110); //iframe高
		$('.mainIframe').css('width',windowWid-menuWid-10);
		$('.copright').css('top',windowHei-70);
	}
	distance();
	window.onresize = function(){
		distance();
	}
	//main内容部分
	$(".menuAll:first").addClass("menuAllTrue");
	$('.menuAll').click(function(){
		$('.menuAll').removeClass("menuAllTrue");
		$(this).addClass("menuAllTrue");
	});
	$('.secondMenu a').click(function(){
		$('.secondMenu a').css('color','#afafaf');
		$(this).css('color','#ffffff');
	});
	//二级菜单显示
	$('.menuAll').click(function(){
		$('.menuAll').next('.secondMenu').slideUp();
		 $(this).next('.secondMenu').slideDown();
	});
	//二级菜单END
	//********index js END!********
	

	$('.cloDiv').click(function(){
		$('.altDiv').css('display','none');
		$('.cloDiv').css('display','none');
		$('.altTable').css('display','none');
	});
});
//新建  删除tr END

var addTrId;
$('.MainTable tbody tr').click(function(){
	changeTd();
	$(this).css('background','#7dcbff');
});

function del(obj) {  
    var trId = obj.parentNode.parentNode.id;  
    var trObj = document.getElementById(trId);  
    document.getElementById("addTr").removeChild(trObj); 
    changeTd();
}
//获取屏幕高度宽度
var iframeWidth = $(window).width();

var iframeHeight = $(window).height();

//获取屏幕高度宽度 END
function altmaterial(obj) {
    addTrId = $(obj).parent().parent().attr("id");
    $('.materialDiv').css('display','block');
    $('.materialcloDiv').css('display','block');
    $('.materialTable').css('display','block');
    var altDivWidth = $('.materialTable').width();
    var altDivHeight = $('.materialTable').height();
    $('.materialTable').css('left',(iframeWidth-altDivWidth)/2);
    $('.materialTable').css('top',(iframeHeight-altDivHeight)/2);
}
function altstock(obj) {
    addTrId = $(obj).parent().parent().attr("id");
    $('.stockDiv').css('display','block');
    $('.stockcloDiv').css('display','block');
    $('.stockTable').css('display','block');
    var iframeWidth = $(window).width();
    var altDivWidth = $('.stockTable').width();
    var iframeHeight = $(window).height();
    var altDivHeight = $('.stockTable').height();
    $('.stockTable').css('left',(iframeWidth-altDivWidth)/2);
    $('.stockTable').css('top',(iframeHeight-altDivHeight)/2);
}
function altsupplier(obj) {
    addTrId = $(obj).parent().parent().attr("id");
    $('.supplierDiv').css('display','block');
    $('.suppliercloDiv').css('display','block');
    $('.supplierTable').css('display','block');
    var iframeWidth = $(window).width();
    var altDivWidth = $('.supplierTable').width();
    var iframeHeight = $(window).height();
    var altDivHeight = $('.supplierTable').height();
    $('.supplierTable').css('left',(iframeWidth-altDivWidth)/2);
    $('.supplierTable').css('top',(iframeHeight-altDivHeight)/2);
}
var trVal1 ="";
var trVal2 ="";
var trVal3 ="";
var trVal4 ="";
var trVal5 ="";
var trVal6 ="";
var trVal7 ="";
var trVal8 ="";
var trVal9 ="";
function materialcho(obj){
	var thisValue = $(obj).parent().parent();
	 trVal1 = thisValue.children(':first').html();
     trVal2 = thisValue.children(':first').next().html();
     trVal3 = thisValue.children(':first').next().next().html();
    document.getElementById(addTrId).innerHTML =
        '<td width="7%" length="10%"><input style="width: 60%" class="tdv1" name="materialid" id="materialid" value="'+trVal1+'"/><a class="marginLeft10" href="javascript:;" onclick="altmaterial(this)"><img src="../img/changePen.png" width="20" align="absmiddle" /></a></td>' +
        '<td width="7%" length="10%"><input style="width: 60%" class="tdv1" name="materialnumber" id="materialnumber" value="'+trVal2+'"/></td>' +
        '<td width="7%" length="10%"><input style="width: 60%" class="tdv1" name="materialname" id="materialname" value="'+trVal3+'"/></td>' +
        '<td width="7%" length="10%"><input style="width: 60%" class="tdv1" name="fbrand" id="fbrand"/></td>' +
        '<td width="7%" length="10%"><input style="width: 60%" class="tdv1" name="fqulity" id="fqulity"/></td>' +
        '<td width="7%" length="10%"><input style="width: 60%" class="tdv1" name="fqty" id="fqty"/></td>' +
        '<td width="7%" length="10%"><input style="width: 60%" class="tdv1" onclick="WdatePicker({dateFmt:\'yyyy-MM-dd\'})" name="fdeldate" id="fdeldate"/></td>' +
        '<td width="7%" length="10%"><input style="width: 60%" class="tdv1" name="fcontnum" id="fcontnum"/></td>' +
        '<td width="7%" length="10%"><input style="width: 60%" class="tdv1" name="freceiptqty" id="freceiptqty"/></td>' +
        '<td width="7%" length="10%"><input style="width: 60%" class="tdv1" name="frefoundqty" id="frefoundqty"/></td>' +
        '<td width="7%" length="10%"><input style="width: 60%" class="tdv1" name="fstoredqty" id="fstoredqty"/></td>' +
        '<td width="7%" length="10%"><input style="width: 60%" class="tdv1" name="fstate" id="fstate"/></td>' +
        '<td width="7%" length="10%"><input style="width: 60%" class="tdv1" name="fnote" id="fnote"/></td>' +
        '<td length="10%"><a class="marginLeft10" href="javascript:;" onclick="del(this)"><img src="../img/delete.png" width="20" align="absmiddle" />删除</a></td>' ;
    $('.materialDiv').css('display','none');
	$('.materialcloDiv').css('display','none');
	$('.materialTable').css('display','none');
}
function materialcloDiv(){
    $('.materialDiv').css('display','none');
    $('.materialcloDiv').css('display','none');
    $('.materialTable').css('display','none');
}

function stockcho(obj){
    var thisValue = $(obj).parent().parent();
    trVal4 = thisValue.children(':first').html();
    trVal5 = thisValue.children(':first').next().html();
    trVal6 = thisValue.children(':first').next().next().html();
    document.getElementById(addTrId).innerHTML = '<td width="8%" length="10%"><input class="tdv1" name="materialid" id="materialid"value="'+trVal1+'"/><a class="marginLeft10" href="javascript:;" onclick="altmaterial(this)"><img src="../img/changePen.png" width="20" align="absmiddle" /></a></td>' +
        '<td width="8%" length="10%"><input class="tdv1" name="materialnumber" id="materialnumber"value="'+trVal2+'"/></td>' +
        '<td width="8%" length="10%"><input class="tdv1" name="materialname" id="materialname"value="'+trVal3+'"/></td>' +
        '<td width="8%" length="10%"><input class="tdv1" name="stockid" id="materialid" value="'+trVal4+'"/><a class="marginLeft10" href="javascript:;" onclick="altstock(this)"><img src="../img/changePen.png" width="20" align="absmiddle" /></a></td>' +
        '<td width="8%" length="10%"><input class="tdv1" name="stocknumber" id="materialnumber"value="'+trVal5+'"/></td>' +
        '<td width="8%" length="10%"><input class="tdv1" name="stockname" id="materialname"value="'+trVal6+'"/></td>' +
        '<td width="8%" length="10%"><input class="tdv1" name="suplierid" id="suplierid" value="'+trVal7+'"/><a class="marginLeft10" href="javascript:;" onclick="altsupplier(this)"><img src="../img/changePen.png" width="20" align="absmiddle" /></a></td>' +
        '<td width="8%" length="10%"><input class="tdv1" name="supliernumber" id="supliernumber" value="'+trVal8+'"/></td>' +
        '<td width="8%" length="10%"><input class="tdv1" name="suppliername" id="suppliername" value="'+trVal9+'"/></td>' +
        '<td width="8%" length="10%"><input class="tdv9" name="fqty" id="fqty"/></td>' +
        '<td width="8%" length="10%"><a class="marginLeft10" href="javascript:;" onclick="del(this)"><img src="../img/delete.png" width="20" align="absmiddle" />删除</a></td>';
    $('.stockDiv').css('display','none');
    $('.stockcloDiv').css('display','none');
    $('.stockTable').css('display','none');
}
function suppliercho(obj){
    var thisValue = $(obj).parent().parent();
    trVal7 = thisValue.children(':first').html();
    trVal8 = thisValue.children(':first').next().html();
    trVal9 = thisValue.children(':first').next().next().html();
    document.getElementById(addTrId).innerHTML = '<td width="8%" length="10%"><input class="tdv1" name="materialid" id="materialid"value="'+trVal1+'"/><a class="marginLeft10" href="javascript:;" onclick="altmaterial(this)"><img src="../img/changePen.png" width="20" align="absmiddle" /></a></td>' +
        '<td width="8%" length="10%"><input class="tdv1" name="materialnumber" id="materialnumber"value="'+trVal2+'"/></td>' +
        '<td width="8%" length="10%"><input class="tdv1" name="materialname" id="materialname"value="'+trVal3+'"/></td>' +
        '<td width="8%" length="10%"><input class="tdv1" name="stockid" id="materialid" value="'+trVal4+'"/><a class="marginLeft10" href="javascript:;" onclick="altstock(this)"><img src="../img/changePen.png" width="20" align="absmiddle" /></a></td>' +
        '<td width="8%" length="10%"><input class="tdv1" name="stocknumber" id="materialnumber"value="'+trVal5+'"/></td>' +
        '<td width="8%" length="10%"><input class="tdv1" name="stockname" id="materialname"value="'+trVal6+'"/></td>' +
        '<td width="8%" length="10%"><input class="tdv1" name="suplierid" id="suplierid" value="'+trVal7+'"/><a class="marginLeft10" href="javascript:;" onclick="altsupplier(this)"><img src="../img/changePen.png" width="20" align="absmiddle" /></a></td>' +
        '<td width="8%" length="10%"><input class="tdv1" name="supllernumber" id="supllernumber" value="'+trVal8+'"/></td>' +
        '<td width="8%" length="10%"><input class="tdv1" name="suppliername" id="suppliername" value="'+trVal9+'"/></td>' +
        '<td width="8%" length="10%"><input class="tdv9" name="fqty" id="fqty"/></td>' +
        '<td width="8%" length="10%"><a class="marginLeft10" href="javascript:;" onclick="del(this)"><img src="../img/delete.png" width="20" align="absmiddle" />删除</a></td>';
    $('.supplierDiv').css('display','none');
    $('.suppliercloDiv').css('display','none');
    $('.supplierTable').css('display','none');
    trVal1 ="";
    trVal2 ="";
    trVal3 ="";
    trVal4 ="";
    trVal5 ="";
    trVal6 ="";
    trVal7 ="";
    trVal8 ="";
    trVal9 ="";


}

var trId = 1;
function add() {  
    trId++;
    var trObj = document.createElement("tr");  
    trObj.id = new Date().getTime();  
    trObj.innerHTML = '<tr name="material" id="'+trId+'">' +
		'<td width="7%" length="10%"><input style="width: 60%" class="tdv1" name="materialid" id="materialid"/><a class="marginLeft10" href="javascript:;" onclick="altmaterial(this)"><img src="../img/changePen.png" width="20" align="absmiddle" /></a></td>' +
		'<td width="7%" length="10%"><input style="width: 60%" class="tdv1" name="materialnumber" id="materialnumber"/></td>' +
		'<td width="7%" length="10%"><input style="width: 60%" class="tdv1" name="materialname" id="materialname"/></td>' +
        '<td width="7%" length="10%"><input style="width: 60%" class="tdv1" name="fbrand" id="fbrand"/></td>' +
        '<td width="7%" length="10%"><input style="width: 60%" class="tdv1" name="fqulity" id="fqulity"/></td>' +
        '<td width="7%" length="10%"><input style="width: 60%" class="tdv1" name="fqty" id="fqty"/></td>' +
        '<td width="7%" length="10%"><input style="width: 60%" class="tdv1" name="fdeldate" id="fdeldate" onclick="WdatePicker({dateFmt:\'yyyy-MM-dd\'})" class="Wdate"/></td>' +
        '<td width="7%" length="10%"><input style="width: 60%" class="tdv1" name="fcontnum" id="fcontnum"/></td>' +
        '<td width="7%" length="10%"><input style="width: 60%" class="tdv1" name="freceiptqty" id="freceiptqty"/></td>' +
        '<td width="7%" length="10%"><input style="width: 60%" class="tdv1" name="frefoundqty" id="frefoundqty"/></td>' +
        '<td width="7%" length="10%"><input style="width: 60%" class="tdv1" name="fstoredqty" id="fstoredqty"/></td>' +
        '<td width="7%" length="10%"><input style="width: 60%" class="tdv1" name="fstate" id="fstate"/></td>' +
        '<td width="7%" length="10%"><input style="width: 60%" class="tdv1" name="fnote" id="fnote"/></td>' +
		'<td length="10%"><a class="marginLeft10" href="javascript:;" onclick="del(this)"><img src="../img/delete.png" width="20" align="absmiddle" />删除</a></td>' +
		'</tr>';
    document.getElementById("addTr").appendChild(trObj); 
    changeTd();
}

function changeTd(){
    var changeTd = $('.MainTable tbody tr');
    for(var i=0;i<changeTd.length;i++){
        if(i%2 == 0){
            changeTd[i].style.backgroundColor="#ffffff"; 
        }else{changeTd[i].style.backgroundColor="#ececec";}
    }
}
//新建  删除tr


//
function supplierDiv(obj) {
    $('.supplierDiv').css('display','block');
    $('.supplierTable').css('display','block');
    var altDivWidth = $('.supplierTable').width();
    var altDivHeight = $('.supplierTable').height();
    $('.supplierTable').css('left',(iframeWidth-altDivWidth)/2);
    $('.supplierTable').css('top',(iframeHeight-altDivHeight)/2);
}


function suppliercloDiv() {
    $('.supplierDiv').css('display','none');
    $('.supplierTable').css('display','none');
}

function changeSupplierValue(obj) {
    document.getElementById('fsupplierid').parentNode.innerHTML ='<input style="width: 60%;display:none;" class="inputText" type="text" name="fsupplierid" id="fsupplierid" />';
    var thisId = $(obj).parent().parent().children(':first').html();
    document.getElementById('fsupplierid').value = thisId;
    var thisValue = $(obj).parent().parent().children(':first').next().next().html();
    var tValTd = document.getElementById('fsupplierid').parentNode;
    var valObj = document.createElement("span");
    valObj.innerHTML = '<input style="width: 60%;" class="inputText" type="text" value="'+thisValue+'" /><a class="marginLeft10" href="javascript:;" onclick="supplierDiv(this)"><img src="../img/changePen.png" width="20" align="absmiddle" /></a>';
    tValTd.appendChild(valObj);
    $('.supplierDiv').css('display','none');
    $('.supplierTable').css('display','none');
}

function createTime() {
    WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'1990-01-01',maxDate:'2050-01-01'});
}




function stockDiv(obj) {
    $('.stockDiv').css('display','block');
    $('.stockTable').css('display','block');
    var altDivWidth = $('.stockTable').width();
    var altDivHeight = $('.stockTable').height();
    $('.stockTable').css('left',(iframeWidth-altDivWidth)/2);
    $('.stockTable').css('top',(iframeHeight-altDivHeight)/2);
}


function stockcloDiv() {
    $('.stockDiv').css('display','none');
    $('.stockTable').css('display','none');
}

function changeStockValue(obj) {
    document.getElementById('fstockid').parentNode.innerHTML ='<input style="width: 60%;display:none;" class="inputText" type="text" name="fstockid" id="fstockid" />';
    var thisId = $(obj).parent().parent().children(':first').html();
    document.getElementById('fstockid').value = thisId;
    var thisValue = $(obj).parent().parent().children(':first').next().next().html();
    var tValTd = document.getElementById('fstockid').parentNode;
    var valObj = document.createElement("span");
    valObj.innerHTML = '<input style="width: 60%;" class="inputText" type="text" value="'+thisValue+'" /><a class="marginLeft10" href="javascript:;" onclick="stockDiv(this)"><img src="../img/changePen.png" width="20" align="absmiddle" /></a>';
    tValTd.appendChild(valObj);
    $('.stockDiv').css('display','none');
    $('.stockTable').css('display','none');
}




//

/* ----xingli 2018-3-9----  */