package string;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * */

public class LC67_AddBinary {
  public String addBinary(String a, String b){
      StringBuilder sb = new StringBuilder();
      int l1 = a.length() - 1;
      int l2 = b.length() - 1;
      int carry = 0;
      int count = 0;
      while(l1 >= 0 && l2 >=0){
          count = (a.charAt(l1) - '0') + (b.charAt(l2) - '0') + carry;
          carry = count/2;
          count = count%2;
          sb.append(count);
          l1--;
          l2--;
      }
      while(l1 >= 0){
          count = (a.charAt(l1) - '0') + carry;
          carry = count/2;
          count = count%2;
          sb.append(count);
          l1--;
      }
      while(l2 >= 0){
          count = (b.charAt(l2) - '0') + carry;
          carry = count/2;
          count = count%2;
          sb.append(count);
          l2--;
      }
      if(carry == 1){
          sb.append(carry);
      }
      return sb.reverse().toString();
  }
}
