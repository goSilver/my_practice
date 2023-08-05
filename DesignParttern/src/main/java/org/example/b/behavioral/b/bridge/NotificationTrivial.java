package org.example.b.behavioral.b.bridge;

/**
 * @author goku
 */
public class NotificationTrivial extends Notification {
    public NotificationTrivial(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        System.out.println("NotificationTrivial.notify --- " + message);
        msgSender.send(message);
    }
}
