package com.linkpal.service;

import java.util.List;
import java.util.Map;




public interface IDataSyncService {
	

	/***
	 * 发送数据
	 * @param map
	 * @return
	 */
	public List<Map<String,Object>> Send(Map map) ;
	
	/***
	 * 接收数据
	 * @param
	 * @return
	 */
	public List<Map<String,Object>> Receive(Map map);
	

}
