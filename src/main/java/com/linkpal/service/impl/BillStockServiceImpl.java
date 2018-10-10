package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.IBillStockDao;
import com.linkpal.model.Billstock;
import com.linkpal.model.Page;
import com.linkpal.service.IBillStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.util.*;

@Service("BillStockServiceImpl")
public class BillStockServiceImpl implements IBillStockService {

    @Qualifier("BillStockDaoImpl")
    @Autowired
    private IBillStockDao IBillStockDao;

    @Override
    public boolean create(Billstock billget) throws Exception {
        return IBillStockDao.create(billget);
    }

    @Override
    public boolean update(Billstock billget) throws Exception {
        return IBillStockDao.update(billget);
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return IBillStockDao.delete(fid);
    }

    @Override
    public List<Billstock> getList() {
        return IBillStockDao.getList();
    }

    @Override
    public Billstock getDetail(String fnumber) {
        return IBillStockDao.getDetail(fnumber);
    }

    @Override
    public Billstock getDetail(int fid) {
        return IBillStockDao.getDetail(fid);
    }

    @Override
    public List<Billstock> getTipList(String fnumber) {
        return IBillStockDao.getTipList(fnumber);
    }

    @Override
    public List<Billstock> showCurrentPage(Page page) {
        return null;
    }

    @Override
    public List<Billstock> showTipPageList(String fnumber, Page page) {
        return null;
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Billstock billget, int insertType) throws ImportException {

    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Map map) {
        if(map==null) {map=new HashMap();map.put("sdate",new java.sql.Date(new Date().getTime()).toString());
            map.put("edate",new java.sql.Date(new Date().getTime()).toString());}
        Map m=new HashMap();
        List<Billstock> list=new ArrayList<>();
        if(request!=null) {
            String pageNow = request.getParameter("pageNow");
            String condition = request.getParameter("condition");
            HttpSession session = request.getSession();
            if (condition == null || "".equals(condition)) {
                session.setAttribute("Billstock", map);
            } else {
                map = (Map) session.getAttribute("Billstock");
            }
            Page page = null;
            int totalCount = IBillStockDao.getTotalNum(map);
            if (pageNow != null) {
                page = new Page(totalCount, Integer.parseInt(pageNow));
            } else {
                page = new Page(totalCount, 1);
            }
            map.put("pageIndex", page.getStartPos());
            map.put("pageSize", page.getPageSize());
            list = IBillStockDao.getList(map);
            m.put("list", list);
            m.put("page", page);
            m.put("model", map);
        }
        return m;
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return IBillStockDao.deleteBatch(ids);
    }

    @Override
    public String getAutoNumber() {
        return IBillStockDao.getAutoNumber();
    }

    @Override
    public void BillStockRewrite_Order(Map map) {
        IBillStockDao.BillStockRewrite_Order(map);
    }


}
