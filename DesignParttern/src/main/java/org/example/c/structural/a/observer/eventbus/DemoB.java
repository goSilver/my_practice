package org.example.c.structural.a.observer.eventbus;

import com.google.common.collect.Lists;

/**
 * @author goku
 * @datetime 2023/8/6 3:12 PM
 */
public class DemoB {
    public static void main(String[] args) {
        UserService userService = new UserService();
        UserController userController = new UserController(userService);

        PromotionService promotionService = new PromotionService();
        NotificationService notificationService = new NotificationService();
        userController.setRegObservers(
                Lists.newArrayList(
                        new RegNotificationObserver(notificationService),
                        new RegPromotionObserver(promotionService)
                ));
        userController.register("user-01");
    }
}
