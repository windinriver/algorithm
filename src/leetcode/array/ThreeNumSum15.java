package leetcode.array;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，
 * 使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeNumSum15 {


    public static void main(String[] args) {
        int nums[] = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> result =  new ThreeNumSum15().threeSum(nums);
        System.out.println(result);
    }

//    特判，对于数组长度 nn，如果数组为 nullnull 或者数组长度小于 33，返回 [][]。
//    对数组进行排序。
//    遍历排序后数组：
//    若 nums[i]>0nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 00，直接返回结果。
//    对于重复元素：跳过，避免出现重复解
//    令左指针 L=i+1L=i+1，右指针 R=n-1R=n−1，当 L<RL<R 时，执行循环：
//    当 nums[i]+nums[L]+nums[R]==0nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,RL,R 移到下一位置，寻找新的解
//    若和大于 00，说明 nums[R]nums[R] 太大，RR 左移
//    若和小于 00，说明 nums[L]nums[L] 太小，LL 右移
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result= new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            //跳过重复解
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length -1;
            int cur = nums[i];
            while (l < r) {
                if (cur + nums[l] + nums[r] == 0) {
                    List<Integer> item = new ArrayList();
                    item.add(cur);
                    item.add(nums[l]);
                    item.add(nums[r]);
                    result.add(item);
                    //跳过重复解
                    while (l < r && nums[l] == nums[l+1]) {
                        l++;
                    }
                    //跳过重复解
                    while (l < r && nums[r] == nums[r-1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (cur + nums[l] + nums[r] > 0) {
                    r--;
                } else {
                    l++;
                }
            }

        }
        return result;
    }

    //难点:怎么去重呢？
    public List<List<Integer>> threeSumMy(int[] nums) {
        //思路一：三重for循环+  数字排序+ set去重
        Arrays.sort(nums);
        List<List<Integer>> result= new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Set set = new HashSet();
        for (int i = 0; i< nums.length; i++) {
            for (int j = 1; j != i && j < nums.length; j++) {
                for (int k = 2;k !=i && k!=j && k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        int sort[] = new int[3];
                        sort[0] = nums[i];
                        sort[1] = nums[j];
                        sort[2] = nums[k];
                        Arrays.sort(sort);
                        String key = sort[0] + "#" + sort[1] + "#" + sort[2];
                        if (!set.contains(key)) {
                            set.add(key);
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            result.add(list);
                        }
                    }
                }
            }
        }
        return result;

    }

}
