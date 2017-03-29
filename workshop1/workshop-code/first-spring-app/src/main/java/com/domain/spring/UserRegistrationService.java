package com.domain.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wszybisty
 */
@Service
public class UserRegistrationService {
    
    @Autowired
    private NotificationService notificationService;
    
    public void registerUser(User user) {
        
        System.out.println("USER registered: " + user);
        
        notificationService.sendWelcomeMessage(user);
    }
    
}
