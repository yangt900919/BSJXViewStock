package com.linkpal.service;

import com.linkpal.model.Organization;
import com.linkpal.model.Organization;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface IOrganizationService extends IBaseService<Organization>{
    boolean deleteBatch(Integer[] ids);

    Map<String,Object> getPageList(HttpServletRequest request, Organization t);
}
