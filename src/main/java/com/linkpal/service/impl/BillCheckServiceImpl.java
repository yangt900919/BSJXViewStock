package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.IBillCheckDao;
import com.linkpal.model.Billcheck;
import com.linkpal.model.Billcheckentry;
import com.linkpal.model.Page;
import com.linkpal.service.IBillCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.util.*;

@Service("BillCheckServiceImpl")
public class BillCheckServiceImpl implements IBillCheckService {

    @Qualifier("BillCheckDaoImpl")
    @Autowired
    private IBillCheckDao IBillCheckDao;

    @Override
    public boolean create(Billcheck billget) throws Exception {
        return IBillCheckDao.create(billget);
    }

    @Override
    public boolean update(Billcheck billget) throws Exception {
        return IBillCheckDao.update(billget);
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return IBillCheckDao.delete(fid);
    }

    @Override
    public List<Billcheck> getList() {
        return IBillCheckDao.getList();
    }

    @Override
    public Billcheck getDetail(String fnumber) {
        return IBillCheckDao.getDetail(fnumber);
    }

    @Override
    public Billcheck getDetail(int fid) {
        return IBillCheckDao.getDetail(fid);
    }

    @Override
    public List<Billcheck> getTipList(String fnumber) {
        return IBillCheckDao.getTipList(fnumber);
    }

    @Override
    public List<Billcheck> showCurrentPage(Page page) {
        return null;
    }

    @Override
    public List<Billcheck> showTipPageList(String fnumber, Page page) {
        return null;
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Billcheck billget, int insertType) throws ImportException {

    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Map map) {
        if(map==null) {map=new HashMap();map.put("sdate",new java.sql.Date(new Date().getTime()).toString());
        map.put("edate",new java.sql.Date(new Date().getTime()).toString());}
        Map m=new HashMap();
        List<Billcheck> list=new ArrayList<>();
        if(request!=null) {
            String pageNow = request.getParameter("pageNow");
            String condition = request.getParameter("condition");
            HttpSession session = request.getSession();
            if (condition == null || "".equals(condition)) {
                session.setAttribute("Billcheck", map);
            } else {
                map = (Map) session.getAttribute("Billcheck");
            }
            Page page = null;
            int totalCount = IBillCheckDao.getTotalNum(map);
            if (pageNow != null) {
                page = new Page(totalCount, Integer.parseInt(pageNow));
            } else {
                page = new Page(totalCount, 1);
            }
            map.put("pageIndex", page.getStartPos());
            map.put("pageSize", page.getPageSize());
            list = IBillCheckDao.getList(map);
            m.put("list", list);
            m.put("page", page);
            m.put("model", map);
        }
        return m;
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return IBillCheckDao.deleteBatch(ids);
    }

    @Override
    public String getAutoNumber() {
        return IBillCheckDao.getAutoNumber();
    }

    @Override
    public Billcheckentry getentryDetail(Integer fid) {
        return IBillCheckDao.getentryDetail(fid);
    }

    @Override
    public String checkRelation(Map map) {
        return IBillCheckDao.checkRelation(map);
    }

    @Override
    public float getPushDownQty(Integer fentryid,Integer fid) {
        return IBillCheckDao.getPushDownQty(fentryid,fid);
    }

    @Override
    public String initAutoboxno(String fonumber) {
        return IBillCheckDao.initAutoboxno(fonumber);
    }


}
