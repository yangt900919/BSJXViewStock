package com.linkpal.service;

import com.linkpal.model.Inv;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface IInvService extends IBaseService<Inv> {
    public boolean deleteBatch(Integer[] ids);

    public Map<String, Object> getPageList(HttpServletRequest request, Inv t);

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
