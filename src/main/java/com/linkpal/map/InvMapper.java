package com.linkpal.map;

import com.linkpal.model.Inv;
import com.linkpal.model.InvExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InvMapper {
    long countByExample(InvExample example);

    int deleteByExample(InvExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Inv record);

    int insertSelective(Inv record);

    List<Inv> selectByExample(InvExample example);

    Inv selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Inv record, @Param("example") InvExample example);

    int updateByExample(@Param("record") Inv record, @Param("example") InvExample example);

    int updateByPrimaryKeySelective(Inv record);

    int updateByPrimaryKey(Inv record);

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

    /***
     * 按查询条件获取列表
     * @param stock
     * @return
     */
    public List<Inv> getList(@Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize,@Param("t")Inv t);

    /**
     * 获取查询的所有条数
     * @param t
     * @return
     */
    public int getTotalNum(Inv t);
}