package leetcode.dynamicPro;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLIS300 {


    public static void main(String[] args) {
        System.out.println(new LengthOfLIS300().lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }

    //用一个数组表示 长度为i的最长上升子序列结尾的数字 最小是 n
    //当遍历的值大于栈顶，入栈， 否则遍历栈找到大于等于 当前值的进行替换
    //找到的时候使用二分查找 可以达到复杂度为O（nlogn）
    public int lengthOfLIS(int[] nums) {
        int[] stack = new int[nums.length];
        stack[0] = nums[0];
        int top = 0;
        for (int i = 1; i < nums.length; i++) {
//            当遍历的值大于栈顶，入栈
            if (nums[i] > stack[top]) {
                stack[++top] = nums[i];
            } else {
                //二分查找优化(测试比直接找还慢)
                int begin = 0;
                int end = top;
                //取左边界
                while (begin < end) {
                    int mid = (begin + end) >> 1;
                    if (nums[i] <= stack[mid]) {
                        end = mid;
                    } else {
                        begin = mid + 1;
                    }
                }
                if (begin < nums.length) {
                    stack[begin] = nums[i];
                }
//                for (int j = 0; j <= top; j++) {
//                    if (nums[i] <= stack[j]) {
//                        stack[j] = nums[i];
//                        break;
//                    }
//                }
            }
        }
        return top+1;
    }

    //暴力递归复杂度是 O（n^2）
    //dp[i]若表示前i个数字的最长递增子序列，发现没有规律
    //dp[i]表示以第i个数字结尾的最长递增子序列，那么dp[i] = dp[0...i] + 1 。 这样的话每次需要遍历0-i，复杂度也是O(n2)
    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        //边界
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                //说明dp[i] 可以和dp[j]构成上升子序列
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                } else if (dp[i] == 0) {
                    dp[i] = 1;
                }
            }
        }
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;

    }
}
