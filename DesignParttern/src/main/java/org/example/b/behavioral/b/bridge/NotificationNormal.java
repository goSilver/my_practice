package org.example.b.behavioral.b.bridge;

/**
 * @author goku
 */
public class NotificationNormal extends Notification {
    public NotificationNormal(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        System.out.println("NotificationNormal.notify --- " + message);
        msgSender.send(message);
    }
}
