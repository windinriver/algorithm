package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum39 {

    public static void main(String[] args) {
        System.out.println(new CombinationSum39().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    //01 要什么给什么
    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(0, new ArrayList<>(), candidates, 0, target);
        return result;
    }

    //02 递归定义
    public void dfs(int cur, List<Integer> item, int[] candidates, int start, int target) {
        //03 结束递归
        if (cur == target) {
            result.add(new ArrayList<>(item));
            return;
        }
        //剪枝
        if (start > candidates.length || cur > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            item.add(candidates[i]);
            //04 递归  （可以重复使用，那么起始位置还是i）
            dfs(cur + candidates[i], item, candidates, i, target);
            //05 回溯
            item.remove(item.size() -1);
        }
    }
}
