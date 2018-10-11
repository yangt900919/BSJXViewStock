package com.linkpal.controller;

import com.linkpal.model.Inv;
import com.linkpal.model.Inventory;
import com.linkpal.model.Inventry;
import com.linkpal.model.Page;
import com.linkpal.service.IInvService;
import com.linkpal.util.CheckOnlyContext;
import com.linkpal.util.ExcelUtil;
import com.linkpal.util.ExportUtil;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
public class InvController
{
    private static final Logger log = Logger.getLogger(InvController.class);  
	
    @Autowired
	private IInvService invService;
    
 
    @RequestMapping(value = "/inv/index")
    public String Index()
    {
    	return "web/inv/index";
    }
    
    @RequestMapping(value = "/inv/getList")
	@RequiresPermissions("inv:view")
    public ModelAndView getList(HttpServletRequest request,Inv inv)
    {

    	Map map=invService.getPageList(request, inv);
    	ModelAndView mav=new ModelAndView("web/inv/index");
    	mav.addObject("invList", (List<Inv>) map.get("list"));
    	mav.addObject("page", (Page) map.get("page"));
    	mav.addObject("url", "inv/getList");
    	mav.addObject("model",(Inv) map.get("model"));
    	return mav;
    }
    
    @RequestMapping(value = "/inv/create")
	@RequiresPermissions("inv:create")
    public ModelAndView Create()
    {
    	ModelAndView mav=new ModelAndView("web/inv/edit");
    	Inv inv=new Inv();
		inv.setFid(0);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");

		inv.setFname(sdf.format(new Date()) );
		inv.setFcreatetime(new Date());
		inv.setFstate(0);
		inv.setFdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    	mav.addObject("inv",inv);
    	   return mav;
    }

	@RequestMapping(value = "/inv/entry")
	public ModelAndView getEntryList(int ID)
	{

		ModelAndView mav=new ModelAndView("web/inv/entry");
		mav.addObject("inventryList", invService.getDetail(ID).getInventries());
		return mav;
	}


	@RequestMapping(value = "/inv/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,Inv Inv) throws Exception {
    	if(Inv.getFid()==null)
    	{
    		invService.create(Inv);	
    		
    	}
    	else
    	{
    		invService.update(Inv);
    	}
    	
    	 return  getList(request,(Inv) request.getSession().getAttribute("Inv")) ; 
    }
    
    @RequestMapping(value = "/inv/edit")
	@RequiresPermissions("inv:edit")
    public ModelAndView Edit(int ID)
    {
    	ModelAndView mav=new ModelAndView("web/inv/edit");
    	Inv Inv=invService.getDetail(ID);
    	mav.addObject("inv",Inv);
    	   return mav;
    }
    
    @RequestMapping(value = "/inv/delete")
	@RequiresPermissions("inv:delete")
    public ModelAndView Delete(HttpServletRequest request,int ID) throws Exception {
    	invService.delete(ID);
    	   return getList(request,(Inv)request.getSession().getAttribute("Inv"));
    }
    
    @RequestMapping(value = "/inv/deleteBatch")
	@RequiresPermissions("inv:delete")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
    	invService.deleteBatch(ids);
    	return getList(request,(Inv)request.getSession().getAttribute("Inv"));
    }

	@RequestMapping(value = "/inv/close")
	public ModelAndView Close(HttpServletRequest request,int ID)
	{
		invService.close(ID);
		return getList(request,(Inv)request.getSession().getAttribute("Inv")) ;
	}

	@RequestMapping(value = "/inv/closeBatch")
	public ModelAndView CloseBatch(HttpServletRequest request,Integer[] ids)
	{
		invService.closeBatch(ids);
		return getList(request,(Inv)request.getSession().getAttribute("Inv")) ;
	}
	@RequestMapping(value = "/inv/export")
	public ModelAndView getExportList(int ID,HttpServletRequest request,HttpServletResponse response)
	{

		//Map<String,Object> map= (Map<String, Object>) request.getSession().getAttribute("Inventory");
		List<Inventry> list=invService.getDetail(ID).getInventries();

		//excel标题
		String[] title = {"序号","物料编码","物料名称","单位","货位","盘点数量","即时库存"};

		//List objs=new ArrayList();
		//objs.add();
		//excel文件名
		String fileName = "物料盘点"+System.currentTimeMillis()+".xls";

		//sheet名
		String sheetName = "物料盘点";

		//String content[]=b

		String[][] content = new String[list.size()][];

		for (int i = 0; i < list.size(); i++) {
			content[i] = new String[title.length];
			//PageData obj = list.get(i);
			content[i][0] = String.valueOf(i+1);
			content[i][1] = list.get(i).getMaterial().getMaterialnumber();
			content[i][2] = list.get(i).getMaterial().getMaterialname();
			content[i][3] = list.get(i).getMaterial().getMaterialunit();
			content[i][4] = list.get(i).getGoodseat().getFnumber();
			content[i][5] = String.valueOf(list.get(i).getFqty());
			content[i][6] = String.valueOf(list.get(i).getFinvqty());

		}

		HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

		//响应到客户端
		try {
			ExportUtil.setResponseHeader(response, fileName);
			OutputStream os;
			os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return getEntryList(ID);
	}
}
