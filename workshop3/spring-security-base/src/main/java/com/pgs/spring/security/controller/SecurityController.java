package com.pgs.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author wszybisty
 */
@Controller
public class SecurityController {

    @GetMapping("login")
    public String login() {
        return "login";
    }
    
    @GetMapping("logout")
    public String logout() {
        return "logout";
    }
    
    @GetMapping("403")
    public String accessDenied() {
        return "403";
    }
}
