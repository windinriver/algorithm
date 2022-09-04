package leetcode.dynamicPro;



import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class UniquePaths62 {

    //动态规划 dp[i][j]代表到i,j一共有多少种
    //边界值 0行0列是1
    //转移方程 dp[i][j] = dp[i][j-1] + dp[i-1][j];
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //边界值初始化
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    //1  深度搜索？
    //TODO 深度搜索？
    public int uniquePaths2(int m, int n) {
        int[][] map = new int[m+1][n+1];
        //外墙赋值为1
        for (int i = 0; i < n+1; i++) {
            map[m-1][i] = 1;
        }
        //最后一列
        for (int i = 0; i < m + 1; i++) {
            map[i][n-1] = 1;
        }
        Deque<Block> stack = new ArrayDeque<>();
        stack.push(new Block(0, 0));
        int result = 0;
        while (!stack.isEmpty()) {


        }
        return 0;
    }

    class Block {
        int x;
        int y;
        //0 向左， 1 向下
        int dx = 0;

        public Block(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
