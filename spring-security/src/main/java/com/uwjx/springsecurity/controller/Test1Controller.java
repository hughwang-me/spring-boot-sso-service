package com.uwjx.springsecurity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "test1")
public class Test1Controller {

    @GetMapping(value = "list")
    public String list(){
        log.warn("进入 Test1Controller -> list");
        return "list";
    }
}
