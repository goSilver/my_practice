package org.example.c.structural.d.chain.v2;

/**
 * @author chensh
 * @datetime 2023/8/13 5:30 PM
 */
public class HandlerA extends Handler {

    @Override
    public boolean doHandle() {
        System.out.println("HandlerA.handle");
        return false;
    }

}
