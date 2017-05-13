package com.domain.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author wszybisty
 */
@Configuration
@EnableWebMvc
@PropertySource("classpath:test/application.properties")
@Import(PersistanceConfig.class)
@ComponentScan("com.domain.spring")
public class TestAppConfig {
    
}
