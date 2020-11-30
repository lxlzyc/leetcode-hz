package lxl.y2021.NOV;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: leetcode-hz
 * @description: 767. 重构字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * <p>
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "aab"
 * 输出: "aba"
 * <p>
 * 示例 2:
 * <p>
 * 输入: S = "aaab"
 * 输出: ""
 * <p>
 * 注意:
 * <p>
 * S 只包含小写字母并且长度在[1, 500]区间内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorganize-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-11-30 09:26
 **/
public class ReorganizeString {

    public String reorganizeString(String S) {
        int l = S.length();
        if (l < 2) {
            return S;
        }
        int[] charCount = new int[26];
        int max = 0;
        for (char c : S.toCharArray()) {
            charCount[c - 'a']++;
            max = Math.max(max, charCount[c - 'a']);
        }
        if (max > (l + 1) / 2) {
            return "";
        }
        PriorityQueue<Character> characters = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Integer.compare(charCount[o2 - 'a'], charCount[o1 - 'a']);
            }
        });
        for (int i = 0; i < 26; i++) {
            if (charCount[i] > 0) {
                characters.offer((char) ('a' + i));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (characters.size() > 1) {
            char a = characters.poll();
            char b = characters.poll();
            charCount[a - 'a']--;
            charCount[b - 'a']--;
            if (charCount[a - 'a'] > 0) {
                characters.offer(a);
            }
            if (charCount[b - 'a'] > 0) {
                characters.offer(b);
            }
            stringBuilder.append(a);
            stringBuilder.append(b);
        }
        if (!characters.isEmpty()) {
            stringBuilder.append(characters.poll());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ReorganizeString reorganizeString = new ReorganizeString();
        System.out.println(reorganizeString.reorganizeString("aabbbbc"));
    }
}
