package org.example.c.structural.a.observer.eventbus;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * @author goku
 * @datetime 2023/8/6 3:27 PM
 */
public class DemoA {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        // 注册监听器
        eventBus.register(new EventListener());
        // 发送消息
        eventBus.post(1);
        eventBus.post(2);
        eventBus.post("3");

    }
}

class EventListener {

    /**
     * 监听 Integer 类型的消息
     */
    @Subscribe
    public void listenInteger(Integer param) {
        System.out.println("EventListener#listenInteger ->" + param);
    }

    /**
     * 监听 String 类型的消息
     */
    @Subscribe
    public void listenString(String param) {
        System.out.println("EventListener#listenString ->" + param);
    }
}
