package org.example.c.structural.a.observer.eventbus;

import com.google.common.eventbus.EventBus;

import java.util.List;

/**
 * @author goku
 * @datetime 2023/8/6 3:03 PM
 */
public class UserController {
    private UserService userService;
    private EventBus eventBus;

    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 2;

    public UserController(UserService userService) {
        this.userService = userService;
        // 同步阻塞方式
        this.eventBus = new EventBus();
        // 异步非阻塞方式
//        this.eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE));
    }

    public void setRegObservers(List<Object> observers) {
        for (Object observer : observers) {
            eventBus.register(observer);
        }
    }

    public void register(String userId) {
        // 业务逻辑代码
        userService.register(userId);
        // 触发观察者
        eventBus.post(userId);
    }
}
