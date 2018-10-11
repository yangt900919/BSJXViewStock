<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'condition.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <jsp:include page="../../web/shared/resource.jsp"></jsp:include>

  </head>
  
  <body>
  <div class="modal fade" id="billget" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      <div class="modal-dialog modal-lg" role="document">
          <div class="modal-content">
              <div class="modal-header">
                  <h4 class="modal-title" id="myModalLabel">出库单条件过滤</h4>
              </div>
              <div class="modal-body" >
                  <div class=row>
                      <div class="col-md-3 col-sm-2 col-xs-2"></div>
                      <div class="col-md-6 col-sm-8 col-xs-8">
                          <form action=""  class="form-horizontal"  id=bgform>

                                          <div class="form-group">
                                              <label for="sdate" class="col-md-4 col-sm-4 col-xs-4">开始时间</label>
                                              <div class="col-md-8 col-sm-8 col-xs-8">
                                                  <div class=row>
                                                      <div class="col-md-10 col-sm-10 col-xs-10">
                                                          <input type="date" class="form-control" id="sdate" name="sdate" placeholder="开始时间" value=${model.sdate }>
                                                      </div>
                                                  </div></div>
                                          </div>

                                                     <div class="form-group">
                                                         <label for="edate" class="col-md-4 col-sm-4 col-xs-4">结束时间</label>
                                                         <div class="col-md-8 col-sm-8 col-xs-8">
                                                             <div class=row>
                                                                 <div class="col-md-10 col-sm-10 col-xs-10">
                                                                     <input type="date" class="form-control" id="edate" name="edate" placeholder="结束时间" value=${model.edate }>
                                                                 </div>
                                                             </div></div>
                                                     </div>

                                            <%--    <div class="form-group">
                                                    <label for="fnumber" class="col-md-4 col-sm-4 col-xs-4">单据编码</label>
                                                    <div class="col-md-8 col-sm-8 col-xs-8">
                                                        <div class=row>
                                                            <div class="col-md-10 col-sm-10 col-xs-10">
                                                                <input type="text" class="form-control" id="fnumber" name="fnumber"  value=${model.fnumber }>
                                                            </div></div></div>
                                                </div>--%>

                              <div class="form-group">
                                  <label for="fnumber" class="col-md-4 col-sm-4 col-xs-4">单据状态</label>
                                  <div class="col-md-8 col-sm-8 col-xs-8">
                                      <div class=row>
                                          <div class="col-md-10 col-sm-10 col-xs-10">
                                              <select id="fstate" name="fstate" class="form-control">
                                                  <option value="-1"></option>
                                                  <option value="0">保存</option>
                                                  <option value="1">审核</option>
                                                  <%--  <option value="2">检查</option>--%>
                                              </select>
                                          </div></div></div>
                              </div>

                              <div class="form-group">
                                  <label for="fmaterialid" class="col-md-4 col-sm-4 col-xs-4">物料</label>
                                  <div class="col-md-8 col-sm-8 col-xs-8">
                                      <div class=row>
                                          <div class="col-md-10 col-sm-10 col-xs-10">
                                              <div class="input-group">
                                                  <input readonly  type="text"  onfocus="clearBasics('fmaterialid')"  class="form-control" id="material" name="materialname"  placeholder="" value=${model.materialname}>
                                                  <input type="hidden" class="form-control" id="fmaterialid" name=fmaterialid  placeholder="" value=${model.fmaterialid}>
                                                  <span class="input-group-btn">
                                                <button class="btn btn-primary btn-sm"  type="button" onclick="getmaterial('material','fmaterialid','','material','','')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span></div>
                                          </div>

                                      </div>
                                  </div>
                              </div>

                                                <div class="form-group">
                                                    <label for="fsendstockid" class="col-md-4 col-sm-4 col-xs-4">仓库</label>
                                                    <div class="col-md-8 col-sm-8 col-xs-8">
                                                        <div class=row>
                                                            <div class="col-md-10 col-sm-10 col-xs-10">
                                                            <div class="input-group">
                                                                <input readonly  type="text"  onfocus="clearBasics('fsendstockid')"  class="form-control" id="stock" name="stockname"  placeholder="" value=${model.stockname}>
                                                                <input type="hidden" class="form-control" id="fsendstockid" name=fsendstockid  placeholder="" value=${model.fsendstockid}>
                                                                <span class="input-group-btn">
                                                <button class="btn btn-primary btn-sm"  type="button" onclick="showBasics('erpstock','fsendstockid','stock')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span></div>
                                                            </div>

                                                        </div>
                                                    </div>
                                                </div>
<%--
                                                <div class="form-group">
                                                    <label for="fcustomid" class="col-md-4 col-sm-4 col-xs-4">客户</label>
                                                    <div class="col-md-8 col-sm-8 col-xs-8">
                                                        <div class=row>
                                                            <div class="col-md-10 col-sm-10 col-xs-10">
                                                            <div class="input-group">
                                                                <input readonly type="text"  onfocus="clearBasics('fcustomid')"  class="form-control" id="custom" name="customname"  placeholder="" value=${model.customname}>
                                                                <input type="hidden" class="form-control" id="fcustomid" name=fcustomid  placeholder="" value=${model.fcustomid}>
                                                                <span class="input-group-btn">
                                                <button class="btn btn-primary btn-sm"  type="button" onclick="showBasics('custom','fcustomid','custom')">&nbsp;<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true" ></span>&nbsp;</button>
                                                                </span></div>
                                                            </div>

                                                        </div>
                                                    </div>
                                                </div>--%>
                      </form>
                  </div>
                  </div>
              </div>
                  <div class="modal-footer">
                      <button class="btn btn-primary btn-sm" onclick="querySubmit('billget/getList','bgform','billget')"> <span class="glyphicon  glyphicon-search" aria-hidden="true"></span> 查询</button>
                  </div>
              </div>
          </div>
      </div>
  </body>
</html>
