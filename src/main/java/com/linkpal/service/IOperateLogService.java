package com.linkpal.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface IOperateLogService {

    Map<String,Object> getPageList(HttpServletRequest request, Map map);

}
