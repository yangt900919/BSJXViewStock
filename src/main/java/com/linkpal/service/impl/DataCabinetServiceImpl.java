package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.ICabinetDao;
import com.linkpal.dao.IDataCabinetDao;
import com.linkpal.model.*;
import com.linkpal.service.ICabinetService;
import com.linkpal.service.IDataCabinetService;
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
public class DataCabinetServiceImpl implements IDataCabinetService {

    @Qualifier("DataCabinetDaoImpl")
    @Autowired
    IDataCabinetDao cabinetDao;

    @Override
    public boolean create(Datacabinet cabinet) throws Exception {
        return cabinetDao.create(cabinet);
    }

    @Override
    public boolean update(Datacabinet cabinet) throws Exception {
        return cabinetDao.update(cabinet);
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return cabinetDao.delete(fid);
    }

    @Override
    public List<Datacabinet> getList() {
        return cabinetDao.getList();
    }

    @Override
    public Datacabinet getDetail(String fnumber) {
        return cabinetDao.getDetail(fnumber);
    }

    @Override
    public Datacabinet getDetail(int fid) {
        return cabinetDao.getDetail(fid);
    }

    @Override
    public List<Datacabinet> getTipList(String fnumber) {
        return cabinetDao.getTipList(fnumber);
    }

    @Override
    public List<Datacabinet> showCurrentPage(Page page) {
        int totalSize = page.getPageNow() * page.getPageSize();
        return cabinetDao.showCurrentPage(totalSize, totalSize - page.getPageSize());
    }

    @Override
    public List<Datacabinet> showTipPageList(String fnumber, Page page) {
        int totalSize = page.getPageNow() * page.getPageSize();
        return cabinetDao.showTipPageList(fnumber, totalSize, totalSize - page.getPageSize());
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Datacabinet cabinet, int insertType) throws ImportException {

    }


    @Override
    public boolean deleteBatch(Integer[] ids) {
        return cabinetDao.deleteBatch(ids);
    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Datacabinet t) {
        PageList<Datacabinet> plist=new PageList<>();
        return plist.getPageList(cabinetDao,request,t,"Datacabinet");
    }

    @Override
    public List<Datascabinet> getScabinetList(Integer fid) {
        return cabinetDao.getDatascabinetList(fid);
    }
}
