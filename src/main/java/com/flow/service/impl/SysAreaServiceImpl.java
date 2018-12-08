package com.flow.service.impl;

import com.flow.dao.SysAreaMapper;
import com.flow.model.SysArea;
import com.flow.service.SysAreaService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysAreaServiceImpl implements SysAreaService {

    @Autowired
    private SysAreaMapper areaMapper;

    @Override
    public int deleteByPrimaryKey(String areaCode) {
        return areaMapper.deleteByPrimaryKey(areaCode);
    }

    @Override
    public int insertSelective(SysArea record) {
        return areaMapper.insertSelective(record);
    }

    @Override
    public SysArea selectByPrimaryKey(String areaCode) {
        return areaMapper.selectByPrimaryKey(areaCode);
    }

    @Override
    public int updateByPrimaryKeySelective(SysArea record) {
        return areaMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<SysArea> selectByParentCode(String parentCode) {
        return areaMapper.selectByParentCode(parentCode);
    }

    @Override
    public List<SysArea> selectAll(int pageNum, int pageSize) {
        // 分页
        PageHelper.startPage(pageNum, pageSize);
        return areaMapper.selectAll();
    }

    @Override
    public int insertBatch(List<SysArea> sysAreas) {
        return areaMapper.insertBatch(sysAreas);
    }
}
