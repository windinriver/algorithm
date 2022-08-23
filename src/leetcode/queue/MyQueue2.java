package leetcode.queue;

import java.util.Stack;
public class MyQueue2 {

    Stack<Integer> a;
    Stack<Integer> b;

    /** Initialize your data structure here. */
    public MyQueue2() {
        a = new Stack<>();
        b = new Stack<>();
    }


    public void push(int x) {
        a.push(x);
    }


    public int pop(){

        if(b.isEmpty()){
            while (!a.isEmpty()){
                b.push(a.pop());
            }
        }
        return b.pop();
    }


    public int peek() {
        if(b.isEmpty()){
            while (!a.isEmpty()){
                b.push(a.pop());
            }
        }
        return b.peek();
    }

    public boolean empty() {
        return a.isEmpty()&&b.isEmpty();
    }
}