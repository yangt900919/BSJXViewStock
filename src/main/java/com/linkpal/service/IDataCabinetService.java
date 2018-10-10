package com.linkpal.service;

import com.linkpal.model.Cabinet;
import com.linkpal.model.Datacabinet;
import com.linkpal.model.Datascabinet;
import com.linkpal.model.Scabinet;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface IDataCabinetService extends IBaseService<Datacabinet> {

    public boolean deleteBatch(Integer[] ids);

    public Map<String,Object> getPageList(HttpServletRequest request, Datacabinet t);

    List<Datascabinet> getScabinetList(Integer fid);

}
