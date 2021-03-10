package lxl.y2021.MAR;

import java.util.Stack;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 224. 基本计算器
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1 + 1"
 * 输出：2
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/10 9:54
 * @Version 1.0
 */
public class BasicValculator {
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                stack.push("(");
            } else if (c == '-') {
                stack.push("-");
            } else if (c == '+' || c == ' ') {
            } else if (c == ')') {
                long sum = 0;
                while (!stack.peek().equals("(")) {
                    long item = Long.valueOf(stack.pop());
                    sum += item;
                }
                stack.pop();
                if (!stack.isEmpty() && stack.peek() == "-") {
                    stack.pop();
                    if (sum <= 0) {
                        stack.push(String.valueOf(0 - sum));
                    } else {
                        stack.push("-" + String.valueOf(sum));
                    }
                } else {
                    stack.push(String.valueOf(sum));
                }
            } else {
                int offset = i;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(c);
                while (offset + 1 < chars.length) {
                    if (chars[offset + 1] >= '0' && chars[offset + 1] <= '9') {
                        stringBuilder.append(chars[offset + 1]);
                        offset++;
                    } else {
                        break;
                    }
                }
                i = offset;
                if (!stack.isEmpty() && stack.peek() == "-") {
                    stack.pop();
                    if (stringBuilder.charAt(0) == '-') {
                        stringBuilder.deleteCharAt(0);
                        stack.push(stringBuilder.toString());
                    } else {
                        stack.push("-" + stringBuilder.toString());
                    }
                } else {
                    stack.push(stringBuilder.toString());
                }
            }
        }
        long ans = 0;
        while (!stack.isEmpty()) {
            ans += Long.valueOf(stack.pop());
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        BasicValculator basicValculator = new BasicValculator();
        System.out.println(basicValculator.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}