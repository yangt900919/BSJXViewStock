package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.IBillGetDao;
import com.linkpal.model.Billget;
import com.linkpal.model.Page;
import com.linkpal.service.IBillGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("BillGetServiceImpl")
public class BillGetServiceImpl implements IBillGetService {

    @Qualifier("BillGetDaoImpl")
    @Autowired
    private IBillGetDao IBillGetDao;

    @Override
    public boolean create(Billget billget) throws Exception {
        return IBillGetDao.create(billget);
    }

    @Override
    public boolean update(Billget billget) throws Exception {
        return IBillGetDao.update(billget);
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return IBillGetDao.delete(fid);
    }

    @Override
    public List<Billget> getList() {
        return IBillGetDao.getList();
    }

    @Override
    public Billget getDetail(String fnumber) {
        return IBillGetDao.getDetail(fnumber);
    }

    @Override
    public Billget getDetail(int fid) {
        return IBillGetDao.getDetail(fid);
    }

    @Override
    public List<Billget> getTipList(String fnumber) {
        return IBillGetDao.getTipList(fnumber);
    }

    @Override
    public List<Billget> showCurrentPage(Page page) {
        return null;
    }

    @Override
    public List<Billget> showTipPageList(String fnumber, Page page) {
        return null;
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Billget billget, int insertType) throws ImportException {

    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Map map) {
        Map m=new HashMap();
        List<Billget> list=new ArrayList<>();
        if(request!=null) {
            String pageNow = request.getParameter("pageNow");
            String condition = request.getParameter("condition");
            HttpSession session = request.getSession();
            if (condition == null || "".equals(condition)) {
                session.setAttribute("Billget", map);
            } else {
                map = (Map) session.getAttribute("Billget");
            }
            Page page = null;
            int totalCount = IBillGetDao.getTotalNum(map);
            if (pageNow != null) {
                page = new Page(totalCount, Integer.parseInt(pageNow));
            } else {
                page = new Page(totalCount, 1);
            }
            map.put("pageIndex", page.getStartPos());
            map.put("pageSize", page.getPageSize());
            list = IBillGetDao.getList(map);
            m.put("list", list);
            m.put("page", page);
            m.put("model", map);
        }
        return m;
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return IBillGetDao.deleteBatch(ids);
    }

    @Override
    public String getAutoNumber() {
        return IBillGetDao.getAutoNumber();
    }

    @Override
    public void updateDepart(Map map) {
        IBillGetDao.updateDepart(map);
    }

    @Override
    public float getInventoryQty(Integer fmaid) {
        return IBillGetDao.getInventoryQty(fmaid);
    }


}
