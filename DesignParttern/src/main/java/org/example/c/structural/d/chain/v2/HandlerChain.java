package org.example.c.structural.d.chain.v2;

/**
 * 基于链表的责任链模式V2版
 *
 * @author chensh
 * @datetime 2023/8/13 5:32 PM
 */
public class HandlerChain {
    protected Handler head;
    protected Handler tail;

    public void addHandler(Handler handler) {
        handler.setSuccessor(null);

        if (head == null) {
            head = handler;
            tail = handler;
            return;
        }

        tail.setSuccessor(handler);
        tail = handler;
    }

    public void handle() {
        if (head != null) {
            head.handle();
        }
    }
}
