package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.IRoleDao;
import com.linkpal.model.Page;
import com.linkpal.model.Role;
import com.linkpal.service.IRoleService;
import com.linkpal.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements IRoleService {

    @Qualifier("roleDaoImpl")
    @Autowired
    IRoleDao roleDao;

    @Override
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return roleDao.deleteBatch(ids);
    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Role t) {
        PageList<Role> pageList=new PageList<>();
        return pageList.getPageList(roleDao,request,t,"Role");
    }

    @Override
    public void rolepermissionBind(int ID, Integer[] ids) {
        roleDao.deleteRolePermission(ID);
        for (Integer i : ids) {
            Map map=new HashMap();
            map.put("FRoleID", ID);
            map.put("FPermissionID", i);
            roleDao.rolepermissionBind(map);
        }
    }

    @Override
    public boolean create(Role role) throws Exception {
        return roleDao.create(role);
    }

    @Override
    public boolean update(Role role) throws Exception {
        return roleDao.update(role);
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return roleDao.delete(fid);
    }

    @Override
    public List<Role> getList() {
        return roleDao.getList();
    }

    @Override
    public Role getDetail(String fnumber) {
        return roleDao.getDetail(fnumber);
    }

    @Override
    public Role getDetail(int fid) {
        return roleDao.getDetail(fid);
    }

    @Override
    public List<Role> getTipList(String fnumber) {
        return null;
    }

    @Override
    public List<Role> showCurrentPage(Page page) {
        return null;
    }

    @Override
    public List<Role> showTipPageList(String fnumber, Page page) {
        return null;
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Role role, int insertType) throws ImportException {

    }
}
