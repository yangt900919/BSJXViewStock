package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.IBillReturnDao;
import com.linkpal.model.Billreturn;
import com.linkpal.model.Billreturnentry;
import com.linkpal.model.Page;
import com.linkpal.service.IBillReturnService;
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

@Service("BillReturnServiceImpl")
public class BilReturnServiceImpl implements IBillReturnService {

    @Qualifier("BillReturnDaoImpl")
    @Autowired
    private IBillReturnDao IBillReturnDao;

    @Override
    public boolean create(Billreturn billreturn) throws Exception {
        return IBillReturnDao.create(billreturn);
    }

    @Override
    public boolean update(Billreturn billreturn) throws Exception {
        return IBillReturnDao.update(billreturn);
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return IBillReturnDao.delete(fid);
    }

    @Override
    public List<Billreturn> getList() {
        return IBillReturnDao.getList();
    }

    @Override
    public Billreturn getDetail(String fnumber) {
        return IBillReturnDao.getDetail(fnumber);
    }

    @Override
    public Billreturn getDetail(int fid) {
        return IBillReturnDao.getDetail(fid);
    }

    @Override
    public List<Billreturn> getTipList(String fnumber) {
        return IBillReturnDao.getTipList(fnumber);
    }

    @Override
    public List<Billreturn> showCurrentPage(Page page) {
        return null;
    }

    @Override
    public List<Billreturn> showTipPageList(String fnumber, Page page) {
        return null;
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Billreturn billreturn, int insertType) throws ImportException {

    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Map map) {
        Map m=new HashMap();
        List<Billreturn> list=new ArrayList<>();
        if(request!=null) {
            String pageNow = request.getParameter("pageNow");
            String condition = request.getParameter("condition");
            HttpSession session = request.getSession();
            if (condition == null || "".equals(condition)) {
                session.setAttribute("Billreturn", map);
            } else {
                map = (Map) session.getAttribute("Billreturn");
            }
            Page page = null;
            int totalCount = IBillReturnDao.getTotalNum(map);
            if (pageNow != null) {
                page = new Page(totalCount, Integer.parseInt(pageNow));
            } else {
                page = new Page(totalCount, 1);
            }
            map.put("pageIndex", page.getStartPos());
            map.put("pageSize", page.getPageSize());
            list = IBillReturnDao.getList(map);
            m.put("list", list);
            m.put("page", page);
            m.put("model", map);
        }
        return m;
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return IBillReturnDao.deleteBatch(ids);
    }

  /*  @Override
    public Billreturnentry getentryDetail(Integer fid) {
        return IBillReturnDao.getentryDetail(fid);
    }*/

    @Override
    public String getAutoNumber() {
        return IBillReturnDao.getAutoNumber();
    }

/*
    @Override
    public void deleteEntry(Integer fid) {
        IBillReturnDao.deleteEntry(fid);
    }

    @Override
    public String checkRelation(Map map) {
        return IBillReturnDao.checkRelation(map);
    }

    @Override
    public float getPushDownQty(Integer fentryid,Integer fid) {
        return IBillReturnDao.getPushDownQty(fentryid,fid);
    }
*/


}
