package org.example.c.structural.a.observer.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * @author goku
 * @datetime 2023/8/6 3:11 PM
 */
public class RegNotificationObserver {
    private final NotificationService notificationService;

    public RegNotificationObserver(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Subscribe
    public void handleRegSuccess(String userId) {
        System.out.println("RegNotificationObserver.handleRegSuccess.userId = " + userId);
        notificationService.sendInboxMessage(userId);
    }
}
