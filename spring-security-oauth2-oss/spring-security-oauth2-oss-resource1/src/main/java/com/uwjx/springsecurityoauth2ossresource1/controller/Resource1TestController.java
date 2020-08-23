package com.uwjx.springsecurityoauth2ossresource1.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "r1")
@Slf4j
public class Resource1TestController {

    @GetMapping(value = "list")
    public String r1List(){
        log.warn("进去 controller r1List");
        Authentication authorization = SecurityContextHolder.getContext().getAuthentication();
        if(authorization != null){
            authorization.getPrincipal();
        }
        return "资源服务器1 的 list";
    }
}
