package com.linkpal.map;

import com.linkpal.model.Cabinettype;
import com.linkpal.model.Organization;
import com.linkpal.model.example.OrganizationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrganizationMapper extends IBaseMapper<Organization>{
    long countByExample(OrganizationExample example);

    int deleteByExample(OrganizationExample example);

    int deleteByPrimaryKey(int fid);

    int insert(Organization record);

    int insertSelective(Organization record);

    List<Organization> selectByExample(OrganizationExample example);

    Organization selectByPrimaryKey(int fid);

    int updateByExampleSelective(@Param("record") Organization record, @Param("example") OrganizationExample example);

    int updateByExample(@Param("record") Organization record, @Param("example") OrganizationExample example);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);

    Organization getDetail(String organizationnumber);

    List<Organization> getTipPageList(int totalSize, int perSize, String fnumber);

    List<Organization> getPageList(int totalSize, int perSize);
}