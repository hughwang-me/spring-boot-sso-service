package com.uwjx.springsecurity.controller;

import com.alibaba.fastjson.JSON;
import com.uwjx.springsecurity.domain.UserDomain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "account")
public class AccountController {

    @PostMapping(value = "login")
    public String login(@RequestBody UserDomain userDomain){
        log.warn("进入 AccountController -> login params : {}" , JSON.toJSONString(userDomain));
        return "list";
    }
}
