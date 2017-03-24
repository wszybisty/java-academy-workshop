package com.domain.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author wszybisty
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.domain.spring")
public class WebConfig {
    
}
