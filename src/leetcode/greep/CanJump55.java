package leetcode.greep;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 */
public class CanJump55 {

    public static void main(String[] args) {
        System.out.println(new CanJump55().canJump(new int[]{0}));
    }
    //思路：每个位置能够跳到的最远距离为 nums[i] + 1。 维护一个变量，记录当前能跳到的最远距离，然后遍历该距离，如果碰到能跳更远的点，则更新
    //当前能跳到的最远距离，如果最远距离大于等于数组长度，则可以到达，否则不能
    public boolean canJump(int[] nums) {
        //最远可以跳的距离最远
        int maxCanJump = nums[0];
        for (int i = 0; i <= maxCanJump; i++) {
            //如果已经可以跳到终点了,返回true
            if (maxCanJump >= nums.length -1) {
                return true;
            }
            //如果遍历到可以跳更远的点，则更新maxCanJump
            if (nums[i] + i > maxCanJump) {
                maxCanJump = nums[i] + i;
            }
        }
        return false;
    }

}
