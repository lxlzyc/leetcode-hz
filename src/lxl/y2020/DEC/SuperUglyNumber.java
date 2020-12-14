package lxl.y2020.DEC;

import java.util.PriorityQueue;

/**
 * @program: leetcode-hz
 * @description: 313. 超级丑数
 * 编写一段程序来查找第 n 个超级丑数。
 * <p>
 * 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 12, primes = [2,7,13,19]
 * 输出: 32
 * 解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 * <p>
 * 说明:
 * <p>
 * 1 是任何给定 primes 的超级丑数。
 * 给定 primes 中的数字以升序排列。
 * 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。
 * 第 n 个超级丑数确保在 32 位有符整数范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-ugly-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-12-10 09:40
 **/
public class SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        int offset = 0;
        long num = 0;
        priorityQueue.offer(1L);
        long temp;
        while (true) {
            offset++;
            num = priorityQueue.poll();
            if (offset == n) {
                break;
            }
            //删除重复的
            while (!priorityQueue.isEmpty() && num == priorityQueue.peek()) {
                priorityQueue.poll();
            }
            for (int prime : primes) {
                temp = num * prime;
                if (temp < Integer.MAX_VALUE) {
                    priorityQueue.offer(temp);
                }
            }
        }
        return (int) num;
    }

    public static void main(String[] args) {
        SuperUglyNumber superUglyNumber = new SuperUglyNumber();
        int[] primes = {7, 19, 29, 37, 41, 47, 53, 59, 61, 79, 83, 89, 101, 103, 109, 127, 131, 137, 139, 157, 167, 179, 181, 199, 211, 229, 233, 239, 241, 251};
        System.out.println(superUglyNumber.nthSuperUglyNumber(100000, primes));
    }
}
