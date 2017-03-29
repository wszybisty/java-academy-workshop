package com.domain.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author wszybisty
 */
public class Application {
    
    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-conf.xml");
        
        UserRegistrationService service = context.getBean(UserRegistrationService.class);
        
        final User user = new User("wszybisty", "Wojtek", "Szybisty", "wojciech.szybisty@gmail.com", "+48888999000");
        
        service.registerUser(user);
        
    }
}
