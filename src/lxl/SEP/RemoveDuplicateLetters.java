package lxl.SEP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description: 316. 去除重复字母
 * 给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: "bcabc"
 * 输出: "abc"
 * <p>
 * 示例 2:
 * <p>
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-09-03 13:50
 **/
public class RemoveDuplicateLetters {
    //每次递归中，在保证其他字符至少出现一次的情况下，确定最小左侧字符。之后再将未处理的后缀字符串继续递归。
    //public String removeDuplicateLetters(String s) {
    //    int[] cnt = new int[26];
    //    for (int i = 0, l = s.length(); i < l; i++) {
    //        cnt[s.charAt(i) - 'a']++;
    //    }
    //    int pos = 0;
    //    for (int i = 0, l = s.length(); i < l; i++) {
    //        if (s.charAt(i) < s.charAt(pos)) {
    //            pos = i;
    //        }
    //        cnt[s.charAt(i) - 'a']--;
    //        if (cnt[s.charAt(i) - 'a'] == 0) {
    //            break;
    //        }
    //    }
    //    return s.length() == 0 ? "" : s.charAt(pos) + this.removeDuplicateLetters(s.replaceAll(String.valueOf(s.charAt(pos)), ""));
    //}
    //用栈来存储最终返回的字符串，并维持字符串的最小字典序。每遇到一个字符，
    //如果这个字符不存在于栈中，就需要将该字符压入栈中。但在压入之前，
    //需要先将之后还会出现，并且字典序比当前字符小的栈顶字符移除，然后再将当前字符压入。
    //
    //作者：LeetCode
    //链接：https://leetcode-cn.com/problems/remove-duplicate-letters/solution/qu-chu-zhong-fu-zi-mu-by-leetcode/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public String removeDuplicateLetters(String s) {

        Stack<Character> stack = new Stack<>();

        // this lets us keep track of what's in our solution in O(1) time
        HashSet<Character> seen = new HashSet<>();

        // this will let us know if there are any more instances of s[i] left in s
        HashMap<Character, Integer> last_occurrence = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            last_occurrence.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // we can only try to add c if it's not already in our solution
            // this is to maintain only one of each character
            if (!seen.contains(c)) {
                // if the last letter in our solution:
                //     1. exists
                //     2. is greater than c so removing it will make the string smaller
                //     3. it's not the last occurrence
                // we remove it from the solution to keep the solution optimal
                while (!stack.isEmpty() && c < stack.peek() && last_occurrence.get(stack.peek()) > i) {
                    seen.remove(stack.pop());
                }
                seen.add(c);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder(stack.size());
        for (Character c : stack) {
            sb.append(c.charValue());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        System.out.println(removeDuplicateLetters.removeDuplicateLetters("cbacdcbc"));
    }
}
