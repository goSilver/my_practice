package org.example.b.behavioral.b.bridge;

/**
 * @author goku
 * @datetime 2023/8/5 10:34 AM
 */
public class main {

    public static void main(String[] args) {
        // 根据需求任意组合告警方式及告警级别
        MsgSender msgSender = new MsgSenderWechat();
        Notification notification = new NotificationSevere(msgSender);
        notification.notify("hello world");
    }
}
