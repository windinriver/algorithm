package leetcode.tree;

import java.util.HashMap;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * 注： preorder 和 inorder 均 无重复 元素
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTree105 {

    public static void main(String[] args) {
        TreeNode treeNode = new BuildTree105().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        TreeNode.preOrder(treeNode);
        System.out.println("-----------");
        TreeNode.inOrder(treeNode);
    }

    private HashMap<Integer, Integer> rootMap = new HashMap<>();
    //根据前序和中序序列构建二叉树。 可以借助hashmap来快速定位 先根遍历在中序序列中的位置
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }

        for (int i = 0; i < inorder.length; i++) {
            rootMap.put(inorder[i], i);
        }
        return  dfs(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd) {
        if (pStart > pEnd) {
            return null;
        }
        //先建立根节点
        TreeNode root = new TreeNode(preorder[pStart]);
        //中序序列中根的位置
        int pos = rootMap.get(preorder[pStart]); //pos = 1   pos - istart = 左子树数量
        int leftNum = pos - iStart;
        int rightNUm = iEnd - pos;
        TreeNode left = dfs(preorder, inorder, pStart+1, pStart + leftNum, iStart, iStart+leftNum );
        TreeNode right = dfs(preorder,inorder, pStart + leftNum +1, pEnd,  iStart+leftNum+1, iEnd);
        root.left = left;
        root.right = right;
        return root;

    }

    //TODO 迭代法实现
}
