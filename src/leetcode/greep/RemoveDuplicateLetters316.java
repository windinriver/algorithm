package leetcode.greep;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicateLetters316 {

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicateLetters316().removeDuplicateLetters("cbacdcbc"));
    }
    /**
     *分析： 满足后进先出，使用栈。
     * 一： 如果栈为空，获取元素字典序 大于 栈顶，入栈
     * 二： 如果元素大小栈顶，那么判断栈顶元素是否在后面出现过，出现过则退栈
     * 三： 如果元素已经在栈中了，那么忽略（栈中已是最小字典序）
     *
     * 另外，需要两个数据保存 元素最后一次出现的位置，以及元素是否在栈中出现。
     *
     * 复杂度分析：空间和时间都是O（N）
     */
    public String removeDuplicateLetters(String s) {
        //26个字符最后出现的位置
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            //元素最后一次出现的位置
            lastIndex[s.charAt(i)-'a'] = i;
        }
        //保存字符在栈中是否出现过
        boolean[] visited = new boolean[26];
        //java中栈推荐使用Deqeue
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
//            三： 如果元素已经在栈中了，那么忽略（栈中已是最小字典序）
            if (visited[s.charAt(i)-'a']) {
                continue;
            }
            //二： 如果元素小于栈顶，那么判断栈顶元素是否在后面出现过，出现过则退栈
            while (!stack.isEmpty() && s.charAt(i) < stack.getLast() && lastIndex[stack.getLast() - 'a'] > i) {
                //更新栈中出现过的字符
                 visited[stack.getLast()-'a'] = false;
                //退栈
                 stack.removeLast();
            }
            //* 一： 如果栈为空，获取元素字典序 大于 栈顶，入栈
            stack.addLast(s.charAt(i));
            //更新栈中出现的字符
            visited[s.charAt(i)-'a'] = true;
        }
        //从头取栈的元素即可
        StringBuffer sb = new StringBuffer();

        while (!stack.isEmpty()) {
            sb.append(stack.removeFirst());
        }
        return sb.toString();
    }
}
