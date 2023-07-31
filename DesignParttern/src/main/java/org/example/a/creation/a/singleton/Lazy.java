package org.example.a.creation.a.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 单例模式 懒汉式
 * @author chensh
 * @datetime 2023/7/30 9:44 PM
 */
public class Lazy {

    private final AtomicLong id = new AtomicLong(0);
    private static Lazy instance;

    private Lazy() {
    }

    /**
     * 获取实例的方法被synchronized关键字修饰
     * @return 实例
     */
    public static synchronized Lazy getInstance() {
        if (instance == null) {
            instance = new Lazy();
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
