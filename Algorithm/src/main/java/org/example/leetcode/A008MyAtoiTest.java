package org.example.leetcode;

import org.junit.Test;

public class A008MyAtoiTest {
    public int myAtoi(String s) {
        if (s.isEmpty()) return 0;

        int res = 0;
        int index = 0;
        // 处理符号位
        int flag = 1;
        if (s.startsWith("-")) {
            flag = -1;
            index++;
        } else if (s.startsWith("+")) {
            index++;
        }

        while (48 <= (int)s.charAt(index) || (int)s.charAt(index) <= 57){
            res = res * 10 + (int)s.charAt(index) - 48;
            index++;
        }
        return res * flag;
    }

    @Test
    public void case0() {
        System.out.println((int)'0');
        System.out.println(Integer.valueOf('0'));
        System.out.println((int)'9');
        assert 42 == myAtoi("42");
    }

    @Test
    public void case1() {
        assert -42 == myAtoi("-042");
    }

    @Test
    public void case2() {
        assert 1337 == myAtoi("1337c0d3");
    }

    @Test
    public void case3() {
        assert 0 == myAtoi("0-1");
    }

    @Test
    public void case4() {
        assert 0 == myAtoi("words and 987");
    }

    @Test
    public void case5() {
        assert 0 == myAtoi("");
    }
}
