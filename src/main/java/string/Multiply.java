package string;

import org.junit.Test;

/**
 * @Author: MLY
 * @Description:
 * @Date: Created in 23:04 2020/2/21
 * @Modified By:
 */

//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
// 示例 1:
//
// 输入: num1 = "2", num2 = "3"
//输出: "6"
//
// 示例 2:
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088"
//
// 说明：
//
//
// num1 和 num2 的长度小于110。
// num1 和 num2 只包含数字 0-9。
// num1 和 num2 均不以零开头，除非是数字 0 本身。
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
//
// Related Topics 数学 字符串

public class Multiply {
    private String multiply(String nums1, String nums2) {
        if (nums1.equals("0") || nums2.equals("0"))
            return "0";
        String ret = "0";
        for (int i = nums2.length() - 1; i >= 0; i--) {
            StringBuilder sb1 = new StringBuilder("");
            for (int j = 0; j < nums2.length() - 1 - i; j++) {
                sb1.append(0);
            }
            sb1.append(0);
            int carry = 0;
            int n2 = nums2.charAt(i) - '0';
            for (int j = nums1.length() - 1; j >= 0; j--) {
                int n1 = nums1.charAt(j) - '0';
                int tmp = n1 * n2 + carry;
                carry = tmp / 10;
                sb1.append(tmp % 10);
            }
            ret = addStrings(ret, sb1.reverse().toString());
        }
        return ret;
    }

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
    public void testMultiply() {
        System.out.println(multiply("123", "456"));
    }
}

