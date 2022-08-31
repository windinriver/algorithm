package leetcode.hashString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * NA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
 *
 * 例如，"ACGAATTCCG" 是一个 DNA序列 。
 * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
 *
 * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/repeated-dna-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//该题主要目的是熟悉位运算的，如果采用非位运算，那么就很简单
public class FindRepeatedDnaSequences187 {

    public static void main(String[] args) {
        System.out.println(new FindRepeatedDnaSequences187().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    //法二：使用位运算，10个串，每个字符只有四种，那么可以用二进制  两位 来表示
    // 那么 10 个 可以 转化为  20个位来存储， 2^20 = 4^10 = 1048576
    //  用一个int 数组来记录 1048576个正数出现的次数，如果大于二，再转换成字符串
    public List<String> findRepeatedDnaSequences(String s) {
        int[] map = new int[1048576];
        int[] charMap = new int[128];
        List<String> strings = new ArrayList<>();
        if (s.length() < 10) {
            return strings;
        }
        charMap['A'] = 0;
        charMap['C'] = 1;
        charMap['G'] = 2;
        charMap['T'] = 3;
        //计算前10个代表的整形值， 后面的数字代表高位
        int key = 0;
        for (int i = 9; i >= 0; i--) {
            key = (key << 2) + charMap[s.charAt(i)];
        }
        map[key] = 1;
        //从第11个字符开始
        for (int i = 10; i < s.length(); i++) {
            //抹掉最地位
            key = key >> 2;
            //拼接最高位
            key = key | (charMap[s.charAt(i)] << 18);
            map[key]++;

            //出现了2次就加入结果
            if (map[key] == 2) {
                strings.add(s.substring(i-9, i+1));
            }
        }
        return strings;


    }

    /**
     * 整形再转换回 字符串
     * @param i
     * @return
     */
    private String changeToString(int i) {
        char[] map = new char[]{'A','C','G','T'};
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < 10; j++) {
            sb.append(map[i & 3]);
            i = i >> 2;
        }
        return sb.toString();
    }


    //法一： 暴力枚举统计每个子串出现的个数
    public List<String> findRepeatedDnaSequences2(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String key = s.substring(i, i + 10);
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key).intValue()+1);
            }
        }
        //遍历结果
        for(String key: map.keySet()) {
            if (map.get(key) > 1) {
                result.add(key);
            }
        }
        return result;
    }

}
