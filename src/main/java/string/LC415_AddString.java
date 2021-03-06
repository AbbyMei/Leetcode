package string;

import org.junit.Test;

/**
 * @Author: MLY
 * @Description:
 * @Date: Created in 10:35 2020/2/24
 * @Modified By:
 */
//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
//
// 注意：
//
//
// num1 和num2 的长度都小于 5100.
// num1 和num2 都只包含数字 0-9.
// num1 和num2 都不包含任何前导零。
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
//
// Related Topics 字符串
public class LC415_AddString {
    public String addStrings(String num1, String num2) {
        StringBuilder ret = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            ret.append(tmp % 10);
            i--;
            j--;
        }
        if (carry == 1) ret.append(1);
        return ret.reverse().toString();
    }

    @Test
    public void testAddString() {
        System.out.println(addStrings("347", "658"));
    }
}
