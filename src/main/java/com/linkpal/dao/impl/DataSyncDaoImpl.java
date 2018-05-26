package com.linkpal.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.linkpal.dao.IDataSyncDao;
import com.linkpal.map.IDataSyncMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("DataSyncDaoImpl")
public class DataSyncDaoImpl  implements IDataSyncDao {

	
	@Autowired
	IDataSyncMapper dataSyncMapper;
	
	@Override
	public List<Map<String, Object>> getHeadData(Map map) {
		// TODO Auto-generated method stub
		return dataSyncMapper.getHeadData(map);
	}

	@Override
	public List<Map<String, Object>> getEntryData(Map map) {
		// TODO Auto-generated method stub
		return dataSyncMapper.getEntryData(map);
	}

	@Override
	public List<Map<String, Object>> dataSave(Map map) {
		return dataSyncMapper.dataSave(map);
	}


}
