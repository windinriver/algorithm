package leetcode.greep;

/**
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/gas-station
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanCompleteCircuit134 {

    public static void main(String[] args) {
        //1 -3 1 -2 3
        System.out.println(new CanCompleteCircuit134().canCompleteCircuit2(new int[]{2,3,4}, new int[]{3,4,3}));
    }
    //暴力时间过不了
    public int canCompleteCircuitMy(int[] gas, int[] cost) {

        int[] dh = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            dh[i] = gas[i] - cost[i];
        }
        //以每个节点作为起点尝试（暴力？）
        for (int i = 0; i < dh.length; i++) {
            if (dh[i] >=0 ) {
               //进行一个环测试
               // i是起点 i到 i-1  length.  一直把数字相加，如果小于0不满足，否则满足
               int len = 0;
               int start = i;
               int cur = 0;
               while (len < dh.length ) {
                   int index = start % dh.length;
                   cur = cur + dh[index];
                   if (cur < 0) {
                       break;
                   }
                   len++;
                   start++;
               }
               if (len == dh.length) {
                   return i;
               }
            }
        }
        return -1;

    }

    //优化暴力解法：如果i最远可以到j,那么i到j之间的点就不可能能够绕一圈，假设i+1可以绕一圈，那么i+1可以达到j+1,而i又能到i+1，也就是i能到j+1，
    // 这和i最远能到j是相悖的
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int j = i;
            int remain = gas[i];
            while (remain - cost[j] >= 0) {
                //减去花费的加上新的点的补给
                remain = remain - cost[j] + gas[(j + 1) % n];
                j = (j + 1) % n;
                //j 回到了 i
                if (j == i) {
                    return i;
                }
            }
            //最远距离绕到了之前，所以 i 后边的都不可能绕一圈了
            if (j < i) {
                return -1;
            }
            //i 直接跳到 j，外层 for 循环执行 i++，相当于从 j + 1 开始考虑
            i = j;

        }
        return -1;
    }

    /**
     * 其实很简单，只要总油量大于等于总耗油量就肯定能跑完一圈，换句话说，油的剩余量如果大于等于0就肯定能跑完一圈，
     * 这么一想这个问题就简单了，那么总耗油量如果小于0，直接返回-1
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curdh = 0;
        int sumDh = 0;
        int ids = 0;
        for (int i = 0; i < gas.length; i++) {
            curdh += gas[i] - cost[i];
            sumDh += gas[i]- cost[i];
            if (curdh < 0) {
                ids = (i+1) % gas.length;
                curdh = 0;
            }
        }
        if (sumDh < 0) {
            return -1;
        }
        return ids;
    }

}
