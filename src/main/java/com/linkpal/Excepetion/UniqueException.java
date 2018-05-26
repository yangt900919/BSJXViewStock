package com.linkpal.Excepetion;

public class UniqueException extends RollbackException{

    public UniqueException(String message) {
        super(message);
    }

    public UniqueException() {
        super("违反唯一约束，请检查ID序列。");
    }
}
