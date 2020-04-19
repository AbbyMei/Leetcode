package recursion;
//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
// F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//
// 示例 1：
// 输入：n = 2
//输出：1
//
// 示例 2：
// 输入：n = 5
//输出：5
//
// 提示：
// 0 <= n <= 100
// Related Topics 递归

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.HashMap;

public class Fib {
    public void fib(int n) {
        int ret1 = solution1(n);
        int re2 = solution2(n);
        int ret3 = solution3(n);

    }

    //递归
    private int solution1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return solution1(n - 1) + solution1(n - 2);
    }

    //保存中间结果
    private int solution2(int n) {
        if (n == 1) return 1;
        if (n == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int result = solution2(n - 1) + solution2(n - 2);
        map.put(n, result);
        return result;

    }

    //类似动态规划
    private int solution3(int n) {
        if (n == 1) return 1;
        if (n == 0) return 0;
        int pre = 0;
        int cur = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = pre + cur;
            pre = cur;
            cur = result;
        }
        return result;
    }


    @Test
    public void testFib() {
        assertEquals(solution1(10), 55);
        assertEquals(solution2(10), 55);
        assertEquals(5, solution3(5));
    }


}
