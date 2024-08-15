package org.example.doubblepointer.array;

import org.junit.Test;

/**
 * 最长回文子串
 */
public class LongestPalindromeStringTest {
    public String longestPalindromeString(String str) {
        String res = "";
        for (int i = 0; i < str.length() - 1; i++) {
            // 存在字符个数为奇偶两种情况
            String s = palindromeString(str, i, i);
            String s1 = palindromeString(str, i, i + 1);
            res = res.length() > s.length() ? res : s;
            res = res.length() > s1.length() ? res : s1;
        }
        return res;
    }

    public String palindromeString(String str, int l, int r) {
        // 防止下标越界
        while (l >= 0 && r < str.length()
                && str.charAt(l) == str.charAt(r)) {
            // 向左右两边扩散
            l--;
            r++;
        }
        // 返回回文串
        return str.substring(l + 1, r);
    }

    @Test
    public void case1() {
        assert "aba".equals(longestPalindromeString("babad"));
    }

    @Test
    public void case2() {
        assert "bb".equals(longestPalindromeString("vbbd"));
    }
}
