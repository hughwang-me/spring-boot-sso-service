package com.uwjx.ossauthserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "server")
public class TestController {

    @GetMapping
    @RequestMapping(value = "test")
    public String test(){

        return "111";
    }
}
