package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 */
public class Permutation38 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Permutation38().permutation("abc")));
    }

    //01 要什么给什么
    public List<String> result = new ArrayList<>();

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        dfs(new StringBuffer(), chars, new boolean[chars.length]);
        String[] strings = new String[result.size()];
        return result.toArray(strings);
    }
    //02 定义递归
    private void dfs(StringBuffer item,char[] chars, boolean[] used) {
        //03 结束
        if (item.length() == chars.length) {
            result.add(item.toString());
            return;
        }
        //04 选择
        for (int i = 0; i < chars.length; i++) {
            if(used[i]) {
                continue;
            }
            if (i > 0 && chars[i] == chars[i-1] && !used[i-1]) {
                continue;
            }
            //05 递归
            item.append(chars[i]);
            used[i] = true;
            dfs(item,chars, used);
            //06 回溯
            item.deleteCharAt(item.length() -1);
            used[i] = false;
        }
    }
}
