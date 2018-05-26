package com.linkpal.dao.impl;

import com.linkpal.dao.IUserDao;
import com.linkpal.map.UserMapper;
import com.linkpal.model.User;
import com.linkpal.model.example.UserExample;
import com.linkpal.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements IUserDao {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean create(User user) {
        user.setUserpassword(MD5Util.getResult(user.getUserpassword()));
        return userMapper.insert(user) > 0;
    }

    @Override
    public boolean update(User user) {
        return userMapper.updateByPrimaryKey(user) > 0;
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
        return 0;
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return false;
    }

    @Override
    public List<User> getList(int pageIndex, int pageSize, User user) {
        return null;
    }

    @Override
    public User isAuthorizedUser(String userName, String pwd) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(userName.trim()).andUserpasswordEqualTo(MD5Util.getResult(pwd).trim());
        List<User> users = userMapper.selectByExample(example);
        return users.get(0);
    }
}
