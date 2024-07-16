package org.example.leetcode;

import org.junit.Test;

import java.util.HashSet;

/**
 * 无重复字符的最长子串 not done
 */
public class A003LengthOfLongestSubstringTest {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        int maxLen = Integer.MIN_VALUE;
        HashSet<Character> charSet = new HashSet<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if (charSet.contains(rightChar)) {
                // 从左指针开始删，一直删到第一个重复字符
                charSet.remove(s.charAt(left));
                left++;
                while (s.charAt(left) != rightChar) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
            } else {
                charSet.add(rightChar);
                maxLen = Integer.max(maxLen, charSet.size());
            }
        }
        return maxLen;
    }

    @Test
    public void normalCase() {
        assert lengthOfLongestSubstring("abcabcbb") == 3;
    }

    @Test
    public void allSameCharCase() {
        assert lengthOfLongestSubstring("aaaaa") == 1;
    }

    @Test
    public void onlyOneCharCase() {
        assert lengthOfLongestSubstring("a") == 1;
    }

    @Test
    public void emptyStringCase() {
        assert lengthOfLongestSubstring("") == 0;
    }

    @Test
    public void notLinkCase() {
        assert lengthOfLongestSubstring("pwwkew") == 3;
    }

    @Test
    public void specialCharCase() {
        assert lengthOfLongestSubstring("aabaab!bb") == 2;
    }

    @Test
    public void simpleCase() {
        assert lengthOfLongestSubstring("aab") == 2;
    }

}
