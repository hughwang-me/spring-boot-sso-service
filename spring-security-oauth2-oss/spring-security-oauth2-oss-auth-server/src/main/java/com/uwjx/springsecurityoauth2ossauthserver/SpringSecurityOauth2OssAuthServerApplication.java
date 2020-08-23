package com.uwjx.springsecurityoauth2ossauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class SpringSecurityOauth2OssAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityOauth2OssAuthServerApplication.class, args);
    }

}
