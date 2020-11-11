package lxl.y2020.AUG;

import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description: 921. 使括号有效的最少添加
 * j给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。
 * <p>
 * 从形式上讲，只有满足下面几点之一，括号字符串才是有效的：
 * <p>
 * 它是一个空字符串，或者
 * 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
 * 它可以被写作 (A)，其中 A 是有效字符串。
 * <p>
 * 给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："())"
 * 输出：1
 * <p>
 * 示例 2：
 * <p>
 * 输入："((("
 * 输出：3
 * <p>
 * 示例 3：
 * <p>
 * 输入："()"
 * 输出：0
 * <p>
 * 示例 4：
 * <p>
 * 输入："()))(("
 * 输出：4
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * S.length <= 1000
 * S 只包含 '(' 和 ')' 字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-add-to-make-parentheses-valid
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-13 10:34
 **/
public class MinimumAddToMakeParenthesesValid {

    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char s : S.toCharArray()) {
            if (!stack.isEmpty()) {
                if (s == ')') {
                    stack.pop();
                } else {
                    stack.push(s);
                }
            } else {
                if (s == ')') {
                    count++;
                } else {
                    stack.push(s);
                }
            }
        }
        return count + stack.size();
    }

}
