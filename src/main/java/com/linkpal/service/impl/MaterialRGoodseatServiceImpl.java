package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.IMaterialRGoodSeatDao;
import com.linkpal.model.Materialrgoodseat;
import com.linkpal.model.Page;
import com.linkpal.service.IMaterialRGoodseatService;
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
public class MaterialRGoodseatServiceImpl implements IMaterialRGoodseatService {

    @Autowired
            @Qualifier("MaterialRGoodSeatDaoImpl")
    IMaterialRGoodSeatDao materialRGoodSeatDao;

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return materialRGoodSeatDao.deleteBatch(ids);
    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Materialrgoodseat t) {

        PageList<Materialrgoodseat> pageList=new PageList<>();
        return pageList.getPageList(materialRGoodSeatDao,request,t,"MaterialRGoodseat");
    }

    @Override
    public boolean create(Materialrgoodseat materialrgoodseat) throws Exception {
        return materialRGoodSeatDao.create(materialrgoodseat);
    }

    @Override
    public boolean update(Materialrgoodseat materialrgoodseat) throws Exception {
        return materialRGoodSeatDao.update(materialrgoodseat);
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return materialRGoodSeatDao.delete(fid);
    }

    @Override
    public List<Materialrgoodseat> getList() {
        return materialRGoodSeatDao.getList();
    }

    @Override
    public Materialrgoodseat getDetail(String fnumber) {
        return materialRGoodSeatDao.getDetail(fnumber);
    }

    @Override
    public Materialrgoodseat getDetail(int fid) {
        return materialRGoodSeatDao.getDetail(fid);
    }

    @Override
    public List<Materialrgoodseat> getTipList(String fnumber) {
        return materialRGoodSeatDao.getTipList(fnumber);
    }

    @Override
    public List<Materialrgoodseat> showCurrentPage(Page page) {
        return materialRGoodSeatDao.showCurrentPage(page.getTotalCount(),page.getTotalCount()-page.getPageSize());
    }

    @Override
    public List<Materialrgoodseat> showTipPageList(String fnumber, Page page) {
        return materialRGoodSeatDao.showTipPageList(fnumber,page.getTotalCount(),page.getPageSize());
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Materialrgoodseat materialrgoodseat, int insertType) throws ImportException {

    }
}
