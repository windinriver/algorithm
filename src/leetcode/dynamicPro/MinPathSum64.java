package leetcode.dynamicPro;


/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *说明：每次只能向下或者向右移动一步。
 **/
public class MinPathSum64 {

    //第一行第一列为边界值
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int rows = grid.length;
        int cols = grid[0].length;
        dp[0][0] = grid[0][0];
        //处理第一列
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        //处理第一列
        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
               dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
            }
        }
        return dp[rows-1][cols-1];
    }
}
