package com.uwjx.springsecurity.configuration;

import com.alibaba.fastjson.JSON;
import com.uwjx.springsecurity.security.LogFilter;
import com.uwjx.springsecurity.security.MyAuthenticationFailureHandler;
import com.uwjx.springsecurity.security.MyAuthenticationSuccessHandler;
import com.uwjx.springsecurity.security.MyUsernamePasswordAuthenticationFilter;
import com.uwjx.springsecurity.service.MyUserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@Configuration
@Slf4j
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailService userDetailService;

    @Autowired
    LogFilter logFilter;


//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception
//    {
//        return super.authenticationManagerBean();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.warn("加载 访问控制 配制");

            http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/test1/**").permitAll() //添加 test1 访问放行
//                .antMatchers("/account/**").permitAll()
                .anyRequest().authenticated()
//                .and().formLogin()
//                .and().formLogin().loginProcessingUrl("/account/login")
//                .and().formLogin().disable()
//        .and().e
                ;
        http.addFilterAt(myUsernamePasswordAuthenticationFilter() , UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(logFilter , UsernamePasswordAuthenticationFilter.class);
//        http.csrf().disable();//关闭csrf 允许POST PUT DELETE 等

    }

    @Autowired
    MyAuthenticationFailureHandler myAuthenticationFailureHandler;
    @Autowired
    MyAuthenticationSuccessHandler authenticationSuccessHandler;

    @Bean
    public MyUsernamePasswordAuthenticationFilter myUsernamePasswordAuthenticationFilter() throws Exception {
        MyUsernamePasswordAuthenticationFilter filter = new MyUsernamePasswordAuthenticationFilter();
        filter.setAuthenticationManager(super.authenticationManagerBean());
        filter.setFilterProcessesUrl("/account/login");
        filter.setAuthenticationFailureHandler(myAuthenticationFailureHandler);
        filter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        return filter;
    }

//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
