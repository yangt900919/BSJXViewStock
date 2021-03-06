<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'edit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<jsp:include page="../../web/shared/resource.jsp"></jsp:include>
    
    <script type="text/javascript">
        $(document).ready(function() {
            $('#form').bootstrapValidator({
//	       live: 'disabled',
                message: 'This value is not valid',
                /*           feedbackIcons: {/!*输入框不同状态，显示图片的样式*!/
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },*/
                fields: {

                    materialname: {
                        validators: {
                            notEmpty: {
                                message: '物料不能为空'
                            }
                        }
                    },
                    dataseatname: {
                        validators: {
                            notEmpty: {
                                message: '货位不能为空'
                            }
                        }
                    }
                }
            });
        });
    </script>
  </head>
  
  <body>
     <div class=title>
  &nbsp;资料-资料位置信息管理
   </div>
    <div class="container-fluid  editpage-content">

   <form action="datardataseat/save"  class="form-horizontal" method="post" id="form">
   <c:if test="${datardataseat.fid>0 }">  <input type="hidden" name=fid value=${datardataseat.fid }></c:if>
 
    <div class="form-group">
    <label for="Material" class=col-sm-3 >物料</label>
     <div class="col-sm-9">
      <div class=row>
       <div class="col-md-10 col-sm-10 col-xs-10">
           <div class="input-group">
               <input  type="text" readonly onfocus="clearBasics('fdataid')"  class="form-control" id="material" name="materialname"  placeholder="" value=${datardataseat.material.materialname}>
               <input type="hidden" class="form-control" id="fdataid" name=fdataid  placeholder="" value=${datardataseat.fdataid}>
               <span class="input-group-btn">
                                                <button class="btn btn-primary  btn-sm"  type="button" onclick="showBasics('ma','fdataid','material')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span></div>
    </div>

    </div>
    </div>
  </div>
  <div class="form-group">
    <label for="fdataseatid" class=col-sm-3>资料位置</label>
     <div class="col-sm-9">
     <div class=row>
       <div class="col-md-10 col-sm-10 col-xs-10">
           <div class="input-group">
               <input  type="text" readonly onfocus="clearBasics('fdataseatid')"  class="form-control" id="dataseat" name="dataseatname"  placeholder="" value=${datardataseat.dataseat.fnumber}>
               <input type="hidden" class="form-control" id="fdataseatid" name=fdataseatid  placeholder="" value=${datardataseat.fdataseatid}>
               <span class="input-group-btn">
                                                <button class="btn btn-primary  btn-sm "  type="button" onclick="showBasics('dataseat','fdataseatid','dataseat')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span></div> </div>

    </div></div>
  </div>
 <%--   <div class="form-group">
    <label for="FSCabinetNum" class=col-sm-3>简易货位</label>
     <div class="col-sm-9">
     <div class=row>
       <!-- <div class="col-md-10 col-sm-10 col-xs-10"> -->
       <div class="col-md-4 col-xs-4 col-sm-4">
       <input type="text" class="form-control" id="FSCabinetNum" name="FSCabinetNum" placeholder="柜号" value=${datardataseat.FSCabinetNum }>
       </div>
      <div class="col-md-2 col-xs-2 col-sm-2">
       <input type="text" class="form-control" id="FRow" name="FRow" placeholder="行号" value=${datardataseat.FRow }>
       </div>
       <div class="col-md-2 col-xs-2 col-sm-2">
       <input type="text" class="form-control" id="FCol" name="FCol" placeholder="列号" value=${datardataseat.FCol }>
       </div>
       <div class="col-md-2 col-xs-2 col-sm-2">
       <input type="text" class="form-control" id="FPosition" name="FPosition" placeholder="仓位" value=${datardataseat.FPosition }>
       </div>
  &lt;%&ndash;   <input type="text" class="form-control" id="FPlatform" name="FPlatform" placeholder="装机平台" value=${datardataseat.FPlatform }> &ndash;%&gt;
  </div></div><!-- </div> -->
  </div>--%>
 <%-- <div class="form-group">
    <label for="FPlatform" class=col-sm-3>装机平台</label>
     <div class="col-sm-9">
     <div class=row>
       <div class="col-md-10 col-sm-10 col-xs-10">
    <input type="text" class="form-control" id="FPlatform" name="FPlatform" placeholder="装机平台" value=${datardataseat.FPlatform }>
  </div></div></div>
  </div>--%>
 <div class="form-group">
    <label for="fremark" class=col-sm-3>备注</label>
    <div class=col-sm-9>
    <div class=row>
       <div class="col-md-10 col-sm-10 col-xs-10">
    <textarea rows="3" cols="10" class="form-control" id="fremark" name="fremark" placeholder="备注" >${datardataseat.fremark }</textarea>
  </div>
  </div></div>
  </div>
       <div class="form-group">
           <div class="col-sm-offset-3 col-sm-9">
               <button type="submit" class="btn btn-primary btn-sm">
                   <span class="glyphicon glyphicon-saved" aria-hidden="true"></span>   保存</button>

               <button  type="button" class="btn btn-warning  btn-sm" onclick="javascript:history.go(-1);">

                   <span class="glyphicon glyphicon-log-out" aria-hidden="true" ></span>  退出</button>
           </div>
       </div>
  </form>
  </div>
   
  <jsp:include page="../../web/shared/modal.jsp"></jsp:include>
  </body>
</html>
