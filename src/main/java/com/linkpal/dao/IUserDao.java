package com.linkpal.dao;

import com.linkpal.model.User;

import java.util.List;

public interface IUserDao extends IBaseDao<User>{

    User isAuthorizedUser(String userName, String pwd);

    User getDetail(int fid);

}
