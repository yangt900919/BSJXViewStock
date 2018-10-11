package com.linkpal.map;

import java.util.List;
import java.util.Map;

public interface DisplayMapper {

    List<Map<String,Object>> getDisplayInfo(Map map);
}
