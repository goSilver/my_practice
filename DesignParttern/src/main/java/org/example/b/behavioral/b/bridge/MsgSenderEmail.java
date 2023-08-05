package org.example.b.behavioral.b.bridge;

/**
 * @author goku
 */
public class MsgSenderEmail implements MsgSender {
    @Override
    public void send(String message) {
        System.out.println("MsgSenderEmail.send --- " + message);
    }
}
