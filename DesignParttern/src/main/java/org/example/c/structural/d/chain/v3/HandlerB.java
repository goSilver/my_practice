package org.example.c.structural.d.chain.v3;

/**
 * @author chensh
 * @datetime 2023/8/13 5:42 PM
 */
public class HandlerB implements IHandler {
    @Override
    public boolean handle() {
        System.out.println("HandlerB.handle");
        return false;
    }
}
