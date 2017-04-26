package com.pgs.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author wszybisty
 */
@Controller
public class IndexController {
    
    @GetMapping(path="/")
    public String index() {
        return "index";
    }
}
