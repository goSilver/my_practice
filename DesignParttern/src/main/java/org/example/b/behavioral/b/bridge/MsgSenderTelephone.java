package org.example.b.behavioral.b.bridge;

import java.util.List;

/**
 * @author goku
 * @datetime 2023/8/5 10:26 AM
 */
public class MsgSenderTelephone implements MsgSender {
    private List<String> telephones;

    public MsgSenderTelephone(List<String> telephones) {
        this.telephones = telephones;
    }

    @Override
    public void send(String message) {
        System.out.println("MsgSenderTelephone.send --- " + message);
    }

}
