package com.linkpal.map;

import com.linkpal.model.Cabinettype;
import com.linkpal.model.Material;
import com.linkpal.model.example.MaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialMapper extends IBaseMapper<Material>{
    long countByExample(MaterialExample example);

    int deleteByExample(MaterialExample example);

    int deleteByPrimaryKey(int fid);

    int insert(Material record);

    int insertSelective(Material record);

    List<Material> selectByExample(MaterialExample example);

    Material selectByPrimaryKey(int fid);

    Material getDetail(String materialnumber);

    int updateByExampleSelective(@Param("record") Material record, @Param("example") MaterialExample example);

    int updateByExample(@Param("record") Material record, @Param("example") MaterialExample example);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);

    List<Material> getTipPageList(int totalSize, int perSize, String fnumber);

    List<Material> getPageList(int totalSize, int perSize);
}