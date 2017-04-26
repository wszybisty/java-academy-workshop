package com.pgs.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author wszybisty
 */
@Controller
@RequestMapping("admin")
public class AdminController {
    
    @GetMapping
    public String index() {
        return "admin/index";
    }    
}
