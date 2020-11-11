package lxl.y2020.AUG;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-primes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-31 13:37
 **/
public class CountPrimes {

    public int countPrimes(int n) {
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, true);
        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) {
                // i 的倍数不可能是素数了
                for (int j = 2 * i; j < n; j += i) {
                    isPrimes[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
        System.out.println(countPrimes.countPrimes(3));
    }

}

