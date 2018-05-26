package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.ICustomDao;
import com.linkpal.model.Custom;
import com.linkpal.model.Custom;
import com.linkpal.model.Page;
import com.linkpal.service.ICustomService;
import com.linkpal.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Service
public class CustomServiceImpl implements ICustomService{

    @Qualifier("customDaoImpl")
    @Autowired
    ICustomDao customDao;

    @Override
    public List<Custom> getTipList(String customnumber) {
        return customDao.getTipList(customnumber);
    }

    @Override
    public List<Custom> showCurrentPage(Page page) {
        int totalSize = page.getPageNow() * page.getPageSize();
        return customDao.showCurrentPage(totalSize, totalSize- page.getPageSize());
    }

    @Override
    public List<Custom> showTipPageList(String fnumber, Page page) {
        int totalSize = page.getPageNow() * page.getPageSize();
        return customDao.showTipPageList(fnumber, totalSize, totalSize- page.getPageSize());
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Custom custom, int insertType) throws ImportException {

    }

    @Override
    public Custom getDetail(String customnumber) {
        return customDao.getDetail(customnumber);
    }

    @Override
    public Custom getDetail(int fid) {
        return customDao.getDetail(fid);
    }

    @Override
    public List<Custom> getList() {
        return customDao.getList();
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return customDao.delete(fid);
    }

    @Override
    public boolean create(Custom custom) throws Exception {
        return customDao.create(custom);
    }

    @Override
    public boolean update(Custom custom) throws Exception {
        return customDao.update(custom);
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return customDao.deleteBatch(ids);
    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Custom t) {
        PageList<Custom> plist=new PageList<>();
        return plist.getPageList(customDao,request,t,"Custom");
    }
}
