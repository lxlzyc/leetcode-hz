package lxl.y2020.JAN;

import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description: 224. 基本计算器
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * <p>
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "1 + 1"
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * 输入: " 2-1 + 2 "
 * 输出: 3
 * <p>
 * 示例 3:
 * <p>
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 * <p>
 * 说明：
 * <p>
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-13 10:37
 **/
public class BasicCalculator {
    //48 -57
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> symbols = new Stack<>();
        char[] chars = s.toCharArray();
        Integer num;
        StringBuffer numString = new StringBuffer();
        for (int i = 0, l = chars.length; i < l; i++) {
            char index = chars[i];
            if (index >= 48 && index <= 57) {
                numString.append(index);
            } else {
                if (numString.length() > 0) {
                    num = Integer.valueOf(numString.toString());
                    numString.delete(0, numString.length());
                    char symbol = symbols.peek();
                    if (symbol == '+') {
                        symbols.pop();
                        int numpop = nums.pop();
                        nums.push(num + numpop);
                    } else if (symbol == '-') {
                        symbols.pop();
                        int numpop = nums.pop();
                        nums.push(num - numpop);
                    } else {
                        nums.push(num);
                    }
                }
                if (index == ' ') {

                } else if (index == '(') {
                    symbols.push('(');
                } else if (index == ')') {

                } else if (index == '-') {

                } else if (index == '+') {

                }
            }
        }
        return 1;
    }

}
