package leetcode.greep;

/**
 * 的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 *
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 *
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/create-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxNumber321 {

    /**
     * 402使用单调栈。
     * 这个提需要使用 两个数据分别单调栈，然后，合并，取所有情况中最大的一个。
     *
     * 一：需要一个获取k个子序列最大的方法
     * 二：需要一个对比两个合并子序列的大小的方法。
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] maxSubsequence = new int[k];
        //拆分成子问题
        //
        int start = Math.max(0, k - n), end = Math.min(k, m);
        for (int i = start; i <= end; i++) {
            int[] subsequence1 = maxSubsequence(nums1, i);
            int[] subsequence2 = maxSubsequence(nums2, k - i);
            int[] curMaxSubsequence = merge(subsequence1, subsequence2);
            if (compare(curMaxSubsequence, 0, maxSubsequence, 0) > 0) {
                System.arraycopy(curMaxSubsequence, 0, maxSubsequence, 0, k);
            }
        }
        return maxSubsequence;


    }

    /**
     * 求nums1 取 k个元素的最大子序列
     * @param nums
     * @param k
     * @return
     */
    private int[] maxSubsequence(int[] nums, int k) {
        //转换成402,移除这个数中的 k 位数字，使数字最大
        int len = nums.length;
        int remove = len - k;
        //3, 4, 6,5
        //转换成单调栈，如果栈为空，或者比栈顶原素小，那么进栈
        //如果比栈顶大，并且还可以移除，那么就退栈
        //最后还有剩余，则继续出栈
        int[] stack = new int[k];
        //栈顶指针
        int top = -1;
        for (int i = 0; i < len; i++) {
            //如果比栈顶大，并且还可以移除，那么就退栈
            while (top!= -1 && stack[top] < nums[i] && remove > 0) {
                top--;
                remove--;
            }
            if (top < k - 1) {
                //进栈
                stack[++top] = nums[i];
            } else {
                //说明数字已经足够了，而nums[i]又小于栈顶，可以不考虑，直接去掉
                remove--;
            }

        }

       return stack;
    }

    public int[] merge(int[] subsequence1, int[] subsequence2) {
        int x = subsequence1.length, y = subsequence2.length;
        if (x == 0) {
            return subsequence2;
        }
        if (y == 0) {
            return subsequence1;
        }
        int mergeLength = x + y;
        int[] merged = new int[mergeLength];
        int index1 = 0, index2 = 0;
        for (int i = 0; i < mergeLength; i++) {
            if (compare(subsequence1, index1, subsequence2, index2) > 0) {
                merged[i] = subsequence1[index1++];
            } else {
                merged[i] = subsequence2[index2++];
            }
        }
        return merged;
    }


    public int compare(int[] subsequence1, int index1, int[] subsequence2, int index2) {
        int x = subsequence1.length, y = subsequence2.length;
        while (index1 < x && index2 < y) {
            int difference = subsequence1[index1] - subsequence2[index2];
            if (difference != 0) {
                return difference;
            }
            index1++;
            index2++;
        }
        return (x - index1) - (y - index2);
    }


}
