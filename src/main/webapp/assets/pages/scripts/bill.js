/*window.onload = function(){
    var tableCont = document.querySelector('#table-cont')
    /!**
     * scroll handle
     * @param {event} e -- scroll event
     *!/
    function scrollHandle (e){
        //console.log(this)
        var scrollTop = this.scrollTop;
        this.querySelector('thead').style.transform = 'translateY(' + scrollTop + 'px)';
    }

    tableCont.addEventListener('scroll',scrollHandle)
}*/
var mid='';
var mnum='';
var mname='';
var mmodel='';
var munit='';
function getmaterial(mtID,id,number,name,model,unit)
{

    initTable(mtID+'table');
    $('#'+mtID+'modal').modal("show");
     mid=id;

     mnum=number;
     mname=name;
     mmodel=model;
     munit=unit;

}

function materialCheck(ID,idval,numval,nameval,modelval,unitval)
{

    $('#'+ID+'modal').modal('toggle');
    $("#"+mid).val(idval);
if(mnum!='')
{
    $("#"+mnum).val(numval);
}

    if(mmodel!='')
    $("#"+mmodel).val(modelval);
    $("#"+mname).val(nameval);
    if(munit!='')
    $("#"+munit).val(unitval);
   // alert( $("#billgetentries[0].material").val);
}

var index=0;
var html="";

function orderentry()
{
    html="  <tr id='tr"+index+"'>\n" +
        "\n" +
        "                        <td>\n" +
        "                            <div class=\"input-group\">\n" +
        "                                <input ${readonly} type=\"text\" required onfocus=\"clearBasics('fmaid"+index+"')\"  class=\"form-control  bill_input_b\" id=\"material"+index+"\" name=\"materialname"+index+"\"  placeholder=\"\" value=\"\">\n" +
        "                                <input type=\"hidden\" class=\"form-control\" id=\"fmaid"+index+"\" name=billorderentries["+index+"].fmaid  placeholder=\"\" value=\"\">\n" +
        "                                <span class=\"input-group-btn\">\n" +
        "         <button class=\"btn btn-primary\" ${disabled} type=\"button\" onclick=\"getmaterial('material','fmaid"+index+"','material"+index+"','materialname"+index+"','','materialunit"+index+"')\">&nbsp;<span class=\"glyphicon glyphicon-search form-control-feedback\" aria-hidden=\"true\" ></span>&nbsp;</button>\n" +
        "    </span>\n" +
        "                            </div>\n" +
        "                        </td>\n" +
        "\n" +
        "                        <td>\n" +
        "                            <input type=\"text\" class=\"form-control  bill_input\" id=\"materialname"+index+"\" name=\"billorderentries["+index+"].materialname\"  value=\"\" readonly>\n" +
        "\n" +
        "                        </td>\n" +
        "                        <td>\n" +
        "                            <input type=\"text\" class=\"form-control  bill_input\" id=\"materialunit"+index+"\" name=\"billorderentries["+index+"].materialunit\"  value=\"\" readonly>\n" +
        "                        </td>\n" +
        "                     <td>\n" +
        "                            <div class=\"input-group\">\n" +
        "                                <input ${readonly} type=\"text\" required onfocus=\"clearBasics('fstockid"+index+"')\"  class=\"form-control  bill_input_b\" id=\"stock"+index+"\" name=\"stockname"+index+"\"  placeholder=\"\" value=\"\">\n" +
        "                                <input  type=\"hidden\" class=\"form-control\" id=\"fstockid"+index+"\" name=billorderentries["+index+"].fstockid  placeholder=\"\" value=\"\">\n" +
        "                                <span class=\"input-group-btn\">\n" +
        "         <button class=\"btn btn-primary\" ${disabled} type=\"button\" onclick=\"showBasics('stock','fstockid"+index+"','stock"+index+"')\">&nbsp;<span class=\"glyphicon glyphicon-search form-control-feedback\" aria-hidden=\"true\" ></span>&nbsp;</button>\n" +
        "    </span>\n" +
        "                            </div>\n" +
        "                        </td>\n" +
        "                                  <td>\n" +
        "                                   <input ${readonly} type=\"number\" class=\"form-control  bill_input\" id=\"fqty"+index+"\" name=\"billorderentries["+index+"].fqty\"  value=\"\" >\n" +
        "                               </td>\n" +
        "                               <td>\n" +
        "                                   <input ${readonly} type=\"text\" class=\"form-control  bill_input\" id=\"fbrand"+index+"\" name=\"billorderentries["+index+"].fbrand\"  value=\"\" >\n" +
        "                               </td>\n" +
        "                               <td>\n" +
        "                                   <input ${readonly}  type=\"text\" class=\"form-control  bill_input\" id=\"fqulity"+index+"\" name=\"billorderentries["+index+"].fqulity\"  value=\"\" >\n" +
        "                               </td>\n" +
        "                               <td>\n" +
        "                                   <input ${readonly} type=\"date\" class=\"form-control  bill_input\" id=\"fdeldate"+index+"\" name=\"billorderentries["+index+"].fdeldate\"  value=\"\" >\n" +
        "                               </td>\n" +
        "                               <td>\n" +
        "                                   <input ${readonly} type=\"text\" class=\"form-control  bill_input\" id=\"fcontnum"+index+"\" name=\"billorderentries["+index+"].fcontnum\"  value=\"\" >\n" +
        "                               </td>\n" +
        "                               <td>\n" +
        "                                   <input readonly type=\"number\" class=\"form-control  bill_input\" id=\"freceiptqty"+index+"\" name=\"billorderentries["+index+"].freceiptqty\"  value=\"\" >\n" +
        "                               </td>\n" +
        "                               <td>\n" +
        "                                   <input readonly type=\"number\" class=\"form-control  bill_input\" id=\"frefoundqty"+index+"\" name=\"billorderentries["+index+"].frefoundqty\"  value=\"\" >\n" +
        "                               </td>\n" +
        "                               <td>\n" +
        "                                   <input readonly type=\"number\" class=\"form-control  bill_input\" id=\"fstoredqty"+index+"\" name=\"billorderentries["+index+"].fstoredqty\"  value=\"\" >\n" +
        "                               </td>\n" +
        "                               <td>\n" +
        "                                   <textarea rows=\"1\" cols=\"10\" class=\"form-control  bill_input\" id=\"fjudgetype"+index+"\" name=\"billorderentries["+index+"].fjudgetype\" placeholder=\"\" ></textarea>\n" +
        "                               </td>\n" +
        "                               <td>\n" +
        "                                   <textarea rows=\"1\" cols=\"10\" class=\"form-control  bill_input\" id=\"fnote"+index+"\" name=\"billorderentries["+index+"].fnote\" placeholder=\"\" ></textarea>\n" +
        "                               </td>\n" +
        "\n" +
        "\n" +
        "                    </tr>"
}

function checkentry()
{
    html=" <tr id='tr"+index+"'>\n" +
        "\n" +
        "                        <td>\n" +
        "                            <div class=\"input-group\">\n" +
        "                                <input ${readonly} type=\"text\"  onfocus=\"clearBasics('fmaid"+index+"')\"  class=\"form-control bill_input_b\" id=\"fMaterial"+index+"\" name=\"billcheckentries["+index+"].fMaterialname\"  placeholder=\"\" value=\"\">\n" +
        "                                <input type=\"hidden\" class=\"form-control\" id=\"fmaid"+index+"\" name=billcheckentries["+index+"].fmaid  placeholder=\"\" value=\"\">\n" +
        "                                <span class=\"input-group-btn\">\n" +
        "         <button class=\"btn btn-primary\" ${disabled} type=\"button\" onclick=\"getmaterial('material','fmaid"+index+"','fMaterial"+index+"','materialname"+index+"','','materialunit"+index+"')\">&nbsp;<span class=\"glyphicon glyphicon-search form-control-feedback\" aria-hidden=\"true\" ></span>&nbsp;</button>\n" +
        "    </span>\n" +
        "                            </div>\n" +
        "                        </td>\n" +
        "                        <td>\n" +
        "                            <input type=\"text\" class=\"form-control bill_input\" id=\"materialname"+index+"\" name=\"billcheckentries["+index+"].materialname\"  value=\"\" readonly>\n" +
        "\n" +
        "                        </td>\n" +
        "                        <td>\n" +
        "                            <input type=\"text\" class=\"form-control bill_input\" id=\"materialunit"+index+"\" name=\"billcheckentries["+index+"].materialunit\"  value=\"\" readonly>\n" +
        "                        </td>\n" +
        "                        <td>\n" +
        "                            <input ${readonly} type=\"text\" class=\"form-control bill_input\" id=\"fbatch"+index+"\" name=\"billcheckentries["+index+"].flot\"  value=\"\" readonly>\n" +
        "                        </td>\n" +
        "                        <td>\n" +
        "                            <input ${readonly} type=\"number\" class=\"form-control bill_input\" id=\"fqty"+index+"\" name=\"billcheckentries["+index+"].fqty\"  value=\"\" >\n" +
        "                        </td>\n" +
        "                        <td>\n" +
        "                            <input ${readonly}  type=\"number\" class=\"form-control bill_input\" id=\"feligqty"+index+"\" name=\"billcheckentries["+index+"].feligqty\"  value=\"\" >\n" +
        "                        </td>\n" +
        "                        <td>\n" +
        "                            <input ${readonly} type=\"number\" class=\"form-control bill_input\" id=\"funqty"+index+"\" name=\"billcheckentries["+index+"].funqty\"  value=\"\" >\n" +
        "                        </td>\n" +
        "                        <td>\n" +
        "                            <textarea rows=\"1\" cols=\"10\" class=\"form-control bill_input\" id=\"freason"+index+"\" name=\"billcheckentries["+index+"].freason\" placeholder=\"\" ></textarea>\n" +
        "                        </td>\n" +
        "                        <td>\n" +
        "                            <textarea rows=\"1\" cols=\"10\" class=\"form-control bill_input\" id=\"fresult"+index+"\" name=\"billcheckentries["+index+"].fresult\" placeholder=\"\" ></textarea>\n" +
        "                        </td>\n" +
        "                        <td>\n" +
        "                            <input ${readonly} type=\"date\" class=\"form-control bill_input\" id=\"fdate"+index+"\" name=\"billcheckentries["+index+"].fdate\"  value=\"\" >\n" +
        "                        </td>\n" +
        "                        <td>\n" +
        "                            <input ${readonly} type=\"text\" class=\"form-control bill_input\" id=\"fguartime"+index+"\" name=\"billcheckentries["+index+"].fguartime\"  value=\"\" >\n" +
        "                        </td>\n" +
        "                        <td>\n" +
        "                            <input ${readonly} type=\"date\" class=\"form-control bill_input\" id=\"fdeltime"+index+"\" name=\"billcheckentries["+index+"].fdeltime\"  value=\"\" >\n" +
        "                        </td>\n" +
        "                        <td>\n" +
        "                            <div class=\"input-group\">\n" +
        "                                <input ${readonly} type=\"text\"  onfocus=\"clearBasics('fstockid"+index+"')\"  class=\"form-control  bill_input_b\" id=\"stock"+index+"\" name=\"billcheckentries["+index+"].stockname\"  placeholder=\"\" value=\"\">\n" +
        "                                <input  type=\"hidden\" class=\"form-control\" id=\"fstockid"+index+"\" name=billcheckentries["+index+"].fstockid  placeholder=\"\" value=\"\">\n" +
        "                                <span class=\"input-group-btn\">\n" +
        "         <button class=\"btn btn-primary\" ${disabled} type=\"button\" onclick=\"showBasics('stock','fstockid"+index+"','stock"+index+"')\">&nbsp;<span class=\"glyphicon glyphicon-search form-control-feedback\" aria-hidden=\"true\" ></span>&nbsp;</button>\n" +
        "    </span>\n" +
        "                            </div>\n" +
        "                        </td>\n" +
        "<td>\n" +
        "    <input readonly type=\"text \" class=\"form-control  bill_input\" id=\"fonumber"+index+"\" name=\"billcheckentries["+index+"].fonumber\" value=\"\">\n" +
        "    <input readonly type=\"hidden\"  id=\"fobillid"+index+"\" name=\"billcheckentries["+index+"].fobillid\" value=\"\">\n" +
        "    <input readonly type=\"hidden\"  id=\"foid"+index+"\" name=\"billcheckentries["+index+"].foid\" value=\"\">\n" +
        "</td>"+
        "\n" +
        "                    </tr>"
}

function getentry()
{
    html="<tr>\n" +
        "\n" +
        "                <td>\n" +
        "                    <div class=\"input-group\">\n" +
        "                        <input ${readonly} type=\"text\"  onfocus=\"clearBasics('fmaterialid"+index+"')\"  class=\"form-control bill_input_b\" id=\"material"+index+"\" name=\"materialn"+index+"\"  placeholder=\"\" value=\"\">\n" +
        "                        <input type=\"hidden\" class=\"form-control\" id=\"fmaterialid"+index+"\" name=billgetentries["+index+"].fmaterialid  placeholder=\"\" value=\"\">\n" +
        "                        <span class=\"input-group-btn\">\n" +
        "         <button class=\"btn btn-primary\" ${disabled} type=\"button\" onclick=\"getmaterial('material','fmaterialid"+index+"','material"+index+"','materialname"+index+"','','materialunit"+index+"')\">&nbsp;<span class=\"glyphicon glyphicon-search form-control-feedback\" aria-hidden=\"true\" ></span>&nbsp;</button>\n" +
        "    </span>\n" +
        "                    </div>\n" +
        "                </td>\n" +
       "                <td>\n" +
        "                    <input type=\"text\" class=\"form-control bill_input\" id=\"materialname"+index+"\" name=\"billgetentries["+index+"].materialname\"  value=\"\" readonly>\n" +
        "\n" +
        "                </td>\n" +
        "                <td>\n" +
        "                    <input type=\"text\" class=\"form-control bill_input\" id=\"materialunit"+index+"\" name=\"billgetentries["+index+"].materialunit\"  value=\"\" readonly>\n" +
        "                </td>\n" +
        "                <td>\n" +
        "                    <input ${readonly} type=\"text\" class=\"form-control bill_input\" id=\"flot"+index+"\" name=\"billgetentries["+index+"].flot\"  value=\"\" >\n" +
        "                </td>\n" +
        "                <td>\n" +
         "                    <input ${readonly} type=\"number\" class=\"form-control bill_input\" id=\"fapplyqty"+index+"\" name=\"billgetentries["+index+"].fapplyqty\"  value=\"\" >\n" +
        "                </td>\n" +
        "                <td>\n" +
        "                    <input ${readonly}  type=\"number\" class=\"form-control bill_input\" id=\"frealqty"+index+"\" name=\"billgetentries["+index+"].frealqty\"  value=\"\" >\n" +
         "                </td>\n" +

         "                <td>\n" +
        "                    <div class=\"input-group\">\n" +
          "                        <input ${readonly} type=\"text\"  onfocus=\"clearBasics('fsendstockid"+index+"')\"  class=\"form-control bill_input_b\" id=\"stock"+index+"\" name=\"billgetentries["+index+"].estockname\"  placeholder=\"\" value=\"\">\n" +
          "                        <input  type=\"hidden\" class=\"form-control\" id=\"fsendstockid"+index+"\" name=billgetentries["+index+"].fsendstockid  placeholder=\"\" value=\"\">\n" +
          "                        <span class=\"input-group-btn\">\n" +
          "         <button class=\"btn btn-primary\" ${disabled} type=\"button\" onclick=\"showBasics('stock','fsendstockid"+index+"','stock"+index+"')\">&nbsp;<span class=\"glyphicon glyphicon-search form-control-feedback\" aria-hidden=\"true\" ></span>&nbsp;</button>\n" +
          "    </span>\n" +
          "                    </div>\n" +
          "                </td>\n" +
            "                <td>\n" +
          "                    <textarea rows=\"1\" cols=\"10\" class=\"form-control bill_input\" id=\"fnote"+index+"\" name=\"billgetentries["+index+"].fnote\" placeholder=\"\" ></textarea>\n" +
          "                </td>\n" +
        "            </tr>";
}

function stockentry()
{
    html="       <tr id='tr"+index+"'>\n" +
        "\n" +
        "                        <td>\n" +
        "                            <div class=\"input-group\">\n" +
        "                                <input ${readonly} type=\"text\"  onfocus=\"clearBasics('fmaterialid"+index+"')\"  class=\"form-control  bill_input_b\" id=\"material"+index+"\" name=\"billstockentries["+index+"].materialname\"  placeholder=\"\" value=\"\">\n" +
        "                                <input type=\"hidden\" class=\"form-control\" id=\"fmaterialid"+index+"\" name=billstockentries["+index+"].fmaterialid  placeholder=\"\" value=\"\">\n" +
        "                                <span class=\"input-group-btn\">\n" +
        "         <button class=\"btn btn-primary\" ${disabled} type=\"button\" onclick=\"getmaterial('material','fmaterialid"+index+"','material"+index+"','materialname"+index+"','','materialunit"+index+"')\">&nbsp;<span class=\"glyphicon glyphicon-search form-control-feedback\" aria-hidden=\"true\" ></span>&nbsp;</button>\n" +
        "    </span>\n" +
        "                            </div>\n" +
        "                        </td>\n" +
        "                        <td>\n" +
        "                            <input type=\"text\" class=\"form-control  bill_input\" id=\"materialname"+index+"\" name=\"billstockentries["+index+"].materialname\"  value=\"\" readonly>\n" +
        "\n" +
        "                        </td>\n" +
        "                        <td>\n" +
        "                            <input type=\"text\" class=\"form-control  bill_input\" id=\"materialunit"+index+"\" name=\"billstockentries["+index+"].materialunit\"  value=\"\" readonly>\n" +
        "                        </td>\n" +
        "                        <td>\n" +
        "                            <input ${readonly} type=\"text\" class=\"form-control  bill_input\" id=\"fbatch"+index+"\" name=\"billstockentries["+index+"].fbatch\"  value=\"\" readonly>\n" +
        "                        </td>\n" +
        "                        <td>\n" +
        "                            <input ${readonly} type=\"number\" class=\"form-control  bill_input\" id=\"fqty"+index+"\" name=\"billstockentries["+index+"].fqty\"  value=\"\" >\n" +
        "                        </td>\n" +
        "                        <td>\n" +
        "                            <input ${readonly}  type=\"number\" class=\"form-control  bill_input\" id=\"facqty"+index+"\" name=\"billstockentries["+index+"].facqty\"  value=\"\" >\n" +
        "                        </td>\n" +
        "                        \n" +
        "                        <td>\n" +
        "                            <div class=\"input-group\">\n" +
        "                                <input ${readonly} type=\"text\"  onfocus=\"clearBasics('fstockid"+index+"')\"  class=\"form-control  bill_input_b\" id=\"stock"+index+"\" name=\"billstockentries["+index+"].stockname\"  placeholder=\"\" value=\"\">\n" +
        "                                <input  type=\"hidden\" class=\"form-control\" id=\"fstockid"+index+"\" name=billstockentries["+index+"].fstockid  placeholder=\"\" value=\"\">\n" +
        "                                <span class=\"input-group-btn\">\n" +
        "         <button class=\"btn btn-primary\" ${disabled} type=\"button\" onclick=\"showBasics('stock','fstockid"+index+"','stock"+index+"')\">&nbsp;<span class=\"glyphicon glyphicon-search form-control-feedback\" aria-hidden=\"true\" ></span>&nbsp;</button>\n" +
        "    </span>\n" +
        "                            </div>\n" +
        "                        </td>\n" +
        "\n" +
        "<td>\n" +
        "    <input readonly type=\"text \" class=\"form-control\" id=\"fonumber"+index+"\" name=\"billcheckentries["+index+"].fonumber\" value=\"\">\n" +
        "    <input readonly type=\"hidden\"  id=\"fobillid"+index+"\" name=\"billcheckentries["+index+"].fobillid\" value=\"\">\n" +
        "    <input readonly type=\"hidden\"  id=\"foid"+index+"\" name=\"billcheckentries["+index+"].foid\" value=\"\">\n" +
        "</td>"+
        "                    </tr>"
}

function returnentry()
{
    html="<tr>\n" +
        "\n" +
        "                        <td>\n" +
        "                            <input type=\"hidden\" class=\"form-control\" id=\"fid"+index+"\" name=billreturnentries["+index+"].fid  placeholder=\"\" value=\"\">\n" +
        "\n" +
        "                            <input type=\"hidden\" class=\"form-control\" id=\"fbillid"+index+"\" name=billreturnentries["+index+"].fbillid  placeholder=\"\" value=\"\">\n" +
        "                            <input type=\"hidden\" class=\"form-control\" id=\"fentriyid"+index+"\" name=billreturnentries["+index+"].fentriyid  placeholder=\"\" value=\"\">\n" +
        "\n" +
        "                            <div class=\"input-group\">\n" +
        "                                <input  ${readonly} type=\"text\"  onfocus=\"clearBasics('fmaterialid"+index+"')\"  class=\"form-control bill_input_b\" id=\"material"+index+"\" name=\"materialname"+index+"\"  placeholder=\"\" value=\"\">\n" +
        "                                <input type=\"hidden\" class=\"form-control\" id=\"fmaterialid"+index+"\" name=billreturnentries["+index+"].fmaterialid  placeholder=\"\" value=\"\">\n" +
        "                                <span class=\"input-group-btn\">\n" +
        "         <button class=\"btn btn-primary\" ${disabled} type=\"button\" onclick=\"getmaterial('material','fmaterialid"+index+"','material"+index+"','materialname"+index+"','','materialunit"+index+"')\">&nbsp;<span class=\"glyphicon glyphicon-search form-control-feedback\" aria-hidden=\"true\" ></span>&nbsp;</button>\n" +
        "    </span>\n" +
        "                            </div>\n" +
        "                        </td>\n" +
        "\n" +
        "                        <td>\n" +
        "                            <input type=\"text\" class=\"form-control bill_input\" id=\"materialname"+index+"\" name=\"billreturnentries["+index+"].materialname\"  value=\"\" readonly>\n" +
        "\n" +
        "                        </td>\n" +
        "                        <td>\n" +
        "                            <input type=\"text\" class=\"form-control bill_input\" id=\"materialunit"+index+"\" name=\"billreturnentries["+index+"].materialunit\"  value=\"\" readonly>\n" +
        "                        </td>\n" +
        "                        <td>\n" +
        "                            <div class=\"input-group\">\n" +
        "                                <input ${readonly} type=\"text\"  onfocus=\"clearBasics('fstockid"+index+"')\"  class=\"form-control bill_input_b\" id=\"stock"+index+"\" name=\"stockname"+index+"\"  placeholder=\"\" value=\"\">\n" +
        "                                <input  type=\"hidden\" class=\"form-control\" id=\"fstockid"+index+"\" name=billreturnentries["+index+"].fstockid  placeholder=\"\" value=\"${map.stock.fid}\">\n" +
        "                                <span class=\"input-group-btn\">\n" +
        "         <button class=\"btn btn-primary\" ${disabled} type=\"button\" onclick=\"showBasics('stock','fstockid"+index+"','stock"+index+"')\">&nbsp;<span class=\"glyphicon glyphicon-search form-control-feedback\" aria-hidden=\"true\" ></span>&nbsp;</button>\n" +
        "    </span>\n" +
        "                            </div>\n" +
        "                        </td>\n" +
        "                        <td>\n" +
        "                            <input ${readonly} type=\"number\" class=\"form-control bill_input\" id=\"freqty"+index+"\" name=\"billreturnentries["+index+"].freqty\"  value=\"\" >\n" +
        "                        </td>\n" +
        "                        <td>\n" +
        "                            <input ${readonly} type=\"number\" class=\"form-control bill_input\" id=\"fqty"+index+"\" name=\"billreturnentries["+index+"].fqty\"  value=\"\" >\n" +
        "                        </td>\n" +
        "      \n" +
        "                                <td>\n" +
        "                                   <input ${readonly} type=\"date\" class=\"form-control bill_input\" id=\"fredate"+index+"\" name=\"billreturnentries["+index+"].fredate\"  value=\"\" >\n" +
        "                               </td>\n" +
        "                              \n" +
        "                               \n" +
        "                               <td>\n" +
        "                                   <textarea ${readonly} rows=\"1\" cols=\"10\" class=\"form-control bill_input\" id=\"fnote"+index+"\" name=\"billreturnentries["+index+"].fnote\" placeholder=\"\" ></textarea>\n" +
        "                               </td>\n" +
        "\n" +
        "                    </tr>";
}

function addEntry(flag)
{
   // alert(index);
    if(flag=="order")
        orderentry();
    else if(flag=="check")
        checkentry();
    else if(flag=="stock")
        stockentry();
    else if(flag=="get")
        getentry();
    else if(flag=="return")
        returnentry();
    //alert(html);
$("#entrys").append(html);
    index++;
  //  alert(index);
}

function deleteEntry()
{
    //alert(index);
    var j = index - 1;
    $("#tr" + j).remove();
    index--;


}

function pushDown(url,billtype)
{
    var ids = [];
    var billid=[];
var str="";
    //alert(url);
    var bool=true;
    $("input[name='push']:checkbox:checked").each(function () {
      var idarray =$(this).val().split(",");
        billid.push(Number(idarray[0]));
      ids.push(Number(idarray[1]));


    });
    for(var i=0;i<billid.length;i++)
    {
        for(var j=0;j<billid.length;j++)
        {
            // alert($("#supplier"+billid[i]).text().trim()+" "+$("#supplier"+billid[j]).text().trim());
            if($("#supplier"+billid[i]).text().trim()!=$("#supplier"+billid[j]).text().trim())
            {

                bool=false;
                str="请选择同一供应商!"
                break;
                //return;
            }

            if(billtype=="order")
            {
                if($("#fstate"+billid[i]).text().trim()!="审核")
                {
                    bool=false;
                    str="请选择已审核单据!"
                    break;
                }
            }
            else if(billtype=="check")
            {
                if($("#fstate"+billid[i]).text().trim()!="检验")
                {
                    bool=false;
                    str="请选择已检验单据!"
                    break;
                }
            }

        }
    }
  if(bool)
  {
      if(ids.length>0)
          location.href = url+"/pushdown?ids=" + ids;
      else
          alert("至少选择一行数据!");
  }
  else
  {
      alert(str);
  }

}

function Audit(url,ID)
{
    //alert($("#fstate"+ID).text().trim());
    if($("#fstate"+ID).text().trim()=="审核")

    {
      alert("单据已审核，请选择未审核单据!")
    }
    else
    location.href=url+"/audit?ID="+ID;
}

function unAudit(url,ID)
{
    if($("#fstate"+ID).text().trim()=="保存")

    {
        alert("单据未审核，请选择已审核单据!")
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
                	//alert(result);
                if(result.replace(/[\r\n]/g,"")=="true")
                {
                    alert("单据已生成下游单据不能反审核!");
                }
                else
                {
                    location.href=url+"/unaudit?ID="+ID;
                }
            },
            error: function (result, data) {
                //alert(data);
            }
        });


    }

}

function billprint(url,ID)
{
    location.href=url+"/print?ID="+ID;
}

function BiiPrint(url)
{
    if(confirm("确认批量打印?"))
    {
        var qrcodes=[];
        //var ids = [];
        //var billid=[];
        //var str="";
        //alert(url);
        //var bool=true;
        $("input[name='push']:checkbox:checked").each(function () {
            var idarray =$(this).val().split(",");
           // billid.push(Number(idarray[0]));
            qrcodes.push(Number(idarray[1]));


        });

        location.href = url+"/maprint?qrcodes=" + qrcodes+"&pageNow="+pageNow+"&condition=1";
    }

}

function initBoxno(url)
{
   // alert($("#fisqt").prop('checked'));
    if($("#fisqt").prop("checked")==true)
    {
        $("#fboxno").attr("readonly",false);
        $("#fisqt").val(1);
if($("#fboxno").val().trim().length==0)
{
    $.ajax
    ({
        type: "get",
        url: url+"/getboxno",
        data: "fonumber=" +$("#fonumber0").val(),
        contentType: "application/json; charset=UTF-8",
        success: function (result) {
            //	alert(result);
            /* if(result)
             {
                 alert("单据已生成下游单据不能反审核!");
             }
             else
             {
                 location.href=url+"/unaudit?ID="+ID;
             }*/
            $("#fboxno").val(result);

        },
        error: function (result, data) {
            //alert(data);
        }
    });
}

    }
    else
    {
        $("#fboxno").attr("readonly","readonly");
        $("#fboxno").val("");
        $("#fisqt").val(0);
    }
}

function getunquqty(index)
{
    var qty=0;
    var quqty=0;
   // var unquqty=0;
//alert($("#feligqty"+index).val());
//alert($("#fqty"+index).val());
/*    if($("#feligqty"+index).val()>$("#fqty"+index).val())$("#feligqty"+index).val($("#fqty"+index).val());
if($("#feligqty"+index).val()<0) $("#feligqty"+index).val($("#fqty"+index).val());*/
    if($("#fqty"+index).val()!=""&&$("#fqty"+index).val()!=null) qty=Number($("#fqty"+index).val());
    if($("#feligqty"+index).val()!=""&&$("#feligqty"+index).val()!=null) quqty=Number($("#feligqty"+index).val());
    if(quqty<0)
    {
        $("#feligqty"+index).val(qty);
        $("#funqty"+index).val(0);
    }
    else if(quqty>qty)
    {
        $("#feligqty"+index).val(qty);
        $("#funqty"+index).val(0);
    }
    else
    $("#funqty"+index).val(qty-quqty);
}
