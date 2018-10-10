package com.linkpal.dao;

import java.util.List;
import java.util.Map;

public interface IReportDao {
    List<Map<String,Object>> getList(Map map);

    List<Map<String,Object>> getReportList(Map map);
}
