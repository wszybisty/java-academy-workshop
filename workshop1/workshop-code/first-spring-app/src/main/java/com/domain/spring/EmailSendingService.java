package com.domain.spring;

import org.springframework.stereotype.Service;

/**
 *
 * @author wszybisty
 */
@Service
public class EmailSendingService {
    
    public void sendMessage(User user, String content) {
        System.out.println("EmailSendingService.sendMessage : " + content + " to user: " + user);
    }
}
