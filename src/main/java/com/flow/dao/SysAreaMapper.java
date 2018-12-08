package com.flow.dao;

import com.flow.model.SysArea;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysAreaMapper {
    int deleteByPrimaryKey(String areaCode);

    int insertSelective(SysArea record);

    SysArea selectByPrimaryKey(String areaCode);

    int updateByPrimaryKeySelective(SysArea record);

    List<SysArea> selectByParentCode(String parentCode);

    List<SysArea> selectAll();

    int insertBatch(@Param("lists") List<SysArea> sysAreas);
}