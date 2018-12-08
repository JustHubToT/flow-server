package com.flow.controller;

import com.flow.model.SysArea;
import com.flow.service.SysAreaService;
import com.flow.utils.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/sys/area")
public class SysAreaController {

    @Autowired
    private SysAreaService areaService;

    @GetMapping("{areaCode}")
    public SysArea queryArea(@PathVariable String areaCode){
        log.info("根据areaCode：{}，查询地区信息", areaCode);
        SysArea sysArea = areaService.selectByPrimaryKey(areaCode);
        log.info("查询地区信息结果为：{}", sysArea == null ? null : JacksonUtil.object2Json(sysArea));
        return sysArea;
    }

    @PostMapping
    public int saveArea(@RequestBody SysArea sysArea){
        log.info("新增地区信息为：{}", JacksonUtil.object2Json(sysArea));
        int i = areaService.insertSelective(sysArea);
        log.info("新增地区信息{}", i == 0 ? "失败" : "成功");
        return i;
    }

    @PutMapping("{areaCode}")
    public int modifyArea(@PathVariable String areaCode, @RequestBody SysArea sysArea){
        log.info("要修改的地区信息的areaCode：{}，修改的值为：{}", areaCode, sysArea);
        sysArea.setAreaCode(areaCode);
        int i = areaService.updateByPrimaryKeySelective(sysArea);
        log.info("修改地区信息{}", i == 0 ? "失败" : "成功");
        return i;
    }

    @DeleteMapping("{areaCode}")
    public int removeArea(@PathVariable String areaCode){
        log.info("根据areaCode：{}查询地区信息", areaCode);
        int i = areaService.deleteByPrimaryKey(areaCode);
        log.info("删除地区信息{}", i ==0 ? "失败" : "成功");
        return i;
    }

    @GetMapping("/getChild/{parentCode}")
    public List<SysArea> queryAreas(@PathVariable String parentCode){
        log.info("根据parentCode：{}，查询地区信息", parentCode);
        List<SysArea> sysAreas = areaService.selectByParentCode(parentCode);
        log.info("查询地区信息结果为：{},{}", sysAreas.size(), sysAreas.size() == 0 ? null : JacksonUtil.list2Json(sysAreas));
        return sysAreas;
    }

    @GetMapping
    public List<SysArea> queryAll(int pageNum, int pageSize){
        log.info("分页查询所有地区信息，pageNum：{}，pageSize：{}", pageNum, pageSize);
        List<SysArea> sysAreas = areaService.selectAll(pageNum, pageSize);
        log.info("查询地区信息结果为：{},{}", sysAreas.size(), sysAreas.size() == 0 ? null : JacksonUtil.list2Json(sysAreas));
        return sysAreas;
    }

    @PostMapping("/batch")
    public int saveBatch(@RequestBody List<SysArea> sysAreas){
        log.info("新增地区信息为：{}, {}", sysAreas.size(), sysAreas.size() == 0 ? null : JacksonUtil.list2Json(sysAreas));
        int i = areaService.insertBatch(sysAreas);
        log.info("新增地区信息{}", i == 0 ? "失败" : "成功");
        return i;
    }
}
