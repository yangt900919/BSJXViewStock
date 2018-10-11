package com.linkpal.service.impl;

import com.linkpal.dao.IICStockBillDao;
import com.linkpal.model.ICStockBill;
import com.linkpal.model.ICStockBill;
import com.linkpal.model.ICStockBill;
import com.linkpal.model.Page;
import com.linkpal.service.IICStockBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ICStockBillServiceImpl implements IICStockBillService {

    @Qualifier("ICStockBillDaoImpl")
    @Autowired
    IICStockBillDao icstockbillDao;

    @Override
    public ICStockBill getById(int ID) {
        return icstockbillDao.getById(ID);
    }

    @Override
    public int add(ICStockBill t) {
        return icstockbillDao.add(t);
    }

    @Override
    public int update(ICStockBill t) {
        return icstockbillDao.update(t);
    }

    @Override
    public int delete(int ID) {
        return icstockbillDao.delete(ID);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return icstockbillDao.deleteBatch(ids);
    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Map map) {
        Map m=new HashMap();
        List<ICStockBill> list=null;
        String pageNow = request.getParameter("pageNow");
        String condition=request.getParameter("condition");
        HttpSession session=request.getSession();
        if(condition==null || "".equals(condition))
        {
            session.setAttribute("ICStockBill", map);
        }
        else
        {
            map=(Map) session.getAttribute("ICStockBill");
        }
        Page page = null;
        int totalCount=icstockbillDao.getTotalNum(map);
        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
        } else {
            page = new Page(totalCount, 1);
        }
        map.put("pageIndex", page.getStartPos());
        map.put("pageSize", page.getPageSize());
        list=icstockbillDao.getList(map);
        m.put("list", list);
        m.put("page", page);
        m.put("model", map);
        return m;
    }

    @Override
    public int getTotalNum(Map map) {
        return 0;
    }

    @Override
    public String getAutoNumber() {
        return icstockbillDao.getAutoNumber();
    }


}
