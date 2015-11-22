package com.lanyus.typecho.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ly on 2015/11/20.
 */
public class LoginFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response
            , FilterChain filterChain) throws ServletException, IOException {
        Object username = request.getSession().getAttribute("username");
        Object password = request.getSession().getAttribute("password");
        if (null == username || null == password) {
            response.setHeader("Location","/login");
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
