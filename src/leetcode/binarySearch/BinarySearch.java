package leetcode.binarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(new BinarySearch().binarySerarchDfs(array, 0, array.length - 1, 3));
        System.out.println(new BinarySearch().binarySerarchDfs(array, 0, array.length - 1, 10));
    }

    //递归实现
    public boolean binarySerarchDfs(int[] array, int begin, int end, int target) {
        if (begin > end) {
            return false;
        }
        int mid = (begin + end) /2;
        if (array[mid] == target) {
            return true;
        }
        if (array[mid] < target) {
            return binarySerarchDfs(array, mid + 1, end , target);
        }
        if (array[mid] > target) {
           return binarySerarchDfs(array, begin, mid -1, target);
        }
        return false;
    }

    //循环实现
    public boolean binarySearchWhile(int[] array, int begin, int end, int target) {
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (array[mid] == target) {
                return true;
            }
            if (array[mid] < target) {
                begin = mid + 1;
            }
            if (array[mid] > target) {
                end = mid -1;
            }
        }
        return false;
    }
}
