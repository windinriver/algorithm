package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 */
public class GenerateParenthesis22 {

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis22().generateParenthesis(3));
    }

    //01 要什么给什么
    List<String> result = new ArrayList<>();

    //深搜
    public List<String> generateParenthesis(int n) {
        dfs("", n, n);
        return result;
    }
    //02 递归定义
    private void dfs(String item, int left, int right) {
        //03 递归结束
        if (left == 0 && right == 0) {
            result.add(item);
        }
        //04递归
        if (left > 0) {
            dfs(item + "(", left - 1, right);
        }
        if (left < right) {
            dfs(item + ")", left, right -1);
        }
    }

}
