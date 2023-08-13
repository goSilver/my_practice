package org.example.c.structural.d.chain.v3;

/**
 * @author chensh
 * @datetime 2023/8/13 5:41 PM
 */
public class HandlerA implements IHandler{
    @Override
    public boolean handle() {
        System.out.println("HandlerA.handle");
        return false;
    }
}
