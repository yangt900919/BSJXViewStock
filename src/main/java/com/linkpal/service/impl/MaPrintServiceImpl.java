package com.linkpal.service.impl;

import com.linkpal.dao.IMaPrintDao;
import com.linkpal.model.Cabinet;
import com.linkpal.model.MaPrint;
import com.linkpal.model.Material;
import com.linkpal.model.Page;
import com.linkpal.service.IMaPrintService;
import com.linkpal.util.PageList;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MaPrintServiceImpl implements IMaPrintService {

    @Qualifier("MaPrintDaoImpl")
    @Autowired
    IMaPrintDao maPrintDao;

    @Override
    public MaPrint getById(int ID) {
        return maPrintDao.getById(ID);
    }

    @Override
    public int add(MaPrint t) {
        return maPrintDao.add(t);
    }

    @Override
    public int update(MaPrint t) {
        return maPrintDao.update(t);
    }

    @Override
    public int delete(int ID) {
        return maPrintDao.delete(ID);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return maPrintDao.deleteBatch(ids);
    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Material t) {
        Map map=new HashMap();
        List<MaPrint> list=null;
        String pageNow = request.getParameter("pageNow");
        String condition=request.getParameter("condition");
        HttpSession session=request.getSession();
        if(condition==null || "".equals(condition))
        {
            session.setAttribute("MaPrint", t);
        }
        else
        {
            t=(Material) session.getAttribute("MaPrint");
        }
        Page page = null;
        int totalCount=maPrintDao.getTotalNum(t);
        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
        } else {
            page = new Page(totalCount, 1);
        }
        list=maPrintDao.getList(page.getStartPos(), page.getPageSize(),t);
        map.put("list", list);
        map.put("page", page);
        map.put("model", t);
        return map;
    }

    @Override
    public int getTotalNum(Material t) {
        return 0;
    }

    @Override
    public Map<String, Object> getboxPageList(HttpServletRequest request, MaPrint t) {
        Map map=new HashMap();
        List<MaPrint> list=null;
        String pageNow = request.getParameter("pageNow");
        String condition=request.getParameter("condition");
        HttpSession session=request.getSession();
        if(condition==null || "".equals(condition))
        {
            session.setAttribute("MaboxPrint", t);
        }
        else
        {
            t=(MaPrint) session.getAttribute("MaboxPrint");
        }
        Page page = null;
        int totalCount=maPrintDao.getboxTotalNum(t);
        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
        } else {
            page = new Page(totalCount, 1);
        }
        list=maPrintDao.getboxList(page.getStartPos(), page.getPageSize(),t);
        map.put("list", list);
        map.put("page", page);
        map.put("model", t);
        return map;
    }

    @Override
    public int getboxTotalNum(MaPrint t) {
        return 0;
    }

    @Override
    public String getCSNo() {
        return maPrintDao.getCSNo();
    }
}
