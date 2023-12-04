package org.example.jvm;

/**
 * @author chensh
 * @datetime 2023/12/4 11:09 PM
 */
public class DynamicAge {
    /**
     * 验证JVM动态年龄判断机制
     * JVM参数：年轻代10m（8+1+1）、老年代10m
     * -XX:NewSize=10485760 -XX:MaxNewSize=10485760 -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520
     * -XX:SurvivorRatio=8  -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=10485760 -XX:+UseParNewGC
     * -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
     *
     * @param args
     */
    public static void main(String[] args) {
        // 创建3个2m的对象并去掉引用，变为垃圾
        byte[] arr1 = new byte[2 * 1024 * 1024];
        arr1 = new byte[2 * 1024 * 1024];
        arr1 = new byte[2 * 1024 * 1024];
        arr1 = null;

        // 再创建一个128k的对象
        byte[] arr2 = new byte[256 * 1024];

        byte[] arr3 = new byte[2 * 1024 * 1024];
        arr3 = new byte[2 * 1024 * 1024];
        arr3 = new byte[2 * 1024 * 1024];
        arr3 = new byte[256 * 1024];
        arr3 = null;

        byte[] arr4 = new byte[2 * 1024 * 1024];

    }
}
