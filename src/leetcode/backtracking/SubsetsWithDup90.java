package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *  
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubsetsWithDup90 {


    public static void main(String[] args) {
        System.out.println(new SubsetsWithDup90().subsetsWithDup(new int[]{1, 2, 2}));
    }

    //第一步要什么给什么
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
//       记住排序是剪枝的前提就行了
        Arrays.sort(nums);
        dfs(new ArrayList<>(), nums, 0);
        return result;
    }

    //2 定义递归
    public void dfs(List<Integer> item, int nums[], int start) {
        //3 递归结束
        if (start> nums.length) {
            return;
        }
        result.add(new ArrayList<>(item));
        for (int i = start; i < nums.length; i++) {
            //如果这个数和前一个数相同，跳过
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            item.add(nums[i]);
            //4 递归
            dfs(item, nums, i+1);
            //5 回溯
            item.remove(item.size()-1);
        }
    }
}
