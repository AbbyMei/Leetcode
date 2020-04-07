package string;

import org.junit.Test;

import java.util.*;

/**
 * @Author: MLY
 * @Description:
 * @Date: Created in 20:05 2020/2/21
 * @Modified By:
 */
//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。
// 示例1:
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 示例2:
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
//
// 注意：
// 输入的字符串只包含小写字母
// 两个字符串的长度都在 [1, 10,000] 之间
//
// Related Topics 双指针 Sliding Window
//1、判断是否包含 s1 的排列的方法：
//截取 s2 中某长度和 s1 字符串长度相等的子串，判断两者每个字符的数量是否一致即可。
//
//2、统计字符数量
//由于字符串只包含 26 个小写字母，我们可以使用 计数排序 来统计，即创建一个长度为 26 的数组，其下标 0 ~ 25 对应 a ~ z 的每个字母，
// 其值为对应字母出现的次数。
//3、判断条件
//先统计 s1 的字符数量 count1，再依次统计 s2 中与之长度相等的子串的字符数量 count2，比较两者是否相同。
public class CheckInclusion {
    public boolean checkInclusion(String s1,String s2){
        int l1 = s1.length();
        int l2 = s2.length();
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for(char c : s1.toCharArray())
            c1[c-'a']++;

        for(int i=0;i<l2;i++)
        {
            if(i>=l1)
                c2[s2.charAt(i-l1)-'a']--;
            c2[s2.charAt(i)-'a']++;
            if(Arrays.equals(c1, c2))
                return true;
        }
        return false;
    }

    @Test
    public void testCheckInclusion(){
        System.out.println(checkInclusion("ab","eidbaooo"));
    }


}
