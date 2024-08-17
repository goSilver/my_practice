package org.example.window;

import org.junit.Test;

import java.util.HashSet;

/**
 * 最长无重复子串
 */
public class LengthOfLongestSubstringTest {
    public int lengthOfLongestSubstring(String str) {
        HashSet<Character> resSet = new HashSet<>();
        int left =0,right =0;
        int maxLen = 0;

        // 扩大窗口
        while (right < str.length()) {
            char cr = str.charAt(right);
            right++;
            if (!resSet.contains(cr)) {
                resSet.add(cr);
            } else  {
                // 记录maxLen
                maxLen = Math.max(maxLen, resSet.size());
                // 缩小窗口
                char cl = str.charAt(left);
                resSet.remove(cl);
                left++;
            }
        }
        return maxLen;
    }

    @Test
    public void case1() {
        assert  3 == lengthOfLongestSubstring("abcabcbb");
    }

    @Test
    public void case2() {
        assert  1 == lengthOfLongestSubstring("bbbbb");
    }

    @Test
    public void case3() {
        assert  3 == lengthOfLongestSubstring("pwwkew");
    }
}
