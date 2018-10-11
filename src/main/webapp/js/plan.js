/*
* @Author: xingli
* @Date:   2018-02-24 14:53:02
* @Last Modified by:   Administrator
* @Last Modified time: 2018-02-26 18:34:50
*/
$(function(){
	function distance(){
		//获取分辨率
		var winWid = $(window).width();
		var winHei = $(window).height();
		// heard高
		$('.header').css('height', winHei*0.15).css('lineHeight',winHei*0.15+'px').css('fontSize',parseInt(winHei*0.15/2.1));
		var headHei = $('.header').outerHeight();//获取head高
		$('.allBlock').css('width',winWid).css('height',winHei-headHei);
		//内容块大小
		var mainBloHei = winHei-headHei;
		var mainBloWid = $('.allBlock').outerWidth();
		// 通道高
		var warHei =  mainBloHei*0.15;

		//内容块，及通道宽度高度计算

		$('.block-1').css('width', mainBloWid/1.9).css('height', (mainBloHei-warHei)/2-10);
		$('.warning').css('height',warHei).css('lineHeight',warHei-5+'px').css('fontSize', parseInt(warHei/2.1));
		$('.block-2').css('width',mainBloWid/2.4).css('height',(mainBloHei-warHei)/2-10);
		$('.block-3').css('width', mainBloWid).css('height', (mainBloHei-warHei)/2-10);
		$('.block-4').css('width', mainBloWid/2).css('height', (mainBloHei-warHei)/2);
		$('.block-5').css('width', mainBloWid/2.3).css('height', (mainBloHei-warHei)/2);
		//$('.block-6').css('width', mainBloWid/2).css('height',mainBloWid*0.189-20);
		//$('.block-7').css('width', mainBloWid/2.3).css('height',mainBloWid*0.189-20);

        var warHei =  mainBloHei*0.15;
        $('.block-6').css('width', mainBloWid/2).css('height',(mainBloHei-warHei)/2-10);
        $('.block-7').css('width', mainBloWid/2.3).css('height',(mainBloHei-warHei)/2-10);
		//信息部分宽高及线宽
		$('.allblock').children("li").css('width',(mainBloWid*0.8)/17.3).css('marginLeft',(mainBloWid*0.2)/17.3).css('borderRadius', warHei/5);
		$('.listLi1').css('width',(mainBloWid)/7.5).css('marginLeft',(mainBloWid*0.2)/17.3);
		$('.listLi2').css('width',(mainBloWid)/9).css('marginLeft',(mainBloWid*0.2)/17.3);
		$('.listLi3').css('width',(mainBloWid)/9).css('marginLeft',(mainBloWid*0.2)/17.3);
		$('.block-1').children("li").css("marginLeft", "3.3%");
		$('.block-2').children("li").css("marginLeft", "4%");
		$('.block-4').children("li").css("marginLeft", "4.3%");
		$('.block-5').children("li").css("marginLeft", "4.3%");
		$('.block-6').children("li").css("marginLeft", "4.3%");
		//$('.block-cs').css("width", mainBloWid-$('.block-4').outerWidth()-$('.block-5').outerWidth()).css("height",$('.block-4').outerHeight()).css('textAlign', 'center').css('fontSize', parseInt(warHei/2.1));
		//$('.block-cs2').css("width", $('.block-cs').outerWidth()).css("height",$('.block-cs').outerHeight()-'10%').css('textAlign', 'center').css('fontSize', parseInt(warHei/2.1));

		var liWordSize = warHei/6.5;//字体大小及距离
		//仓位编号大小宽高
		var listNum = warHei/2;
		var allLi = $('.allblock').children('li');
		allLi.children('div').css('width', listNum).css('height', listNum).css('borderRadius', listNum).css('lineHeight', listNum+'px');
		//仓库号字行高
		if(winHei < 1550){
			allLi.children('div').children('span').css('lineHeight', liWordSize+'px').css('marginTop','10%');
		}else{
			allLi.children('div').children('span').css('lineHeight', liWordSize+'px').css('marginTop','20%');
		}
		//通道边线
		allLi.children('div').css('borderWidth',liWordSize/5);
		allLi.css('fontSize',parseInt(liWordSize));//信息快字体大小
		$('.allblock').css('borderWidth', liWordSize/5);
		//---2018-3-19 xingli---
		$('.block-8').css('width', mainBloWid).css('height', (mainBloHei-warHei)/2-10);
		$('.listLi-8-li1').css('width',(mainBloWid)/10).css('marginLeft',(mainBloWid*0.2)/17.3);
		var liHeight = $('.listLi-8-li1').height();
		$('.listLi-8-li1').css('lineHeight',liHeight+'px');
		$('.listLi-8-li2').css('width',(mainBloWid)/5).css('marginLeft',(mainBloWid*0.2)/17.3).css('lineHeight',liHeight+'px');
		$('.listLi-8-li3').css('width',(mainBloWid)/2.32).css('marginLeft',(mainBloWid*0.2)/17.3).css('lineHeight',liHeight+'px');
		$('.block-9').css('width', mainBloWid/1.2).css('height', (mainBloHei-warHei)/2-10).css('marginLeft', liHeight/2.5);
		$('.listLi-9-li1').css('lineHeight',liHeight+'px').css('width', mainBloWid/7);
		$('.listLi-9-li2').css('width', mainBloWid/5).css('lineHeight',liHeight+'px');
        $('.noWork').css('width',mainBloWid/6.3);
        $('.door').css('height',warHei).css('margin-top',warHei*-1+'px');
		//---2018-3-19 xingli---

	};
	//加载页面及调整窗口时调用计算布局
	distance();
	window.onresize = function(){
		distance();
	}
});