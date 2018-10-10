package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.IDataSCabinetDao;
import com.linkpal.dao.ISCabinetDao;
import com.linkpal.model.Page;
import com.linkpal.model.Datascabinet;
import com.linkpal.service.IDataSCabinetService;
import com.linkpal.service.ISCabinetService;
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
public class DataSCabinetServiceImpl implements IDataSCabinetService {

    @Autowired
            @Qualifier("DataSCabinetDaoImpl")
    IDataSCabinetDao scabinetDao;

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return scabinetDao.deleteBatch(ids);
    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Datascabinet t) {

        PageList<Datascabinet> pageList=new PageList<>();
        return pageList.getPageList(scabinetDao,request,t,"Datascabinet");
    }

    @Override
    public boolean create(Datascabinet scabinet) throws Exception {
        return scabinetDao.create(scabinet);
    }

    @Override
    public boolean update(Datascabinet scabinet) throws Exception {
        return scabinetDao.update(scabinet);
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return scabinetDao.delete(fid);
    }

    @Override
    public List<Datascabinet> getList() {
        return scabinetDao.getList();
    }

    @Override
    public Datascabinet getDetail(String fnumber) {
        return scabinetDao.getDetail(fnumber);
    }

    @Override
    public Datascabinet getDetail(int fid) {
        return scabinetDao.getDetail(fid);
    }

    @Override
    public List<Datascabinet> getTipList(String fnumber) {
        return null;
    }

    @Override
    public List<Datascabinet> showCurrentPage(Page page) {
        return null;
    }

    @Override
    public List<Datascabinet> showTipPageList(String fnumber, Page page) {
        return null;
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Datascabinet scabinet, int insertType) throws ImportException {

    }
}
