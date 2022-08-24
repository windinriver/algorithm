package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
 * <p>
 * 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
 * <p>
 * 小时不会以零开头：
 * <p>
 * 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
 * 分钟必须由两位数组成，可能会以零开头：
 * <p>
 * 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
 * <p>
 * <p>
 * 输入：turnedOn = 1
 * 输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-watch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReadBinaryWatch401 {
    public static void main(String[] args) {
        System.out.println(new ReadBinaryWatch401().readBinaryWatch(1));
    }

    //01 要什么给什么
    private List<String> result = new ArrayList<>();

    public List<String> readBinaryWatch(int turnedOn) {
        //0-3表示小时， 3-9表示分钟
        int[] time = new int[]{8, 4, 2, 1, 32, 16, 8, 4, 2, 1};

        dfs(0, 0, time, 0, turnedOn);
        return result;

    }

    //02 定义递归
    public void dfs(int hp, int mp, int[] time, int start, int turnedOn) {
        //03 结束条件
        if (turnedOn == 0) {

            if (mp < 10) {
                result.add(hp + ":0" + mp);
            } else {
                result.add(hp + ":" + mp);
            }

            return;
        }
        //04 选择
        for (int i = start; i < time.length; i++) {
            //小时
            if (i < 4) {
                if (hp + time[i] < 12) {
                    //05 递归
                    dfs(hp + time[i], mp, time, i + 1, turnedOn - 1);
                }
            } else {
                //分钟
                if (mp + time[i] < 60) {
                    dfs(hp, mp + time[i], time, i + 1, turnedOn - 1);
                }
            }
        }
    }
}
