package lxl.y2021.DEC;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @program: leetcode-hz
 * @description: 264. 丑数 II
 * 编写一个程序，找出第 n 个丑数。
 * <p>
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 1
 * 2 3 5
 * 4 6 10 ;6 9 12; 12
 * <p>
 * 说明:
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-12-09 10:10
 **/
public class UglyNumberii {
    //2123366400
//第1690个2123366400
    public int nthUglyNumber(int n) {

        int[] dp = new int[n];
        dp[0] = 1;
        //初始指针
        int num2 = 0;
        int num3 = 0;
        int num5 = 0;

        int l = dp.length;
        int offset = 1;
        while (offset < l) {
            dp[offset] = Math.min(Math.min(dp[num2] * 2, dp[num3] * 3), dp[num5] * 5);
            if (dp[offset] == dp[num2] * 2) {
                num2++;
            }
            if (dp[offset] == dp[num3] * 3) {
                num3++;
            }
            if (dp[offset] == dp[num5] * 5) {
                num5++;
            }
            offset++;
        }
        return dp[n - 1];
    }

    public int nthUglyNumber2(int n) {
        int[] nums = new int[n];
        HashSet<Long> seen = new HashSet();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.add(1L);
        long currUgly, newUgly;
        int[] primes = new int[]{2, 3, 5};
        for (int i = 0; i < n; ++i) {
            currUgly = heap.poll();
            nums[i] = (int) currUgly;
            for (int j : primes) {
                newUgly = currUgly * j;
                if (!seen.contains(newUgly)) {
                    seen.add(newUgly);
                    heap.add(newUgly);
                }
            }
        }
        return nums[n - 1];
    }

    public static void main(String[] args) {
        UglyNumberii uglyNumberii = new UglyNumberii();
        System.out.println(uglyNumberii.nthUglyNumber(1690));
        System.out.println(uglyNumberii.nthUglyNumber2(1690));
        for (int i = 0; i < 1000; i++) {
            if (uglyNumberii.nthUglyNumber(i + 1) != uglyNumberii.nthUglyNumber2(i + 1)) {
                System.out.println("i==" + i);
            }
        }
        System.out.println("end-----");

    }

}
