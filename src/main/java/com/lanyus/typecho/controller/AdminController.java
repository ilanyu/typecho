package com.lanyus.typecho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("/login")
    public String login(@RequestParam(value = "name", required = false) String name,
                        @RequestParam(value = "password", required = false) String password,
                        @RequestParam(value = "referer", required = false) String referer) {
        System.out.println(referer);
        return "login";
    }

    @RequestMapping("/logout")
    public String logout() {

        return "redirect:./";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }
}
