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
        map.put("status", "success");
        if (screenName != null) {
            map.put("screenName", screenName);
        }
        if (url != null) {
            map.put("url", url);
        }
        if (mail != null) {
            map.put("mail", mail);
        }
        if (password != null) {
            map.put("password", password);
        }
        out.print(JSON.toJSONString(map));
        out.close();
    }

    @RequestMapping("/options-discussion")
    public String optionsDiscussion(ModelMap model) {
        model.addAttribute("short_name", "idealanyus");
        return "admin/optionsDiscussion";
    }

    @RequestMapping("/setOptionsDiscussion")
    public void setOptionsDiscussion(@RequestParam("short_name") String short_name, PrintWriter out) {
        Map<String, String> map = new HashMap<>();
        map.put("status", "success");
        if (short_name != null) {
            map.put("short_name", short_name);
        }
        out.print(JSON.toJSONString(map));
        out.close();
    }

    @RequestMapping("/options-general")
    public String optionsGeneral() {
        return "admin/optionsGeneral";
    }

}
