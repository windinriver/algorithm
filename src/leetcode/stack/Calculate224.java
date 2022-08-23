package leetcode.stack;

import java.util.Stack;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 */
public class Calculate224 {
    public static void main(String[] args) {
        System.out.println(new Calculate224().calculate("1-(-2)"));
        // 1 4 5 + 2 + + 3 - 6 3 + +
    }

    //解法一：中缀转后缀
    //思路： 遇到数字，直接加到后缀表达式
    //遇到+ - ,出栈直到遇到（
    //遇到） ,出栈直到遇到（
    public int calculate(String s) {
        if (s==null||s.isEmpty()) {
            return 0;
        }
        //唉，还要搞个负号来恶心人
        String postExp = inToOrder(s);
        //后缀表达式的计算
        int result= caculatePlus(postExp);
        return result;
    }

    //遇到数字，进操作数栈，遇到符号，出栈两个数，然后计算再放进栈
    public int caculatePlus(String postExp){
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i<postExp.length()){
            char c = postExp.charAt(i);
            switch (c){
                case '+':

                    int a = stack.pop();
                    //有可能是表示正数
                    int b = stack.isEmpty()?0: stack.pop();
                    stack.push(a+b);
                    i++;
                    break;
                case '-':
                    int e = stack.pop();
                    int f = stack.isEmpty()?0:stack.pop();
                    stack.push(f-e);
                    i++;
                    break;
                default:
                    int num = 0;
                    while (i<postExp.length()&&postExp.charAt(i)!='#'){
                        num = num*10+postExp.charAt(i)-'0';
                        i++;
                    }
                    stack.push(num);
                    //跳过#号
                    i++;
            }

        }
        return stack.peek();
    }

    private String inToOrder(String exp) {
        StringBuffer postExp = new StringBuffer();
        int i = 0;
        Stack<Character> stack = new Stack<>();
        while (i < exp.length()) {
            char c = exp.charAt(i);
            //过滤空格
            if (c == ' ') {
                i++;
                continue;
            }
            switch (c){
                case '+':
                case '-':
                    //出栈直到栈空或者遇到(
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        postExp.append(stack.pop());
                    }
                    //符号入栈
                    stack.push(c);
                    i++;
                    break;
                case '(':
                    stack.push(c);
                    i++;
                    break;
                case ')':
                    //出栈直到遇到左括号
                    while (stack.peek() != '(') {
                        postExp.append(stack.pop());
                    }
                    //出栈左括号
                    stack.pop();
                    i++;
                    break;
                default:
                    //数字
                    //数字结束时用‘#‘号标识
                    while (i < exp.length() && exp.charAt(i) >= '0' &&  exp.charAt(i) <= '9') {
                        postExp.append(exp.charAt(i));
                        i++;
                    }
                    postExp.append('#');
            }
        }
        while (!stack.isEmpty()) {
            postExp.append(stack.pop());
        }
        return postExp.toString();

    }

}
