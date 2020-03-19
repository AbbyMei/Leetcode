import org.junit.Test;

/**
 * @Author: MLY
 * @Description:
 * @Date: Created in 11:46 2020/2/19
 * @Modified By:
 */
//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//
// 示例 1:
//
// 输入: 123
//输出: 321
//
//
// 示例 2:
//
// 输入: -123
//输出: -321
//
//
// 示例 3:
//
// 输入: 120
//输出: 21
//
//Integer.MAX_VALUE=2147483647(十进制)
// 注意:
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
// Related Topics 数学
public class ReverseInt {
    public int reverse(int i) {
        int ret = 0;
        while (i != 0) {
            int pop = i % 10;
            i /= 10;
            if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            ret = ret * 10 + pop;
        }
        return ret;
    }

    @Test
    public void testReverseInt() {
        System.out.println(reverse(123));
    }
}
