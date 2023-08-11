package org.example.c.structural.c.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 策略工厂（无状态）
 *
 * @author chensh
 * @datetime 2023/8/10 8:54 PM
 */
public class StrategyStatelessFactory {
    private static final Map<String, Strategy> STRATEGIES = new HashMap<>();

    static {
        STRATEGIES.put("A", new ConcreteStrategyA());
        STRATEGIES.put("B", new ConcreteStrategyB());
    }

    public static Strategy getStrategy(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        return STRATEGIES.get(type);
    }

}
