package com.domain.spring;

import org.springframework.stereotype.Component;

/**
 *
 * @author wszybisty
 */
@Component
public class NotificationService {
    
    private EmailSendingService emailSendingService;
    
    private SmsSendingService smsSendingService;

    public NotificationService(EmailSendingService emailSendingService, SmsSendingService smsSendingService) {
        this.emailSendingService = emailSendingService;
        this.smsSendingService = smsSendingService;
    }
    
    public void sendWelcomeMessage(User user) {
        if (user.getEmail() != null) {
            emailSendingService.sendMessage(user, "Welcome email");
        }
        if (user.getPhone() != null) {
            smsSendingService.sendMessage(user, "Welcome SMS");
        }
    }
}
