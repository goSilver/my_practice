package org.example.c.structural.d.chain.v1;

/**
 * @author chensh
 * @datetime 2023/8/13 5:23 PM
 */
public class HandlerB extends Handler {

    @Override
    public void handle() {
        System.out.println("HandlerB.handle");
        if (successor != null) {
            successor.handle();
        }
    }
}
