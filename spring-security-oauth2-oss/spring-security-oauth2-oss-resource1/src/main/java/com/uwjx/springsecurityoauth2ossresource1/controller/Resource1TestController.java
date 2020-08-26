package com.uwjx.springsecurityoauth2ossresource1.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "resource1")
@Slf4j
public class Resource1TestController {

    @GetMapping(value = "list")
    public String list(){
        log.warn("进去 controller list");
        Authentication authorization = SecurityContextHolder.getContext().getAuthentication();
        if(authorization != null){
            log.warn("用户认证信息:{}" , JSON.toJSONString(authorization.getPrincipal()));
        }else {
            log.warn("authorization is null");
        }
        return "资源服务器1 的 list";
    }

    @GetMapping(value = "add")
    public String add(){
        log.warn("进去 controller add");
        Authentication authorization = SecurityContextHolder.getContext().getAuthentication();
        if(authorization != null){
            authorization.getPrincipal();
        }else {
            log.warn("authorization is null");
        }
        return "资源服务器1 的 add";
    }
}
