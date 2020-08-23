package com.uwjx.springsecurity.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        logger.warn("进入 MyUsernamePasswordAuthenticationFilter");
        log.warn("请求方法:{}" , request.getMethod());
        if(!request.getMethod().equalsIgnoreCase(HttpMethod.POST.name())){
            throw new AuthenticationServiceException("只支持 POST 请求方式进行登录");
        }

        if (request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
            try {
                Map<String , String> requestBody = new ObjectMapper().readValue(request.getInputStream()  , Map.class);
                String username = requestBody.get("username");
                String password = requestBody.get("password");
                log.warn("username -> {}" , username);
                log.warn("password -> {}" , password);

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username , password);
                setDetails(request , authenticationToken);
                return this.getAuthenticationManager().authenticate(authenticationToken);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            log.warn("不是JSON请求");
        }

        return super.attemptAuthentication(request, response);
    }
}
