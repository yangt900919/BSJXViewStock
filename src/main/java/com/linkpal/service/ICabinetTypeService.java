package com.linkpal.service;

import com.linkpal.model.Cabinet;
import com.linkpal.model.Cabinettype;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface ICabinetTypeService extends IBaseService<Cabinettype> {
    public boolean deleteBatch(Integer[] ids);

    public Map<String, Object> getPageList(HttpServletRequest request, Cabinettype t);
}
