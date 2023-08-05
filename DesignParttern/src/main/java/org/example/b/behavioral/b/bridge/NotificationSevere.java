package org.example.b.behavioral.b.bridge;

/**
 * @author goku
 */
public class NotificationSevere extends Notification {
    public NotificationSevere(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        System.out.println("NotificationSevere.notify --- " + message);
        msgSender.send(message);
    }
}
