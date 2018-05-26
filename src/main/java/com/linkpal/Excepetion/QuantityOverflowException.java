package com.linkpal.Excepetion;

public class QuantityOverflowException extends RollbackException {

    public QuantityOverflowException() {
        super("下推数量有误，请重新检查数量！");
    }

    public QuantityOverflowException(String message) {
        super(message);
    }

    public QuantityOverflowException(int entryid, String type, String name, int qty) {
        super("第" + entryid + "行" + name +  type + "数量不能超过：" + qty);
    }
}
