package lxl.y2021.MAR;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 示例:
 * <p>
 * s = "abaccdeff"
 * 返回 "b"
 * <p>
 * s = ""
 * 返回 " "
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/17 11:01
 * @Version 1.0
 */
public class FirstUniqChar {

    public char firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> treeMap = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            treeMap.put(c, treeMap.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : treeMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        System.out.println(firstUniqChar.firstUniqChar("leetcode"));
    }
}