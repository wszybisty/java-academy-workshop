package com.pgs.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author wszybisty
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.pgs.spring.security")
@Import(SecurityConfig.class)
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver viewResolver()  {
        return new InternalResourceViewResolver("/WEB-INF/pages/", ".jsp");
    }
}
