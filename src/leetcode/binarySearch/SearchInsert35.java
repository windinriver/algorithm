package leetcode.binarySearch;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class SearchInsert35 {
    public static void main(String[] args) {
        new SearchInsert35().searchInsert(new int[]{2,3,5,6,9}, 7);
    }

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        while (start <= end) {
            int mid = (start + end) /2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                if (mid == nums.length-1 || target < nums[mid + 1]) {
                    return mid + 1;
                }
                start = mid + 1;
            }
            if (nums[mid] > target) {
                if (mid == 0 || target > nums[mid - 1]) {
                    return mid;
                }
                end = mid -1;

            }
        }
        return -1;
    }
}
