package org.example.a.creation.a.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author chensh
 * @datetime 2023/7/30 9:54 PM
 */
public class DoubleCheck {
    private final AtomicLong id = new AtomicLong(0);
    /**
     * volatile关键字修饰
     * CPU 指令重排序可能导致在 IdGenerator 类的对象被关键字 new 创建并赋值给 instance 之后，还没来得及初始化（执行构造函数中的代码逻辑），就被另一个线程使用了。
     * 这样，另一个线程就使用了一个没有完整初始化的 IdGenerator 类的对象。
     * 要解决这个问题，我们只需要给 instance 成员变量添加 volatile 关键字来禁止指令重排序即可。
     */
    private static volatile DoubleCheck instance;

    private DoubleCheck() {
    }

    /**
     * 双重检查
     * @return 实例
     */
    public static DoubleCheck getInstance() {
        if (instance == null) {
            // 只有第一次才会执行到这里，此处为类级别锁
            synchronized (DoubleCheck.class) {
                if (instance == null) {
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
