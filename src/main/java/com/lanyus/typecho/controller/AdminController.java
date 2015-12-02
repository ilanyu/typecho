package com.lanyus.typecho.controller;

import com.alibaba.fastjson.JSON;
import com.lanyus.typecho.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    AdminService admin;

    @RequestMapping(value = {"", "/"})
    public String index(ModelMap model) {
        model.addAttribute("pageCount", "29");
        model.addAttribute("categoriyCount", "29");
        return "admin/index";
    }

    @RequestMapping("/profile")
    public String profile(ModelMap model) {
        model.addAttribute("screenName", "ilanyu");
        model.addAttribute("url", "http://www.lanyus.com");
        model.addAttribute("mail", "lanyu19950316@gmail.com");
        return "admin/profile";
    }

    @RequestMapping("/users-profile")
    public void usersProfile(@RequestParam(value = "screenName", required = false) String screenName,
                             @RequestParam(value = "url", required = false) String url,
                             @RequestParam(value = "mail", required = false) String mail,
                             @RequestParam(value = "password", required = false) String password,
                             PrintWriter out) {
        Map<String, String> map = new HashMap<>();
        map.put("status","success");
        out.print(JSON.toJSONString(map));
        out.close();
    }
}
