package dp;
//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。
//
//
//
// 示例 1:
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3
//解释: 11 = 5 + 5 + 1
//
// 示例 2:
//
// 输入: coins = [2], amount = 3
//输出: -1
//
//
//
// 说明:
//你可以认为每种硬币的数量是无限的。

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CoinChange {

    public void coinChange(int[] coins, int amount) {
        solution1(coins, amount);
        solution2(coins,amount);
//        solution3(coins,amount);
    }


    private int solution2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        if (map.get(amount) != null) {
            return map.get(amount);
        }
        int ret = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int subMin = solution1(coins, amount - coins[i]);
            if (subMin == -1) continue;
            ret = Math.min(subMin + 1, ret);
        }

        if (ret == Integer.MAX_VALUE) {
            return -1;
        }

        map.put(amount, ret);
        return ret;
    }

    private int solution1(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        int ret = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int subMin = solution1(coins, amount - coins[i]);
            if (subMin == -1) continue;
            ret = Math.min(subMin + 1, ret);
        }

        if (ret == Integer.MAX_VALUE) {
            return -1;
        }
        return ret;
    }

    @Test
    public void testCoinChange() {
        int[] coins = {1, 2, 5};
        assertEquals(3, solution2(coins, 11));
    }


}
