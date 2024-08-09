package org.example.leetcode;

import org.junit.Test;

public class A007ReverseTest {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res < Integer.MIN_VALUE/10 || res > Integer.MAX_VALUE/10) return 0;
            res = res * 10 + x % 10;
            x = x / 10;
        }
        System.out.println(res);
        return res;
    }

    @Test
    public void case0() {
        assert 0 == reverse(0);
    }

    @Test
    public void case1() {
        assert 123 == reverse(321);
    }

    @Test
    public void case2() {
        assert -123 == reverse(-321);
    }
}
