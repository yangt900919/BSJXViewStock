package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.ISCabinetDao;
import com.linkpal.model.Page;
import com.linkpal.model.Scabinet;
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
public class SCabinetServiceImpl implements ISCabinetService {

    @Autowired
            @Qualifier("SCabinetDaoImpl")
    ISCabinetDao scabinetDao;

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return scabinetDao.deleteBatch(ids);
    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Scabinet t) {

        PageList<Scabinet> pageList=new PageList<>();
        return pageList.getPageList(scabinetDao,request,t,"SCabinet");
    }

    @Override
    public boolean create(Scabinet scabinet) throws Exception {
        return scabinetDao.create(scabinet);
    }

    @Override
    public boolean update(Scabinet scabinet) throws Exception {
        return scabinetDao.update(scabinet);
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return scabinetDao.delete(fid);
    }

    @Override
    public List<Scabinet> getList() {
        return scabinetDao.getList();
    }

    @Override
    public Scabinet getDetail(String fnumber) {
        return scabinetDao.getDetail(fnumber);
    }

    @Override
    public Scabinet getDetail(int fid) {
        return scabinetDao.getDetail(fid);
    }

    @Override
    public List<Scabinet> getTipList(String fnumber) {
        return null;
    }

    @Override
    public List<Scabinet> showCurrentPage(Page page) {
        return null;
    }

    @Override
    public List<Scabinet> showTipPageList(String fnumber, Page page) {
        return null;
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Scabinet scabinet, int insertType) throws ImportException {

    }
}
