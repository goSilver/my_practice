package org.example.c.structural.d.chain.v2;

/**
 * 责任链模式V2版，基于模板方法模式将公共逻辑抽取到父类中
 *
 * @author chensh
 * @datetime 2023/8/13 5:27 PM
 */
public abstract class Handler {
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    /**
     * 模板方法模式，将公共逻辑抽取到父类中
     */
    public void handle() {
        System.out.println("Handler.handle");
        boolean handled = doHandle();
        if (successor != null && !handled) {
            successor.handle();
        }
    }

    /**
     * 所有的处理者都必须实现处理方法
     *
     * @return 是否处理成功
     */
    public abstract boolean doHandle();
}
