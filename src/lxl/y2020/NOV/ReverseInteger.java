package lxl.y2020.NOV;

/**
 * @program: leetcode-hz
 * @description: 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * <p>
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-11-27 17:16
 **/
public class ReverseInteger {

    // int 范围 -2147483648——2147483647
    // 字符串翻转
    public int reverse(int x) {
        if (x == 0) {
            return x;
        }
        boolean bigThenZero = true;
        if (x < 0) {
            bigThenZero = false;
            x = 0 - x;
        }
        while (x % 10 == 0) {
            x = x / 10;
        }
        StringBuilder sb = new StringBuilder("" + x);
        if (!bigThenZero) {
            sb.append("-");
        }
        try {
            return Integer.valueOf(sb.reverse().toString());
        } catch (Exception e) {
            return 0;
        }

    }

    public int reverse2(int x) {
        if (x == 0) {
            return x;
        }
        if (x == -2147483648) {
            return 0;
        }
        long re = 0;
        boolean bigThenZero = true;
        if (x < 0) {
            bigThenZero = false;
            x = 0 - x;
        }
        while (x > 0) {
            re = re * 10 + x % 10;
            x = x / 10;
        }
        if (!bigThenZero) {
            re = 0 - re;
        }
        if (re > 2147483647 || re < -2147483648) {
            return 0;
        }
        return (int) re;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse2(21474470));
    }

}
