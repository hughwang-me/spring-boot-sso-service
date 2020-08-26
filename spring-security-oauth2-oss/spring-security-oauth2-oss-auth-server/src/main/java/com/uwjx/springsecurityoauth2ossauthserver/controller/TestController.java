package com.uwjx.springsecurityoauth2ossauthserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "test")
public class TestController {


    @GetMapping
    @RequestMapping(value = "test1")
    public String test1(){
        log.warn("请求 test1");
        return "test1";
    }

    @GetMapping
    @RequestMapping(value = "test2")
    public String test2(){
        log.warn("请求 test2");
        return "test2";
    }
}
