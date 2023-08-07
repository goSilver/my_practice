package org.example.c.structural.b.template.callback;

/**
 * @author goku
 * @datetime 2023/8/7 10:29 PM
 */
public class BClass {
    public void process(ICallback callback) {
        System.out.println("BClass.process");
        callback.methodToCallback();
    }
}
