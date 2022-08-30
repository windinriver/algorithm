package leetcode.binarySearch;


/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Search33 {
    public static void main(String[] args) {
        System.out.println(new Search33().search(new int[]{3,1}
        , 1));
    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        while (start <= end) {
            int mid = (start + end) /2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {

                //说明旋转区间在mid 前面  && target大于后半段，那只能在旋转区间找
                if (nums[start] > nums[mid] && target > nums[end]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            if (target < nums[mid]) {
                if (nums[start] < nums[mid] && target < nums[start]) {
                    start = mid +1;
                    //只有2个元素
                } else if (nums[start] == nums[mid]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

}
