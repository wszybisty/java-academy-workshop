package com.domain.spring;

/**
 *
 * @author wszybisty
 */
public class NotificationService {
    
    private EmailSendingService emailSendingService;
    
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
