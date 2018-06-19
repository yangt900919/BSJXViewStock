package com.linkpal.dao.impl;

import com.linkpal.dao.IDisplayDao;
import com.linkpal.map.DisplayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("DisplayDaoImpl")
public class DisplayDaoImpl implements IDisplayDao {

    @Autowired
    DisplayMapper displayMapper;

    @Override
    public List<Map<String, Object>> getDisplayInfo(Map map) {
        return displayMapper.getDisplayInfo(map);
    }
}
