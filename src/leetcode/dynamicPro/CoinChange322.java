package leetcode.dynamicPro;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CoinChange322 {


    public static void main(String[] args) {
        System.out.println(new CoinChange322().coinChange(new int[]{1, 2, 5}, 11));
    }
    //原问题与子问题：
    //dp[i]表示  i的金币需要的最少硬币个数
    //状态转移方程  dp[i] = dp[i - 面值] + 1: 如果dp[i] 为-1 说明无法组成
    //初始值 dp[面值] = 1
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = -1;
        }
        dp[0]=0;
        //02 边界: 可以省略
//        for (int i = 0; i < coins.length; i++) {
//            if (coins[i] <= amount) {
//                dp[coins[i]] = 1;
//            }
//        }
        //03 转移
        for (int i = 1; i <= amount; i++) {
            int min = -1;
            for (int j = 0; j < coins.length; j++) {
                // i - coins[j]必须是合法金额， 并且是可达的
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                    if (min==-1 || dp[i - coins[j]] + 1  < min) {
                        min = dp[i - coins[j]] + 1;
                    }
                }
            }
            dp[i] = min;
        }
        return dp[amount];
    }
}
