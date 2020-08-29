package com.uwjx.ossclient01.controller;

import com.uwjx.ossclient01.net.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
@RequestMapping(value = "test")
public class TestController {

    @GetMapping(value = "list")
    public String list(){
        log.warn("test - list");
        return "test list";
    }

    @GetMapping(value = "userInfo")
    public String userInfo(){
        log.warn("test - userInfo");
        String url = "http://localhost:8090/user/info";
        String resp = HttpUtil.get(url);
        return resp;
    }

    @RequestMapping("login-page")
    public String loginPage(){
        log.warn("使用 thymeleaf 登录页面");

        return "login";
    }
}
