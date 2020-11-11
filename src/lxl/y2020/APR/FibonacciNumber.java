package lxl.y2020.APR;

/**
 * @program: leetcode-hz
 * @description: 509. 斐波那契数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * <p>
 * 给定 N，计算 F(N)。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * <p>
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * <p>
 * 示例 3：
 * <p>
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 ≤ N ≤ 30
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-11 19:31
 **/
public class FibonacciNumber {

    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        int re = 0;
        int count = 1;
        int help;
        while (N > 1) {
            help = count;
            count += re;
            re = help;
            N--;
        }

        return count;
    }

    public static void main(String[] args) {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        System.out.println(fibonacciNumber.fib(6));
    }

}
