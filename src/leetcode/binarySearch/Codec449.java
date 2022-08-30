package leetcode.binarySearch;

import leetcode.tree.TreeNode;

/**
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 *
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 *
 * 编码的字符串应尽可能紧凑。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/serialize-and-deserialize-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Codec449 {


    //按先序序列进行编码
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        dfs(root, sb);
        return sb.toString();
    }

    public void dfs(TreeNode root, StringBuffer sb) {
        if (root == null) {
            return;
        }
         sb.append(root.val).append("#");
         dfs(root.left, sb);
         dfs(root.right, sb);
    }

    //二叉树的插入
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] split = data.split("#");
        TreeNode root = new TreeNode(Integer.valueOf(split[0]));
        for (int i = 1; i < split.length; i++) {
            dfsInsert(root, Integer.valueOf(split[i]));
        }
        return root;

    }

    public void dfsInsert(TreeNode root, int num) {
        if (num < root.val) {
            if (root.left != null) {
                dfsInsert(root.left, num);
            } else {
                root.left = new TreeNode(num);
            }
        } else {
            if (root.right != null) {
                dfsInsert(root.right, num);
            } else {
                root.right = new TreeNode(num);
            }
        }
    }
}
