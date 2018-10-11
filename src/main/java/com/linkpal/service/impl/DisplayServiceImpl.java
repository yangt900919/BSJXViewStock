package com.linkpal.service.impl;

import com.linkpal.dao.IDisplayDao;
import com.linkpal.service.IDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DisplayServiceImpl implements IDisplayService {

    @Autowired
            @Qualifier("DisplayDaoImpl")
    IDisplayDao displayDao;

    @Override
    public List<Map<String, Object>> getDisplayInfo(Map map) {
        return displayDao.getDisplayInfo(map);
    }
}
