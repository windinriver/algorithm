package leetcode.dynamicPro;

/**
 * 设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class ClimbStairs70 {
    public static void main(String[] args) {
        System.out.println(new ClimbStairs70().climbStairs(3));
    }

    //动态规划
//    1.确认原问题与子问题
    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        //    2. 确认状态（一维还是二维）,dp[i] 代表什么， dp[i][j] 代表什么
        //    dp[i] 表示第i 个台阶有多少种走法
        int[] dp = new int[n];
        //    3 确认状态边界  不需要递推的值
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            //    4 确认递推方程
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }

    //暴力递归
    public int dfs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        else return dfs(n-1) + dfs(n - 2);
    }

}
