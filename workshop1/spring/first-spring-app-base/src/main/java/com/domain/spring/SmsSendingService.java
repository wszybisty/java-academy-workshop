package com.domain.spring;

/**
 *
 * @author wszybisty
 */
public class SmsSendingService {

    public void sendMessage(User user, String content) {
        System.out.println("SmsSendingService.sendMessage : " + content + " to user: " + user);
    }
}
