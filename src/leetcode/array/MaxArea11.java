package leetcode.array;

/**
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 *
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxArea11 {
    public static void main(String[] args) {
        System.out.println(new MaxArea11().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    /**
     * 思路： 面积 S = （j-i） * min(num[i] * num[j])
     * 向内移动端板才可能使面积增大
     * 使用双指针,遍历得出最大面积即可
     * @param height
     * @return
     */
    public int maxAreaMy(int[] height) {
        int i = 0,j = height.length-1;
        int max = (j-i) * Math.min(height[j],height[i]) ;
        while (i < j) {
            //j是短板
            if (height[i] > height[j]) {
                //移动后的面积
                j--;
                if ((j - i) * Math.min(height[i],height[j]) > max) {
                    max = (j - i) * Math.min(height[i],height[j]);
                }
            } else {
                //i 是短板
                i++;
                if ((j - i) * Math.min(height[i],height[j]) > max) {
                    max = (j - i) * Math.min(height[i],height[j]);
                }
            }
        }
        return max;
    }


    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]) :
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }

}
