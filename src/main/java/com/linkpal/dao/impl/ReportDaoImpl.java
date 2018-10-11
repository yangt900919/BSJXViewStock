package com.linkpal.dao.impl;

import com.linkpal.dao.IReportDao;
import com.linkpal.map.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ReportDaoImpl implements IReportDao {

    @Autowired
    ReportMapper reportMapper;

    @Override
    public List<Map<String, Object>> getList(Map map) {
        return reportMapper.getList(map);
    }

    @Override
    public List<Map<String, Object>> getReportList(Map map) {
        return reportMapper.getReportList(map);
    }
}
