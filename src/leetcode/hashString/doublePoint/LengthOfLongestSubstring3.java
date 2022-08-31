package leetcode.hashString.doublePoint;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * s 由英文字母、数字、符号和空格组成
 */
public class LengthOfLongestSubstring3 {

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring3().lengthOfLongestSubstring("pwwkew"));
    }

    //双指针0
    //用一个数据记录出现的次数，如果出现过，就移动begin指针，直到没有重复的元素
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int begin = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            //如果元素没有出现过
            if (map[s.charAt(i)] == 0) {
                map[s.charAt(i)] = 1;
                //更新最大值
                if ((i - begin + 1) > result) {
                    result = i - begin + 1;
                }
            } else {
                //移动begin 指针，直到没有重复的元素
                while (begin < i && map[s.charAt(i)] == 1) {
                    map[s.charAt(begin)]--;
                    begin++;
                }
                //表示当前元素出现过了
                map[s.charAt(i)] = 1;
            }
        }

        return result;
    }
}
