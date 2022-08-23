package leetcode.stack;

/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 */
//Dequeue: https://blog.csdn.net/SeekN/article/details/114231727

import java.util.LinkedList;
import java.util.Queue;

/**
 * 思路： 用临时队列先放要入栈的元素，然后结果队列中的元素出队进临时队列，临时队列再出队到结果队列即可
 */
class MyStack {


    //用做临时队列
    Queue<Integer> queue1;
    //结果队列
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        //先进临时队列
        queue1.add(x);
        //出队
        while (!queue2.isEmpty()) {
            //结果队列的元素依次进入临时队列
            queue1.add(queue2.poll());
        }
//        while (!queue1.isEmpty()) {
//            //临时队列进结果队列
//            queue2.add(queue1.poll());
//        }
        //交换队列，使得queue1在没有push的时候始终为空
        Queue temp =queue1;
        queue1 = queue2;
        queue2= temp;
    }

    public int pop() {
        int res = -1;
        if (!queue2.isEmpty()) {
            res = queue2.poll();
        }
        return res;
    }

    public int top() {
        int res = -1;
        if(!queue2.isEmpty()) {
            res = queue2.peek();
        }
        return res;
    }

    public boolean empty() {
        return queue2.isEmpty();
    }
}

