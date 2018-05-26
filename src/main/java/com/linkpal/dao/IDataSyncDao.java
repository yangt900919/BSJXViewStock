package com.linkpal.dao;

import java.util.List;
import java.util.Map;



public interface IDataSyncDao {
	
	/***
	 * 获取ERP单据表头
	 * @param  （RKD，LLD，YH）
	 * @param  （请求入库单或者领料单时，需要传入库管员的名称）
	 * @return
	 */
	public List<Map<String,Object>> getHeadData(Map map) ;
	
	/***
	 * 获取ERP表体数据
	 * @param map
	 * @return
	 */
	public List<Map<String,Object>> getEntryData(Map map);



	/**
	 * 保存从PDA接收的数据
	 * @param map
	 * @return
	 */
	public List<Map<String,Object>> dataSave(Map map);
	

}
