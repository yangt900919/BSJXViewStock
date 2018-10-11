package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.IUserDao;
import com.linkpal.model.Page;
import com.linkpal.model.User;
import com.linkpal.service.IUserService;
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
public class UserServiceImpl implements IUserService {

    @Qualifier("userDaoImpl")
    @Autowired
    IUserDao userDao;

    @Override
    public boolean create(User user) throws Exception {
        return userDao.create(user);
    }

    @Override
    public boolean update(User user) throws Exception {
        return userDao.update(user);
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return userDao.delete(fid);
    }



    @Override
    public List<User> getList() {
        return userDao.getList();
    }

    @Override
    public User getDetail(String fnumber) {
        return userDao.getDetail(fnumber);
    }

    @Override
    public List<User> getTipList(String fnumber) {
        return userDao.getTipList(fnumber);
    }

    @Override
    public List<User> showCurrentPage(Page page) {
        int totalSize = page.getPageNow() * page.getPageSize();
        return userDao.showCurrentPage(totalSize, totalSize - page.getPageSize());
    }

    @Override
    public List<User> showTipPageList(String fnumber, Page page) {
        int totalSize = page.getPageNow() * page.getPageSize();
        return userDao.showTipPageList(fnumber, totalSize, totalSize - page.getPageSize());
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, User user, int insertType) throws ImportException {

    }

    @Override
    public int isAuthorizedUser(String userName, String pwd) {
        try{
            return userDao.isAuthorizedUser(userName, pwd).getFid();
        }catch (Exception e){
        }
        return 0;
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return userDao.deleteBatch(ids);
    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, User t) {
        PageList<User> userPageList=new PageList<>();
        return userPageList.getPageList(userDao,request,t,"User");
    }

    @Override
    public void RoleUserBind(int ID, Integer[] ids) {
        userDao.deleteRoleUser(ID);
        for (Integer i : ids) {
            Map map=new HashMap();
            map.put("fuserid", ID);
            map.put("froleid", i);
            userDao.roleuserBind(map);
        }
    }

    @Override
    public void UserBindStock(int id, Integer[] stockId) {
        userDao.deleteUserERPStock(id);
        if(stockId.length>0){
            for(Integer i : stockId){
                Map map  = new HashMap();
                map.put("fuserid",id);
                map.put("ferpstockid",i);
                userDao.saveUserErpStock(map);
            }
        }
    }


    @Override
    public User getDetail(int fid) {
        return userDao.getDetail(fid);
    }
}
