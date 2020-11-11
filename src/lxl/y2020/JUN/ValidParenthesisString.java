package lxl.y2020.JUN;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description: 678. 有效的括号字符串
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 * <p>
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: True
 * <p>
 * 示例 2:
 * <p>
 * 输入: "(*)"
 * 输出: True
 * <p>
 * 示例 3:
 * <p>
 * 输入: "(*))"
 * 输出: True
 * <p>
 * 注意:
 * <p>
 * 字符串大小将在 [1，100] 范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parenthesis-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-03 13:46
 **/
public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        LinkedList<Character> linkedList = new LinkedList<>();
        char[] chars = s.toCharArray();
        boolean begin = false;
        for (int i = 0, l = chars.length; i < l; i++) {
            if (chars[i] == ')') {
                boolean remove = false;
                for (int j = linkedList.size() - 1; j >= 0; j--) {
                    if (linkedList.get(j) == '(') {
                        linkedList.remove(j);
                        remove = true;
                        break;
                    }
                }
                if (!remove) {
                    if (linkedList.isEmpty()) {
                        return false;
                    } else if (linkedList.getLast() == '*') {
                        linkedList.pollLast();
                    } else {
                        return false;
                    }
                }
            } else {
                linkedList.addLast(chars[i]);
            }
        }
        Stack<Character> stack = new Stack<>();
        for (Character c : linkedList) {
            if (stack.isEmpty() && c == '*') {
                continue;
            } else if (c == '(') {
                stack.push('(');
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    //贪心
    //在检查字符串是否有效时，我们只关心是否 “balance”：当我们分析字符串时计算未配对的左括号的数量。例如，在检查 “(()())” 是否有效时，我们在分析字符串时得到了 1, 2, 1, 2, 1, 0 的平衡过程：“(” 有1个左括号，“(” 有2个左括号，“(()” 剩下一个左括号，依此类推。
    //例如，如果我们有字符串 (***)，那么在分析每个符号时，balance 的可能值是 '(' 对应 [1] ,'(*' 对应 [0, 1, 2], '(**' 对应 [0, 1, 2, 3], '(***' 对应 [0, 1, 2, 3, 4],'(***)'对应 [0, 1, 2, 3]。(指的是可能的未匹配的左括号数量)
    //此外，我们可以证明这些状态总是形成一个连续的区间。因此，我们只需要知道这个区间的左右边界。也就是说，我们将把上面描述的中间状态保持为 [lo, hi] = [1, 1], [0, 2], [0, 3], [0, 4], [0, 3]
    //
    //算法：
    //
    //在处理字符串中的当前字符时，让 lo、hi 分别为可能的最小和最大左括号数。
    //如果我们遇到左括号（c == '('），那么 lo++，若遇到右括号，则 lo--。如果我们遇到 * 号且可以转换成左括号（c != ')'），则 hi++，否则我们转换成右括号，所以 hi--。如果 hi<0 ，那么无论我们选择什么，当前情况都无法生成有效的括号。而且，左括号不能小于0。最后，我们应该检查一下是否可以有 0 个左括号。
    //
    //作者：LeetCode
    //链接：https://leetcode-cn.com/problems/valid-parenthesis-string/solution/you-xiao-de-gua-hao-zi-fu-chuan-by-leetcode/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean checkValidString2(String s) {
        int lo = 0;
        int hi = 0;
        char[] chars = s.toCharArray();
        for (int i = 0, l = chars.length; i < l; i++) {
            if (chars[i] == '(') {
                lo += 1;
                hi += 1;
            } else if (chars[i] == ')') {
                if (lo > 0) {
                    lo -= 1;
                }
                hi -= 1;
            } else {
                if (lo > 0) {
                    lo -= 1;
                }
                hi += 1;
            }
            if (hi < 0) {
                return false;
            }
        }
        return lo == 0;
    }

    public static void main(String[] args) {
        ValidParenthesisString validParenthesisString = new ValidParenthesisString();
        System.out.println(validParenthesisString.checkValidString("**)(*((*)*"));
    }
}
