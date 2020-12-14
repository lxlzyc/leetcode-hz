package lxl.y2020.DEC;

import java.util.LinkedList;

/**
 * @program: leetcode-hz
 * @description: 1209. 删除字符串中的所有相邻重复项 II
 * 给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。
 * <p>
 * 你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。
 * <p>
 * 在执行完所有删除操作后，返回最终得到的字符串。
 * <p>
 * 本题答案保证唯一。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", k = 2
 * 输出："abcd"
 * 解释：没有要删除的内容。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "deeedbbcccbdaa", k = 3
 * 输出："aa"
 * 解释：
 * 先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
 * 再删除 "bbb"，得到 "dddaa"
 * 最后删除 "ddd"，得到 "aa"
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "pbbcggttciiippooaais", k = 2
 * 输出："ps"
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * 2 <= k <= 10^4
 * s 中只含有小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-12-02 14:20
 **/
public class RemoveAllAdjacentDuplicatesInStringii {

    public String removeDuplicates(String s, int k) {
        LinkedList<Character> chars = new LinkedList<>();
        LinkedList<Integer> charsCount = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (chars.isEmpty()) {
                chars.addLast(c);
                charsCount.addLast(1);
            } else if (chars.getLast() != c) {
                chars.addLast(c);
                charsCount.addLast(1);
            } else {
                int count = charsCount.removeLast() + 1;
                if (count == k) {
                    chars.removeLast();
                } else {
                    charsCount.addLast(count);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0, l = chars.size(); i < l; i++) {
            char c = chars.removeFirst();
            for (int j = 0, count = charsCount.removeFirst(); j < count; j++) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInStringii removeAllAdjacentDuplicatesInStringii = new RemoveAllAdjacentDuplicatesInStringii();
        System.out.println(removeAllAdjacentDuplicatesInStringii.removeDuplicates("a", 3));
    }
}
