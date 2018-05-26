package com.linkpal.Excepetion;

public class ImportException extends RollbackException {

    public ImportException(String message)
    {
        super(message);
    }
   /* public ImportException(String type,String message,int seq)
    {
       super(type+"基础资料导入第"+seq+"行"+message);
    }*/
}
