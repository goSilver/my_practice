package org.example.jvm;

/**
 * @author chensh
 * @datetime 2023/12/4 11:28 PM
 */
public class MaxTenuringThreshold {
    /**
     * 验证MaxTenuringThreshold参数
     * @param args
     */
    public static void main(String[] args) {
        // 创建3个2m的对象并去掉引用，变为垃圾
        byte[] arr1 = new byte[6 * 1024 * 1024];
        arr1=null;

        // 再创建一个128k的对象
        byte[] arr2 = new byte[128 * 1024];

        byte[] arr3 = new byte[6 * 1024 * 1024];
        arr3=null;
        byte[] arr4 = new byte[6 * 1024 * 1024];
        arr4=null;
        byte[] arr5 = new byte[6 * 1024 * 1024];
        arr5=null;
        byte[] arr6 = new byte[6 * 1024 * 1024];
        arr6=null;
    }

}
