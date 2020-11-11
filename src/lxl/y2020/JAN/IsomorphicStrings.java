package lxl.y2020.JAN;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 205. 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "egg", t = "add"
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * <p>
 * 示例 3:
 * <p>
 * 输入: s = "paper", t = "title"
 * 输出: true
 * <p>
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-09 15:24
 **/
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }
        Map<Character, Character> changes = new HashMap<>();
        Map<Character, Character> changes2 = new HashMap<>();

        char[] char1 = s.toCharArray();
        char[] char2 = t.toCharArray();
        for (int i = 0, l = char1.length; i < l; i++) {
            char index = char1[i];
            if (changes.containsKey(index)) {
                if (changes.get(index) != char2[i]) {
                    return false;
                }
            }
            if (changes2.containsKey(char2[i])) {
                if (changes2.get(char2[i]) != index) {
                    return false;
                }
            }
            changes.put(char1[i], char2[i]);
            changes2.put(char2[i], char1[i]);

        }
        return true;
    }

    public static void main(String[] args) {
        String s = "12";
        String t = "11";
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        System.out.println(isomorphicStrings.isIsomorphic(s, t));
    }
}
