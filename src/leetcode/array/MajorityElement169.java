package leetcode.array;

import java.util.Arrays;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MajorityElement169 {

    public static void main(String[] args) {
        int []nums = new int[]{ 2,2,1,1,1,2,2};
        System.out.println(new MajorityElement169().majorityElementMy(nums));
        System.out.println(new MajorityElement169().majorityElement(nums));
    }

    //思路:排序计数
    //复杂度是nLog(n)
    public int majorityElementMy(int[] nums) {
        Arrays.sort(nums);
        int result = nums[0];
        int sum = 1;
        int majority = nums.length/2;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] == nums[i-1]) {
                sum++;
            } else {
               sum = 1;
            }
            if (sum > majority) {
                return nums[i];
            }
            i++;
        }
        return result;
        //额,超过半数那么中间元素肯定就是了
        //  Arrays.sort(nums);
        //  return nums[nums.length >> 1];
    }

    //摩尔投票法思路
    /**
     * 候选人(cand_num)初始化为nums[0]，票数count初始化为1。
     * 当遇到与cand_num相同的数，则票数count = count + 1，否则票数count = count - 1。
     * 当票数count为0时，更换候选人，并将票数count重置为1。
     * 遍历完数组后，cand_num即为最终答案。
     *
     * 为何这行得通呢？
     * 投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
     * 且“多数元素”的个数> ⌊ n/2 ⌋，其余元素的个数总和<= ⌊ n/2 ⌋。
     * 因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
     * 这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。
     */
    public int majorityElement(int[] nums) {
        int cand_num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cand_num) {
                count++;
            } else {
                count--;
            }
            //当count为1时,更换候选人
            if (count == 0) {
                cand_num = nums[i];
                count = 1;
            }
        }
        return cand_num;
    }
}
