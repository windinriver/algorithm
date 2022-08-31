package leetcode.hashString;

import java.util.HashMap;

/**
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordPattern290 {
    public static void main(String[] args) {
        System.out.println(new WordPattern290().wordPattern("abba", "dog cat cat dog"));
    }
//    "abba"
//"dog dog dog dog"

    //思路：建立pattern 与 单词的映射
    public boolean wordPattern(String pattern, String s) {
        HashMap<String,Character> map = new HashMap<>();
        //记录pattern是否已经映射过
        boolean[] used = new boolean[26];
        String[] strings = s.split(String.valueOf(' '));
        int len = pattern.length();
        if (strings.length != len) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            //如果不包含并且没有映射过
          if (!map.containsKey(strings[i])  && !used[pattern.charAt(i)-'a']) {
              map.put(strings[i],pattern.charAt(i));
              used[pattern.charAt(i)-'a'] = true;
          }
          if (map.get(strings[i]) ==null || map.get(strings[i])!= pattern.charAt(i)) {
              return false;
          }
        }
        return true;
    }
}
