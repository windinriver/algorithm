package sort;

import java.util.Arrays;

public class QuickSort {

    public void sort(int arr[]){
        partition(arr, 0, arr.length-1);
    }

    public void partition(int arr[], int left, int right) {
        //递归结束条件
        if (arr == null || left >= right) {
            return;
        }
        //选择一个基准
        int temp = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            //先从右往左找一个小于基准的值
            while (i < j && arr[j] >= temp) {
                j--;
            }
            //找到了,放入坑
            arr[i] = arr[j];
            //从左往右找大于等于基准的值
            while (i < j && arr[i] < temp) {
                i++;
            }
            arr[j] = arr[i];


        }
        //将基准放到临界出
        arr[i] = temp;
        partition(arr, 0 , i -1);
        partition(arr , i+ 1, right);
    }

    public static void main(String[] args) {
        int [] arr = {3,2,1,5,6,4};
        new QuickSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
