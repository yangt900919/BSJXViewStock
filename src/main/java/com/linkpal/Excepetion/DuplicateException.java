package com.linkpal.Excepetion;

public class DuplicateException extends RollbackException {

    public DuplicateException() {
        super("数据重复！");
    }

    public DuplicateException(String message) {
        super(message);
    }
}
