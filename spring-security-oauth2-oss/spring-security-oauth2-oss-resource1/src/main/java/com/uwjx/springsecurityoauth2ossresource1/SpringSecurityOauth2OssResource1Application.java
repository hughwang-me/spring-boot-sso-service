package com.uwjx.springsecurityoauth2ossresource1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class SpringSecurityOauth2OssResource1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityOauth2OssResource1Application.class, args);
    }

}
