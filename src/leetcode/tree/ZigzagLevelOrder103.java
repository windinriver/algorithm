package leetcode.tree;


import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class ZigzagLevelOrder103 {

    public static void main(String[] args) {

    }

    //本质上还是广度优先遍历
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        //先往队列放
        queue.add(root);
        //如果为true，放入队列，否则放入队尾
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> item = new LinkedList<>();
            while (size > 0) {
                TreeNode first = queue.pollFirst();
                if (flag) {
                    item.addFirst(first.val);
                } else {
                    item.addLast(first.val);
                }
                if (first.left!= null) {
                    queue.add(first.left);
                }
                if (first.right != null) {
                    queue.add(first.right);
                }
                size--;
            }
            flag = !flag;
            result.add(new ArrayList<>(item));
        }
        return result;
    }
}
