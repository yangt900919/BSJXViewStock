package com.linkpal.dao;

import com.linkpal.model.Permission;
import com.linkpal.model.Role;

import java.util.List;
import java.util.Map;

public interface IRoleDao extends  IBaseDao<Role>{

    List<Role> getRoles();

    public void rolepermissionBind(Map map);

    public void deleteRolePermission(int id);
}
