package lxl.y2020.JAN;

import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description: 150. 逆波兰表达式求值
 * 根据逆波兰表示法，求表达式的值。
 * <p>
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 说明：
 * <p>
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * <p>
 * 示例 1：
 * <p>
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-06 14:48
 **/
public class EvaluateReversePolishNotation {

    //下面以(a+b)*c为例子进行说明：
    //        (a+b)*c的逆波兰式为ab+c*，假设计算机把ab+c*按从左到右的顺序压入栈中，并且按照遇到运算符就把栈顶两个元素出栈，执行运算，得到的结果再入栈的原则来进行处理，那么ab+c*的执行结果如下：
    //        1）a入栈（0位置）
    //        2）b入栈（1位置）
    //        3）遇到运算符“+”，将a和b出栈，执行a+b的操作，得到结果d=a+b，再将d入栈（0位置）
    //        4）c入栈（1位置）
    //        5）遇到运算符“*”，将d和c出栈，执行d*c的操作，得到结果e，再将e入栈（0位置）
    //经过以上运算，计算机就可以得到(a+b)*c的运算结果e了。
    public int evalRPN(String[] tokens) {
        Stack<Integer> stackNum = new Stack();
        Stack operator = new Stack();
        int num1;
        int num2;
        for (String string : tokens) {
            if ("+".equals(string)) {
                num1 = stackNum.pop();
                num2 = stackNum.pop();
                stackNum.push(num1 + num2);
            } else if ("-".equals(string)) {
                num1 = stackNum.pop();
                num2 = stackNum.pop();
                stackNum.push(num2 - num1);
            } else if ("*".equals(string)) {
                num1 = stackNum.pop();
                num2 = stackNum.pop();
                stackNum.push(num1 * num2);
            } else if ("/".equals(string)) {
                num1 = stackNum.pop();
                num2 = stackNum.pop();
                stackNum.push(num2 / num1);
            } else {
                stackNum.push(Integer.valueOf(string));
            }
        }
        return stackNum.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evaluateReversePolishNotation.evalRPN(tokens));
    }
}
