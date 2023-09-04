package com.thatchedcottage.user.controller;
import com.thatchedcottage.common.file.CustomConfigurationUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import com.thatchedcottage.user.service.IUserService;
import com.thatchedcottage.user.mapper.UserMapper;

import java.io.IOException;
import java.util.Arrays;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.thatchedcottage.user.domain.User;
import xin.altitude.cms.common.entity.AjaxResult;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import xin.altitude.cms.common.entity.PageEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
@RequestMapping("/user")
public class UserController{
    @Autowired
    private IUserService userService;

    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity,User user){
        return AjaxResult.success(userService.page(pageEntity.toPage(), Wrappers.lambdaQuery(user)));
    }
    @GetMapping("/list")
    public AjaxResult list(User user){
        return AjaxResult.success(userService.list(Wrappers.lambdaQuery(user)));
    }
    @PostMapping("/push")
    public AjaxResult add(@RequestBody User user) {
        return AjaxResult.success(userService.save(user));
    }
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody User user) {
        return AjaxResult.success(userService.updateById(user));
    }
    @DeleteMapping("/delete/{ids}")
    public AjaxResult delete(@PathVariable String[] ids) {
        return AjaxResult.success(userService.removeByIds(Arrays.asList(ids)));
    }

    @GetMapping(value = "/detail/{id}")
    public AjaxResult detail(@PathVariable("id") String id) {
        return AjaxResult.success(userService.getById(id));
    }
}
