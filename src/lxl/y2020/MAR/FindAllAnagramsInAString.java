package lxl.y2020.MAR;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 438. 找到字符串中所有字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * 输出:
 * [0, 6]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * s: "abab" p: "ab"
 * <p>
 * 输出:
 * [0, 1, 2]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 * @author: lxl
 * @create: 2020-03-24 15:56
 **/
public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        if (s.isEmpty() || p.isEmpty()) {
            return new ArrayList<>();
        }
        for (char index : p.toCharArray()) {
            map.put(index, map.getOrDefault(index, 0));
        }
        int length = s.length();
        int left = 0;
        int right = 0;
        int pLength = p.length();
        char[] schars = s.toCharArray();
        Map<Character, Integer> window = new HashMap<>();
        List<Integer> re = new ArrayList<>();
        while (right < length) {
            char rightChar = schars[right];
            if (!map.containsKey(rightChar)) {
                right++;
                left = right;
                window.clear();
                continue;
            }
            window.put(schars[right], window.getOrDefault(schars[right], 0) + 1);
            if (right - left + 1 == pLength) {
                boolean same = this.checkSame(map, window);
                if (same) {
                    re.add(left);
                }
                char leftchar = schars[left];
                if (window.get(leftchar) > 1) {
                    window.put(leftchar, window.get(leftchar) - 1);
                } else {
                    window.remove(leftchar);
                }
                left++;
                right++;
                while (right < length && schars[right] != leftchar) {
                    window.put(schars[right], window.getOrDefault(schars[right], 0) + 1);
                    if (window.get(schars[left]) > 1) {
                        window.put(schars[left], window.get(schars[left]) - 1);
                    } else {
                        window.remove(schars[left]);
                    }
                    left++;
                    right++;
                }
                continue;
            }
            right++;

        }
        return re;
    }

    private boolean checkSame(Map<Character, Integer> map, Map<Character, Integer> window) {
        for (Character key : window.keySet()) {
            if (!window.get(key).equals(map.get(key))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString findAllAnagramsInAString = new FindAllAnagramsInAString();
        System.out.println(findAllAnagramsInAString.findAnagrams("abacbabc",
                "abc"));
    }
}
