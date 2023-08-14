package com.thatchedcottage.controller;

import com.thatchedcottage.user.controller.RoleController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.cms.common.entity.AjaxResult;

@RestController
@RequestMapping("/test")
public class Test {
    @GetMapping("/get")
    public static void get() {
        RoleController roleController = new RoleController();
        AjaxResult list = roleController.list(null);
        Object o = list.get("data");
        System.out.println(o);
    }
}
