package com.linkpal.Excepetion;

public class UncheckException extends Exception {

    public UncheckException() {
        super("单据未审核，不能下推单据！");
    }

    public UncheckException(String message) {
        super(message);
    }
}
