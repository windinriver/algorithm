package sort;

import java.util.Arrays;

/**
 * 分治，合并
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = new int[]{5,4,3,2,1};
        new MergeSort().mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 将a组和 b数组合并成有序的  result数据
     * @param a
     * @param b
     * @param result
     */
      void mergeTwoArray(int[] a, int[] b, int[] result) {
        int i = 0;
        int j = 0;
        int k = 0;
        //双指针，指向谁小谁赋值给result
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result[k] = a[i];
                i++;
            } else {
                result[k] = b[j];
                j++;
            }
            k++;
        }
        //剩余的接上
        while (i < a.length) {
            result[k++] = a[i++];
        }
        while (j < b.length) {
            result[k++] = b[j++];
        }
    }

    public void mergeSort(int[] arr){
        if (arr.length < 2) {
            return;
        }
        //数组大于两个,那么拆分成两个子问题
        int mid = arr.length/2;
        int[] a = Arrays.copyOfRange(arr, 0, mid);
        int[] b = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(a);
        mergeSort(b);
        //合并子问题的解
        mergeTwoArray(a,b, arr);

    }


}
