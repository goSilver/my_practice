package org.example.c.structural.d.chain.v1;

/**
 * 所有处理器的抽象父类
 *
 * @author chensh
 * @datetime 2023/8/13 5:20 PM
 */
public abstract class Handler {
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    /**
     * 所有的处理者都必须实现处理方法
     */
    public abstract void handle();
}
