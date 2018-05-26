package com.linkpal.Excepetion;

public class UnChangeException extends Exception {
    public UnChangeException() {
        super("单据已审核，无法进行相关操作！");
    }

    public UnChangeException(String message) {
        super(message);
    }
}
