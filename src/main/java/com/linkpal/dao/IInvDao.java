package com.linkpal.dao;

import com.linkpal.model.Inv;

public interface IInvDao extends IBaseDao<Inv> {
    /**
     * 关闭方案
     * @param ID
     * @return
     */
    public int close(int ID);


    /**
     * 批量关闭
     * @param IDS
     * @return
     */
    public int closeBatch(Integer[] ids);



}
