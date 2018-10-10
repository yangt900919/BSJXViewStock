package com.linkpal.map;

import java.util.List;
import java.util.Map;


public interface ReportMapper {

    List<Map<String,Object>> getList(Map map);

    List<Map<String,Object>> getReportList(Map map);
}
