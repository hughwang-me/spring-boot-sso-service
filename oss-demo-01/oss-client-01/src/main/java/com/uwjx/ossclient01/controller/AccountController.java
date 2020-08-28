package com.uwjx.ossclient01.controller;

import com.uwjx.ossclient01.net.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "account")
public class AccountController {

    @GetMapping(value = "callback")
    public String login(@RequestParam("code") String code) {
        log.warn("登录回调 GET ");
        log.warn("code-> {}", code);
        StringBuilder sb = new StringBuilder();
        sb.append("http://localhost:8090/oauth/token?");
        sb.append("grant_type=authorization_code");
        sb.append("&code=" + code);
        sb.append("&redirect_uri=http://localhost:8081/account/callback");

        String url = sb.toString();
        log.warn("url -> {}" , url);
        String resp = HttpUtil.post(url , "");
        return resp;
    }

    @PostMapping(value = "callback")
    public String post() {
        log.warn("登录回调 POST ");
        return "111222";
    }
}
