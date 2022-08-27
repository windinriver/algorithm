package leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 */
public class LevelOrder102 {

    //跟199 题一个道理， 宽度搜索
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int cur = queue.size();
            List<Integer> item = new ArrayList<>();
            while (cur > 0) {
                TreeNode poll = queue.poll();
                item.add(poll.val);
                cur = cur - 1;
                if (poll.left != null) {
                    queue.add(poll.left);
                    //shift + enter跳到下一行
                }
                if (poll.right !=  null) {
                    queue.add(poll.right);
                }
                if (cur == 0) {
                    result.add(item);
                }
            }
        }
        return result;
    }
}
