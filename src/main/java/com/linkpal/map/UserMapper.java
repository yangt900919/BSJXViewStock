package com.linkpal.map;

import com.linkpal.model.User;
import com.linkpal.model.example.UserExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserMapper extends IBaseMapper<User>{
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    List<User> getTipPageList(int totalSize, int perSize, String fnumber);

    List<User> getPageList(int totalSize, int perSize);

    public int deleteRoleUser(int id);

    public void roleuserBind(Map map);

    public void deleteUserERPStock(int id);

    public void saveUserErpStock(Map map);
}