package leetcode.greep;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Jump45 {

    public static void main(String[] args) {
        System.out.println(new Jump45().jump(new int[]{1,1,1,1}));
    }

    //思路：怎么跳最少? 不得不跳时才跳，维护当前能跳的最远距离，如果这个最远距离还没到终点，说明需要跳了，那么就从这个最远距离中选择一个
    //能跳的最远的跳，重复以上动作就行了。
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int maxCanJump = nums[0];
        //记录不得不跳时选择能跳的最远距离
        int selectToJump = 0;
        int jump = 1;
        for (int i = 1; i < nums.length; i++) {
            //说明当前不得不跳了,那就选一个最远距离跳
            if (maxCanJump < i) {
                jump++;
                maxCanJump = selectToJump;
            }

            //记录每个位置能跳的最远距离
            if (nums[i] + i > selectToJump) {
                selectToJump = nums[i]+i;
            }
        }
        return jump;
    }
}
