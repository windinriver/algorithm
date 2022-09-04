package leetcode.dynamicPro;

import leetcode.hashString.LongestPalindrome409;

/**
 * 你一个字符串 s，找到 s 中最长的回文子串
 */
public class LongestPalindrome5 {

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome5().longestPalindrome("babad"));
    }

    //中心扩散法: 从左扫描，知道与起点元素不同， 向右扫描，知道与起点元素不同，判断左右指针元素是否相同
    public String longestPalindrome2(String s) {
        //从每一个位置出发
        int max = -1;
        int l = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
           int begin = i -1;
           int end = i + 1;
           int len = 1;
           while (begin >=0 && s.charAt(begin) == s.charAt(i)) {
               begin--;
               len++;
           }
           while (end < s.length() && s.charAt(end) == s.charAt(i)) {
               end++;
               len++;
           }
           while (begin>=0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
               begin--;
               end++;
               len+=2;
           }
           if (len > max) {
               max = len;
               l = begin;
               r = end;
           }
        }
        return s.substring(l+1, r);
    }

    /**
     * 中心扩散的方法，其实做了很多重复计算。动态规划就是为了减少重复计算的问题。
     * 动态规划听起来很高大上。其实说白了就是空间换时间，将计算结果暂存起来，避免重复计算。作用和工程中用 redis 做缓存有异曲同工之妙。
     * 我们用一个 boolean dp[l][r] 表示字符串从 i 到 j 这段是否为回文。
     * 试想如果 dp[l][r]=true，我们要判断 dp[l-1][r+1] 是否为回文。只需要判断字符串在(l-1)和（r+1)两个位置是否为相同的字符，是不是减少了很多重复计算。
     * 进入正题，动态规划关键是找到初始状态和状态转移方程。
     * 初始状态，l=r 时，此时 dp[l][r]=true。
     * 状态转移方程，dp[l][r]=true 并且(l-1)和（r+1)两个位置为相同的字符，此时 dp[l-1][r+1]=true
     *
     * 作者：reedfan
     * 链接：https://leetcode.cn/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-fa-he-dong-tai-gui-hua-by-reedfa/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        //边界
        dp[0][0] = true;
        int maxl = 0;
        int maxr = 0;
        int len = 0;
        for (int r = 1; r < s.length(); r++) {
            for (int l = 0; l < r; l++) {
                //串的长度小于等于2 或者dp[l+1][r-1]是回文串
                if (s.charAt(r) == s.charAt(l) && (r - l <= 2 || dp[l+1][r-1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > len) {
                        len =  r - l + 1;
                        maxr = r;
                        maxl = l;
                    }
                }
            }
        }
        return s.substring(maxl,maxr+1);
    }
}
