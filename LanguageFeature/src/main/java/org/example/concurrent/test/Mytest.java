package org.example.concurrent.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chensh
 * @datetime 2024/3/22 10:44 AM
 */
public class Mytest {
    public static void main(String[] args) {
        Data data  = new Data();
        data.amap.put("main", "main");
        refresh(data.amap);
        System.out.println(data.amap);
    }

    public static void refresh(Map<String, String> amap) {
        amap.put("refresh", "rrr");
    }
}

class Data{
    public Map<String,String> amap = new HashMap<>();
}
