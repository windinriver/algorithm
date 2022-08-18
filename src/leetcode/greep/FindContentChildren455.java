package leetcode.greep;

import java.util.Arrays;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 *
 * 对每个孩子 i，都有一个胃口值g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j]。如果 s[j]>= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/assign-cookies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindContentChildren455 {

    public static void main(String[] args) {
        System.out.println(new FindContentChildren455().findContentChildren(new int[]{1, 2, 3}, new int[]{1, 2}));
    }


    //思路，将孩子和糖果排序，然后优先用最小糖果满足需求小的孩子
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int result = 0;
        for(int i = 0, j = 0; i < g.length && j < s.length; j++) {
            if (s[j] >= g[i] ){
                result++;
                //满足了一个孩子
                i++;
            }
        }
        return result;
    }
}
