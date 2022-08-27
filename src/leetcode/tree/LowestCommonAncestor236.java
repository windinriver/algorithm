package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class LowestCommonAncestor236 {

    /**
     * 当我们用递归去做这个题时不要被题目误导，应该要明确一点
     * 这个函数的功能有三个：给定两个节点 pp 和 qq
     *
     * 如果 pp 和 qq 都存在，则返回它们的公共祖先；
     * 如果只存在一个，则返回存在的一个；
     * 如果 pp 和 qq 都不存在，则返回NULL
     * 本题说给定的两个节点都存在，那自然还是能用上面的函数来解决
     *
     * 具体思路：
     * （1） 如果当前结点 rootroot 等于 NULL，则直接返回 NULL
     * （2） 如果 rootroot 等于 pp 或者 qq ，那这棵树一定返回 pp 或者 qq
     * （3） 然后递归左右子树，因为是递归，使用函数后可认为左右子树已经算出结果，用 leftleft 和 rightright 表示
     * （4） 此时若leftleft为空，那最终结果只要看 rightright；若 rightright 为空，那最终结果只要看 leftleft
     * （5） 如果 leftleft 和 rightright 都非空，因为只给了 pp 和 qq 两个结点，都非空，说明一边一个，因此 rootroot 是他们的最近公共祖先
     * （6） 如果 leftleft 和 rightright 都为空，则返回空（其实已经包含在前面的情况中了）
     *
     * 作者：Wilson79
     * 链接：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/solution/c-jing-dian-di-gui-si-lu-fei-chang-hao-li-jie-shi-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //如果左右都有，那么root是最近祖先
        if (left!=null && right!= null) {
            return root;
        }
        // 左子树为空则返回右子树
        if (left == null) {
            return right;
        }
        //否则返回左子树
        return left;
    }


    //解法一: 记录p, q点的路径,然后找到最后一个相同的点就行了。
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> listp = new ArrayList<>();
        List<TreeNode> listq = new ArrayList<>();
        dfs(listp, root, p);
        dfs(listq, root, q);
        TreeNode common = null;
        for (int i = 0; i < listp.size() && i < listq. size(); i++) {
            if (listp.get(i) == listq.get(i)) {
                common = listp.get(i);
            } else break;
        }
        return common;
    }

    private boolean dfs(List<TreeNode> list, TreeNode root, TreeNode search) {
        if (root == null) {
            return false;
        }

        list.add(root);
        if (root == search) {
            return true;
        }
        //05 tracking
        boolean find = dfs(list, root.left, search);
        //左子树没找到
        if (!find) {
            find = dfs(list, root.right, search);
        }
        //左右子树都没找到
        if (!find) {
            //06 back
            list.remove(list.size() - 1);
        }
        return find;
    }


}
