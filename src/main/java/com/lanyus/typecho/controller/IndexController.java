package com.lanyus.typecho.controller;

import com.alibaba.fastjson.JSON;
import com.lanyus.typecho.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class IndexController {

    @Resource
    BlogService blogService;

    @RequestMapping("/login/login")
    public void login(@RequestParam(value = "name", required = false) String name,
                      @RequestParam(value = "password", required = false) String password,
                      @RequestParam(value = "referer", required = false) String referer,
                      HttpServletRequest req, HttpServletResponse resp, HttpSession session, PrintWriter out) throws IOException {

        if (null == name || null == password) {
            Map<String,String> Message = new HashMap<String,String>();
            Message.put("status","error");
            Message.put("message","username and password is error!");
            out.print(JSON.toJSONString(Message));
            out.close();
            return;
        }
        if (blogService.login(name, password)) {
            Cookie cookie = new Cookie("username", name);
            resp.addCookie(cookie);
            session.setAttribute("username",name);
            session.setAttribute("password",password);
            Map<String,String> Message = new HashMap<String,String>();
            Message.put("status","success");
            Message.put("message","");
            out.print(JSON.toJSONString(Message));
        } else {
            Map<String,String> Message = new HashMap<String,String>();
            Message.put("status","error");
            Message.put("message","username and password is error!");
            out.print(JSON.toJSONString(Message));
        }
        out.close();
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest req, ModelMap model) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    model.addAttribute("username",cookie.getValue());
                }
            }
        }
        return "admin/login";
    }

    @RequestMapping("/logout")
    public void logout(HttpSession session, HttpServletResponse resp) {
        session.removeAttribute("username");
        session.removeAttribute("password");
        resp.setHeader("Location","./");
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/getIndexBlog")
    public void getIndexBlog(@RequestParam(value = "start",required = false,defaultValue = "0") String start,
                             @RequestParam(value = "limit",required = false,defaultValue = "5") String limit,
                             PrintWriter out) {
        try {
            out.print(JSON.toJSONString(blogService.getIndexBlog(Integer.valueOf(start),Integer.valueOf(limit))));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        out.close();
    }

    @RequestMapping("/getNewBlogList")
    public void getNewBlogList(@RequestParam(value = "limit",required = false,defaultValue = "5") String limit,
                               PrintWriter out) {
        try {
            out.print(JSON.toJSONString(blogService.getNewBlogList(Integer.valueOf(limit))));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        out.close();
    }

    @RequestMapping("/getPage")
    public void getPage(PrintWriter out) {
        out.print(JSON.toJSONString(blogService.getPage()));
        out.close();
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
