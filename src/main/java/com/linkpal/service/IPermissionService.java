package com.linkpal.service;

import com.linkpal.model.Cabinettype;
import com.linkpal.model.Permission;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface IPermissionService extends IBaseService<Permission> {
    public boolean deleteBatch(Integer[] ids);

    public Map<String, Object> getPageList(HttpServletRequest request, Permission t);
}
