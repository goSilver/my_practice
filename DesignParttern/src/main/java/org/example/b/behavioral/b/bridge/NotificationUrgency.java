package org.example.b.behavioral.b.bridge;

/**
 * @author goku
 */
public class NotificationUrgency extends Notification {
    public NotificationUrgency(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        System.out.println("NotificationUrgency.notify --- " + message);
        msgSender.send(message);
    }
}
