package com.linkpal.service;

import com.linkpal.model.Custom;
import com.linkpal.model.Custom;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface ICustomService extends IBaseService<Custom>{

    boolean deleteBatch(Integer[] ids);

     Map<String,Object> getPageList(HttpServletRequest request, Custom t);

}
