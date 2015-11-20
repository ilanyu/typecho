package com.lanyus.typecho.controller;

import com.lanyus.typecho.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Ly on 2015/11/16.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Resource
    BlogService blogService;

    @RequestMapping("/login/login")
    public void login(@RequestParam(value = "name", required = false) String name,
                      @RequestParam(value = "password", required = false) String password,
                      @RequestParam(value = "referer", required = false) String referer,
                      HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        if (null == name || null == password) {
            out.print("{\"status\":\"failed\",\"message\":\"username and password is error!\"}");
        }
        if (blogService.login(name, password)) {
            out.print("{\"status\":\"success\",\"message\":\"\"}");
        } else {
            out.print("{\"status\":\"failed\",\"message\":\"username and password is error!\"}");
        }
        out.close();
    }

    @RequestMapping("/login")
    public String login(HttpSession session, ModelMap model) {
        Object username = session.getAttribute("username");
        if (null != username) {
            model.addAttribute("username",String.valueOf(username));
        }
        return "admin/login";
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
