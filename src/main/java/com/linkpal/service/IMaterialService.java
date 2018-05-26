package com.linkpal.service;

import com.linkpal.model.Material;
import com.linkpal.model.Material;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface IMaterialService extends IBaseService<Material>{

    boolean deleteBatch(Integer[] ids);

    Map<String,Object> getPageList(HttpServletRequest request, Material t);
}
