package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.IDataRDataSeatDao;
import com.linkpal.dao.IMaterialRGoodSeatDao;
import com.linkpal.model.Datardataseat;
import com.linkpal.model.Page;
import com.linkpal.service.IDataRDataseatService;
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
public class DataRDataseatServiceImpl implements IDataRDataseatService {

    @Autowired
            @Qualifier("DataRDataSeatDaoImpl")
    IDataRDataSeatDao materialRGoodSeatDao;

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return materialRGoodSeatDao.deleteBatch(ids);
    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Datardataseat t) {

        PageList<Datardataseat> pageList=new PageList<>();
        return pageList.getPageList(materialRGoodSeatDao,request,t,"Datardataseat");
    }


    @Override
    public boolean create(Datardataseat materialrgoodseat) throws Exception {
        return materialRGoodSeatDao.create(materialrgoodseat);
    }

    @Override
    public boolean update(Datardataseat materialrgoodseat) throws Exception {
        return materialRGoodSeatDao.update(materialrgoodseat);
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return materialRGoodSeatDao.delete(fid);
    }

    @Override
    public List<Datardataseat> getList() {
        return materialRGoodSeatDao.getList();
    }

    @Override
    public Datardataseat getDetail(String fnumber) {
        return materialRGoodSeatDao.getDetail(fnumber);
    }

    @Override
    public Datardataseat getDetail(int fid) {
        return materialRGoodSeatDao.getDetail(fid);
    }

    @Override
    public List<Datardataseat> getTipList(String fnumber) {
        return materialRGoodSeatDao.getTipList(fnumber);
    }

    @Override
    public List<Datardataseat> showCurrentPage(Page page) {
        return materialRGoodSeatDao.showCurrentPage(page.getTotalCount(),page.getTotalCount()-page.getPageSize());
    }

    @Override
    public List<Datardataseat> showTipPageList(String fnumber, Page page) {
        return materialRGoodSeatDao.showTipPageList(fnumber,page.getTotalCount(),page.getPageSize());
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Datardataseat materialrgoodseat, int insertType) throws ImportException {

    }
}
