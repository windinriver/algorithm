package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */

public class Permute {

    public static void main(String[] args) {
        System.out.println(new Permute().permute(new int[]{1,2,3}));
    }

    //01 要什么给什么
    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }
    //02 写递归，全排列和子集的差别在于这里要记录使用的元素，而子集使用start变量
    private void dfs(List<Integer> item, int[] nums,  boolean[] used) {
        //03 递归结束
        if (item.size() == nums.length) {
            result.add(new ArrayList<>(item));
            return;
        }

        //04 选择范围
        for (int i = 0; i < nums.length; i++) {
            //如果元素用过了,跳过
            if (used[i]) {
                continue;
            }
            //标记为用过
            item.add(nums[i]);
            used[i] = true;
            //05 递归
            dfs(item, nums, used);
            //06 回溯
            item.remove(item.size()-1);
            //回退标记
            used[i] = false;
        }
    }
}
