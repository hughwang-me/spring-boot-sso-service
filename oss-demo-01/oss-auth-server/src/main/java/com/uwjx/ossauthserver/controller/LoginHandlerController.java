package com.uwjx.ossauthserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@Slf4j
public class LoginHandlerController {

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @RequestMapping(value = "login_handler")
    public String handleLoginRequest(HttpServletRequest request , HttpServletResponse response) throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(request , response);
        if(savedRequest != null){
            String redirectUrl = savedRequest.getRedirectUrl();
            log.warn("LoginHandlerController redirectUrl -> {}" , redirectUrl);
            if(!StringUtils.isEmpty(redirectUrl) && (redirectUrl.endsWith(".html"))){
                redirectStrategy.sendRedirect(request , response , redirectUrl);
            }
        }

        return "请先登录";
    }
}
