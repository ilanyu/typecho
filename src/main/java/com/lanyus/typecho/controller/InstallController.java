package com.lanyus.typecho.controller;

import com.lanyus.typecho.service.InstallService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by Ly on 2015/11/13.
 */
@Controller
public class InstallController {
    @Resource
    InstallService installService;


}
