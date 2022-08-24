package leetcode.backtracking;

import java.util.Arrays;
import java.util.Collections;

/**
 * 给定一个整数数组  nums 和一个正整数 k，
 * 找出是否有可能把这个数组分成 k 个非空子集，其总和都相等
 * <p>
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/partition-to-k-equal-sum-subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanPartitionKSubsets698 {

    public static void main(String[] args) {
        System.out.println(new CanPartitionKSubsets698().canPartitionKSubsets(new int[]{1,1,1,1,2,2,2,2}, 4));
    }

    //题解 https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/solution/javahui-su-jian-zhi-shou-ba-shou-jiao-hu-0equ/
    //贪心 + 回溯 + 剪枝
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        //表示元素是否使用过
        boolean[] used = new boolean[nums.length];
        //从小到大排序， 根据贪心思想，从大的元素开始尝试
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        if(sum%k!=0)
            return false;
        int target=sum/k;
        if(nums[nums.length-1]>target)
            return false;
        return dfs(nums, target, 0, k, nums.length-1, used);
    }

    //02定义递归
    private boolean dfs(int[] nums, int target, int curSum, int k, int start, boolean[] used) {
        //03 结束条件？ 当k-1个集合满足了，那么剩下的也一定满足
        if (k == 1) {
            return true;
        }
        if (curSum == target) {
            return dfs(nums, target, 0, k -1 , nums.length-1, used);
        }
        //04 选择
        for (int i = start; i >= 0; i--) {
            if (!used[i]) {
                //剪枝
                if (curSum + nums[i] > target) {
                    continue;
                }
                //剪枝
                if (i < start && nums[i] == nums[i + 1] && !used[i+1]) {
                    continue;
                }
                //小于或等于则可以选
                used[i] = true;

                //05 递归
                //如果添加了这个元素后完成了题目要求，就return true.
                if (dfs(nums, target, curSum + nums[i], k, i - 1, used)) {
                    return true;
                }
                //06 回溯
                used[i] = false;
            }
        }
        return false;
    }

}
