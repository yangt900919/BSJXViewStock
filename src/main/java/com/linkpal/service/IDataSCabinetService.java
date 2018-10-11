package com.linkpal.service;

import com.linkpal.model.Datascabinet;
import com.linkpal.model.Scabinet;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface IDataSCabinetService extends IBaseService<Datascabinet> {
    public boolean deleteBatch(Integer[] ids);

    public Map<String, Object> getPageList(HttpServletRequest request, Datascabinet t);
}
