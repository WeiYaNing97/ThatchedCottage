package com.thatchedcottage.user.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.thatchedcottage.user.domain.Role;
import com.thatchedcottage.user.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.AjaxResult;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.Arrays;
@RestController
@ResponseBody
@RequestMapping("/role")
public class RoleController{
    @Autowired
    private IRoleService roleService;
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity,Role role){
        return AjaxResult.success(roleService.page(pageEntity.toPage(), Wrappers.lambdaQuery(role)));
    }
    @GetMapping("/list")
    public AjaxResult list(Role role){
        return AjaxResult.success(roleService.list(Wrappers.lambdaQuery(role)));
    }
    @PostMapping("/push")
    public AjaxResult add(@RequestBody Role role) {
        return AjaxResult.success(roleService.save(role));
    }
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Role role) {
        return AjaxResult.success(roleService.updateById(role));
    }
    @DeleteMapping("/delete/{ids}")
    public AjaxResult delete(@PathVariable Integer[] ids) {
        return AjaxResult.success(roleService.removeByIds(Arrays.asList(ids)));
    }
    @GetMapping(value = "/detail/{id}")
    public AjaxResult detail(@PathVariable("id") Integer id) {
        return AjaxResult.success(roleService.getById(id));
    }
}
