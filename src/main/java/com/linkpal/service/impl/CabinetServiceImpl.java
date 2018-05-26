package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.ICabinetDao;
import com.linkpal.model.Cabinet;
import com.linkpal.model.Page;
import com.linkpal.service.ICabinetService;
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
public class CabinetServiceImpl implements ICabinetService {

    @Qualifier("cabinetDaoImpl")
    @Autowired
    ICabinetDao cabinetDao;

    @Override
    public boolean create(Cabinet cabinet) throws Exception {
        return cabinetDao.create(cabinet);
    }

    @Override
    public boolean update(Cabinet cabinet) throws Exception {
        return cabinetDao.update(cabinet);
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return cabinetDao.delete(fid);
    }

    @Override
    public List<Cabinet> getList() {
        return cabinetDao.getList();
    }

    @Override
    public Cabinet getDetail(String fnumber) {
        return cabinetDao.getDetail(fnumber);
    }

    @Override
    public Cabinet getDetail(int fid) {
        return cabinetDao.getDetail(fid);
    }

    @Override
    public List<Cabinet> getTipList(String fnumber) {
        return cabinetDao.getTipList(fnumber);
    }

    @Override
    public List<Cabinet> showCurrentPage(Page page) {
        int totalSize = page.getPageNow() * page.getPageSize();
        return cabinetDao.showCurrentPage(totalSize, totalSize - page.getPageSize());
    }

    @Override
    public List<Cabinet> showTipPageList(String fnumber, Page page) {
        int totalSize = page.getPageNow() * page.getPageSize();
        return cabinetDao.showTipPageList(fnumber, totalSize, totalSize - page.getPageSize());
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Cabinet cabinet, int insertType) throws ImportException {

    }


    @Override
    public boolean deleteBatch(Integer[] ids) {
        return cabinetDao.deleteBatch(ids);
    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Cabinet t) {
        PageList<Cabinet> plist=new PageList<>();
        return plist.getPageList(cabinetDao,request,t,"Cabinet");
    }
}
