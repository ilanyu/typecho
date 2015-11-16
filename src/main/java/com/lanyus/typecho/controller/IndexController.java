package com.lanyus.typecho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Ly on 2015/11/16.
 */
@Controller
public class IndexController {
    @RequestMapping("/login")
    public String login(@RequestParam(value = "name", required = false) String name,
                        @RequestParam(value = "password", required = false) String password,
                        @RequestParam(value = "referer", required = false) String referer) {
        if (name == null) {
            return "admin/login";
        } else {
            return "admin/login";
        }
    }

    @RequestMapping("/logout")
    public String logout() {

        return "redirect:./";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/getBlog")
    public String getBlog() {

        return "";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
