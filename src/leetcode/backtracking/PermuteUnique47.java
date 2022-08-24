package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 */
public class PermuteUnique47 {

    public static void main(String[] args) {
        System.out.println(new PermuteUnique47().permuteUnique(new int[]{1, 1,2}));
    }

    //01 要什么给什么
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        dfs(new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }
    //02 递归定义
    private void dfs(List<Integer> item, int[] nums, boolean[] used) {
        //03 递归结束
        if (item.size() == nums.length){
            result.add(new ArrayList<>(item));
            return;
        }

        //04 选择范围
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            //过滤重复
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }
            item.add(nums[i]);
            used[i] = true;
            //05 递归
            dfs(item, nums, used);
            //06 回溯
            item.remove(item.size() - 1);
            used[i] = false;
        }
    }
}
