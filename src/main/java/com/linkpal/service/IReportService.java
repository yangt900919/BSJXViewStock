package com.linkpal.service;

import java.util.List;
import java.util.Map;

public interface IReportService {
    List<Map<String,Object>> getList(Map map);

    List<Map<String,Object>> getReportList(Map map);
}
