package leetcode.greep;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class LargestNumber179 {

    public static void main(String[] args) {
        System.out.println(new LargestNumber179().largestNumber(new int[]{10, 2}));
    }

    //思路：难点在于如何排序，对于a和b， 如果拼接后ab 大于 ba, 那么a应该放在b前面
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = nums[i] + "";
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String ab = o1 + o2;
                String ba = o2 + o1;
                return ba.compareTo(ab);
            }
        });
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < nums.length; i++) {
            sb.append(strs[i]);
        }
        //前导零的处理
        int k = 0;
        while (k < sb.length() - 1 && sb.charAt(k) == '0') k++;
        return sb.substring(k);

    }
}
