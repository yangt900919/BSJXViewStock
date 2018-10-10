package com.linkpal.service;

import com.linkpal.model.Datardataseat;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface IDataRDataseatService extends IBaseService<Datardataseat> {
    public boolean deleteBatch(Integer[] ids);

    public Map<String,Object> getPageList(HttpServletRequest request, Datardataseat t);


}
