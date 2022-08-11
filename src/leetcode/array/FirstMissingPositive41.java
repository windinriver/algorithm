package leetcode.array;

/**
 * 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 */
public class FirstMissingPositive41 {

    public static void main(String[] args) {
        int[] nums = new int[]{7,8,9,11,12};
        System.out.println(new FirstMissingPositive41().firstMissingPositive(nums));
    }

    //思路：原地hash
//    (原地哈希） O(n)O(n)
//    对于一个长度为 n 的数组，其中没有出现的最小正整数只能在[1, n + 1]中。
//    这是因为如果[1, n]都出现了，那么答案是 n + 1则答案是[1, n]中没有出现的最小正整数。
//    将数组恢复到原位: nums[i] != i+1的时候
    // 遍历恢复后的数组，如果num[i] != i+1,那么i+1就是第一个缺少的正数
    //否则就是n+1
    public int firstMissingPositive(int[] nums) {
        //01 将数据恢复原位
        for (int i = 0; i < nums.length; i++) {
            //虽然看起来是是两层循环，但是最内层的whilewhile循环，每循环一次，
            // 就会将一个数放在正确的位置上，所以总共最多执行 nn 次，因此总的时间复杂度为 O(n)

            //判断nums[i]有没有放在正确的位置上了
            // nums[i] != i+1 (错误!)<--> nums[i] != nums[nums[i] - 1]
            while (nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                //当前的nums[i] 应该放到正确的位置 nums[i]-1。 比如值3 应该放到下标2的位置
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }

        }
        //02 遍历恢复后的数组，如果num[i] != i+1,那么i+1就是第一个缺少的正数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }
}
