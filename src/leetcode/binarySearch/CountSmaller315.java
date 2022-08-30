package leetcode.binarySearch;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-of-smaller-numbers-after-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountSmaller315 {

    public static void main(String[] args) {
        System.out.println(new CountSmaller315().countSmaller(new int[]{5,2,6,1}));
    }


    LinkedList<Integer> result = new LinkedList<>();

    //    将元素按照原数组逆置后的顺序插入到二叉查找树中，如何在元素 插入时，计算已有多少个元素比当前插入元素小
    // 设置一个字段记录左子树数量，当插入节点小于等于当前节点，那么左子树加1， 否则 计算值为 节点左子树数量+1
    // 该做法超时了。。。
    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        TreeNode root =  new TreeNode(nums[nums.length-1]);
        result.add(0);
        for (int i = nums.length-2; i >= 0 ; i--) {
            dfs(root, nums[i], 0);
        }

        return result;
    }

    private void dfs(TreeNode root, int val, int cur) {
        //插左子树
        if (val <= root.val) {
            if (root.left != null) {
                dfs(root.left, val, cur);
            } else {
                root.left = new TreeNode(val);
                //记录结果
                result.addFirst(cur);
            }
            //左子树数量自增
            root.count++;
        } else {
            if (root.right != null) {
                dfs(root.right, val, cur + root.count + 1);
            } else {
                root.right = new TreeNode(val);
                //记录结果
                result.addFirst(cur + root.count + 1);
            }
        }
    }

}
