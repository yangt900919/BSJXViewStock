package com.linkpal.service.impl;

import com.linkpal.dao.IGsPrintDao;
import com.linkpal.model.GsPrint;
import com.linkpal.model.Material;
import com.linkpal.model.Page;
import com.linkpal.service.IGsPrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GsPrintServiceImpl implements IGsPrintService {

    @Qualifier("GsPrintDaoImpl")
    @Autowired
    IGsPrintDao gsPrintDao;

    @Override
    public GsPrint getById(int ID) {
        return gsPrintDao.getById(ID);
    }

    @Override
    public int add(GsPrint t) {
        return gsPrintDao.add(t);
    }

    @Override
    public int update(GsPrint t) {
        return gsPrintDao.update(t);
    }

    @Override
    public int delete(int ID) {
        return gsPrintDao.delete(ID);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return gsPrintDao.deleteBatch(ids);
    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, GsPrint t) {
        Map map=new HashMap();
        List<GsPrint> list=null;
        String pageNow = request.getParameter("pageNow");
        String condition=request.getParameter("condition");
        HttpSession session=request.getSession();
        if(condition==null || "".equals(condition))
        {
            session.setAttribute("GsPrint", t);
        }
        else
        {
            t=(GsPrint) session.getAttribute("GsPrint");
        }
        Page page = null;
        int totalCount=gsPrintDao.getTotalNum(t);
        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
        } else {
            page = new Page(totalCount, 1);
        }
        list=gsPrintDao.getList(page.getStartPos(), page.getPageSize(),t);
        map.put("list", list);
        map.put("page", page);
        map.put("model", t);
        return map;
    }

    @Override
    public int getTotalNum(GsPrint t) {
        return 0;
    }


}
