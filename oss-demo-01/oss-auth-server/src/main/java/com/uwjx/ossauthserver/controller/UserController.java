package com.uwjx.ossauthserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "user")
public class UserController {

    @GetMapping(value = "info")
    public String info(){
        log.warn("获取用户信息");
        SecurityContext context = SecurityContextHolder.getContext();
        return "当前你登录用户" + context.getAuthentication().getName();
    }
}
