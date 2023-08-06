package org.example.c.structural.a.observer.classic;

/**
 * @author goku
 * @datetime 2023/8/6 2:40 PM
 */
public interface Subject {
    /**
     * 注册观察者
     * @param observer 观察者
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察者
     * @param observer 观察者
     */
    void removeObserver(Observer observer);

    /**
     * 通知观察者
     * @param message 消息
     */
    void notifyObservers(Message message);
}

