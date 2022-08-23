package leetcode.heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        //默认是从小到大排序
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        minheap.add(3);
        minheap.add(2);
        minheap.add(5);
        System.out.println(minheap);

        //构建最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(3);
        maxHeap.add(2);
        maxHeap.add(5);
        System.out.println(maxHeap);

        //可以自定义排序
        PriorityQueue<Integer> maxHeap2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        maxHeap2.add(3);
        maxHeap2.add(2);
        maxHeap2.add(5);
        System.out.println(maxHeap2);
    }
}
