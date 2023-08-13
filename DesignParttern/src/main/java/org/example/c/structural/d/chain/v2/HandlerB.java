package org.example.c.structural.d.chain.v2;

/**
 * @author chensh
 * @datetime 2023/8/13 5:31 PM
 */
public class HandlerB extends Handler {
    @Override
    public boolean doHandle() {
        System.out.println("HandlerB.handle");
        return false;
    }
}
