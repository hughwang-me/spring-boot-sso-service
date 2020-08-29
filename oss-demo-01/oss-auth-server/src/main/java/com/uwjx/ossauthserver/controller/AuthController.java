package com.uwjx.ossauthserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
@RequestMapping(value = "auth")
public class AuthController {

    @RequestMapping("union-login")
    public String login() {
        log.warn("加载统一登录页面");
        return "union-login";
    }
}
