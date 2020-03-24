package com.hjq.study.springcloud.oauth2.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@EnableResourceServer
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(ResourceServerConfig.class);

    public static final String RESOURCE_ID = "authorizationserver";

    @Override
    public void configure(HttpSecurity http) throws Exception {
       logger.info("ResourceServerConfig中配置HttpSecurity对象执行");
       //只有/me端点作为资源服务器的资源
//        http.requestMatchers().antMatchers("/")
//                .and()
//                .authorizeRequests()
//                .antMatchers("/")
//                .permitAll()
//                .anyRequest()
//                .authenticated();

        http.requestMatchers().antMatchers("/resources/*").and().authorizeRequests().antMatchers("/resources/phone").permitAll().anyRequest().authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        super.configure(resources);
        resources.resourceId(RESOURCE_ID);
    }
}
