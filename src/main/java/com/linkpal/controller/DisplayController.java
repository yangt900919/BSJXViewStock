package com.linkpal.controller;

import com.linkpal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DisplayController {

    @Autowired
    IDisplayService displayService;

    @RequestMapping(value = "/cabinet/display")
    public ModelAndView CabinetDisplay(String fsnumber,String fenumber,String fstock)
    {
        Map map=new HashMap<>();
        map.put("fsnumber",fsnumber);
        map.put("fenumber",fenumber);
        map.put("flag","CABINET");
        map.put("fstock",fstock);
        ModelAndView mav=null;
        List<Map<String,Object>> list=displayService.getDisplayInfo(map);
        if(list.size()>0)
        {
            int page=Integer.parseInt(list.get(0).get("page").toString());
            if(page==1)
             mav=new ModelAndView("web/cabinet/display");
            else if(page==2)
                mav=new ModelAndView("web/goodseat/display");
            mav.addObject("cdlist",list);
        }

        return mav;
    }

    @RequestMapping(value = "/scabinet/display")
    public ModelAndView SCabinetDisplay(String fsnumber,String fenumber,String fstock)
    {
        Map map=new HashMap<>();
        map.put("fsnumber",fsnumber);
        map.put("fenumber",fenumber);
        map.put("flag","SCABINET");
        map.put("fstock",fstock);
        ModelAndView mav=  mav=new ModelAndView("web/scabinet/display");;
        List<Map<String,Object>> list=displayService.getDisplayInfo(map);

            mav.addObject("scdlist",list);


        return mav;
    }


    @RequestMapping(value = "/goodseat/display")
    public ModelAndView GoodseatDisplay(String fsnumber,String fenumber,String fstock)
    {
        Map map=new HashMap<>();
        map.put("fsnumber",fsnumber);
        map.put("fenumber",fenumber);
        map.put("flag","GOODSEAT");
        map.put("fstock",fstock);
        ModelAndView mav=  mav=new ModelAndView("web/goodseat/display");;
        List<Map<String,Object>> list=displayService.getDisplayInfo(map);

        mav.addObject("gdlist",list);


        return mav;
    }

  /*  private Map mapParam(String fsnumber,String fenumber,String fstock)
    {
        Map map=new HashMap<>();
        map.put("fsnumber",fsnumber);
        map.put("fenumber",fenumber);
        map.put("fstock",fstock);
        return map;
    }*/

}
