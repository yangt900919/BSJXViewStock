package com.linkpal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.linkpal.model.User;
import com.linkpal.service.IDataSyncService;
import com.linkpal.service.IUserService;
import com.linkpal.util.GlobalVarContext;
import com.linkpal.util.MenuContext;
import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DataSyncController
{
    private static final Logger log = Logger.getLogger(DataSyncController.class);  
	
    @Autowired
	private IDataSyncService dataService;

    @Autowired
	private IUserService userService;
	
    @RequestMapping(value = "/Send")
   public void Send(HttpServletRequest request,HttpServletResponse response,@RequestParam("billtype") String billtype) throws Exception
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String username="";
		if(request.getParameter("username")!=null)username=request.getParameter("username");
		Map param=new HashMap();
		param.put("billtype", billtype);
		param.put("username",username);
		//dataService.Send(param);
        List list=dataService.Send(param);
       // if(list.size()>0)
	    out.println(JSON.toJSONString(list));

    	
    }
	
    @RequestMapping(value = "/Receive")
    @POST
    public void Receive(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		ServletInputStream inputStream = request.getInputStream();

		byte[] bArray = new byte[2048];
		int count = 0;
		// String xmlStr="";
		StringBuilder strb = new StringBuilder();
		while ((count = inputStream.read(bArray)) != -1) {
			strb.append(new String(bArray, 0, count, "utf-8"));
		}
		String param = strb.toString();
		//param="";
		//param="{\"_id\":2,\"billType\":\"入库单\",\"factqty\":2,\"fbillid\":1,\"fdate\":\"2018-04-25\",\"fentryid\":1,\"fgoodseat\":\"g123\",\"fid\":1,\"fnumber\":\"000001\",\"fqty\":10,\"fstock\":\"\",\"fuser\":\"admin\",\"mamodel\":\"16*2.5mm 费斯托 PUN-H-16×2.5sw   \",\"maname\":\"聚酰胺管 16*2.5mm 费斯托 PUN-H-16×2.5sw\",\"manum\":\"10000443337\",\"maunit\":\"m\"}";
		//param="{\"_id\":3,\"entry\":[{\"factqty\":10,\"fbillid\":36,\"fentryid\":1,\"fgoodseat\":\"AP01G001L01K01\",\"fqty\":10,\"fsrc_billid\":42,\"fsrc_entryid\":1,\"fsrc_number\":\"SHTZ201805220002\",\"fstock\":\"新区标准件库\",\"mamodel\":\"M50*2-RC1/2（作废）     \",\"maname\":\"直角接头 M50*2-RC1/2（作废）\",\"manum\":\"900080759\",\"maunit\":\"只\"},{\"factqty\":5,\"fbillid\":36,\"fentryid\":2,\"fgoodseat\":\"AP01G001L01K01\",\"fqty\":5,\"fsrc_billid\":42,\"fsrc_entryid\":2,\"fsrc_number\":\"SHTZ201805220002\",\"fstock\":\"新区标准件库\",\"mamodel\":\"绞车控制阀箱 华北90D后台机组    \",\"maname\":\"绞车配件 绞车控制阀箱 华北90D后台机组\",\"manum\":\"115010395\",\"maunit\":\"只\"},{\"factqty\":8,\"fbillid\":36,\"fentryid\":3,\"fgoodseat\":\"AP01G001L01K01\",\"fqty\":8,\"fsrc_billid\":42,\"fsrc_entryid\":3,\"fsrc_number\":\"SHTZ201805220002\",\"fstock\":\"新区标准件库\",\"mamodel\":\"M16*1.5-RC1/2（作废）     \",\"maname\":\"直角接头 M16*1.5-RC1/2（作废）\",\"manum\":\"900080760\",\"maunit\":\"只\"}],\"fbilltype\":\"入库单\",\"fboxno\":\"CGDD201805220002-1\",\"fdate\":\"2018-05-22\",\"fid\":36,\"fisqt\":1,\"fnumber\":\"RK201805220003\",\"fsupplier\":\"测试供应商\",\"ftype\":\"czjl\",\"fuser\":\"admin\"}";
		//param="{\"_id\":10,\"factqty\":3,\"fbillid\":31,\"fbilltype\":\"领料单\",\"fdate\":\"2018-05-23 15:24:35\",\"fentryid\":1,\"fgoodseat\":\"AP27G080L02K01\",\"fid\":31,\"fisqt\":0,\"fnumber\":\"000003\",\"fqty\":3,\"fsrc_billid\":0,\"fsrc_entryid\":0,\"fsrc_number\":\"\",\"fstock\":\"\",\"ftype\":\"czjl\",\"fuser\":\"admin\",\"mamodel\":\"16*2.5mm\",\"maname\":\"聚酰胺管\",\"manum\":\"10000443337\",\"maunit\":\"m\"}";
		if(param==null||param.equals(""))
		{
			Map map=new HashMap();
			map.put("state",0);
			map.put("message","No data found");
			map.put("data"," ");
			out.println(JSON.toJSONString(map));
		}
		else
		{
			JSONObject jo=new JSONObject();
			Map map= JSON.parseObject(param,Map.class);
			//out.println(param);
			out.println(JSON.toJSONString(dataService.Receive(map).get(0)));
		}


	}


	@RequestMapping(value = "/doLogin")
	@POST
	public void Login(HttpServletRequest request,HttpServletResponse response,@RequestParam("username") String username, @RequestParam("password") String password) throws IOException {
		response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		boolean authorized = userService.isAuthorizedUser(username, password)>0? true:false;

		if (authorized) {
			User user=userService.getDetail(username);
			Map map=new HashMap();
			map.put("state",0);
			map.put("message","成功");
			map.put("data",user.getErpStocks());
			System.out.println(JSON.toJSONString(map));
			out.println(JSON.toJSONString(map));
		} else {
			Map map=new HashMap();
			map.put("state",-1);
			map.put("message","用户名或密码错误");
			map.put("data"," ");
			out.println(JSON.toJSONString(map));
		}
	}
    

}
