package com.linkpal.dao;

import java.util.List;
import java.util.Map;

public interface IDisplayDao {

    public List<Map<String,Object>> getDisplayInfo(Map map);
}
