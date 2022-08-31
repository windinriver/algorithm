package leetcode.hashString;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GroupAnagrams49 {

    public static void main(String[] args) {
        System.out.println(new GroupAnagrams49().groupAnagrams(new String[]{"abc", "cba", "efg"}));
    }

    //思路： hashmap存储key - value的映射。
    //key 可以是字典序的字符串
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map  = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String key = Arrays.toString(cs);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        //遍历map取出结果
        for(List<String> item: map.values()) {
            result.add(item);
        }
        return result;
    }

    //解法二： key用int 数组来表示, 其他就一样了
    private int[] getKey(String s) {
        int[] key = new int[26];
        for (int i = 0; i < s.length(); i++) {
            key[s.charAt(i)-'a']++;
        }
        return key;
    }


    //一些简便的使用
    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        for(String s:strs){
            char[] ch=s.toCharArray();
            Arrays.sort(ch);
            String key=String.valueOf(ch);
            if(!map.containsKey(key))    map.put(key,new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}
