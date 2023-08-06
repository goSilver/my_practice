package org.example.c.structural.a.observer.eventbus;

/**
 * @author goku
 * @datetime 2023/8/6 3:12 PM
 */
public class NotificationService {
    public void sendInboxMessage(String userId) {
        System.out.println("NotificationService.sendInboxMessage.userId = " + userId);
    }
}
