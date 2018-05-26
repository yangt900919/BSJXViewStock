package com.linkpal.Excepetion;

public class NullParameterException extends RollbackException {

    public NullParameterException() {
        super("参数不能为空！");
    }

    public NullParameterException(String message) {
        super(message);
    }

    public NullParameterException(int entryid) {
        super("第" + entryid + "行分录数量不能为空");
    }

    public NullParameterException(int entryid, String column) {
        super("第" + entryid + "行分录" + column + "不能为空");
    }

}
