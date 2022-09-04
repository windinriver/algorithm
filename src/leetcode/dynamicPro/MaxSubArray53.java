package leetcode.dynamicPro;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6
 */
public class MaxSubArray53 {

    public static void main(String[] args) {
        System.out.println(new MaxSubArray53().maxSubArray(new int[]{4, -1, 2, 1}));
    }

    public int result = 0;
    //若假设第i个状态(dp[i])代表前i个数字组成的连续的最大子段和, 由于有连续的限制，无法推出状态方程
    //用题目的内在关系转化成状态， dp[i]表一以i结尾的最大连续子串
    //那么 dp[i] = max(dp[i-1]+nums[i], nums[i])
    public int maxSubArray(int[] nums) {
        //01 dp[i]表一以i结尾的最大连续子
        int[] dp = new int[nums.length];
        //02 边界
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //03 转移
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return result;

    }

    //暴力递归？？ 复杂度是O(n^2) 连续
    private void dfs(int[] nums, int start, int item, int pre) {
        if (start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            //加上连续的限制
            if (i - pre > 1) {
                continue;
            }
           item +=  nums[i];
           if (item > result) {
               result = item;
           }
           //递归
            dfs(nums, i+1, item, i);
           //回溯
            item -= nums[i];
        }
    }
}
