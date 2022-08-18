package leetcode.greep;

/**
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。
 * 第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/wiggle-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WiggleMaxLength376 {

    public static void main(String[] args) {
        System.out.println(new WiggleMaxLength376().wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
    }

    //状态机
    public int wiggleMaxLength(int[] nums) {
        //特判
        if (nums.length <= 1) {
            return nums.length;
        }
        final int BEGIN = 0;
        final int UP = 1;
        final int DOWN = -1;
        int STATUS = BEGIN;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            switch (STATUS) {
                case BEGIN :
                    //当前值比上一个值大,构成上升段
                    if (nums[i] > nums[i-1]) {
                        STATUS = UP;
                        result++;
                    }
                    if (nums[i] < nums[i-1]) {
                        STATUS = DOWN;
                        result++;
                    }
                    break;
                case UP:
                    //UP 状态如果遇到小的值
                    if (nums[i] < nums[i-1]) {
                        STATUS = DOWN;
                        result++;
                    }
                    break;
                case DOWN:
                    //DOWN状态遇到大的值
                    if (nums[i] > nums[i-1]) {
                        STATUS = UP;
                        result++;
                    }
                    break;
            }
        }
        return result;
    }

    //TODO 解法二:动态规划
}
