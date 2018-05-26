package com.linkpal.service;

import com.linkpal.model.Permission;
import com.linkpal.model.Scabinet;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface ISCabinetService extends IBaseService<Scabinet> {
    public boolean deleteBatch(Integer[] ids);

    public Map<String, Object> getPageList(HttpServletRequest request, Scabinet t);
}
