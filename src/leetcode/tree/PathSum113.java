package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSum113 {
    public static void main(String[] args) {
        System.out.println(new PathSum113().pathSum(new TreeNode(3), 3));
    }

    //01 要什么给什么
    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(new ArrayList<>(), root, 0, targetSum);
        return result;
    }

    //02 定义递归
    private void dfs(List<Integer> item, TreeNode root, int curSum, int targetSum) {
        //03 end
        if (root == null) {
            return;
        }

        // 04 choose
        item.add(root.val);
        // 根节点
        if (root.left == null && root.right == null) {
            if (curSum + root.val == targetSum) {
                result.add(new ArrayList<>(item));
            }
        }
        //05 tracking

        dfs(item, root.left, curSum + root.val, targetSum);
        dfs(item, root.right, curSum + root.val, targetSum);
        //回溯
        item.remove(item.size() - 1);

    }

}
