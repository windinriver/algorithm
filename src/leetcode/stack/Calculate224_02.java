package leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 */
//Deque   https://blog.csdn.net/devnn/article/details/82716447
public class Calculate224_02 {

    public static void main(String[] args) {
        System.out.println(new Calculate224_02().calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    //思路：该题只有+ 和 -
    //也就是说遇到括号的时候变换一下括号的字符就行了
    public int calculate(String s) {
        Deque<Integer> opStack = new LinkedList<>();
        int sign = 1;
        opStack.push(sign);
        int result = 0;
        int i = 0;
        while (i < s.length()) {
            Character c = s.charAt(i);
            switch (c){
                case '+':
                    sign = opStack.peek();
                    i++;
                    break;
                case '-':
                    sign = -opStack.peek();
                    i++;
                    break;
                case '(':
                    opStack.push(sign);
                    i++;
                    break;
                case ')':
                    opStack.pop();
                    i++;
                    break;
                case ' ':
                    i++;
                    break;
                default:
                    int num = 0;
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        num = num * 10 + s.charAt(i) - '0';
                        i++;
                    }
                    result += sign * num;
            }
        }
        return result;
    }
}
