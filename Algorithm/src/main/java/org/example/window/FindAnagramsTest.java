package org.example.window;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 寻找所有字母的异位词
 */
public class FindAnagramsTest {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        ArrayList<Integer> res = new ArrayList<>();

        // 向右扩大窗口
        while (right < s.length()) {
            char cr = s.charAt(right);
            right++;
            if (need.containsKey(cr)) {
                window.put(cr, window.getOrDefault(cr, 0) + 1);
                if (window.get(cr).equals(need.get(cr)))
                    valid++;
            }

            // 判断是否需要收缩窗口
            while (right - left >= p.length()) {
                // 满足条件时记录下标
                if (valid == p.length()) {
                    res.add(left);
                }

                // 缩小窗口
                char cl = s.charAt(left);
                left++;
                if (need.containsKey(cl)) {
                    if (window.get(cl).equals(need.get(cl)))
                        valid--;
                    window.put(cl, window.getOrDefault(cl, 0) - 1);
                }
            }
        }
        return res;
    }

    @Test
    public void case1() {
        List<Integer> res = findAnagrams("cbaebabacd", "abc");
        System.out.println(res);
    }

    @Test
    public void case2() {
        List<Integer> res = findAnagrams("abab", "ab");
        System.out.println(res);
    }
}
