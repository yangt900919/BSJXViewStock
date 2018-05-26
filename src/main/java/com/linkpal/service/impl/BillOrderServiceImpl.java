package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.IBillOrderDao;
import com.linkpal.model.Billorder;
import com.linkpal.model.Billorderentry;
import com.linkpal.model.Page;
import com.linkpal.service.IBillOrderService;
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

@Service("BillOrderServiceImpl")
public class BillOrderServiceImpl implements IBillOrderService {

    @Qualifier("BillOrderDaoImpl")
    @Autowired
    private IBillOrderDao IBillOrderDao;

    @Override
    public boolean create(Billorder billget) throws Exception {
        return IBillOrderDao.create(billget);
    }

    @Override
    public boolean update(Billorder billget) throws Exception {
        return IBillOrderDao.update(billget);
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return IBillOrderDao.delete(fid);
    }

    @Override
    public List<Billorder> getList() {
        return IBillOrderDao.getList();
    }

    @Override
    public Billorder getDetail(String fnumber) {
        return IBillOrderDao.getDetail(fnumber);
    }

    @Override
    public Billorder getDetail(int fid) {
        return IBillOrderDao.getDetail(fid);
    }

    @Override
    public List<Billorder> getTipList(String fnumber) {
        return IBillOrderDao.getTipList(fnumber);
    }

    @Override
    public List<Billorder> showCurrentPage(Page page) {
        return null;
    }

    @Override
    public List<Billorder> showTipPageList(String fnumber, Page page) {
        return null;
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Billorder billget, int insertType) throws ImportException {

    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Map map) {
        Map m=new HashMap();
        List<Billorder> list=new ArrayList<>();
        if(request!=null) {
            String pageNow = request.getParameter("pageNow");
            String condition = request.getParameter("condition");
            HttpSession session = request.getSession();
            if (condition == null || "".equals(condition)) {
                session.setAttribute("Billorder", map);
            } else {
                map = (Map) session.getAttribute("Billorder");
            }
            Page page = null;
            int totalCount = IBillOrderDao.getTotalNum(map);
            if (pageNow != null) {
                page = new Page(totalCount, Integer.parseInt(pageNow));
            } else {
                page = new Page(totalCount, 1);
            }
            map.put("pageIndex", page.getStartPos());
            map.put("pageSize", page.getPageSize());
            list = IBillOrderDao.getList(map);
            m.put("list", list);
            m.put("page", page);
            m.put("model", map);
        }
        return m;
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return IBillOrderDao.deleteBatch(ids);
    }

    @Override
    public Billorderentry getentryDetail(Integer fid) {
        return IBillOrderDao.getentryDetail(fid);
    }

    @Override
    public String getAutoNumber() {
        return IBillOrderDao.getAutoNumber();
    }

    @Override
    public void deleteEntry(Integer fid) {
        IBillOrderDao.deleteEntry(fid);
    }

    @Override
    public String checkRelation(Map map) {
        return IBillOrderDao.checkRelation(map);
    }

    @Override
    public float getPushDownQty(Integer fentryid,Integer fid) {
        return IBillOrderDao.getPushDownQty(fentryid,fid);
    }


}
