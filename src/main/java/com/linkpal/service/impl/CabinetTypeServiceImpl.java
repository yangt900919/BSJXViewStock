package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.ICabinetTypeDao;
import com.linkpal.model.Cabinet;
import com.linkpal.model.Cabinettype;
import com.linkpal.model.Page;
import com.linkpal.service.ICabinetTypeService;
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
public class CabinetTypeServiceImpl implements ICabinetTypeService {

    @Autowired
            @Qualifier("CabinetTypeDaoImpl")
    ICabinetTypeDao cabinetTypeDao;

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return cabinetTypeDao.deleteBatch(ids);
    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Cabinettype t) {

        PageList<Cabinettype> pageList=new PageList<>();
        return pageList.getPageList(cabinetTypeDao,request,t,"CabinetType");
    }

    @Override
    public boolean create(Cabinettype cabinettype) throws Exception {
        return cabinetTypeDao.create(cabinettype);
    }

    @Override
    public boolean update(Cabinettype cabinettype) throws Exception {
        return cabinetTypeDao.update(cabinettype);
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return cabinetTypeDao.delete(fid);
    }

    @Override
    public List<Cabinettype> getList() {
        return cabinetTypeDao.getList();
    }

    @Override
    public Cabinettype getDetail(String fnumber) {
        return cabinetTypeDao.getDetail(fnumber);
    }

    @Override
    public Cabinettype getDetail(int fid) {
        return cabinetTypeDao.getDetail(fid);
    }

    @Override
    public List<Cabinettype> getTipList(String fnumber) {
        return cabinetTypeDao.getTipList(fnumber);
    }

    @Override
    public List<Cabinettype> showCurrentPage(Page page) {
        return cabinetTypeDao.showCurrentPage(page.getTotalCount(),page.getPageSize());
    }

    @Override
    public List<Cabinettype> showTipPageList(String fnumber, Page page) {
        return cabinetTypeDao.showTipPageList(fnumber,page.getTotalCount(),page.getPageSize());
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Cabinettype cabinettype, int insertType) throws ImportException {

    }
}
