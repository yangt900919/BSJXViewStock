package com.linkpal.service;

import com.linkpal.model.Cabinettype;
import com.linkpal.model.Datacabinettype;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface IDataCabinetTypeService extends IBaseService<Datacabinettype> {
    public boolean deleteBatch(Integer[] ids);

    public Map<String, Object> getPageList(HttpServletRequest request, Datacabinettype t);
}
