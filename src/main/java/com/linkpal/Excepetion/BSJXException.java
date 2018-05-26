package com.linkpal.Excepetion;

import java.sql.SQLException;

public class BSJXException {

    public static Exception throwException(SQLException ex){
        String msg = ex.getCause().getMessage();
        if (msg != null){
            int begin = msg.indexOf("(");
            int end = msg.indexOf(")");
            String column = msg.substring(begin, end + 1);
            if (msg.contains("ORA-00904")){
                return new com.linkpal.Excepetion.SQLException(ex.getMessage());
            }
            if (msg.contains("ORA-01400")){
                return new NullParameterException(column + "不能为空！");
            }
            if (msg.contains("ORA-00001")){
                return new UniqueException(column + "重复，请重新生成！");
            }
            if (msg.contains("ORA-01422")){
                return new DuplicateException("存在重复数据：" + column);
            }
        }
        return new Exception();
    }
}
