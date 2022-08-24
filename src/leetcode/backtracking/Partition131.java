package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 */
public class Partition131 {

    public static void main(String[] args) {
        System.out.println(new Partition131().partition("aab"));
    }

    //01 要什么给什么
    public List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
       dfs(new ArrayList<>(), s, 0);
       return result;
    }

    //02 递归定义
    private  void dfs(List<String> item, String s, int start) {
        //03 end
        if (start > s.length() -1) {
            result.add(new ArrayList<>(item));
            return;
        }
        //04 选择(画递归树)
        for (int i = start; i < s.length(); i++) {
            if (isHuiWen(s.substring(start, i+1))) {
                item.add(s.substring(start, i+1));
                //05 递归
                dfs(item, s, i + 1);
                //06 回溯
                item.remove(item.size()-1);
            }
        }
    }

    //判断是否回文串
    private boolean isHuiWen(String s) {
        int mid = s.length()/2;
        int len = s.length();
        for (int i = 0; i < mid; i++) {
            if (s.charAt(i) != s.charAt(len - i -1)) {
                return false;
            }
        }
        return true;
    }
}
