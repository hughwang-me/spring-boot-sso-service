package com.uwjx.springsecurityoauth2ossresource1.configration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@Slf4j
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

//    private static final String DEMO_RESOURCE_ID = "resource1";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        resources.resourceId(DEMO_RESOURCE_ID).stateless(true);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        log.warn("资源服务器1 加载权限配制");
            http.csrf().disable()

                    .authorizeRequests()
                    .antMatchers("/resource1/**").authenticated();

//        http
//                // Since we want the protected resources to be accessible in the UI as well we need
//                // session creation to be allowed (it's disabled by default in 2.0.6)
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//                .and()
//                .requestMatchers().anyRequest()
//                .and()
//                .anonymous()
//                .and()
//                .authorizeRequests()
////                    .antMatchers("/product/**").access("#oauth2.hasScope('select') and hasRole('ROLE_USER')")
//                .antMatchers("/resource1/**").authenticated();//配置order访问控制，必须认证过后才可以访问

    }
}
