package org.example.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * N字形转换
 */
public class A006NConvert {
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) {
            sb.append(row.toString());
        }
        return sb.toString();
    }

    @Test
    public void case1() {
        String res = convert("PAYPALISHIRING", 3);
        assert Objects.equals(res, "PAHNAPLSIIGYIR");
    }

    @Test
    public void case2() {
        String res = convert("PAYPALISHIRING", 4);
        assert Objects.equals(res, "PINALSIGYAHRPI");
    }
}
