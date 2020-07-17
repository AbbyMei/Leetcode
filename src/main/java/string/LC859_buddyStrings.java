package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。

示例 1：
输入： A = "ab", B = "ba"
输出： true
示例 2：
输入： A = "ab", B = "ab"
输出： false
示例 3:
输入： A = "aa", B = "aa"
输出： true
示例 4：
输入： A = "aaaaaaabc", B = "aaaaaaacb"
输出： true
示例 5：
输入： A = "", B = "aa"
输出： false

提示：
0 <= A.length <= 20000
0 <= B.length <= 20000
A 和 B 仅由小写字母构成。

* */
public class LC859_buddyStrings {
    /**
     * 这道题首先判断两个字符串长度是否相等，长度不相等不可能是亲密字符串。
     * 长度相等时，再比较两个字符串是否相等。
     * 两个字符串相等：则查找在A或者B中是否有相同字符出现，有则是亲密字符串，没有就不是亲密字符串。
     * 两个字符串不相等：先遍历记录不相等的字符个数和位置。不相等的字符数不等于2就不是亲密字符串。
     * 不相等的字符数等于2：A交换这两个字符，再与B比较，相等就是亲密字符串。
     */
    public boolean buddyStrings(String A, String B) {
        int l1 = A.length();
        int l2 = B.length();
        if(l1 != l2){
            return false;
        }
        if(A.equals(B)){
            Set<Character> set = new HashSet<>();
            for(char c : A.toCharArray()){
                if(set.contains(c)){
                    return true;
                }else{
                    set.add(c);
                }
            }
        }else{
            int diffSize = 0;
            List<Integer> list = new ArrayList<>();
            for(int i = 0 ; i < l1; i++){
                if(A.charAt(i) != B.charAt(i)){
                    diffSize++;
                    list.add(i);
                }
            }
            if(diffSize == 2){
                int i = list.get(0);
                int j = list.get(1);
                char tmp = A.charAt(i);
                StringBuilder sb = new StringBuilder(A);
                sb.setCharAt(i,A.charAt(j));
                sb.setCharAt(j,tmp);
                if(B.equals(sb.toString())){
                    return true;
                }
            }
        }
        return false;
    }
}
