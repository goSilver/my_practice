package org.example.c.structural.a.observer.classic;

/**
 * @author goku
 */
public interface Observer {
    /**
     * 触发观察者
     *
     * @param message 消息
     */
    void update(Message message);
}
