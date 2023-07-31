package org.example.a.creation.a.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 单例模式 饿汉式
 *
 * @author chensh
 * @datetime 2019/5/15 15:44
 */
public class Hungry {

    private final AtomicLong id = new AtomicLong(0);

    /**
     * 类加载时就初始化
     */
    private static final Hungry instance = new Hungry();

    private Hungry() {
    }

    public static Hungry getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
