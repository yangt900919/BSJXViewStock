package com.linkpal.Excepetion;

public class SQLException extends RollbackException {

    public SQLException() {
        super("数据库异常，请联系后台管理人员进行处理！");
    }

    public SQLException(String message) {
        super(message);
    }
}
