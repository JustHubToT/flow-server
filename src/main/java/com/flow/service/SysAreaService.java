package com.flow.service;

import com.flow.model.SysArea;
import com.flow.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysAreaService {
    int deleteByPrimaryKey(String areaCode);

    int insertSelective(SysArea record);

    SysArea selectByPrimaryKey(String areaCode);

    int updateByPrimaryKeySelective(SysArea record);

    List<SysArea> selectByParentCode(String parentCode);

    List<SysArea> selectAll(int pageNum, int pageSize);

    int insertBatch(@Param("lists") List<SysArea> sysAreas);
}
