package leetcode.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindKthLargest215 {

    public static void main(String[] args) {
        System.out.println(new FindKthLargest215().findKthLargest2(new int[]{3,2,1,5,6,4},2));
    }

    /**
     * 维护一个K大小的最小堆，堆中元素个数小于K时，新元素直接进入堆；否则，当
     * 堆顶小于新元素时，弹出堆顶，将新元素加入堆。
     * 解释:
     * 由于堆是最小堆，堆顶是堆中最小元素，新元素都会保证比堆顶小(否则新元素
     * 替换堆顶)，故堆中K个元素是已扫描的元素里最大的K个；堆顶即为第K大的数。
     */
    //时间复杂度 O（nlogk）
    //空间复杂度 logk
    public int findKthLargest(int[] nums, int k) {
        //从小到大拍
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
           //如果最小堆的数量小于k
            if (minHeap.size() < k) {
               minHeap.add(nums[i]);
           } else if (nums[i] > minHeap.peek()) {
                //如果扫描到比堆顶的数字大的，加进去
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        //堆顶就是第k大的
        return minHeap.peek();
    }

    public int partition(int arr[], int left, int right, int index) {
        //基准
        int temp = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && arr[j] >= temp) {
                j--;
            }
            arr[i] =arr[j];
            while (i < j && arr[i] < temp) {
                i++;
            }
            arr[j] = arr[i];
        }
        //基准位
        arr[i] = temp;
        if (i == index) {
            return arr[i];
        } else if (i < index) {
            //往右找
            return partition(arr, i+1, right,index);
        } else {
            return partition(arr, left, i -1, index);
        }
    }

    //解法二：快排，适用固定数据流
    //每一次排序后的基准位置和 第 len -k 小比较，如果小于，那么往右边继续排，如果大于，那么左边继续排
    //平均复杂度O（n）
    //最差复杂度 O（n2）
    public int findKthLargest2(int[] nums, int k) {
       return partition(nums, 0, nums.length -1, nums.length -k);
    }
}
