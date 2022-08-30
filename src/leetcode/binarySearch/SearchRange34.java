package leetcode.binarySearch;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 * nums 是一个非递减数组
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchRange34 {

    public static void main(String[] args) {
        System.out.println(new SearchRange34().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }

    //分开查最左和最右的下标
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = leftRange(nums, target);
        result[1] = rightRange(nums, target);
        return result;
    }

    public int leftRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int mid =  (start + end) /2;
            if (target == nums[mid]){
                //左边还有相等元素
                if (mid != 0 && target == nums[mid -1]) {
                    end = mid -1;
                } else return mid;
            }
            if (target > nums[mid]){
                start = mid + 1;
            }
            if (target < nums[mid]) {
                end = mid - 1;
            }
        }
        return -1;
    }

    public int rightRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int mid =  (start + end) /2;
            if (target == nums[mid]){
                //左边还有相等元素
                if (mid != nums.length-1 && target == nums[mid + 1]) {
                    start = mid + 1;
                } else return mid;
            }
            if (target > nums[mid]){
                start = mid + 1;
            }
            if (target < nums[mid]) {
                end = mid - 1;
            }
        }
        return -1;
    }
}
