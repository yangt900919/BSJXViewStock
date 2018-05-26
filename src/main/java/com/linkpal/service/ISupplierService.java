package com.linkpal.service;

import com.linkpal.model.Supplier;
import com.linkpal.model.Supplier;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface ISupplierService extends IBaseService<Supplier>{

    boolean deleteBatch(Integer[] ids);

    Map<String,Object> getPageList(HttpServletRequest request, Supplier t);

}
