package com.linkpal.service;

import com.linkpal.model.Cabinet;
import com.linkpal.model.Scabinet;
import org.apache.poi.ss.formula.functions.T;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface ICabinetService extends IBaseService<Cabinet> {

    public boolean deleteBatch(Integer[] ids);

    public Map<String,Object> getPageList(HttpServletRequest request, Cabinet t);

    List<Scabinet> getScabinetList(Integer fid);

}
