package com.linkpal.dao;

import com.linkpal.model.User;

import java.util.List;
import java.util.Map;

public interface IUserDao extends IBaseDao<User>{

    User isAuthorizedUser(String userName, String pwd);

    User getDetail(int fid);

    public int deleteRoleUser(int id);

    public void roleuserBind(Map map);

}
