package com.linkpal.controller;

import com.alibaba.fastjson.JSONObject;
import com.linkpal.model.Material;
import com.linkpal.model.Material;
import com.linkpal.model.Page;
import com.linkpal.service.IMaterialService;
import com.linkpal.util.CheckOnlyContext;
import com.linkpal.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@Controller
public class MaterialController {

    @Autowired
    IMaterialService materialService;


    @RequestMapping(value = "/material/index")
    public String Index()
    {
        return "web/material/index";
    }

    @RequestMapping(value = "/material/getList")
    public ModelAndView getList(HttpServletRequest request,Material material)
    {

        Map map=materialService.getPageList(request, material);
        ModelAndView mav=new ModelAndView("web/material/index");
        mav.addObject("materialList", (List<Material>) map.get("list"));
        mav.addObject("page", (Page) map.get("page"));
        mav.addObject("url", "material/getList");
        mav.addObject("model",(Material) map.get("model"));
        return mav;
    }

    @RequestMapping(value = "/material/create")
    public ModelAndView Create()
    {
        ModelAndView mav=new ModelAndView("web/material/edit");
        Material material=new Material();
        material.setFid(0);
        mav.addObject("material",material);
        return mav;
    }

    @RequestMapping(value = "/material/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,Material material) throws Exception {
        if(material.getFid()==null)
        {
            materialService.create(material);

        }
        else
        {
            materialService.update(material);
        }

        return  getList(request,(Material) request.getSession().getAttribute("Material")) ;
    }

    @RequestMapping(value = "/material/edit")
    public ModelAndView Edit(int ID)
    {
        ModelAndView mav=new ModelAndView("web/material/edit");
        Material material=materialService.getDetail(ID);
        mav.addObject("material",material);
        return mav;
    }

    @RequestMapping(value = "/material/delete")
    public ModelAndView Delete(HttpServletRequest request,int ID) throws Exception {
        materialService.delete(ID);
        return getList(request,(Material)request.getSession().getAttribute("Material"));
    }

    @RequestMapping(value = "/material/deleteBatch")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
        materialService.deleteBatch(ids);
        return getList(request,(Material)request.getSession().getAttribute("Material"));
    }

    @RequestMapping(value = "/material/CheckOnly")
    @POST
    public void CheckOnly(HttpServletResponse response,String param,int ID) throws Exception
    {
    	response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		CheckOnlyContext coc=new CheckOnlyContext();
		Material model=null;
		if(ID==0)model=new Material();
		else model=materialService.getDetail(ID);
    	out.println( coc.CheckOnly(model.getMaterialnumber(), materialService, param, ID));
    }
/*
    @Override
    @RequestMapping(value = "/material/creat")
    @POST
    public void create(HttpServletRequest request, HttpServletResponse response, Material material) throws Exception {
        if(materialService.create(material)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @RequestMapping(value = "/material/delete")
    @POST
    public void delete(HttpServletRequest request, HttpServletResponse response, int fid) throws Exception{
        if(materialService.delete(fid)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @POST
    @RequestMapping(value = "/material/edit")
    public void update(HttpServletRequest request, HttpServletResponse response, Material material) throws Exception {
        if(materialService.update(material)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @RequestMapping(value = "/material/list")
    public ModelAndView getList(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("web/material/materiel");
        mav.addObject("materiallist", materialService.getList());
        return mav;
    }

    @Override
    @RequestMapping(value = "/material/part-list")
    public void getTipList(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String code = request.getParameter("materialnumber");
        response.getWriter().write(JSONObject.toJSONString(materialService.getTipList(code)));
        response.getWriter().flush();
        response.getWriter().close();
    }

    @Override
    @RequestMapping(value = "/material/detail")
    public ModelAndView getDetail(HttpServletRequest request) {
        String code = request.getParameter("materialnumber");
        ModelAndView mav = new ModelAndView("web/material/materiel-change");
        mav.addObject("material", materialService.getDetail(code));
        return mav;
    }

    @Override
    @RequestMapping(value = "/material/add")
    public ModelAndView toAdd(){
        ModelAndView mav = new ModelAndView("web/material/materiel-add");
        return mav;
    }

    @Override
    public ModelAndView toEdit(HttpServletRequest request, int fid) {
        ModelAndView mav = new ModelAndView("web/material/materiel-change");
        mav.addObject("material", materialService.getDetail(fid));
        return mav;
    }

    @Override
    @RequestMapping(value = "/material/auto-list")
    public ModelAndView getMatchList(HttpServletRequest request, String fnumber){
        ModelAndView mav = new ModelAndView("web/material/materiel");
        mav.addObject("materiallist", materialService.getTipList(fnumber));
        return mav;
    }*/
}
