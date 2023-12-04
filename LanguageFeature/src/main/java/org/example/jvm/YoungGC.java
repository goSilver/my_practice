package org.example.jvm;

/**
 * @author chensh
 * @datetime 2023/12/4 10:37 PM
 */
public class YoungGC {
    /**
     * 验证触发YoungGC
     * JVM参数：年轻代5m(eden区4m\survivor区0.5m * 2)、老年代5m
     * -XX:NewSize=5242880 -XX:MaxNewSize=5242880 -XX:InitialHeapSize=10485760 -XX:MaxHeapSize=10485760
     * -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=10485760 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC
     * -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
     * @param args
     */
    public static void main(String[] args) {
        // 创建3个1m的对象并去掉引用，变为垃圾
        byte[] arr1 = new byte[1024 * 1024];
        arr1 = new byte[1024 * 1024];
        arr1 = new byte[1024 * 1024];
        arr1 = null;

        // 再创建一个2m的对象
        byte[] arr2 = new byte[2 * 1024 * 1024];

    }
}
