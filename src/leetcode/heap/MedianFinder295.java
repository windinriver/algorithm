package leetcode.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-median-from-data-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MedianFinder295 {

    //定义最小堆
    private PriorityQueue<Integer> minHeap;
    //定义最大堆
    private PriorityQueue<Integer> maxHeap;


    /**
     * 关键在于维护两个性质
     * 1 最大堆 堆顶元素小于 最小堆
     * 2 最大最小堆两个元素只能相差一个。
     * 这样当两个堆数量相同时，取平均值，
     * 否则取数量多的一个堆顶元素即可
     */
    public MedianFinder295() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
            return;
        }
        if (maxHeap.size() == minHeap.size()) {
            if (num >= maxHeap.peek()) {
                minHeap.add(num);
            } else maxHeap.add(num);
        }
        //如果最大堆数量小于最小堆（说明不能再往最小堆里面放了）
        else if (maxHeap.size() < minHeap.size()) {
            if (num < minHeap.peek()) {
                maxHeap.add(num);
            } else {
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            }
        }
        //最大堆数量大于最小堆，那么不能放最大堆了
        else if (maxHeap.size() > minHeap.size()) {
            if (num > maxHeap.peek()) {
                minHeap.add(num);
            } else {
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }
        }
    }

    public double findMedian() {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            return 0;
        }
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder295 arr = new MedianFinder295();
        arr.addNum(-1);
        System.out.println(arr.findMedian());
        arr.addNum(-2);
        System.out.println(arr.findMedian());
        arr.addNum(-3);
        System.out.println(arr.findMedian());
        arr.addNum(-4);
        System.out.println(arr.findMedian());
    }

}
