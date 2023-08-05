package org.example.b.behavioral.b.bridge;

/**
 * @author goku
 */
public abstract class Notification {
    protected MsgSender msgSender;

    public Notification(MsgSender msgSender) {
        this.msgSender = msgSender;
    }

    /**
     * 发送告警消息
     * @param message 消息
     */
    public abstract void notify(String message);
}
