package com.uwjx.oss.cookie.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Objects;

@RestController
@Slf4j
@RequestMapping(value = "cookie")
public class CookieController {

    @GetMapping
    @RequestMapping(value = "addCookie")
    public String addCookie(HttpServletRequest request , HttpServletResponse response){

        Cookie cookie = new Cookie("token" ,"token11111111111111");
        cookie.setMaxAge(10);

        Cookie cookie2 = new Cookie("token2" ,"token22222222");
        cookie2.setDomain("wanghuan.com");
        cookie2.setMaxAge(-1);

        Cookie cookie3 = new Cookie("token3" ,"token33333333");
        cookie3.setDomain("wanghuan.com");
        cookie3.setMaxAge(20);

//        cookie.setDomain();
        response.addCookie(cookie);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
        return "ok";
    }

    @GetMapping
    @RequestMapping(value = "listCookie")
    public Cookie[] listCookie(HttpServletRequest request , HttpServletResponse response){

        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0){
            Arrays.stream(cookies).filter(Objects::nonNull).forEach(cookie -> {
                log.warn("cookie -> {}" , JSON.toJSONString(cookie));
            });
        }
        return cookies;
    }



}
