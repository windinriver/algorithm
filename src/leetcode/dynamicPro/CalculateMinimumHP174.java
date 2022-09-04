package leetcode.dynamicPro;


/**
 * 些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 *
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 *
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 *
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 *
 *  
 *
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/dungeon-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CalculateMinimumHP174 {


    public static void main(String[] args) {
        System.out.println(new CalculateMinimumHP174().calculateMinimumHP(
                new int[][]{{-2, -3, 3},
                            {-5, -10, 1},
                            {10, 30, -5}}));
    }
    //如果从0点出发，发现很难得出至少需要多少，尝试从终点倒推
    //那么终点需要血量 max(1, 1 - dungeon[i][j])
    //边界值： 尾行尾列  dp[i][j] = max(1,  dp[i+1][j]- dungeon[i][j] +);
    //其他 dp[i][j] = max(1, min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j] )
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;;
        int cols = dungeon[0].length;
        int[][] dp = new int[rows][cols];
        dp[rows-1][cols-1] = Math.max(1, 1 - dungeon[rows-1][cols-1]);
        //最后一行
        for (int i = cols-2; i >= 0; i--) {
            dp[rows-1][i] = Math.max(1, dp[rows-1][i+1] -  dungeon[rows-1][i]);
        }
        //最后一列
        for (int i = rows-2; i >=0 ; i--) {
            dp[i][cols-1] = Math.max(1,   dp[i+1][cols-1] -dungeon[i][cols-1]);
        }
        //转移方程
        for (int i = rows -2 ; i  >= 0; i--) {
            for (int j = cols-2; j >= 0; j--) {
                //下一行，右一列取最小
                int min = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = Math.max(1, min - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}
