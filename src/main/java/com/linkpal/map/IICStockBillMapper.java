package com.linkpal.map;

import com.linkpal.model.ICStockBill;
import com.linkpal.model.ICStockBill;
import com.linkpal.model.ICStockBill;
import com.linkpal.model.Material;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 异常出入库CURD
 * @author Yang
 *
 */
public interface IICStockBillMapper  {

	/***
	 * 获取实体对象
	 * @param ID
	 * @return
	 */
	ICStockBill getById(int ID);



	/**
	 * 新增
	 * @param
	 * @return
	 */
	int add(ICStockBill t);

	/**
	 * 更新
	 * @param
	 * @return
	 */
	int update(ICStockBill t);

	/**
	 * 删除
	 * @param ID
	 * @return
	 */
	int delete(int ID);


	/**
	 * 批量删除
	 * @param IDS
	 * @return
	 */
	int deleteBatch(Integer[] ids);



	/***
	 * 按查询条件获取列表
	 * @param stock
	 * @return
	 */
	List<ICStockBill> getList(Map map);

	/**
	 * 获取查询的所有条数
	 * @param t
	 * @return
	 */

	int getTotalNum(Map map);

	String getAutoNumber();
}
