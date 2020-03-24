package com.hjq.study.springcloud.oauth2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/resources")
public class ResourceController {
    private static final Logger logger = LoggerFactory.getLogger(ResourceController.class);

    /**
     * 需要认证
     *
     * @param access_token
     * @param principal
     * @return
     */
    @RequestMapping("/me")
    public Principal me(String access_token, Principal principal) {
        logger.info(principal.toString());
        logger.info(access_token);
        return principal;
    }

    /**
     * antMatchers("/resources/phone").permitAll()
     * 无需认证
     *
     * @return
     */
    @RequestMapping("/phone")
    public String phone() {

        return "phone: 1234567890";
    }
}
