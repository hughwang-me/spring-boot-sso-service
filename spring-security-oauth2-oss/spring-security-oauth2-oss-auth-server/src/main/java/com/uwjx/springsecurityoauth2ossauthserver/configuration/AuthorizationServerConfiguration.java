package com.uwjx.springsecurityoauth2ossauthserver.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@Slf4j
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    private static final String DEMO_RESOURCE_ID = "order";
//
    @Autowired
    AuthenticationManager authenticationManager;


//    @Autowired
//    RedisConnectionFactory redisConnectionFactory;

    @SuppressWarnings("deprecation")
    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        security.allowFormAuthenticationForClients();
        security.checkTokenAccess("isAuthenticated()");
    }
//
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(new InMemoryTokenStore())
                .authenticationManager(authenticationManager);

    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory().withClient("client_1")
//                .resourceIds(DEMO_RESOURCE_ID)
//                .authorizedGrantTypes("client_credentials", "refresh_token")
//                .scopes("select")
//                .authorities("client")
//                .secret("123456")
//                .and().withClient("client_2")
//                .resourceIds(DEMO_RESOURCE_ID)
//                .authorizedGrantTypes("password", "refresh_token")
//                .scopes("select")
//                .authorities("client")
//                .secret("123456");

        clients.inMemory() .withClient("resource1")
//                .resourceIds(DEMO_RESOURCE_ID)
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("select")
                .authorities("client")
                .secret("951753");

    }
}
