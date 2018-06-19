package com.linkpal.service;

import com.linkpal.model.Permission;
import com.linkpal.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface IUserService extends IBaseService<User>{

    int isAuthorizedUser(String userName, String pwd);

    public boolean deleteBatch(Integer[] ids);

    public Map<String, Object> getPageList(HttpServletRequest request, User t);

    public void RoleUserBind(int ID,Integer[] ids);
}
