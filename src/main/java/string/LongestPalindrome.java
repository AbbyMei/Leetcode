package string;

import org.junit.Test;

/**
 * @Author: MLY
 * @Description:
 * @Date: Created in 23:20 2020/2/17
 * @Modified By:
 */

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规划

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        return solution1(s);
    }

    //暴力枚举出所有的回文子串
    public String solution1(String s) {

        if (s == null || s.length() == 0)
            return "";
        int len = s.length();
        int min = 0;
        String ret = "";
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len + 1; j++) {
                if (isPalindrome(s.substring(i, j))) {
                    if (s.substring(i, j).length() > min) {
                        min = s.substring(i, j).length();
                        ret = s.substring(i, j);
                    }
                }
            }
        }

        return ret;
    }


    public boolean isPalindrome(String s) {
        int len = s.length();
        int begin = 0;
        int end = len - 1;
        while (begin <= end) {
            if (s.charAt(begin) == s.charAt(end)) {
                begin++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }


    public String solution2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start;
        int end;
        int maxStart = 0;
        int maxEnd = 0;
        String ret = "";

        for (int i = 0; i < s.length(); i++) {
            start = i;
            end = i + 1;

            while (start > -1 && end < s.length()) {
                if (s.charAt(start) != s.charAt(end))
                    break;
                start--;
                end++;
            }

            start++;
            end--;

            if ((end - start + 1) > (maxEnd - maxStart + 1)) {
                maxStart = start;
                maxEnd = end;
            }

            start = i;
            end = i;

            while (start > -1 && end < s.length()) {
                if (s.charAt(start) != s.charAt(end))
                    break;
                start--;
                end++;
            }

            start++;
            end--;

            if ((end - start + 1) > (maxEnd - maxStart + 1)) {
                maxStart = start;
                maxEnd = end;
            }


        }
        return s.substring(maxStart, maxEnd + 1);
    }

    @Test
    public void test() {
        System.out.println(solution2("a"));
    }


}
