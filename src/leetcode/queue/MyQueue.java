package leetcode.queue;

import java.util.Stack;

/**
 * 使用两个栈实现队列
 */
class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;


    public MyQueue() {
        //临时
        stack1 = new Stack<>();
        //结果
        stack2 = new Stack<>();
    }

    public void push(int x) {
        //先将结果栈进临时栈
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(x);
        //再将临时栈进结果栈
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    public int pop() {
        return stack2.pop();
    }

    public int peek() {
      return stack2.peek();
    }

    public boolean empty() {
        return stack2.isEmpty();
    }
}