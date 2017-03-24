package com.domain.spring;

/**
 *
 * @author wszybisty
 */
public class UserRegistrationService {
    
    private NotificationService notificationService;
    
    public void registerUser(User user) {
        
        System.out.println("USER registered: " + user);
        
        notificationService.sendWelcomeMessage(user);
    }
    
}
