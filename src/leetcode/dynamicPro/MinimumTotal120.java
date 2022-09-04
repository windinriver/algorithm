package leetcode.dynamicPro;

import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumTotal120 {

    //如果自上而下，需要考虑边界值，反向思维： 自下而上
    public int minimumTotal(List<List<Integer>> triangle) {
        //最小路径和
        int[][] dp= new int[triangle.size()][triangle.size()];
        //边界
        for (int i = 0; i < triangle.size(); i++) {
            //最后一行
            List<Integer> lastRow = triangle.get(triangle.size() - 1);
            dp[triangle.size()-1][i] = lastRow.get(i);
        }
        //从倒数第二行开始
        for (int i = triangle.size()-2; i >=0; i--) {
            for (int j = 0; j <= i; j++) {
                //状态转移方程
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];


    }

    /**
     * 使用 O(n)空间复杂度
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }


}
