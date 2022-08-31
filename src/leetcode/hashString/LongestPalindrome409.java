package leetcode.hashString;


/**
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 *
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 * 1 <= s.length <= 2000
 * s 只由小写 和/或 大写英文字母组成
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome409 {

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome409().longestPalindrome("abccccdd"));
    }

    //思路： 记录字母出现的次数，如果为偶数，则可以全部使用，如果为计数，只有一个能使用
    public int longestPalindrome(String s) {
        int[] map = new int[128];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }
        //遍历map,计算值
        //是否有奇数
        int flag = 0;
        int result  = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0 ) {
                //如果是偶数
                //map[i] & 1 == 0
                if (map[i] % 2 ==0) {
                    result += map[i];
                } else {
                    //奇数
                    result += map[i] -1;
                    flag = 1;
                }
            }
        }
        return result + flag;
    }
}
