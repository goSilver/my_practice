package org.example.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chensh
 * @datetime 2023/12/10 9:41 PM
 */
public class OutOfMemory {
    public static void main(String[] args) {
        long counter = 0;
        List<Object> objectList = new ArrayList<>();
        while (true) {
            objectList.add(new Object());
            System.out.printf("当前创建了%d个对象", ++counter);
        }
    }
}
