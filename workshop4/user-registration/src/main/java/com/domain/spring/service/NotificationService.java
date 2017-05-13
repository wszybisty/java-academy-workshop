package com.domain.spring.service;

import com.domain.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wszybisty
 */
@Service
public class NotificationService {
    
    @Autowired
    private EmailSendingService emailSendingService;
    
    @Autowired
    private SmsSendingService smsSendingService;
    
    public void sendWelcomeMessage(User user) {
        
        if (user.getEmail() != null) {
            emailSendingService.sendMessage(user, "Welcome email");
        }
        if (user.getPhone() != null) {
            smsSendingService.sendMessage(user, "Welcome SMS");
        }
    }
}
