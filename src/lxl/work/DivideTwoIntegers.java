package lxl.work;

/**
 * @program: leetcode-hz
 * @description: 29. 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * <p>
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-04 16:31
 **/
public class DivideTwoIntegers {
    //int 范围 -2147483648——2147483647
    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == -2147483648) {
                return 2147483647;
            } else {
                return 0 - dividend;
            }
        }
        if (divisor == -2147483648) {
            if (dividend == -2147483648) {
                return 1;
            } else {
                return 0;
            }
        }


        boolean negative = false;
        if (divisor < 0) {
            negative = !negative;
            divisor = 0 - divisor;
        }
        if (dividend < 0) {
            negative = !negative;
            dividend = 0 - dividend;
        }
        int re = 0;
        int help = 1;
        int helpDivisor = divisor;
        while (true) {
            if (dividend >= 0) {
                if (dividend < divisor) {
                    break;
                } else {
                    re += help;
                    dividend -= helpDivisor;
                    helpDivisor += divisor;
                    help++;
                }
            } else {
                while (dividend < 0) {
                    dividend += divisor;
                    re--;
                }
                break;
            }

        }
        return negative ? 0 - re : re;
    }

    public static void main(String[] args) {
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        System.out.println(divideTwoIntegers.divide(-2147483648, 2));
    }
}
