package org.example.c.structural.c.strategy;

/**
 * @author chensh
 * @datetime 2023/8/10 8:52 PM
 */
public class ConcreteStrategyA implements Strategy{

    @Override
    public void algorithm() {
        System.out.println("ConcreteStrategyA.algorithm");
    }
}
