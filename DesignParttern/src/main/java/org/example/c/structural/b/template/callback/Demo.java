package org.example.c.structural.b.template.callback;

/**
 * 回调案例
 *
 * @author goku
 * @datetime 2023/8/7 10:30 PM
 */
public class Demo {
    public static void main(String[] args) {
        BClass bClass = new BClass();
        bClass.process(new ICallback() {
            @Override
            public void methodToCallback() {
                System.out.println("main.methodToCallback");
            }
        });
    }
}
