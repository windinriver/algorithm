package leetcode.greep;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，
 * 其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 *
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
 * 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 *
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMinArrowShots452 {

    public static void main(String[] args) {
        System.out.println(new FindMinArrowShots452().findMinArrowShots(new int[][]{{-2147483646, -2147483645}, {2147483646, 214748364}}));
    }

    //points = [[10,16],[2,8],[1,6],[7,12]]
    //思路： 根据x左标排序，维护一个射击区间，遍历气球，如果气球不在射击区间里，说明需要再射一次，并重新更新射击区间
    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1) {
            return points.length;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[0] > point2[0]) {
                    return 1;
                } else if (point1[0] < point2[0]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        //[[-2147483646,-2147483645],[2147483646,2147483647]]
        //射击区间
        int end = points[0][1];
        int shot = 1;
        for (int i = 1; i < points.length; i++) {
            //如果气球在射击区间，就不需要再射，更新射击区间即可
            if (points[i][0] <= end) {
                if (points[i][1] < end) {
                    //第二个气球区间更小，那么射击的区间就会变小
                    end = points[i][1];
                }
            } else {
                //否则需要再射一箭
                end = points[i][1];
                shot++;
            }
        }
        return shot;
    }

    //解法二：按右边界排序，如果起始大于当前的右边界，那么需要再射一箭
    public int findMinArrowShots2(int[][] points) {
        if(points.length < 1) return points.length;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] < o2[1]) {
                    return -1;
                } else if (o1[1] > o2[1]) {
                    return 1;
                } else return 0;
            }
        });
        int pre = points[0][1];
        int shot = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > pre) {
                shot++;
                pre = points[i][1];
            }
        }
        return shot;
    }
}
