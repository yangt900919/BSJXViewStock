package com.linkpal.dao;

import com.linkpal.model.*;

import java.util.List;
import java.util.Map;

public interface IBillDao extends IBaseDao<Bill>{

    String buildNum();

    /**
     * 生成采购订单编号
     * @return
     */
    String buildReceiveNum();

    /**
     * 生成入库单编号
     * @return
     */
    String buildStockedNum();

    /**
     * 删除指定采购订单分录
     * @param fid 分录内码ID
     * @return
     */
    boolean deleteEntry(int fid);

    /**
     * 获取当前订单下的所有订单分录
     * @param fbillid
     * @return
     */
    List<Billentry> getEntries(int fbillid);

    /**
     * 获取当前用户下的采购订单
     * @param fid
     * @return
     */
    List<Bill> getCurrentUser(int fid);

    /**
     * 获取采购订单详情
     * @param fbillid   采购订单详情内码ID
     * @return
     */
    Bill getDetail(int fbillid);

    /**
     * 获取收料通知请检单详情
     * @param fbillid   收料通知请检单内码ID
     * @return
     */
    Billcheck getReceiveDetail(int fbillid);

    /**
     * 获取入库单详情
     * @param fbillid   入库单内码ID
     * @return
     */
    Billstock getStockedDetail(int fbillid);

    /**
     * 是否存在下游单据收料通知请检单
     * @param fentriesid    上游单据采购订单的分录内码ID
     * @return
     */
    boolean hasReceiveChild(List<Integer> fentriesid);

    /**
     * 是否存在下游单据入库单
     * @param fentriesid    上游单据收料通知请检单的分录内码ID
     * @return
     */
    boolean hasStockChild(List<Integer> fentriesid);

    /**
     * 获取所有的采购订单
     * @return
     */
    List<Bill> getBills();

    /**
     * 获取当前收料通知请检单单据所有分录
     * @param fbillid   收料通知请检单单据内码ID
     * @return
     */
    List<Billcheckentry> getCheckBillentries(int fbillid);

    /**
     * 获取当前入库单据所有分录
     * @param fbillid   入库单单据内码ID
     * @return
     */
    List<Billstockentry> getStockBillentries(int fbillid);

    /**
     * 审核采购订单
     * @param bill      采购订单单据内码ID
     * @return
     */
    boolean checkPurchaseBill(Bill bill);

    /**
     * 审核收料通知请检单，并反填采购订单的收料数量
     * @param bill      收料通知请检单内码ID
     * @return
     */
    boolean checkReceiveBill(Billcheck bill) throws Exception;

    /**
     * 审核入库单，并反填采购订单的入库数量
     * @param bill      入库单内码ID
     * @return
     */
    boolean checkStockedBill(Billstock bill) throws Exception;

    /**
     * 下推生成收料通知请检单
     * @param billcheck     收料通知请检单详情
     * @return
     */
    boolean createReceiveBill(Billcheck billcheck) throws Exception ;

    /**
     * 下推生成入库单
     * @param billstock     入库单详情
     * @return
     */
    boolean createStockedBill(Billstock billstock) throws Exception;

    /**
     * 生成并保存收料通知请检单，并补全除合格和不合格数量外的所有信息
     * @param bill  收料通知请检单
     * @return
     */
    boolean updateReceiveBillentryOnlyQty(Billcheck bill) throws Exception;

    /**
     * 检验收料通知请检单，填写合格和不合格数量并反填采购订单的退料数量
     * @param bill  收料通知请检单
     * @return
     */
    boolean updateReceiveBillentryAfterCheck(Billcheck bill) throws Exception;

    /**
     * 获取所有状态下收料通知请检单数量
     * @param foid  采购订单分录内码ID
     * @return
     */
    int leaveQtyInReceive(int foid);

    /**
     * 获取所有状态下的入库单数量
     * @param foid  收料通知请检单分录内码ID
     * @return
     */
    int leaveQtyInStock(int foid);

    /**
     * 对入库单的数量进行填写并反填采购订单的入库数量
     * @param billstock 入库单详情
     * @return
     */
    boolean updateStockedBill(Billstock billstock) throws Exception ;

    /**
     * 删除入库单
     * @param fid   入库单内码ID
     * @return
     */
    boolean deleteStockBill(int fid) throws Exception;

    /**
     * 删除收料通知请检单
     * @param fid   收料通知请检单内码ID
     * @return
     */
    boolean deleteCheckBill(int fid) throws Exception;

    /**
     * 获取所有收料通知请检单
     * @return
     */
    List<Billcheck> getCheckBills();

    /**
     * 获取所有的入库单
     * @return
     */
    List<Billstock> getStockBills();

    /**
     * 获取所有的入库单
     * @return
     */
    List<Billstock> getStockBills(int userid);

    /**
     * 获取指定采购订单分录下的所有收料通知请检单收料数量之和（所有状态）
     * @param foid  采购订单分录内码ID
     * @return
     */
    int getReceiveQtySum(int foid);

    /**
     * 获取指定采购订单分录下的所有收料通知请检单不合格料数量之和（已检验状态下）
     * @param foid  采购订单分录内码ID
     * @return
     */
    int getUnQtySum(int foid);

    /**
     * 获取指定收料通知请检单分录下的所有入库单入库数量之和（审核状态下）
     * @param foid  收料通知请检单分录内码ID
     * @return
     */
    int getStockQtySum(int foid);

    /**
     * 根据采购订单的分录ID获取单据头
     * @return
     */
    Bill getBillByEntryID(int fidInEntry);


    /**
     * 根据收料通知请检单的分录ID获取单据头
     * @return
     */
    Billcheck getCheckBillByEntryID(int fidInEntry);

    List<Billcheck> getBillcheckList(Map map);

    int getBillcheckTotalNum(Map map);

    public boolean BillcheckdeleteBatch(Integer[] ids);

    List<Billstock> getBillstockList(Map map);

    int getBillstockTotalNum(Map map);

    public boolean BillstockdeleteBatch(Integer[] ids);

    List<Bill> getBillList(Map map);

    int getBillTotalNum(Map map);

    public boolean BilldeleteBatch(Integer[] ids);
}
