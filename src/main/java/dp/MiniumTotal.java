package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
//
// 例如，给定三角形：
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//
// 说明：
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
// Related Topics 数组 动态规划
public class MiniumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        //return solution1(triangle,0,0);
        //return solution2(triangle,0,0);
        return solution3(triangle, 0, 0);
    }

    //递归算法
    private int solution1(List<List<Integer>> triangle, int i, int j) {
        if (i >= triangle.size()) {
            return 0;
        }
        return Math.min(solution1(triangle, i + 1, j), solution1(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }

    //保存中间态结果
    private int solution2(List<List<Integer>> triangle, int i, int j) {
        if (i >= triangle.size()) {
            return 0;
        }
        String key = i + "" + j;
        Map<String, Integer> map = new HashMap<String, Integer>();
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int left = solution2(triangle, i + 1, j);
        int right = solution2(triangle, i + 1, j + 1);
        int ret = Math.min(left, right) + triangle.get(i).get(j);
        map.put(key, ret);
        return ret;
    }

    //动态规划
    private int solution3(List<List<Integer>> triangle, int i, int j) {
        List<Integer> min = new ArrayList<Integer>();
        int col = triangle.get(triangle.size() - 1).size();
        int row = triangle.size() - 1;
        for (int k = 0; k < col; k++) {
            min.add(triangle.get(row).get(k));
        }
        for (int k = row - 1; k >= 0; k--) {
            for (int l = 0; l < triangle.get(k).size(); l++) {
                int tmp = Math.min(min.get(l), min.get(l + 1)) + triangle.get(k).get(l);
                min.set(l, tmp);
            }
        }
        return min.get(0);
    }


}
