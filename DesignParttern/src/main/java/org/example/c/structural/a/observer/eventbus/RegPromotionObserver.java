package org.example.c.structural.a.observer.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * @author goku
 * @datetime 2023/8/6 3:10 PM
 */
public class RegPromotionObserver {
    private final PromotionService promotionService;

    public RegPromotionObserver(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @Subscribe
    public void handleRegSuccess(String userId) {
        System.out.println("RegPromotionObserver.handleRegSuccess.userId = " + userId);
        promotionService.issueNewUserExperienceCash(userId);
    }
}
