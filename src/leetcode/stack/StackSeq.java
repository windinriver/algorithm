package leetcode.stack;

import java.util.Stack;

/**
 * 合法出栈序列
 * 325441
 *
 * 1 出栈结果存储在队列中，
 * 2 按元素顺序，将元素push进入栈。
 * 3 检查是否与队列一致，如果一致，则出队和出栈。
 * 4 若栈为空，说明合法
 *
 */
public class StackSeq {
    public static void main(String[] args) {
        System.out.println(new StackSeq().check_is_vaild_order(new int[]{3,2,5,4,1}));
    }


    boolean check_is_vaild_order(int[] order) {
        int n = order.length;
        int top = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            while (!stack.isEmpty() && order[top] == stack.peek()) {
                top++;
                stack.pop();
            }

        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }
}
