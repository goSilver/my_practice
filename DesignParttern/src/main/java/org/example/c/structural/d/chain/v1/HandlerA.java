package org.example.c.structural.d.chain.v1;

/**
 * @author chensh
 * @datetime 2023/8/13 5:22 PM
 */
public class HandlerA extends Handler {

    @Override
    public void handle() {
        System.out.println("HandlerA.handle");
        if (successor != null) {
            successor.handle();
        }
    }
}
