package org.example.c.structural.c.strategy;

/**
 * @author chensh
 * @datetime 2023/8/10 8:59 PM
 */
public class DemoStateful {
    public static void main(String[] args) {
        Strategy strategy = StrategyStatefulFactory.getStrategy("A");
        strategy.algorithm();

        strategy = StrategyStatefulFactory.getStrategy("B");
        strategy.algorithm();
    }
}
