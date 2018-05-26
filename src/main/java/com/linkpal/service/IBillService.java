package com.linkpal.service;

import com.linkpal.model.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface IBillService extends IBaseService<Bill>{

    String buildNum();

    /**
     * 生成收料/请检单单号
     * @return
     */
    String buildCheckNum();

    /**
     * 生成入库单单号
     * @return
     */
    String buildStockNum();

    /**
     * 删除采购单单据分录
     * @param fbillid    内码
     * @param fentryid   分录
     * @return
     */
    boolean deleteEntry(int fbillid, int fentryid) throws Exception;

    /**
     * 删除采购单单据分录
     * @param fid    分录内码
     * @return
     */
    boolean deleteEntry(int fid) throws Exception;

    /**
     * 获取采购订单的所有分录
     * @param fbillid 单据内码
     * @return
     */
    List<Billentry> getEntries(int fbillid);

    /**
     * 获取收料/请检单的所有分录
     * @param fbillid 单据内码
     * @return
     */
    List<Billcheckentry> getCheckEntries(int fbillid);

    /**
     * 获取当前用户下的所有采购订单表头列表
     * @param fid   userid
     * @return
     */
    List<Bill> getCurrentUser(int fid);

    /**
     * 获取当前用户下的所有采购订单详细列表
     * @param userid    userid
     * @return
     */
    List<Bill> getBills(int userid);

    /**
     * 审核采购订单
     * @param fbillid   单据内码
     * @param userid    审核用户
     * @return
     */
    boolean checkPurchaseBill(int fbillid, int userid) throws Exception;

    /**
     * 审核收料/请检单，并反填采购订单的收料数量
     * @param fbillid   单据内码
     * @param userid    审核用户
     * @return
     */
    boolean checkReceiveBill(int fbillid, int userid) throws Exception;

    /**
     * 审核入库单，并反填采购订单的入库数量
     * @param fbillid   单据内码
     * @param userid    审核用户
     * @return
     */
    boolean checkStockedBill(int fbillid, int userid) throws Exception;

    /**
     * 反审核采购订单
     * @param fbillid   单据内码
     * @param userid    审核用户
     * @return
     */
    boolean uncheckPurchaseBill(int fbillid, int userid) throws Exception;

    /**
     * 反审核收料/请检单，并扣减收料数量和退料数量（逐级反审核并扣减）
     * @param fbillid   单据内码
     * @param userid    反审核用户
     * @return
     */
    boolean uncheckReceiveBill(int fbillid, int userid) throws Exception;

    /**
     * 反审核入库单，并扣减入库数量
     * @param fbillid   单据内码
     * @param userid    反审核用户
     * @return
     */
    boolean uncheckStockedBill(int fbillid, int userid) throws Exception;

    /**
     * 下推生成收料请检通知单
     * @param bill          收料通知请检单
     * @return
     */
    boolean createReceiveBill(Billcheck bill) throws Exception ;

    /**
     * 下推生成入库单
     * @param billstock 入库单
     * @return
     */
    boolean createStockedBill(Billstock billstock) throws Exception;

    /**
     * 修改收料通知请检单的收料数量，如果是已审核状态
     * @param fid           收料通知请检单内码ID
     * @param entries       收料通知请检单分录行
     * @return
     */
    boolean updateReceiveQty(int fid, List<Billcheckentry> entries) throws Exception;

    /**
     * 修改收料入库单的可入库数量
     * @param fid           入库单内码ID
     * @param entries       入库单分录集合
     * @return
     */
    boolean updateStockedQty(int fid, List<Billstockentry> entries) throws Exception;

//    /**
//     * 填写收料通知请检单的合格和不合格数量，并反填采购订单的不合格数量
//     * @param fid           收料通知请检单内码ID
//     * @param entries       收料通知请检单分录行
//     * @return
//     */
//    boolean updateEligibleQty(int fid, List<Billcheckentry> entries);

    /**
     * 删除生成的收料通知请检单
     * @param fid       收料通知请检单内码ID
     * @return
     */
    boolean deleteCheckBill(int fid) throws Exception;

    /**
     * 删除生成的入库单
     * @param fid       入库单内码ID
     * @return
     */
    boolean deleteStockBill(int fid) throws Exception;

    /**
     * 获取收料通知请检单单据集合（含分录）
     * @return
     */
    List<Billcheck> getCheckBills();

    /**
     * 获取指定的收料通知请检单单据详情
     * @param fid
     * @return
     */
    Billcheck getCheckBill(int fid);

    /**
     * 获取入库单单据集合（含分录）
     * @return
     */
    List<Billstock> getStockBills();

    /**
     * 获取入库单单据集合（含分录）
     * @param userid    库管员ID
     * @return
     */
    List<Billstock> getStockBills(int userid);

    /**
     * 获取入库单详情
     * @param fid       入库单内码ID
     * @return
     */
    Billstock getStockBill(int fid);

    /**
     * 获取采购订单的一个分录下的所有下有单据（收料通知请检单）的数量和
     * @param foid 原单（采购订单分录）内码ID
     * @return
     */
    int getReceiveQtySum(int foid);

    /**
     * 获取采购订单的一个分录下的所有下有单据（收料通知请检单）的不合格数量（退货数量）和
     * @param foid 原单（采购订单分录）内码ID
     * @return
     */
    int getUnQtySum(int foid);

    /**
     * 获取收料通知请检单的一个分录下的所有下有单据（入库单）的入库数量（退货数量）和
     * @param foid 原单（采购订单分录）内码ID
     * @return
     */
    int getStockQtySum(int foid);


    /**
     * 获取分页信息
     * @param request
     * @return
     */
    public Map<String,Object> getBillcheckPageList(HttpServletRequest request, Map map);
    /*
     *//**
     * 获取查询的所有条数
     * @param
     * @return
     *//*
    public int getTotalNum(Map map);*/

    public boolean BillcheckdeleteBatch(Integer[] ids);
}
