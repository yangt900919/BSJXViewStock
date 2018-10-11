package com.linkpal.dao.impl;

import com.linkpal.dao.IUserDao;
import com.linkpal.map.UserMapper;
import com.linkpal.map.UserrroleMapper;
import com.linkpal.model.Role;
import com.linkpal.model.User;
import com.linkpal.model.Userrrole;
import com.linkpal.model.example.UserExample;
import com.linkpal.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class UserDaoImpl implements IUserDao {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserrroleMapper userrroleMapper;

    @Override
    public boolean create(User user) {
      /*  userMapper.deleteRoleUser(user.getFid());
        saveUserrole(user,user.getRoles());*/
        user.setUserpassword(MD5Util.getResult(user.getUserpassword()));
        return userMapper.insert(user) > 0;
    }

    @Override
    public boolean update(User user) {
        /*userMapper.deleteRoleUser(user.getFid());
        saveUserrole(user,user.getRoles());*/
        return userMapper.updateByPrimaryKey(user) > 0;
    }

    private void saveUserrole(User user, List<Role> roles)
    {
        for(Role r:roles)
        {
            Userrrole ur=new Userrrole();
            ur.setFroleid(r.getFid());
            ur.setFuserid(user.getFid());
            ur.setFcreatetime(new Date());

            userrroleMapper.insert(ur);
        }
    }

    @Override
    public boolean delete(int fid) {
        return userMapper.deleteByPrimaryKey(fid) > 0;
    }

    @Override
    public List<User> getList() {
        UserExample example = new UserExample();
        return userMapper.selectByExample(example);
    }

    @Override
    public User getDetail(String fnumber) {

        UserExample example=new UserExample();
        example.createCriteria().andUsernameEqualTo(fnumber);
        List<User> list=userMapper.selectByExample(example);
        if(list.size()>0)return list.get(0);
        else return null;
    }

    @Override
    public User getDetail(int fid) {
        return userMapper.selectByPrimaryKey(fid);
    }

    @Override
    public int deleteRoleUser(int id) {
        return userMapper.deleteRoleUser(id);
    }

    @Override
    public void roleuserBind(Map map) {
userMapper.roleuserBind(map);
    }

    @Override
    public void deleteUserERPStock(int id) {
        userMapper.deleteUserERPStock(id);
    }

    @Override
    public void saveUserErpStock(Map map) {
        userMapper.saveUserErpStock(map);
    }

    @Override
    public List<User> getTipList(String fnumber) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameLike("%" + fnumber + "%");
        return userMapper.selectByExample(example);
    }

    @Override
    public List<User> showCurrentPage(int totalSize, int perSize) {
        return userMapper.getPageList(perSize, totalSize);
    }

    @Override
    public List<User> showTipPageList(String fnumber, int totalSize, int perSize) {
        return userMapper.getTipPageList(perSize, totalSize, "%" + fnumber + "%");
    }

    @Override
    public int getTotalNum(User user) {
        return userMapper.getTotalNum(user);
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return userMapper.deleteBatch(ids)>0;
    }

    @Override
    public List<User> getList(int pageIndex, int pageSize, User user) {
        return userMapper.getList(pageIndex,pageSize,user);
    }

    @Override
    public User isAuthorizedUser(String userName, String pwd) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(userName.trim()).andUserpasswordEqualTo(MD5Util.getResult(pwd).trim());
        List<User> users = null;
        try{
            users = userMapper.selectByExample(example);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return users.get(0);
    }
}
