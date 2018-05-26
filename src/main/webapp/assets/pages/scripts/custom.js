/**
Custom module for you to write your own javascript functions
**/
var Custom = function () {

    // private functions & variables

    var myFunc = function (text) {
        alert(text);
    }

    //表单提交删除
    var dataDelete = function () {
        $("#delete").click(function () {
            var message = "您确定要删除勾选的记录吗?";
            if ($(this).attr("message"))
                message = $(this).attr("message") + "，" + message;
            if (confirm(message))
                $("#mainForm").submit();
        });
    }

    //全选
    var checkAll = function () {
        $("#checkall").click(function () {
            var ischecked = this.checked;
            $("input:checkbox[name='ids']").each(function () {
                this.checked = ischecked;
            });

            $.uniform.update(':checkbox');
        });
    }

    //根据新url判断菜单选中
    var menuUrl = function () {
        var locationHref = window.location.href;
        $(".page-sidebar>ul>li>a").each(function () {

            if (locationHref.indexOf($(this).attr("href")) > 0) {
                $(this).parent().addClass("active");
                $(this).append("<span class='selected'></span>");

                $("#navigation .page-title span").html($(this).text());
                $("#navigation .page-title small").html($(this).attr("title") || "");
                //$("#navigation .page-breadcrumb li:eq(1) span").html($(this).text());
                //$("#navigation .page-breadcrumb li:eq(1) i").remove();
                //$("#navigation .page-breadcrumb li:eq(2)").remove();

                document.title = $(this).text() + " - " + document.title;

                return false;
            }
            else {
                var parent = $(this);
                $(this).next("ul").each(function () {
                    $("a", $(this)).each(function () {
                        if (locationHref.indexOf($(this).attr("href")) > 0) {
                            $(this).parent().addClass("active");
                            $(this).parent().append("<span class='selected'></span>");
                            parent.parent().addClass("active");
                            //$(".arrow", parent).addClass("open").before("<span class='selected'></span>");

                            $("#navigation .page-title span").html($(this).text());
                            $("#navigation .page-title small").html($(this).attr("title") || "");
                            //$("#navigation .page-breadcrumb li:eq(1) span").html(parent.text());
                            //$("#navigation .page-breadcrumb li:eq(2) span").html($(this).text());

                            document.title = $(this).text() + " - " + document.title;

                            return false;
                        }
                    });
                });
            }
        });
    }

    // public functions
    return {

        //main function
        init: function () {
            //initialize here something. 
            dataDelete();
            checkAll();
            menuUrl();
        },

        //some helper function
        doSomeStuff: function () {
            myFunc();
        }

    };

}();

jQuery(document).ready(function () {
    Custom.init();
});

/***
Usage
***/
//Custom.doSomeStuff();