package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author chensh
 */
public class HelloWorld {
    public static void main(String[] args) {
        Map<String, String> aMap = new HashMap<>();
        aMap.put("aa", "22");
        aMap.put("bb", "22");
        Map<String, String> bMap = new HashMap<>();
        bMap.put("bb", "22");
        bMap.put("aa", "22");
        System.out.println(Objects.equals(aMap, bMap));
    }

    public String sayHello() {
        return "Hello Maven";
    }


}