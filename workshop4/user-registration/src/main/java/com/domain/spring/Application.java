package com.domain.spring;

import com.domain.spring.model.User;
import com.domain.spring.exception.UserRegistrationException;
import com.domain.spring.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author wszybisty
 */
public class Application {
    
    public static void main(String[] args) throws UserRegistrationException {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");
        
        UserService service = context.getBean(UserService.class);
        
        final User user = new User(null, "wszybisty", "Wojtek", "Szybisty", "wojciech.szybisty@gmail.com", "+48888999000");
        
        service.registerUser(user);
    }
}
