package com.domain.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wszybisty
 */
@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String hello() {
        System.out.println("hello");
        return "Hello Annotations";
    }
}
