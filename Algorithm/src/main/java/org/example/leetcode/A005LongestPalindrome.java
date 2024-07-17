package org.example.leetcode;

import org.junit.Test;

import java.util.Objects;

public class A005LongestPalindrome {
    public String longestPalindrome(String s) {
        return null;
    }

    @Test
    public void case1() {
        String res = longestPalindrome("babad");
        assert Objects.equals(res, "bab");
    }

}
