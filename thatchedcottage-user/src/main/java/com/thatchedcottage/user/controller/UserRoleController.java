package com.thatchedcottage.user.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.thatchedcottage.user.mapper.UserRoleMapper;
import java.util.Arrays;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.thatchedcottage.user.domain.UserRole;
import xin.altitude.cms.common.entity.AjaxResult;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import xin.altitude.cms.common.entity.PageEntity;
import com.thatchedcottage.user.service.IUserRoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
@RequestMapping("/user/user/role")
public class UserRoleController{
    @Autowired
    private IUserRoleService userRoleService;
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity,UserRole userRole){
        return AjaxResult.success(userRoleService.page(pageEntity.toPage(), Wrappers.lambdaQuery(userRole)));
    }
    @GetMapping("/list")
    public AjaxResult list(UserRole userRole){
        return AjaxResult.success(userRoleService.list(Wrappers.lambdaQuery(userRole)));
    }
    @PostMapping("/push")
    public AjaxResult add(@RequestBody UserRole userRole) {
        return AjaxResult.success(userRoleService.save(userRole));
    }
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody UserRole userRole) {
        return AjaxResult.success(userRoleService.updateById(userRole));
    }
    @DeleteMapping("/delete/{ids}")
    public AjaxResult delete(@PathVariable Integer[] ids) {
        return AjaxResult.success(userRoleService.removeByIds(Arrays.asList(ids)));
    }
    @GetMapping(value = "/detail/{id}")
    public AjaxResult detail(@PathVariable("id") Integer id) {
        return AjaxResult.success(userRoleService.getById(id));
    }
}
