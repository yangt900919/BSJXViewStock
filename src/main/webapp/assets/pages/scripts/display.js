function gotoSCabinet(fsnumber,fenumber,fstock)
{
   // alert("123");
    window.location.href="scabinet/display?fsnumber="+fsnumber+"&fenumber="+fenumber+"&fstock="+fstock
}

function gotoCabinet(fsnumber,fenumber,fstock)
{
window.location.href="cabinet/display?fsnumber="+fsnumber+"&fenumber="+fenumber+"&fstock="+fstock	;
}

function gotoStock(page)
{
	window.location.href="page/stock/"+page;
}

function gotoGoodSeat(fsnumber,fenumber,fstock)
{
    window.location.href="goodseat/display?fsnumber="+fsnumber+"&fenumber="+fenumber+"&fstock="+fstock	;
}