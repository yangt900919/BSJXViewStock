package com.linkpal.service.impl;

import com.linkpal.dao.IReportDao;
import com.linkpal.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements IReportService {

    @Autowired
    @Qualifier("reportDaoImpl")
    IReportDao reportDao;

    @Override
    public List<Map<String, Object>> getList(Map map) {
        return reportDao.getList(map);
    }

    @Override
    public List<Map<String, Object>> getReportList(Map map) {
        return reportDao.getReportList(map);
    }
}
