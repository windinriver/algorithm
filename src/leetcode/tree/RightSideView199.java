package leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * https://leetcode.cn/problems/binary-tree-right-side-view/description/
 */
public class RightSideView199 {


    //广度优先遍历
    //解法一: 记录当前层数量和下一层数量
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return result;
        }
        queue.add(root);
        int cur = 1;
        int next = 0;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            cur--;
            if (poll.left != null) {
                queue.add(poll.left);
                next++;
            }
            if (poll.right != null) {
                queue.add(poll.right);
                next++;
            }
            if (cur == 0) {
                result.add(poll.val);
                cur = next;
                next = 0;
            }
        }
        return result;
    }


    //解法二： 每一层打应完队列中的数量就是下一层要打应的数量
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return result;
        }
        queue.add(root);
        int cur = 1;
        while (!queue.isEmpty()) {
            //当前层树的数量
            cur = queue.size();
            while (cur > 0) {
                TreeNode poll = queue.poll();
                cur = cur - 1;
                if (cur == 0) {
                    result.add(poll.val);
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return result;
    }

}
