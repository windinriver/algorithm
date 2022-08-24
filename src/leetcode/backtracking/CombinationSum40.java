package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum40 {

    public static void main(String[] args) {
        System.out.println(new CombinationSum40().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }


    //01 要什么给什么
    public List<List<Integer>> result = new ArrayList<>();

    //这个题有重复元素要去重
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(new ArrayList<>(), 0, 0, candidates, target);
        return result;
    }

    //02 定义递归
    public void dfs(List<Integer> item, int cur,  int start, int[] candidates, int target) {
        //03 递归结束
        if (cur == target) {
            result.add(new ArrayList<>(item));
            return;
        }
        //剪枝
        if (cur > target || start > candidates.length) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            item.add(candidates[i]);
            //04 递归
            dfs(item, cur + candidates[i], i + 1, candidates, target);
            item.remove(item.size() -1);
        }
    }
}
