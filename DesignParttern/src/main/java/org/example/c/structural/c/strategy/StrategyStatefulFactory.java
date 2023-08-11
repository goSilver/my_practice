package org.example.c.structural.c.strategy;

/**
 * 策略工厂（有状态）
 *
 * @author chensh
 * @datetime 2023/8/10 8:57 PM
 */
public class StrategyStatefulFactory {
    public static Strategy getStrategy(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }

        if ("A".equals(type)) {
            return new ConcreteStrategyA();
        } else if ("B".equals(type)) {
            return new ConcreteStrategyB();
        }
        return null;
    }
}
