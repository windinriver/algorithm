package leetcode.dynamicPro;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Rob198 {

    //如果dp[i] 表示 以前i个房间的最大值， 那么可以推导出状态转移方程 dp[i] = Max(dp[i-1], dp[i-2]+nums[i])
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        //01 确认dp[i]表示以i结尾的最大值
        int[] dp = new int[nums.length];
        // 02确认边界
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+ nums[i]);
        }
        return dp[nums.length-1];
    }
}
