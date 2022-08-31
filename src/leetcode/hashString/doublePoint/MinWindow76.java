package leetcode.hashString.doublePoint;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
 *
 * s 和 t 由英文字母组成
 */
public class MinWindow76 {

    public static void main(String[] args) {
        System.out.println(new MinWindow76().minWindow("ADOBECODEBANC", "ABC"));
    }

    //1 怎么判断覆盖了？  数组存储t 中字符出现的个数，   s出现的字符个数均大于等于t就覆盖了
    //双指针，当有足够多的元素后，尝试移动begin, 如果是t未出现过的字符,直接跳过，否则，如果数量足够，则继续跳过，知道无法跳过
    public String minWindow(String s, String t) {
        int[] tMap = new int[128];
        //统计t中字符的个数
        for (int i = 0; i < t.length(); i++) {
            tMap[t.charAt(i)]++;
        }
        int[] sMap = new int[128];
        int begin = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            sMap[s.charAt(i)]++;
            //如果已经覆盖了，尝试移动begin指针
            if (isContain(sMap, tMap)) {
                while (begin < i) {
                    //begin指向的字符在t中没有出现过，或者s有足够多的元素
                    if (tMap[s.charAt(begin)] == 0 || sMap[s.charAt(begin)] > tMap[s.charAt(begin)]) {
                        sMap[s.charAt(begin)]--;
                        begin++;
                    } else break;
                }
                if (result.isEmpty() || (i - begin + 1) < result.length()) {
                    result = s.substring(begin, i + 1);
                }
            }

        }
        return result;

    }

    private boolean isContain(int[] sMap, int[] tMap) {
        for (int i = 0; i < tMap.length; i++) {
            if (sMap[i] < tMap[i]) {
                return false;
            }
        }
        return true;
    }
}
