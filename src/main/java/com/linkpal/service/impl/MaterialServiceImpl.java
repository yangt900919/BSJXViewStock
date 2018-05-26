package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.IMaterialDao;
import com.linkpal.model.Material;
import com.linkpal.model.Material;
import com.linkpal.model.Page;
import com.linkpal.service.IBaseService;
import com.linkpal.service.IMaterialService;
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
public class MaterialServiceImpl implements IMaterialService {

    @Qualifier("materialDaoImpl")
    @Autowired
    IMaterialDao materialDao;

    @Override
    public List<Material> getTipList(String code) {
        return materialDao.getTipList(code);
    }

    @Override
    public List<Material> showCurrentPage(Page page) {
        int totalSize = page.getPageNow() * page.getPageSize();
        return materialDao.showCurrentPage(totalSize, totalSize - page.getPageSize());
    }

    @Override
    public List<Material> showTipPageList(String fnumber, Page page) {
        int totalSize = page.getPageNow() * page.getPageSize();
        return materialDao.showTipPageList(fnumber, totalSize, totalSize - page.getPageSize());
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Material material, int insertType) throws ImportException {

    }

    @Override
    public Material getDetail(String code) {
        return materialDao.getDetail(code);
    }

    @Override
    public Material getDetail(int fid) {
        return materialDao.getDetail(fid);
    }

    @Override
    public List<Material> getList() {
        return materialDao.getList();
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return materialDao.delete(fid);
    }

    @Override
    public boolean update(Material material ) throws Exception {
        return materialDao.update(material);
    }

    @Override
    public boolean create(Material material ) throws Exception {
        return materialDao.create(material);
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return materialDao.deleteBatch(ids);
    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Material t) {
        PageList<Material> plist=new PageList<>();
        return plist.getPageList(materialDao,request,t,"Material");
    }
}
