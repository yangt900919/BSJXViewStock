package com.linkpal.Excepetion;

public class DeleteException extends RollbackException {

    public DeleteException(String message) {
        super(message);
    }

    public DeleteException() {
        super("单据删除出错，请重新尝试！");
    }

//    public DeleteException(int entryid) {
//        super("单据第" + entryid + "分录保存/修改出错，请重新尝试！");
//    }
}
