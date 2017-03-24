package com.domain.spring;

/**
 *
 * @author wszybisty
 */
public class EmailSendingService {
    
    public void sendMessage(User user, String content) {
        System.out.println("EmailSendingService.sendMessage : " + content + " to user: " + user);
    }
}
