package com.lanyus.typecho.controller;

import com.lanyus.typecho.service.InstallService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by Admin on 2015/11/13.
 */
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
