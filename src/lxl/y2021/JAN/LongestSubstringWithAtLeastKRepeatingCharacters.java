package lxl.y2021.JAN;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 395. 至少有K个重复字符的最长子串
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "aaabb", k = 3
 * <p>
 * 输出:
 * 3
 * <p>
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * s = "ababbc", k = 2
 * <p>
 * 输出:
 * 5
 * <p>
 * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/1/20 10:02
 * @Version 1.0
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {

    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        if (k <= 1) {
            return len;
        }
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            characterIntegerMap.put(c, characterIntegerMap.getOrDefault(c, 0) + 1);
        }
        // 这里是先把 s 传进 sb 中来找出不满足 k 个的元素及其位置
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (characterIntegerMap.get(s.charAt(i)) < k) {
                sb.setCharAt(i, ',');
            }
        }
        // 然后以不符合要求的元素位置进行分割存储到字符串数组中
        String[] string = sb.toString().split(",");
        // 如果仅有一组，则说明只有一个字母，返回首字母既可
        if (string.length == 1) {
            return string[0].length();
        }
        int max = 0;
        // 如果有多组，就进行最大值比较
        // 例如 aaabcccc，通过上面的操作后 化为 aaa,cccc
        for (String str : string) {
            max = Math.max(max, longestSubstring(str, k));
        }
        return max;
    }
}