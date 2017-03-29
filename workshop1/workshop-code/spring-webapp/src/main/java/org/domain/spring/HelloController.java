package org.domain.spring;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wszybisty
 */
@RestController
public class HelloController {
    
    @RequestMapping("/hello/{id}")
    public String hello(@PathVariable("id") int id) {
        return "Hello Spring " + id;
    }
}
