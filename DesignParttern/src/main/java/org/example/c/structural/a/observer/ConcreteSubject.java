package org.example.c.structural.a.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author goku
 * @datetime 2023/8/6 2:43 PM
 */
public class ConcreteSubject implements Subject {
    private final List<Observer> observers = new ArrayList<Observer>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Message message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

}

