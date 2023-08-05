package org.example.b.behavioral.b.bridge;

/**
 * @author goku
 */
public class MsgSenderWechat implements MsgSender {
    @Override
    public void send(String message) {
        System.out.println("MsgSenderWechat.send --- " + message);
    }
}
