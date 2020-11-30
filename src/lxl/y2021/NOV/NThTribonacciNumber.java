package lxl.y2021.NOV;

/**
 * @program: leetcode-hz
 * @description: 1137. 第 N 个泰波那契数
 * 泰波那契序列 Tn 定义如下：
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 25
 * 输出：1389537
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-11-30 10:27
 **/
public class NThTribonacciNumber {

    private int[] help = new int[38];

    public int tribonacci(int n) {
        if (n <= 2) {
            return n > 0 ? 1 : 0;
        }
        if (help[n] > 0) {
            return help[n];
        }
        int val = tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1);
        help[n] = val;
        return val;
    }
}
