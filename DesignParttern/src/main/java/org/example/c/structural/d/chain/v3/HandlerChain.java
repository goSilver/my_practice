package org.example.c.structural.d.chain.v3;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于数组的责任链模式，将处理器放入数组中，遍历数组，如果处理成功则退出
 *
 * @author chensh
 * @datetime 2023/8/13 5:44 PM
 */
public class HandlerChain {
    private final List<IHandler> handlerList = new ArrayList<>();

    public void addHandler(IHandler handler) {
        handlerList.add(handler);
    }

    /**
     * 遍历处理器数组，如果处理成功则退出
     */
    public void handle() {
        for (IHandler handler : handlerList) {
            boolean handled = handler.handle();
            if (handled) {
                break;
            }
        }
    }
}
