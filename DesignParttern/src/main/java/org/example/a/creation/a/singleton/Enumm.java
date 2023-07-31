package org.example.a.creation.a.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author goku
 * @datetime 2023/7/30 10:11 PM
 */
public enum Enumm {
    /**
     * 实例
     */
    INSTANCE;
    private final AtomicLong id = new AtomicLong(0);
    public long getId() {
        return id.incrementAndGet();
    }
}
