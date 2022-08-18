package leetcode.greep;

import java.util.ArrayList;

/**
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 * 除了 0 本身之外，num 不含任何前导零
 */
public class RemoveKdigits402 {
    public static void main(String[] args) {
        System.out.println(new RemoveKdigits402().removeKdigits("1432219", 3));
    }


    //思路：遍历数字num,如果栈为空,那么入栈，否则，和栈顶元素比较，如果比栈顶大，不需要移除，直接入栈
    //如果比栈顶小，则出栈直到栈为空获者比栈顶大。

    //特殊： 为0的情况(栈为空时不需要把0入栈)
    public String removeKdigits(String num, int k) {
        ArrayList<Integer> stack = new ArrayList<>();

        //遍历数字
        for (int i = 0; i < num.length(); i++) {
            int cur = num.charAt(i) -'0';
            //当栈不空，并且当前值比栈顶小的时候并且有移除的数量时
           while (!stack.isEmpty() && stack.get(stack.size()-1) > cur && k > 0) {
               //移除栈顶元素
               stack.remove(stack.size()-1);
               k--;
            }
            //如果栈不为空,不需要把0入栈
            if (!stack.isEmpty() || (stack.isEmpty() && cur!= 0)) {
                stack.add(cur);
            }
        }
        //如果还有移除名额，那么继续出栈
        while (!stack.isEmpty() && k-- > 0) {
            //移除栈顶元素
            stack.remove(stack.size()-1);
        }
        //返回字符串即可
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }

        String result = sb.toString();
        if (result.isEmpty()) {
            return  "0";
        }
        return  sb.toString();
    }
}
