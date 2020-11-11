package lxl.work;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 907. 子数组的最小值之和
 * 给定一个整数数组 A，找到 min(B) 的总和，其中 B 的范围为 A 的每个（连续）子数组。
 * <p>
 * 由于答案可能很大，因此返回答案模 10^9 + 7。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A <= 30000
 * 1 <= A[i] <= 30000
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-subarray-minimums
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-12 13:39
 **/
public class SumOfSubarrayMinimums {

    public int sumSubarrayMins2(int[] A) {
        Queue<Integer> queue = new LinkedList<>();
        long count = 0;
        for (int a : A) {
            queue.add(a);
            count += a;
        }
        while (!queue.isEmpty()) {
            int index = queue.poll();
            List<Integer> nextQueue = new ArrayList<>();
            int next;
            int min;
            while (!queue.isEmpty()) {
                next = queue.poll();
                min = Math.min(index, next);
                nextQueue.add(min);
                count += min;
                index = next;
            }
            queue.addAll(nextQueue);

        }
        return (int) (count % 1_000_000_007);
    }

    int MOD = 1000000007;

    public int sumSubarrayMins(int[] A) {
        Stack<Pair> stack = new Stack<>();
        int res = 0, tmp = 0;
        for (int i = 0; i < A.length; i++) {
            int count = 1;
            while (!stack.empty() && stack.peek().val >= A[i]) {
                Pair pop = stack.pop();
                count += pop.count;
                tmp -= pop.val * pop.count;
            }
            stack.push(new Pair(A[i], count));
            tmp += A[i] * count;
            res += tmp;
            res %= MOD;
        }
        return res;
    }

    static class Pair {
        public int val;
        public int count;

        public Pair(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }


    public static void main(String[] args) {
        SumOfSubarrayMinimums sumOfSubarrayMinimums = new SumOfSubarrayMinimums();
        int[] A = {1};
        System.out.println(sumOfSubarrayMinimums.sumSubarrayMins(A));
    }
}
