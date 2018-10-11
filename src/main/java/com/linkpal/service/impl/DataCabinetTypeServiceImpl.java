package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.ICabinetTypeDao;
import com.linkpal.dao.IDataCabinetTypeDao;
import com.linkpal.model.Datacabinettype;
import com.linkpal.model.Datacabinettype;
import com.linkpal.model.Page;
import com.linkpal.service.ICabinetTypeService;
import com.linkpal.service.IDataCabinetTypeService;
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
public class DataCabinetTypeServiceImpl implements IDataCabinetTypeService {

    @Autowired
            @Qualifier("DataCabinetTypeDaoImpl")
    IDataCabinetTypeDao cabinetTypeDao;

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return cabinetTypeDao.deleteBatch(ids);
    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Datacabinettype t) {

        PageList<Datacabinettype> pageList=new PageList<>();
        return pageList.getPageList(cabinetTypeDao,request,t,"Datacabinettype");
    }

    @Override
    public boolean create(Datacabinettype cabinettype) throws Exception {
        return cabinetTypeDao.create(cabinettype);
    }

    @Override
    public boolean update(Datacabinettype cabinettype) throws Exception {
        return cabinetTypeDao.update(cabinettype);
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return cabinetTypeDao.delete(fid);
    }

    @Override
    public List<Datacabinettype> getList() {
        return cabinetTypeDao.getList();
    }

    @Override
    public Datacabinettype getDetail(String fnumber) {
        return cabinetTypeDao.getDetail(fnumber);
    }

    @Override
    public Datacabinettype getDetail(int fid) {
        return cabinetTypeDao.getDetail(fid);
    }

    @Override
    public List<Datacabinettype> getTipList(String fnumber) {
        return cabinetTypeDao.getTipList(fnumber);
    }

    @Override
    public List<Datacabinettype> showCurrentPage(Page page) {
        return cabinetTypeDao.showCurrentPage(page.getTotalCount(),page.getPageSize());
    }

    @Override
    public List<Datacabinettype> showTipPageList(String fnumber, Page page) {
        return cabinetTypeDao.showTipPageList(fnumber,page.getTotalCount(),page.getPageSize());
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Datacabinettype cabinettype, int insertType) throws ImportException {

    }
}
