package com.flow.controller;

import com.flow.model.SysUser;
import com.flow.service.SysUserService;
import com.flow.utils.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Autowired
    private SysUserService userService;

    @PostMapping
    public int saveUser(@RequestBody SysUser sysUser){
        log.info("新增用户信息为：{}", JacksonUtil.object2Json(sysUser));
        int i = userService.insertSelective(sysUser);
        log.info("新增用户信息{}", i == 0 ? "失败" : "成功");
        return i;
    }

    @DeleteMapping("{id}")
    public int removeUser(@PathVariable Integer id){
        log.info("根据id：{}删除用户信息", id);
        int i = userService.deleteByPrimaryKey(id);
        log.info("删除用户信息{}", i ==0 ? "失败" : "成功");
        return i;
    }

    @GetMapping("{id}")
    public SysUser queryUser(@PathVariable Integer id){
        log.info("根据id：{}查询用户信息", id);
        SysUser sysUser = userService.selectByPrimaryKey(id);
        log.info("查询地区信息结果为：{}", sysUser == null ? null : JacksonUtil.object2Json(sysUser));
        return sysUser;
    }

    @PutMapping("{id}")
    public int modifyUser(@PathVariable Integer id, @RequestBody SysUser sysUser){
        log.info("要修改的用户信息的id：{}，修改的值为：{}", id, sysUser);
        sysUser.setId(id);
        int i = userService.updateByPrimaryKeySelective(sysUser);
        log.info("修改用户信息{}", i ==0 ? "失败" : "成功");
        return i;
    }

    @GetMapping
    public List<SysUser> queryAll(int pageNum, int pageSize){
        log.info("查询所有用户信息");
        List<SysUser> sysUsers = userService.selectAll(pageNum, pageSize);
        log.info("查询用户信息结果为：{},{}", sysUsers.size(), sysUsers.size() == 0 ? null : JacksonUtil.list2Json(sysUsers));
        return sysUsers;
    }

}
