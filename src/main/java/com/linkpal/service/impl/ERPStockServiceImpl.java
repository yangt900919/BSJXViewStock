package com.linkpal.service.impl;

import com.linkpal.dao.IERPStockDao;
import com.linkpal.model.ERPStock;
import com.linkpal.model.ERPStock;
import com.linkpal.model.Page;
import com.linkpal.service.IERPStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ERPStockServiceImpl implements IERPStockService {

    @Qualifier("ERPStockDaoImpl")
    @Autowired
    IERPStockDao erpStockDao;

    @Override
    public ERPStock getById(int ID) {
        return erpStockDao.getById(ID);
    }

    @Override
    public int add(ERPStock t) {
        return erpStockDao.add(t);
    }

    @Override
    public int update(ERPStock t) {
        return erpStockDao.update(t);
    }

    @Override
    public int delete(int ID) {
        return erpStockDao.delete(ID);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return erpStockDao.deleteBatch(ids);
    }

    @Override
    public List<ERPStock> getList() {
        return erpStockDao.getAllList();
    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, ERPStock t) {
        Map map=new HashMap();
        List<ERPStock> list=null;
        String pageNow = request.getParameter("pageNow");
        String condition=request.getParameter("condition");
        HttpSession session=request.getSession();
        if(condition==null || "".equals(condition))
        {
            session.setAttribute("ERPStock", t);
        }
        else
        {
            t=(ERPStock) session.getAttribute("ERPStock");
        }
        Page page = null;
        int totalCount=erpStockDao.getTotalNum(t);
        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
        } else {
            page = new Page(totalCount, 1);
        }
        list=erpStockDao.getList(page.getStartPos(), page.getPageSize(),t);
        map.put("list", list);
        map.put("page", page);
        map.put("model", t);
        return map;
    }

    @Override
    public int getTotalNum(ERPStock t) {
        return 0;
    }

}
