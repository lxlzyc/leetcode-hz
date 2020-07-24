package lxl.JUL;

import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description: 856. 括号的分数
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 * <p>
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： "()"
 * 输出： 1
 * <p>
 * 示例 2：
 * <p>
 * 输入： "(())"
 * 输出： 2
 * <p>
 * 示例 3：
 * <p>
 * 输入： "()()"
 * 输出： 2
 * <p>
 * 示例 4：
 * <p>
 * 输入： "(()(()))"
 * 输出： 6
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * S 是平衡括号字符串，且只含有 ( 和 ) 。
 * 2 <= S.length <= 50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-24 15:39
 **/
public class ScoreOfParentheses {

    public int scoreOfParentheses(String S) {
        Stack<String> stack = new Stack<>();
        char[] chars = S.toCharArray();
        for (int i = 0, l = chars.length; i < l; i++) {
            this.pushStack(stack, "" + chars[i]);
        }
        return Integer.valueOf(stack.pop());
    }

    private void pushStack(Stack<String> stack, String item) {
        if (stack.isEmpty()) {
            stack.push(item);
            return;
        }
        if ("(".equals(item)) {
            stack.push("" + item);
        } else if (")".equals(item)) {
            String pop = stack.pop();
            if ("(".equals(pop)) {
                this.pushStack(stack, "1");
            } else {
                stack.pop();
                this.pushStack(stack, "" + Integer.valueOf(pop) * 2);
            }
        } else {
            if ("(".equals(stack.peek())) {
                stack.push("" + item);
            } else {
                stack.push(String.valueOf(Integer.valueOf(stack.pop()) + Integer.valueOf("" + item)));
            }
        }
    }

    public int scoreOfParentheses2(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if (S.charAt(i - 1) == '(')
                    ans += 1 << bal;
            }
        }

        return ans;
    }

    //字符串 S 中的每一个位置都有一个“深度”，即该位置外侧嵌套的括号数目。例如，字符串 (()(.())) 中的 . 的深度为 2，因为它外侧嵌套了 2 层括号：(__(.__))。
    //
    //我们用一个栈来维护当前所在的深度，以及每一层深度的得分。当我们遇到一个左括号 ( 时，我们将深度加一，并且新的深度的得分置为 0。当我们遇到一个右括号 ) 时，我们将当前深度的得分乘二并加到上一层的深度。这里有一种例外情况，如果遇到的是 ()，那么只将得分加一。
    //
    //下面给出了字符串 (()(())) 每次对应的栈的情况：
    //
    //        [0, 0] (
    //        [0, 0, 0] ((
    //        [0, 1] (()
    //        [0, 1, 0] (()(
    //        [0, 1, 0, 0] (()((
    //        [0, 1, 1] (()(()
    //        [0, 3] (()(())
    //        [6] (()(()))
    //
    //作者：LeetCode
    //链接：https://leetcode-cn.com/problems/score-of-parentheses/solution/gua-hao-de-fen-shu-by-leetcode/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int scoreOfParentheses3(String S) {
        Stack<Integer> stack = new Stack();
        stack.push(0); // The score of the current frame

        for (char c : S.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        ScoreOfParentheses scoreOfParentheses = new ScoreOfParentheses();
        System.out.println(scoreOfParentheses.scoreOfParentheses("()(12)()"));


    }
}
