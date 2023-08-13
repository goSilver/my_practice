package org.example.c.structural.d.chain.v1;

/**
 * 责任链V1版本实现，缺点是每个处理的handle()方法都需要显示调用下一个处理器
 *
 * @author chensh
 * @datetime 2023/8/13 5:25 PM
 */
public class Demo {
    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());
        chain.handle();
    }
}
