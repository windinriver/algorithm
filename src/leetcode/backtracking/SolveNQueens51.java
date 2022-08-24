package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveNQueens51 {

    public static void main(String[] args) {
        System.out.println(new SolveNQueens51().solveNQueens(4));
    }

    //01 要什么给什么
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        dfs(new ArrayList<>(), n, 0, new int[n]);
        return result;
    }

    /**
     *
     * @param item 存每一个结果
     * @param n   棋盘大小
     * @param row   当前处理第几行
     * @param mark   用于判断当前列是否可以放
     *               mark[0]  表示第0行皇后的位置
     *               mark[1]  第一行皇后的位置
     */
    //02 写递归函数
    private void dfs(List<String> item, int n, int row, int[] mark) {
        //03 结束条件
        if (row == n) {
            result.add(new ArrayList<>(item));
            return;
        }
        //遍历每一列，看是否可以存放
        for (int i = 0; i < n; i++) {
            //标识第row行的皇后存放在第i的位置
            mark[row] = i;
            if (isValid(mark, row)) {
                //生成当前行结果
                item.add(create(i, n));
                //04 递归
                dfs(item, n, row+1, mark);
                //05 回溯
                item.remove(item.size()-1);
            }
        }
    }

    private String create(int i, int n) {
        char[] c = new char[n];
        Arrays.fill(c, '.');
        c[i] = 'Q';
        return String.valueOf(c);
    }

    private boolean isValid(int[] mark, int row) {
        //只需要判断当前处理的row行前面的行
        for (int i = 0; i < row; i++) {
            //判断是否处在同一列上
            if(mark[i] == mark[row]) {
                return false;
            }
            //是否在对角上
            if(Math.abs(row -i) == Math.abs(mark[row] - mark[i])) {
                return false;
            }
        }
        return true;
    }
}
