package com.lanyus.typecho.controller;

import com.lanyus.typecho.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    AdminService admin;

    @RequestMapping(value = {"", "/"})
    public String index() {
        return "admin/index";
    }
}
