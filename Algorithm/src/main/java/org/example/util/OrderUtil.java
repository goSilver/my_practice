package org.example.util;

/**
 * @author chensh
 * @datetime 2024/6/23 3:58 PM
 */
public class OrderUtil {

    /**
     * 判断数组是否升序
     *
     * @param arr 数组
     * @return 是否升序
     */
    public static boolean isOrderAsc(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
