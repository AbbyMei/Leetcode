package string;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * @Author: MLY
 * @Description:
 * @Date: Created in 20:14 2020/2/18
 * @Modified By:
 */

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
//
// Related Topics 数组 哈希表
public class LC01_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        /*return solution1(nums,target);*/
        return solution1(nums, target);
    }

    //暴力枚举
    public int[] solution1(int[] nums, int target) {
        int[] ret = new int[2];
        int len = nums.length;

        if (len != 0) {
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    if ((nums[i] + nums[j]) == target) {
                        ret[0] = i;
                        ret[1] = j;
                    }
                }
            }
        }
        return ret;
    }


    public int[] solution2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Set<Integer> set = map.keySet();
        for (Integer i : set) {
            int temp = target - map.get(i);
            if (map.containsKey(temp))
                return new int[]{i, map.get(temp)};
        }
        throw new IllegalArgumentException("No available Solution");
    }

    @Test
    public void testTwoSum() {
        int[] nums = {2, 7, 11, 3};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
}
