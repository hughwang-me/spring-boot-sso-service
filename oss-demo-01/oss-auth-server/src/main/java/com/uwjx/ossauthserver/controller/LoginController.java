package com.uwjx.ossauthserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Slf4j
@RequestMapping(value = "authentication")
public class LoginController {

    @GetMapping(value = "test")
    public String test(){
        log.warn("test------------------");
        return "test";
    }

    @GetMapping("login")
    public ModelAndView require() {
        return new ModelAndView("ftl/login");
    }
}
