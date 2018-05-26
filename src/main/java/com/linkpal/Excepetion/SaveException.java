package com.linkpal.Excepetion;

public class SaveException extends RollbackException {

    public SaveException(String message) {
        super(message);
    }

    public SaveException() {
        super("单据保存/修改出错，请重新尝试！");
    }

    public SaveException(int entryid) {
        super("单据第" + entryid + "分录保存/修改出错，请重新尝试！");
    }
}
