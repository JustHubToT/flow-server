package com.flow.service;

import com.flow.model.SysUser;

import java.util.List;

public interface SysUserService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    List<SysUser> selectAll(int pageNum, int pageSize);
}
