package com.linkpal.map;

import com.linkpal.model.Userrrole;
import com.linkpal.model.example.UserrroleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserrroleMapper {
    long countByExample(UserrroleExample example);

    int deleteByExample(UserrroleExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Userrrole record);

    int insertSelective(Userrrole record);

    List<Userrrole> selectByExample(UserrroleExample example);

    Userrrole selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Userrrole record, @Param("example") UserrroleExample example);

    int updateByExample(@Param("record") Userrrole record, @Param("example") UserrroleExample example);

    int updateByPrimaryKeySelective(Userrrole record);

    int updateByPrimaryKey(Userrrole record);
}