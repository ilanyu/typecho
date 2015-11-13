package com.lanyus.typecho.controller;

import com.lanyus.typecho.service.InstallService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class MainController {

    @Resource
    InstallService installService;

    @RequestMapping(value = "/")
    public String main() {
        if (installService.isInstall()) {
            return "";
        } else {
            return "";
        }
    }
}
