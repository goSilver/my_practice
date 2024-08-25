package org.example.window;

import org.junit.Test;

import java.util.HashMap;

/**
 * 气球游戏
 */
public class BalloonGameTest {
    private Integer result = Integer.MAX_VALUE;

    public int balloonGame(int m, int n, int[] balloon) {
        HashMap<Integer, Integer> window = new HashMap<>();
        HashMap<Integer, Integer> need = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            need.put(i, 1);
        }

        int left = 0, right = 0;
        int hit = 0;

        while (right < n) {
            // 扩大窗口
            int curBalloon = balloon[right];
            right++;
            if (need.containsKey(curBalloon)) {
                window.put(curBalloon, window.getOrDefault(curBalloon, 0) + 1);
                if (window.get(curBalloon).equals(need.get(curBalloon))) {
                    hit++;
                }
            }

            // 收缩窗口
            while (hit == m) {
                result = Math.min(result, right - left);
                int leftBalloon = balloon[left];
                left++;
                if (need.containsKey(leftBalloon)) {
                    if (window.get(leftBalloon).equals(need.get(leftBalloon))) {
                        hit--;
                    }
                    window.put(leftBalloon, window.get(leftBalloon) - 1);
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    @Test
    public void case1() {
        int[] balloon = new int[]{2, 5, 3, 1, 3, 2, 4, 1, 0, 5, 4, 3};
        int res = balloonGame(5, 12, balloon);
        System.out.println(res);
        assert res == 6;
    }

    @Test
    public void case2() {
        int[] balloon = new int[]{2, 5, 3, 1, 3, 2, 4, 1, 5, 0, 4, 3};
        int res = balloonGame(5, 12, balloon);
        System.out.println(res);
        assert res == 5;
    }
}
