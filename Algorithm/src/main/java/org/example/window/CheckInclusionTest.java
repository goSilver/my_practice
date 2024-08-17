package org.example.window;

import org.junit.Test;

import java.util.HashMap;

/**
 * 字符串的排列
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 */
public class CheckInclusionTest {
    public boolean checkInclusion(String str, String target) {
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();

        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right =0;
        int valid = 0;

        while (right < str.length()) {
            char cr = str.charAt(right);
            right++;
            if (need.containsKey(cr)) {
                window.put(cr, window.getOrDefault(cr, 0) + 1);
                if (window.get(cr).equals(need.get(cr)))
                    valid++;
            }

            // 判断左侧窗口是否需要收缩
            while (right - left >= need.size()) {
                // 判断是否找到合法子串
                if (valid == need.size())
                    return true;
                char cl = str.charAt(left);
                left++;
                if (need.containsKey(cl)) {
                    if (window.get(cl).equals(need.get(cl)))
                        valid--;
                    window.put(cl, window.get(cl) - 1);
                }
            }
        }
        return false;
    }

    @Test
    public void case1() {
        assert checkInclusion("eidbaooo", "ab");
    }

    @Test
    public void case2() {
        assert !checkInclusion("eidboaoo", "ab");
    }

}
