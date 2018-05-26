package com.linkpal.Excepetion;

public class SupplierNotEqualsException extends Exception{

    public SupplierNotEqualsException() {
    }

    public SupplierNotEqualsException(String message) {
        super("单据" + message + "的供应商与前面的供应商不一致，不能下推为同一个采购订单！");
    }
}
