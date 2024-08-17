package org.example.window;

import org.junit.Test;

import java.util.HashMap;

/**
 * 最小覆盖子串
 */
public class MinCoverStringTest {
    public String minCoverString(String str, String target) {
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();

        for (char c : target.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的索引起始位置及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < str.length()) {
            // c是即将移入窗口的字符
            char c = str.charAt(right);
            // 窗口扩大
            right++;

            // 进行窗口内的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            // 判断左侧窗口是否需要收缩
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                // 缩小左侧窗口
                char cl = str.charAt(left);
                left++;
                if (need.containsKey(cl)) {
                    if (window.get(cl).equals(need.get(cl)))
                        valid--;
                    window.put(cl, window.get(cl) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : str.substring(start, start + len);
    }

    @Test
    public void case1() {
       assert "BANC".equals(minCoverString("ADOBECODEBANC", "ABC"));
    }

    @Test
    public void case2() {
        assert "a".equals(minCoverString("a", "a"));
    }

    @Test
    public void case3() {
        assert "".equals(minCoverString("a", "aa"));
    }

}
