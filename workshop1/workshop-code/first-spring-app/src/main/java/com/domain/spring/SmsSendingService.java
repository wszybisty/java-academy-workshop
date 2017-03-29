package com.domain.spring;

import org.springframework.stereotype.Service;

/**
 *
 * @author wszybisty
 */
@Service
public class SmsSendingService {

    public void sendMessage(User user, String content) {
        System.out.println("SmsSendingService.sendMessage : " + content + " to user: " + user);
    }
}
