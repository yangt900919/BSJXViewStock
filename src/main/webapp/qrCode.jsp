<%--
  Created by IntelliJ IDEA.
  User: Yang
  Date: 2018/4/24
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href=" assets/global/plugins/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href=" assets/pages/css/login.css" />
    <link rel="stylesheet" href="assets/global/plugins/bootstrapValidator/css/bootstrapValidator.css"/>
    <script type="text/javascript" src=" assets/global/plugins/jquery.min.js"></script>
    <script type="text/javascript" src=" assets/pages/scripts/jquery.jqprint-0.3.js"></script>
    <script type="text/javascript" src=" assets/pages/scripts/jquery.qrcode.js"></script>
    <script type="text/javascript" src=" assets/global/plugins/jquery.cookie.js"></script>
    <script type="text/javascript" src=" assets/global/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="assets/global/plugins/bootstrapValidator/js/bootstrapValidator.js"></script>
</head>
<style type="text/css">

    @media print
    {
        .pageBreak
        {
            page-break-after: always; /*强制换页的关键*/
        }
        .noPrint
        {
            display: none;
        }
      /*  @page {
            size: 40mm 40mm; !* or size: 794px 1123px; *!
            size: 70mm 100mm; !* or size: 1123px 1588px; *!
        }*/
    }
</style>
<style>
    @media screen
    {
        #canvas
        {
            display: block;
        }
        #image
        {
            display: none;
        }
    }
    @media print
    {
        #canvas
        {
            display: none;
        }
        #image
        {
            display: block;
        }
    }
/*    #image
    {
        width: 100px;
        height: 100px;
        border :1px solid grey;
    }*/
</style>
<script language=”JavaScript”> if (window != top) top.location.href = location.href; </script>
<script type="text/javascript" defer="true">
    function toUtf8(str) {
        var out, i, len, c;
        out = "";
        len = str.length;
        for(i = 0; i < len; i++) {
            c = str.charCodeAt(i);
            if ((c >= 0x0001) && (c <= 0x007F)) {
                out += str.charAt(i);
            } else if (c > 0x07FF) {
                out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));
                out += String.fromCharCode(0x80 | ((c >>  6) & 0x3F));
                out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));
            } else {
                out += String.fromCharCode(0xC0 | ((c >>  6) & 0x1F));
                out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));
            }
        }
        return out;
    }

    function print()
    {
        var codes="${param.qrcodes}".split(",");
        $("#codes").empty();
        var tmp=0;
        for(var i=0;i<codes.length;i=i+4)
        {
            $("#codes").append("<div class=row>");

            if(i+4<codes.length-1)tmp=4; else tmp=codes.length%4;
            //alert(tmp);
            for(var j=0;j<tmp;j++)
            {
                $("#codes").append("<div class=col-md-3><div id=code"+(i+j)+"></div><div style='font-size:12px;margin: 8px;'>"+codes[i+j]+"</div></div>");
                $("#image").append("<img id=image"+(i+j)+" src=\\\"\\\"/><div style='font-size:12px;margin: 8px;'>"+codes[i+j]+"</div><div class=\\\"pageBreak\\\"></div>");
            }
            $("#codes").append("</div>");
      /*      $("#codes").append("<div class=row><div class=col-md-3><div id=code"+i+"></div><div>"+codes[i]+"</div></div>" +
                "<div class=col-md-3><div id=code"+(i+1)+"></div><div>"+codes[i+1]+"</div></div>" +
                "<div class=col-md-3><div id=code"+(i+2)+"></div><div>"+codes[i+2]+"</div></div>" +
                "<div class=col-md-3><div id=code"+(i+3)+"></div><div>"+codes[i+3]+"</div></div></div>");*/
            //if(i%4==0)
         /*   $("#image").append("<img id=image"+i+" src=\\\"\\\"/><div>"+codes[i]+"</div><div class=\\\"pageBreak\\\"></div>");
            $("#image").append("<img id=image"+(i+1)+" src=\\\"\\\"/><div>"+codes[i+1]+"</div><div class=\\\"pageBreak\\\"></div>")
            $("#image").append("<img id=image"+(i+2)+" src=\\\"\\\"/><div>"+codes[i+2]+"</div><div class=\\\"pageBreak\\\"></div>")
            $("#image").append("<img id=image"+(i+3)+" src=\\\"\\\"/><div>"+codes[i+3]+"</div><div class=\\\"pageBreak\\\"></div>")
*/


        }
        //alert($("#codes").html());
        for(var i=0;i<codes.length;i++)
        {


            var   str=codes[i]+"h";
            $("#code"+i).qrcode({
                render: "canvas", //table方式
                width:85, //宽度
                height:85, //高度
                text: str //任意内容
            });
        }

        var canvas  = document.getElementsByTagName("canvas");
        for(var i=0;i<canvas.length;i++)
        {
            document.getElementById("image"+i).src=canvas[i].toDataURL();
        }
        $("#image").jqprint({
            debug:false,
            importCSS:true,
            printContainer:true,
            operaSupport:false
        });
    }

   /* var html="";
    var img="";
    for(var i=0;i<codes.length;i++)
    {
        html+="<div id=code"+i+"></div>";
        img+="<div id=image"+i+"></div><div class=\"pageBreak\"></div>";


    }
    document.getElementById("codes").innerHTML=html;
    document.getElementById("image").innerHTML=img;
    for(var i=0;i<codes.length;i++)
    {


        var   str=codes[i];
        $("#code"+i).qrcode({
            render: "canvas", //table方式
            width: 200, //宽度
            height:200, //高度
            text: str //任意内容
        });
    }
    var canvas  = document.getElementsByTagName("canvas");
    for(var i=0;i<canvas.length;i++)
    {
        document.getElementById("image"+i).src=canvas[i].toDataURL();
    }
    $("#image").jqprint({
        debug:false,
        importCSS:true,
        printContainer:true,
        operaSupport:false
    });*/
</script>
<body onload="print()">

   <div class="container">
       <div id="codes" align="center">

       </div>
       <div id="image" align="center">
       </div>
   </div>

</body>
</html>
