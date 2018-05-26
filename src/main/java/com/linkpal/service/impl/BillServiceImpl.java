package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.Excepetion.QuantityOverflowException;
import com.linkpal.Excepetion.UnChangeException;
import com.linkpal.Excepetion.UncheckException;
import com.linkpal.dao.IBillDao;
import com.linkpal.dao.IBillGetDao;
import com.linkpal.model.*;
import com.linkpal.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.util.*;

@Service
public class BillServiceImpl implements IBillService {


    @Autowired
    IBillDao billDao;

    @Override
    public String buildNum() {
        return billDao.buildNum();
    }

    @Override
    public String buildCheckNum() {
        return billDao.buildReceiveNum();
    }

    @Override
    public String buildStockNum() {
        return billDao.buildStockedNum();
    }

    @Override
    public boolean deleteEntry(int fbillid, int fentryid) {
        return false;
    }

    @Override
    public boolean deleteEntry(int fid) {
        return billDao.deleteEntry(fid);
    }

    @Override
    public List<Billentry> getEntries(int fbillid) {
        return billDao.getEntries(fbillid);
    }

    @Override
    public List<Billcheckentry> getCheckEntries(int fbillid) {
        return billDao.getCheckBillentries(fbillid);
    }

    @Override
    public List<Bill> getCurrentUser(int fid) {
        return billDao.getCurrentUser(fid);
    }

    @Override
    public List<Bill> getBills(int userid) {
        List<Bill> bills = billDao.getCurrentUser(userid);
        for (Bill bill : bills) {
            bill.setmEntries(billDao.getEntries(bill.getFbillid()));
        }
        return bills;
    }

    @Override
    public boolean checkPurchaseBill(int fbillid, int userid) {
        try {
            Bill bill = billDao.getDetail(fbillid);
            List<Integer> fids = new ArrayList<>();
            for (Billentry entry : bill.getmEntries()) {
                fids.add(entry.getFid());
            }
            if (billDao.hasReceiveChild(fids) && bill.getFstatus() == 0) {
                bill.setFstatus(1);
                bill.setFchuserid(userid);
                bill.setFcheckdate(new Date());
                return billDao.checkPurchaseBill(bill);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkReceiveBill(int fbillid, int userid) {
        try {
            Billcheck bill = billDao.getReceiveDetail(fbillid);
            List<Integer> fids = new ArrayList<>();
            for (Billcheckentry entry : bill.getmEntries()) {
                fids.add(entry.getFid());
            }
            if (billDao.hasStockChild(fids) && bill.getFstatus() == 0) {
                bill.setFstatus(1);
                bill.setFchuid(userid);
                bill.setFchetime(new Date());
                for (Billcheckentry entry : bill.getmEntries()) {
                    if (entry.getFeligqty() + entry.getFunqty() != entry.getFqty()) {
                        return false;
                    }
                }
            }else {
                return false;
            }
            return billDao.checkReceiveBill(bill);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkStockedBill(int fbillid, int userid) {
        try {
            Billstock bill = billDao.getStockedDetail(fbillid);
            for (Billstockentry entry : bill.getmEntries()) {
                if (entry.getFactqty() != entry.getFqty()){
                    return false;
                }
            }
            if (bill.getFstatus() == 0) {
                bill.setFstatus(1);
                bill.setFchuserid(userid);
                bill.setFchedate(new Date());
                return billDao.checkStockedBill(bill);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean uncheckPurchaseBill(int fbillid, int userid) {
        try {
            Bill bill = billDao.getDetail(fbillid);
            if (bill.getFstatus() == 1 && bill.getFchuserid() == userid) {
                bill.setFstatus(0);
                bill.setFchuserid(null);
                bill.setFcheckdate(null);
                return billDao.checkPurchaseBill(bill);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean uncheckReceiveBill(int fbillid, int userid) {
        try {
            Billcheck bill = billDao.getReceiveDetail(fbillid);
            if (bill.getFstatus() == 1 && userid == bill.getFchuid()) {
                bill.setFstatus(0);
                bill.setFchuid(null);
                bill.setFchetime(null);
            }else if (bill.getFstatus() == 2 && userid == bill.getFchuid()){
                bill.setFstatus(1);
                for (Billcheckentry entry : bill.getmEntries()) {
                    entry.setFeligqty(null);
                    entry.setFunqty(null);
                }
            }
            return billDao.checkReceiveBill(bill);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean uncheckStockedBill(int fbillid, int userid) {
        try {
            Billstock bill = billDao.getStockedDetail(fbillid);
            if (bill.getFstatus() == 1) {
                bill.setFstatus(0);
                bill.setFchuserid(null);
                bill.setFchedate(null);
                return billDao.checkStockedBill(bill);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean createReceiveBill(Billcheck billcheck) throws Exception {
        int supplierid = 0;
        for (Billcheckentry entry : billcheck.getmEntries()) {
            int leftQty = billDao.leaveQtyInReceive(entry.getFoid());
            if (entry.getFqty() <= leftQty){
                throw new QuantityOverflowException(entry.getFentryid(), entry.getfMaterial().getMaterialname(), "收料数量", leftQty);
            }
            Bill bill = billDao.getBillByEntryID(entry.getFoid());
            if (bill.getFstatus() != 1){
                throw new UncheckException();
            }
            if (supplierid == 0){
                 supplierid = bill.getFsupplierid();
            }
            if (supplierid != bill.getFsupplierid()){
                throw new Exception(bill.getFnumber());
            }
        }
        return billDao.createReceiveBill(billcheck);
    }

    @Override
    public boolean createStockedBill(Billstock billstock) throws Exception {
        int supplierid = 0;
        for (Billstockentry entry : billstock.getmEntries()) {
            int leftQty = billDao.leaveQtyInStock(entry.getFoid());
            if (entry.getFqty() <= leftQty){
                throw new QuantityOverflowException(entry.getFentryid(), entry.getMaterial().getMaterialname(), "入库", leftQty);
            }
            Billcheck bill = billDao.getCheckBillByEntryID(entry.getFoid());
            if (bill.getFstatus() != 1){
                throw new UncheckException();
            }
            if (supplierid == 0){
                supplierid = bill.getFsupplierid();
            }
            if (supplierid != bill.getFsupplierid()){
                throw new Exception(bill.getFnumber());
            }
        }
        return billDao.createStockedBill(billstock);
    }

    @Override
    @Transactional
    public boolean updateReceiveQty(int fid, List<Billcheckentry> entries) throws Exception {
        Billcheck billcheck = billDao.getReceiveDetail(entries.get(0).getFbillid());
        if(billcheck.getFstatus() == 0){
            return billDao.updateReceiveBillentryOnlyQty(billcheck);
        }else if(billcheck.getFstatus() == 1){
            billcheck.setFstatus(2);
            return billDao.updateReceiveBillentryAfterCheck(billcheck);
        }else {
            throw new UnChangeException();
        }
    }

    @Override
    @Transactional
    public boolean updateStockedQty(int fid, List<Billstockentry> entries) throws Exception {
        Billstock billstock = billDao.getStockedDetail(entries.get(0).getFbillid());
        billstock.setmEntries(entries);
        if (billstock.getFstatus() == 0) {
            return billDao.updateStockedBill(billstock);
        }else {
            throw new UnChangeException();
        }
    }

    @Override
    public boolean deleteCheckBill(int fid) throws Exception{
        List<Integer> fentryids = new ArrayList<>();
        List<Billcheckentry> entries = billDao.getCheckBillentries(fid);
        int length = entries.size();
        for (int i = 0; i < length; i++) {
            fentryids.add(entries.get(i).getFid());
        }
        Billcheck bill;
        if (billDao.hasStockChild(fentryids) && (bill = billDao.getReceiveDetail(fid)) != null && bill.getFstatus() == 0){
            return billDao.deleteCheckBill(fid);
        }
        return false;
    }

    @Override
    public boolean deleteStockBill(int fid) throws Exception {
        Billstock bill;
        if ((bill = billDao.getStockedDetail(fid)) != null && bill.getFstatus() == 0){
            return billDao.deleteStockBill(fid);
        }
        return false;
    }

    @Override
    public List<Billcheck> getCheckBills() {
        List<Billcheck> bills = billDao.getCheckBills();
        for (Billcheck bill : bills) {
            bill.setmEntries(billDao.getCheckBillentries(bill.getFid()));
        }
        return bills;
    }

    @Override
    public Billcheck getCheckBill(int fid) {
        Billcheck bill = billDao.getReceiveDetail(fid);
        bill.setmEntries(billDao.getCheckBillentries(bill.getFid()));
        return bill;
    }

    @Override
    public List<Billstock> getStockBills() {
        List<Billstock> bills = billDao.getStockBills();
        for (Billstock bill : bills) {
            bill.setmEntries(billDao.getStockBillentries(bill.getFid()));
        }
        return bills;
    }

    @Override
    public List<Billstock> getStockBills(int userid) {
        List<Billstock> bills = billDao.getStockBills(userid);
        for (Billstock bill : bills) {
            bill.setmEntries(billDao.getStockBillentries(bill.getFid()));
        }
        return bills;
    }

    @Override
    public Billstock getStockBill(int fid) {
        Billstock bill = billDao.getStockedDetail(fid);
        bill.setmEntries(billDao.getStockBillentries(bill.getFid()));
        return bill;
    }

    @Override
    public int getReceiveQtySum(int foid) {
        return billDao.getReceiveQtySum(foid);
    }

    @Override
    public int getUnQtySum(int foid) {
        return billDao.getUnQtySum(foid);
    }

    @Override
    public int getStockQtySum(int foid) {
        return billDao.getStockQtySum(foid);
    }

    @Override
    public Map<String, Object> getBillcheckPageList(HttpServletRequest request, Map map) {
        Map m=new HashMap();
        List<Billcheck> list=new ArrayList<>();
        if(request!=null) {
            String pageNow = request.getParameter("pageNow");
            String condition = request.getParameter("condition");
            HttpSession session = request.getSession();
            if (condition == null || "".equals(condition)) {
                session.setAttribute("Billcheck", map);
            } else {
                map = (Map) session.getAttribute("Billget");
            }
            Page page = null;
            int totalCount = billDao.getBillcheckTotalNum(map);
            if (pageNow != null) {
                page = new Page(totalCount, Integer.parseInt(pageNow));
            } else {
                page = new Page(totalCount, 1);
            }
            map.put("pageIndex", page.getStartPos());
            map.put("pageSize", page.getPageSize());
            list = billDao.getBillcheckList(map);
            m.put("list", list);
            m.put("page", page);
            m.put("model", map);
        }
        return m;
    }

    @Override
    public boolean BillcheckdeleteBatch(Integer[] ids) {
        return billDao.BillcheckdeleteBatch(ids);
    }

    @Override
    public Bill getDetail(int fbillid) {
        return billDao.getDetail(fbillid);
    }

    @Override
    public boolean create(Bill bill) throws Exception{
        return billDao.create(bill);
    }

    @Override
    public boolean update(Bill bill) throws Exception {
        if (billDao.getDetail(bill.getFbillid()).getFstatus() == 0) {
            return billDao.update(bill);
        }else {
            throw new UnChangeException();
        }
    }

    @Override
    public boolean delete(int fid) throws Exception {
        List<Integer> fentryids = new ArrayList<>();
        List<Billentry> entries = billDao.getEntries(fid);
        int length = entries.size();
        for (int i = 0; i < length; i++) {
            fentryids.add(entries.get(i).getFid());
        }
        if (billDao.hasReceiveChild(fentryids) && billDao.getDetail(fid).getFstatus() == 0) {
            return billDao.delete(fid);
        }
        return false;
    }

    @Override
    public List<Bill> getList() {
        List<Bill> bills = billDao.getBills();
        int size = bills.size();
        for (int i = 0; i < size; i++) {
            Bill bill = bills.get(i);
            bill.setmEntries(billDao.getEntries(bill.getFbillid()));
            bills.set(i, bill);
        }
        return bills;
    }

    @Override
    public Bill getDetail(String fnumber) {
        return billDao.getDetail(fnumber);
    }

    @Override
    public List<Bill> getTipList(String fnumber) {
        List<Bill> bills = billDao.getTipList(fnumber);
        int size = bills.size();
        for (int i = 0; i < size; i++) {
            Bill bill = bills.get(i);
            bill.setmEntries(billDao.getEntries(bill.getFbillid()));
            bills.set(i, bill);
        }
        return bills;
    }

    @Override
    public List<Bill> showCurrentPage(Page page) {
        int totalSize = page.getPageNow() * page.getPageSize();
        List<Bill> bills = billDao.showCurrentPage(totalSize, totalSize - page.getPageSize());
        return bills;
    }

    @Override
    public List<Bill> showTipPageList(String fnumber, Page page) {
        int totalSize = page.getPageNow() * page.getPageSize();
        List<Bill> bills = billDao.showTipPageList(fnumber, totalSize, totalSize - page.getPageSize());
        return bills;
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Bill bill, int insertType) throws ImportException {

    }
}
