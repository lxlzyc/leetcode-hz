package lxl.APR;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 1111. 有效括号的嵌套深度
 * 有效括号字符串 仅由 "(" 和 ")" 构成，并符合下述几个条件之一：
 * <p>
 * 空字符串
 * 连接，可以记作 AB（A 与 B 连接），其中 A 和 B 都是有效括号字符串
 * 嵌套，可以记作 (A)，其中 A 是有效括号字符串
 * <p>
 * 类似地，我们可以定义任意有效括号字符串 s 的 嵌套深度 depth(S)：
 * <p>
 * s 为空时，depth("") = 0
 * s 为 A 与 B 连接时，depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是有效括号字符串
 * s 为嵌套情况，depth("(" + A + ")") = 1 + depth(A)，其中 A 是有效括号字符串
 * <p>
 * 例如：""，"()()"，和 "()(()())" 都是有效括号字符串，嵌套深度分别为 0，1，2，而 ")(" 和 "(()" 都不是有效括号字符串。
 * <p>
 * <p>
 * <p>
 * 给你一个有效括号字符串 seq，将其分成两个不相交的子序列 A 和 B，且 A 和 B 满足有效括号字符串的定义（注意：A.length + B.length = seq.length）。
 * <p>
 * 现在，你需要从中选出 任意 一组有效括号字符串 A 和 B，使 max(depth(A), depth(B)) 的可能取值最小。
 * <p>
 * 返回长度为 seq.length 答案数组 answer ，选择 A 还是 B 的编码规则是：如果 seq[i] 是 A 的一部分，那么 answer[i] = 0。否则，answer[i] = 1。即便有多个满足要求的答案存在，你也只需返回 一个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：seq = "(()())"
 * 输出：[0,1,1,1,1,0]
 * <p>
 * 示例 2：
 * <p>
 * 输入：seq = "()(())()"
 * 输出：[0,0,0,1,1,0,1,1]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= text.size <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-01 10:46
 **/
public class MaximumNestingDepthOfTwoValidParenthesesStrings {

    //维护一个栈 s，从左至右遍历括号字符串中的每一个字符：
    //
    //如果当前字符是 (，就把 ( 压入栈中，此时这个 ( 的嵌套深度为栈的高度；
    //
    //        如果当前字符是 )，此时这个 ) 的嵌套深度为栈的高度，随后再从栈中弹出一个 (。
    //
    //                                                下面给出了括号序列 (()(())()) 在每一个字符处的嵌套深度：
    //
    //括号序列   ( ( ) ( ( ) ) ( ) )
    //下标编号   0 1 2 3 4 5 6 7 8 9
    //嵌套深度   1 2 2 2 3 3 2 2 2 1
    //
    //知道如何计算嵌套深度，问题就很简单了：只要在遍历过程中，我们保证栈内一半的括号属于序列 A，一半的括号属于序列 B，那么就能保证拆分后最大的嵌套深度最小，是当前最大嵌套深度的一半。要实现这样的对半分配，我们只需要把奇数层的 ( 分配给 A，偶数层的 ( 分配给 B 即可。对于上面的例子，我们将嵌套深度为 1 和 3 的所有括号 (()) 分配给 A，嵌套深度为 2 的所有括号 ()()() 分配给 B。
    //
    //此外，由于在这个问题中，栈中只会存放 (，因此我们不需要维护一个真正的栈，只需要用一个变量模拟记录栈的大小。
    public int[] maxDepthAfterSplit(String seq) {
        int length = seq.length();
        int[] nums = new int[length];
        char[] chars = seq.toCharArray();
        int help = 1;
        for (int i = 0; i < length; i++) {
            if (chars[i] == '(') {
                help++;
                nums[i] = help % 2;
            } else {
                nums[i] = help % 2;
                help--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        MaximumNestingDepthOfTwoValidParenthesesStrings maximumNestingDepthOfTwoValidParenthesesStrings = new
                MaximumNestingDepthOfTwoValidParenthesesStrings();
        System.out.println(Arrays.toString(maximumNestingDepthOfTwoValidParenthesesStrings.maxDepthAfterSplit("()(())()")));
    }
}

