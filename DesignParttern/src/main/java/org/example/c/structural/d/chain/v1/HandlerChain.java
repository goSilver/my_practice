package org.example.c.structural.d.chain.v1;

/**
 * 基于链表的责任链模式V1，将所有处理器串联起来
 *
 * @author chensh
 * @datetime 2023/8/13 5:23 PM
 */
public class HandlerChain {
    private Handler head;
    private Handler tail;

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
