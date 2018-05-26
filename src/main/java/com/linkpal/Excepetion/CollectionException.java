package com.linkpal.Excepetion;

public class CollectionException extends RollbackException {

    public CollectionException() {
        super("分录行存在修改列不成功，请重新尝试！");
    }

    public CollectionException(String message) {
        super(message);
    }

    public CollectionException(String type, int entryid) {
        super(type + "订单存在第" + entryid + "分录行修改失败，请重新尝试！");
    }
}
