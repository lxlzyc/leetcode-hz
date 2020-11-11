package lxl.y2020.AUG;

import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description: 5483. 整理字符串
 * <p>
 * <p>
 * 给你一个由大小写英文字母组成的字符串 s 。
 * <p>
 * 一个整理好的字符串中，两个相邻字符 s[i] 和 s[i + 1] 不会同时满足下述条件：
 * <p>
 * 0 <= i <= s.length - 2
 * s[i] 是小写字符，但 s[i + 1] 是对应的大写字符；反之亦然 。
 * <p>
 * 请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
 * <p>
 * 请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
 * <p>
 * 注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "leEeetcode"
 * 输出："leetcode"
 * 解释：无论你第一次选的是 i = 1 还是 i = 2，都会使 "leEeetcode" 缩减为 "leetcode" 。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：s = "abBAcC"
 * 输出：""
 * 解释：存在多种不同情况，但所有的情况都会导致相同的结果。例如：
 * "abBAcC" --> "aAcC" --> "cC" --> ""
 * "abBAcC" --> "abBA" --> "aA" --> ""
 * <p>
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "s"
 * 输出："s"
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 只包含小写和大写英文字母
 * @author: lxl
 * @create: 2020-08-09 10:30
 **/
public class MakeTheStringGreat {

    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (Math.abs(c - stack.peek()) == 32) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        MakeTheStringGreat makeTheStringGreat = new MakeTheStringGreat();
        System.out.println(makeTheStringGreat.makeGood("leEeetcode"));
        System.out.println(makeTheStringGreat.makeGood("abBAcC"));
        System.out.println(makeTheStringGreat.makeGood("s"));
        //System.out.println(makeTheStringGreat.makeGood());

    }
}
