package com.linkpal.service;

import com.linkpal.model.Permission;
import com.linkpal.model.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface IRoleService extends IBaseService<Role> {

    List<Role> getRoles();

    public boolean deleteBatch(Integer[] ids);

    public Map<String, Object> getPageList(HttpServletRequest request, Role t);

    public void rolepermissionBind(int ID, Integer[] ids);

}
