package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.IPermissionDao;
import com.linkpal.model.Page;
import com.linkpal.model.Permission;
import com.linkpal.service.IPermissionService;
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
public class PermissionServiceImpl implements IPermissionService {

    @Qualifier(value = "PermissionDaoImpl")
    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return permissionDao.deleteBatch(ids);
    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Permission t) {

        PageList<Permission> pageList=new PageList<>();
        return pageList.getPageList(permissionDao,request,t,"Permission");
    }

    @Override
    public boolean create(Permission permission) throws Exception {
        return permissionDao.create(permission);
    }

    @Override
    public boolean update(Permission permission) throws Exception {
        return permissionDao.update(permission);
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return permissionDao.delete(fid);
    }

    @Override
    public List<Permission> getList() {
        return permissionDao.getList();
    }

    @Override
    public Permission getDetail(String fnumber) {
        return permissionDao.getDetail(fnumber);
    }

    @Override
    public Permission getDetail(int fid) {
        return permissionDao.getDetail(fid);
    }

    @Override
    public List<Permission> getTipList(String fnumber) {
        return null;
    }

    @Override
    public List<Permission> showCurrentPage(Page page) {
        return null;
    }

    @Override
    public List<Permission> showTipPageList(String fnumber, Page page) {
        return null;
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Permission permission, int insertType) throws ImportException {

    }
}
