package org.example.c.structural.c.strategy;

/**
 * @author chensh
 * @datetime 2023/8/10 9:00 PM
 */
public class DemoStateless {
    public static void main(String[] args) {
        Strategy strategy = StrategyStatelessFactory.getStrategy("A");
        strategy.algorithm();

        strategy = StrategyStatelessFactory.getStrategy("B");
        strategy.algorithm();
    }
}
