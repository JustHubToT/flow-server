package com.flow.service.impl;

import com.flow.common.CommonInfo;
import com.flow.dao.SysUserMapper;
import com.flow.model.SysUser;
import com.flow.service.SysUserService;
import com.flow.utils.EncryptUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUser.setIsValid(CommonInfo.IS_VALID_NO);
        return updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public int insertSelective(SysUser record) {
        String s = EncryptUtil.md5(record.getPassword());
        record.setPassword(s);
        return userMapper.insertSelective(record);
    }

    @Override
    public SysUser selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<SysUser> selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAll();
    }
}
