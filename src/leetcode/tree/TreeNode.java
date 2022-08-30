package leetcode.tree;


import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNode {

    public int val;

    //记录左子树的数量
    public int count;

    public TreeNode left;

    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) { this.val = val; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    /**
     * 二插查找树插入
     * @param root 二插查找树
     * @param node 插入节点
     */
    public static void BST_INSERT(TreeNode root, TreeNode node) {
        //若小于当前节点
        if (node.val < root.val) {
            if (root.left!=null) {
                BST_INSERT(root.left, node);
            } else{
                root.left = node;
            }
        } else {
            if (root.right != null) {
                BST_INSERT(root.right, node);
            } else {
                root.right = node;
            }
        }
    }

    /**
     * 二插查找树插入
     * @param root 二插查找树
     * @param val 插入节点
     */
    public static void BST_INSERT(TreeNode root, int val) {
        //若小于当前节点
        if (val < root.val) {
            if (root.left!=null) {
                BST_INSERT(root.left, val);
            } else{
                root.left = new TreeNode(val);
            }
        } else {
            if (root.right != null) {
                BST_INSERT(root.right, val);
            } else {
                root.right = new TreeNode(val);
            }
        }
    }


    public static boolean BST_SEARCH(TreeNode root, int val) {
        if (root== null) {
            return false;
        }
        if (root.val == val) {
            return true;
        }
        if (root.val < val) {
            BST_INSERT(root.right, val);
        }
        if (root.val > val) {
            BST_INSERT(root.left, val);
        }
        return false;
    }


    /**
     * 先序遍历,先访问根节点，再访问左右子树
     * @param node 根节点
     */
    public static void preOrder(TreeNode node) {
        if (node != null) {
            System.out.println(node.val);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 中序遍历左子树，再访问根节点， 中序遍历右子树
     * @param node
     */
    public static void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.val);
            inOrder(node.right);
        }
    }

    /**
     * 后续遍历，先左子树，再后子树，再根
     * @param node
     */
    public static void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.val);
        }
    }

    /**
     * 宽度优先遍历
     * @param node 根节点
     */
    public static void bfsOrder(TreeNode node) {
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        if (node != null) {
            queue.add(node);
        }
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.println(poll.val);
            if (poll.left!= null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
    }

    /**
     * 创建树需要先序和中序遍历节点 ，或者中序和后续遍历节点
     * @return 创建好的树的根节点
     */
    public static TreeNode creTreePreInOrder(int[] pre, int[] in, int len) {
        //TODO
        return null;
    }

    /**
     * 根据后续序列和中序序列创建树
     * @param post 后续
     * @param in 中序
     * @return 根
     */
    public static TreeNode creTreePostInOrder(int[] post, int[] in) {
        //TODO
        return null;
    }

}
