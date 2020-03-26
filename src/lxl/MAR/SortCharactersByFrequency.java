package lxl.MAR;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @program: leetcode-hz
 * @description: 451. 根据字符出现频率排序
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "tree"
 * <p>
 * 输出:
 * "eert"
 * <p>
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * "cccaaa"
 * <p>
 * 输出:
 * "cccaaa"
 * <p>
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * <p>
 * 示例 3:
 * <p>
 * 输入:
 * "Aabb"
 * <p>
 * 输出:
 * "bbAa"
 * <p>
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-03-26 16:27
 **/
public class SortCharactersByFrequency {

    public String frequencySort(String s) {

        char[] chars = s.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char index : chars) {
            hashMap.put(index, hashMap.getOrDefault(index, 0) + 1);
        }
        TreeMap<Character, Integer> treeMaps = new TreeMap<>(
                new ValueComparator(hashMap)
        );
        treeMaps.putAll(hashMap);
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<Character, Integer> mapEntry : treeMaps.entrySet()) {
            for (int i = 0; i < mapEntry.getValue(); i++) {
                stringBuilder.append(mapEntry.getKey());
            }
        }
        return stringBuilder.toString();
    }

    class ValueComparator implements Comparator<Character> {

        HashMap<Character, Integer> base;

        public ValueComparator(HashMap<Character, Integer> base) {
            this.base = base;
        }

        @Override
        public int compare(Character a, Character b) {
            if (base.get(a) >= base.get(b)) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        SortCharactersByFrequency sortCharactersByFrequency = new SortCharactersByFrequency();
        System.out.println(sortCharactersByFrequency.frequencySort("adddddddddddddeeeeeafaweeeeeeeqw"));
    }
}
