package com.linkpal.map;

import com.linkpal.dao.IBaseDao;
import com.linkpal.model.Rolerpermission;
import com.linkpal.model.example.RolerpermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolerpermissionMapper extends IBaseMapper<Rolerpermission>{
    long countByExample(RolerpermissionExample example);

    int deleteByExample(RolerpermissionExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Rolerpermission record);

    int insertSelective(Rolerpermission record);

    List<Rolerpermission> selectByExample(RolerpermissionExample example);

    Rolerpermission selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Rolerpermission record, @Param("example") RolerpermissionExample example);

    int updateByExample(@Param("record") Rolerpermission record, @Param("example") RolerpermissionExample example);

    int updateByPrimaryKeySelective(Rolerpermission record);

    int updateByPrimaryKey(Rolerpermission record);
}