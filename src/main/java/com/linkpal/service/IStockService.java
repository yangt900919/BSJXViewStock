package com.linkpal.service;

import com.linkpal.model.Scabinet;
import com.linkpal.model.Stock;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface IStockService extends IBaseService<Stock>{


    public boolean deleteBatch(Integer[] ids);

    public Map<String, Object> getPageList(HttpServletRequest request, Stock t);
}
