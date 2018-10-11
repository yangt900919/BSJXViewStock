var keyCode=0;
var idval="";
var id="";
$(document).keydown(function(event){
    keyCode=event.keyCode;


    if(keyCode==8)
    {
        /*alert(bName);*/
        $("#"+bID).val(0);
        $("#"+bName).val("");
        bID="";
        bName="";
    }
    /*if(keyCode==17)
	{
		$("#"+id).val(idval);
        idval="";
         id="";
	}*/
});

var table="";
function initTable(ID)
{
	if(table!="")
	{
		table.fnDestroy();
	
	}
	
	table=$('#'+ID).dataTable( {        				
				 "language":{
					"url":"assets/pages/scripts/Chinese.json"
				},
				 "bLengthChange": false,
				 "bProcessing": true,
				 "bSortClasses":true,
				 "sPaginationType": "full_numbers",
                 "pageLength":8,
                    "bSort":true
				}); 
	 
}

function Edit(url,ID)
{
	location.href=url+"/edit?ID="+ID;
}

function checkall()
{
//	/alert($("#checkall").prop("checked"));
	if($("#checkall").prop("checked"))
	{
		$(".check").prop("checked",true) ;

	}
	else
	{
		$(".check").prop("checked",false) ;
	}
}

function Delete(url,ID)
{
	if(confirm("确认删除?"))
	{
		if($("#fstate"+ID).length>0)
		{
			if($("#fstate"+ID).text().trim()=="审核")
			{
				alert("单据已审核，不能删除!");
			}
			else
			{
                $.ajax
                ({
                    type: "get",
                    url: url+"/checkrelation",
                    data: "ID=" +ID,
                    contentType: "application/json; charset=UTF-8",
                    success: function (result) {
                    	//alert(result=="true");
                        if(result)
                        {
                            alert("单据已生成下游单据不能删除!");
                        }
                        else
                        {
                            location.href=url+"/delete?ID="+ID;
                        }
                    },
                    error: function (result, data) {
                        //alert(data);
                    }
                });
			}

		}

	else
            location.href=url+"/delete?ID="+ID;

	}

}


function DeleteBatch(url)
{
	if(confirm("确认批量删除?"))
			{
		var ids = [];
	var	bool=true;
	var str="";
        $("input[name='check']:checkbox:checked").each(function () {
            ids.push(Number($(this).val().split(",")[0]));


            if($("#fstate"+$(this).val()).length>0)
			{
				if($("#fstate"+$(this).val()).text().trim()=="审核")
				{
					//bool=false;
					str="存在已审核单据，批量删除失败!";

				}
				else
				{
				    if(ids.length>0)
                    {
                        $.ajax
                        ({
                            type: "get",
                            url: url+"/checkrelation",
                            data: "ID=" +Number($(this).val().split(",")[0]),
                            contentType: "application/json; charset=UTF-8",
                            success: function (result) {

                                if(result)
                                {

                                   // bool=false;
                                    str="单据已生成下游单据不能删除!";
                                   //alert(str+"fdgdfg");
                                }

                            },
                            error: function (result, data) {
                                //alert(data);
                            }
                        });
                    }
                    else
                    {
                        //bool=false;
                        str="至少选择一条数据!";
                    }

                }
			}
        });
                if(ids.length==0)
                {
                    //bool=false;
                    str="至少选择一条数据!";
                }
                alert(str);
        if(str=="" )
         location.href = url+"/deleteBatch?ids=" + ids;
        else
        	alert(str);
			}
	

}
var pageNow=1;
function PrintqrCode(url)
{
    /*if(confirm("确认批量打印?"))
	{*/
var qrcodes=[];
        $("input[name='check']:checkbox:checked").each(function () {
            qrcodes.push($(this).val());
        });

        location.href = url+"/print?qrcodes=" + qrcodes+"&pageNow="+pageNow+"&condition=1";
    /*}*/

}

function scPrint(url)
{
    if(confirm("确认批量打印?"))
    {
        var qrcodes=[];
        $("input[name='check']:checkbox:checked").each(function () {
            qrcodes.push($(this).val());
        });

        location.href = url+"/print?qrcodes=" + qrcodes+"&pageNow="+pageNow+"&condition=1";
    }

}

function Close(url,ID)
{
	if(confirm("确认关闭?"))
	location.href=url+"/close?ID="+ID;
}


function CloseBatch(url)
{
	if(confirm("确认批量关闭?"))
			{
	var ids = [];
          $("input[name='check']:checkbox:checked").each(function () {
              ids.push($(this).val());
          });
          
           location.href = url+"/closeBatch?ids=" + ids;
			}
}

function getBaiscInfo(ID)
{
	initTable(ID+'table');
	$('#'+ID+'modal').modal("show");
}

var bID="";
var bName="";

function showBasics(mtID,ID,name)
{
    initTable(mtID+'table');
    $('#'+mtID+'modal').modal("show");
    bID=ID;
    bName=name;
}

//ID,name,IDval,nameval
function basicCheck(ID,name,IDval,nameval)
{
	$('#'+ID+'modal').modal('toggle');
	$("#"+ID).val(IDval);
	$("#"+name).val(nameval);
	
}

function getBasics(modal,IDval,nameval)
{
    $('#'+modal+'modal').modal('toggle');
    $("#"+bID).val(IDval);
    $("#"+bName).val(nameval);

    //alert(bName);
    if(modal=="goodseat")
	{
        getGSInfo();
	}
}

function clearBasics(ids)
{
	//alert(keyCode);
    bID=ids;
    idval=$("#"+bID).val();
    id=bID;
}

function clearBasicInfo(id,idname)
{
    
	$("#"+id).val('');
	if(idname.indexOf("ID")>-1)
	$("#"+idname).val(0);
	else
		$("#"+idname).val('');	
}

function showCondition(ID,param)
{
	//alert(param.length);
	if(param.length==0)
	$("#"+ID).modal({backdrop:'static',keyborad:false});
}

function querySubmit(url,id,mid)
{
	//alert(url);
	$('#'+mid).modal('toggle');
	$("#"+id).attr('action',url);    //通过jquery为action属性赋值
        $("#"+id).submit(); 
}

function filter(ID)
{
	$("#"+ID).modal('show');
}
function initDate(ID)
{
var date=new Date().format("yyyy-MM-dd");
$("#"+ID).val(date);
}

function initStartDate(ID)
{
    var date=new Date().format("yyyy-MM-dd");
    var arr = date.split('-');
    var year = arr[0]; //获取当前日期的年份
    var month = arr[1]; //获取当前日期的月份
    var day = arr[2]; //获取当前日期的日
    var days = new Date(year, month, 0);
    days = days.getDate(); //获取当前日期中月的天数
    var year2 = year;
    var month2 = parseInt(month) - 1;
    if (month2 == 0) {
        year2 = parseInt(year2) - 1;
        month2 = 12;
    }
    var day2 = day;
    var days2 = new Date(year2, month2, 0);
    days2 = days2.getDate();
    if (day2 > days2) {
        day2 = days2;
    }
    if (month2 < 10) {
        month2 = '0' + month2;
    }
    var t2 = year2 + '-' + month2 + '-' + day2;
    $("#"+ID).val(t2);
}

Date.prototype.DateAdd = function(strInterval, Number) {
    var dtTmp = this;
    switch (strInterval) {
        case 's' :return new Date(Date.parse(dtTmp) + (1000 * Number));
        case 'n' :return new Date(Date.parse(dtTmp) + (60000 * Number));
        case 'h' :return new Date(Date.parse(dtTmp) + (3600000 * Number));
        case 'd' :return new Date(Date.parse(dtTmp) + (86400000 * Number));
        case 'w' :return new Date(Date.parse(dtTmp) + ((86400000 * 7) * Number));
        case 'q' :return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number*3, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
        case 'm' :return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
        case 'y' :return new Date((dtTmp.getFullYear() + Number), dtTmp.getMonth(), dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
    }
}

Date.prototype.format=function(fmt)
{
	var o={
	"M+":this.getMonth()+1,
	"d+":this.getDate(),
	"h+":this.getHours(),
	"m+":this.getMinutes(),
	"s+":this.getSeconds(),
	"q+":Math.floor((this.getMonth()+3)/3),
	"S":this.getMilliseconds()	
	};
	
	if(/(y+)/.test(fmt))
		{
		fmt=fmt.replace(RegExp.$1,(this.getFullYear()+"").substr(4-RegExp.$1.length));
		}
	for(var k in o)
		{
		if(new RegExp("("+k+")").test(fmt))
			{
			fmt=fmt.replace(RegExp.$1,(RegExp.$1.length==1)?(o[k]):(("00"+o[k]).substr((""+o[k]).length)));
			}
		}
	return fmt;
	}

function adjust(ID)
{
	location.href="materialrgoodseat/adjustGoodseat?ID="+ID;
	}
	
	
	function Bind()
{
	var id=$("#fid").val();
	var ids = [];
          $("input[name='check']:checkbox:checked").each(function () {
              ids.push($(this).val());
          });
           location.href = "user/bind?ID="+id+"&rids=" + ids;
}
	
	function bindrole(ID)
	{
		location.href="bindrole?ID="+ID;
		}

		function initpsw(ID)
        {
            if(confirm("确认初始化密码!"))
            {
                location.href="initpsw?ID="+ID;
            }
        }

function auth(ID)
{
    location.href="authority?ID="+ID;
}

function defaultstock(ID,it)
{
    var rolename=$(it).parent().prev().text();
    if(rolename.indexOf(".库管员")>-1){
        location.href="defaultstock?ID="+ID;
    }else{
        alert('不是库管员不能设置仓库');
    }


}

function BindStock(){
    var id =$("#fid").val();
    var ids =[];
    $("input[name='check']:checkbox:checked").each(function(){
        ids.push($(this).val());
    });
    location.href="user/bindStock?ID="+id+"&stockId="+ids;
}

function doAuth()
	{
		
		var id=$("#fid").val();
		var ids = [];
	          $("input[name='check']:checkbox:checked").each(function () {
	              ids.push($(this).val());
	          });
	           location.href = "doauthority?ID="+id+"&pids=" + ids;
	}
	function getGSInfo()
	{
		if($("#fcharge").length>0&&$("#fmatype").length>0)
		{


        $.ajax
        ({
            type: "get",
            url: "goodseat/getinfo",
            data: "ID=" + $("#fgoodseatid").val(),
            contentType: "application/json; charset=UTF-8",
            success: function (result) {

            	result=JSON.parse(result);
            	alert(result.cabinettype.frows);
                if(result.cabinettype.frows>1||result.cabinettype.fcolumns>1)
				{
					//alert("123");
					$("#fcharge").attr("readonly","readonly");
                    $("#fmatype").attr("readonly","readonly");
				}
				else
				{
					//alert("456");
                    $("#fcharge").removeAttr("readonly");
                    $("#fmatype").removeAttr("readonly");
				}
            },
            error: function (result, data) {
                //alert(data);
            }
        });
        }
	}