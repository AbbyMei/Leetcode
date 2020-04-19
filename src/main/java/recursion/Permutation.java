package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法
public class Permutation {
    //从第K位开始的全排列
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> nums_list = new ArrayList<Integer>();
        for (int num : nums) {
            nums_list.add(num);
        }
        solution1(nums_list, ret, 0);
        return ret;
    }

    private void solution1(List<Integer> nums_list, List<List<Integer>> ret, int k) {
        if (k == nums_list.size() - 1) {
            ret.add(new ArrayList<Integer>(nums_list));
        }
        for (int i = k; i < nums_list.size(); i++) {
            Collections.swap(nums_list, k, i);
            solution1(nums_list, ret, k + 1);
            Collections.swap(nums_list, k, i);
        }
    }


}
