package com.uwjx.ossauthserver.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        FilterChain chain,
                                        Authentication authentication) throws IOException, ServletException {
        log.warn("登录成功处理1: {}" , authentication.getName());
        chain.doFilter(request , response);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        log.warn("登录成功处理2: {}" , authentication.getName());
        SavedRequest savedRequest = requestCache.getRequest(request , response);
        if(savedRequest != null){
            String redirectUrl = savedRequest.getRedirectUrl();
            log.warn("LoginHandlerController redirectUrl -> {}" , redirectUrl);
            if(!StringUtils.isEmpty(redirectUrl)){
                log.warn("登录成功后执行跳转");
                redirectStrategy.sendRedirect(request , response , redirectUrl);
            }
        }
    }
}
