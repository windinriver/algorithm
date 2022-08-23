package leetcode.stack;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 */
//1个变量MIN无法完成记录栈中所有状态下的最小
//2栈的每个状态，都需要有一个变量记录最小值。（空间换时间）
class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (!minStack.isEmpty()) {
            if (val < minStack.peek()) {
                minStack.push(val);
            } else {
                minStack.push(minStack.peek());
            }
        } else minStack.push(val);

    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
         return  stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
