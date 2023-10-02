package org.example.util;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式在JDK中的应用
 * @author chensh
 * @datetime 2023/10/2 4:08 PM
 */
public class ObserverTest {
    public static void main(String[] args) {
        // new一个观察者
        ObservableCopy ob = new ObservableCopy();

        // 添加被观察者
        ObserverA a = new ObserverA();
        ob.addObserver(a);
        ObserverB b = new ObserverB();
        ob.addObserver(b);

        ob.doAction();
    }

    static class ObservableCopy extends Observable {
        public void doAction(){
            // 标记changed
            setChanged();
            // 执行操作
            System.out.println("ObservableCopy.doAction()");
            // 通知所有被观察者
            notifyObservers();
        }
    }

    static class ObserverA implements Observer{
        @Override
        public void update(Observable o, Object arg) {
            System.out.println("ObserverA.update()");
        }
    }

    static class ObserverB implements Observer{
        @Override
        public void update(Observable o, Object arg) {
            System.out.println("ObserverB.update()");
        }
    }
}
