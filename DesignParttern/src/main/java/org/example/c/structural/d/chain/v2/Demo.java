package org.example.c.structural.d.chain.v2;

/**
 * @author chensh
 * @datetime 2023/8/13 5:33 PM
 */
public class Demo {
    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());
        chain.handle();
    }
}
