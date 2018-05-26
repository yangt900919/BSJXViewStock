package com.linkpal.service;

import com.linkpal.model.User;

import java.util.List;

public interface IUserService extends IBaseService<User>{

    int isAuthorizedUser(String userName, String pwd);
}
