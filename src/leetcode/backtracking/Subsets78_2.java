package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
public class Subsets78_2 {
    public static void main(String[] args) {
        System.out.println(new Subsets78_2().subsets(new int[]{1, 2, 3}));
    }

    //思考：不需要回溯的时候怎么写
    public List<List<Integer>> subsets(int[] nums) {
        //第一步:要什么给什么
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, new ArrayList<>(), nums, 0);
        return result;

    }
    //第二步,定义递归函数
    public void backtracking(List<List<Integer>> resutl ,List<Integer> item, int[] nums, int start) {
        //第三步，递归结束条件
        if (start > nums.length) {
            return;
        }
        resutl.add(new ArrayList<>(item));
        //第四步，递归
        for (int i = start; i < nums.length; i++) {
            item.add(nums[i]);
            backtracking(resutl, item, nums, i+1);
            //第五步，回溯
            item.remove(item.size() - 1);
        }
    }
}
