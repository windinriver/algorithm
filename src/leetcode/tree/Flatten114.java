package leetcode.tree;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Flatten114 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        TreeNode node2 = null;
        TreeNode node3 = new TreeNode(3);

        root.left = node;
        node.left = node3;


        new Flatten114().flatten(root);
        TreeNode.preOrder(root);
    }

    public void flatten(TreeNode root) {
        dfs(root);
    }
    private TreeNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }
        //先备份
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = null;
        //last记录最后一个节点
        TreeNode last = node;
        //存在左子树
        if (left != null) {
            last = dfs(left);
            //该节点右指针指向左指数
            node.right = left;

            //左子树的最后一个节点指向右子树
            last.right = right;
        }
        //遍历右子树
        if (right != null) {
            last = dfs(right);
        }
        return last;
    }



    //大神解法
    public void flatten2(TreeNode root){
        if(root==null){
            return;
        }
        flatten(root.left);
        flatten(root.right);

        //记录原来的右指针
        TreeNode temp = root.right;

        root.right=root.left;
        //左指针置为空
        root.left = null;
        //移到左子树的最后一个节点
        while (root.right!=null){
            root = root.right;
        }
        root.right = temp;

    }
}
