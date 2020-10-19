package lxl.OCT;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: leetcode-hz
 * @description: 862. 和至少为 K 的最短子数组
 * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
 * <p>
 * 如果没有和至少为 K 的非空子数组，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1], K = 1
 * 输出：1
 * <p>
 * 示例 2：
 * <p>
 * 输入：A = [1,2], K = 4
 * 输出：-1
 * <p>
 * 示例 3：
 * <p>
 * 输入：A = [2,-1,2], K = 3
 * 输出：3
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 50000
 * -10 ^ 5 <= A[i] <= 10 ^ 5
 * 1 <= K <= 10 ^ 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-10-19 16:22
 **/
public class ShortestSubarrayWithSumAtLeastK {

    public int shortestSubarray(int[] A, int K) {
        int N = A.length;
        //前缀和。 P[i+1] = A[0]---A[i]的和
        long[] P = new long[N + 1];
        for (int i = 0; i < N; ++i) {
            P[i + 1] = P[i] + (long) A[i];
        }
        //返回值
        int ans = N + 1;
        //双端队列
        Deque<Integer> monoq = new LinkedList();

        for (int y = 0; y < P.length; ++y) {
            //保持前缀和单调递增
            while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()]) {
                monoq.removeLast();
            }
            //如果 队列头 first---y的值大于K，计算此时长度。且移除队列头
            while (!monoq.isEmpty() && (P[y] - P[monoq.getFirst()]) >= K) {
                ans = Math.min(ans, y - monoq.removeFirst());
            }
            //添加进队列尾
            monoq.addLast(y);
        }
        return ans < N + 1 ? ans : -1;
    }


    public static void main(String[] args) {
        ShortestSubarrayWithSumAtLeastK shortestSubarrayWithSumAtLeastK = new ShortestSubarrayWithSumAtLeastK();
        int[] A = {2, -1, 2};
        System.out.println(shortestSubarrayWithSumAtLeastK.shortestSubarray(A, 3));
    }

    public int shortestSubarray3(int[] A, int K) {
        int l = A.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < l; i++) {
            int sum = A[i];
            if (sum <= 0) {
                continue;
            }
            if (sum >= K) {
                return 1;
            }
            for (int j = i + 1; j < l; j++) {
                if (j - i + 1 >= min) {
                    break;
                }
                sum += A[j];
                if (sum <= 0) {
                    break;
                }
                if (sum >= K) {
                    min = Math.min(j - i + 1, min);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public int shortestSubarray2(int[] A, int K) {
        int l = A.length;
        //标识i-j闭区间的sum
        int[][] dp = new int[l][l];
        for (int i = 0; i < l; i++) {
            if (A[i] >= K) {
                return 1;
            }
            dp[i][i] = A[i];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                if (j - i + 1 >= min) {
                    break;
                }
                dp[i][j] = dp[i][j - 1] + A[j];
                if (dp[i][j] >= K) {
                    min = Math.min(j - i + 1, min);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public int shortestSubarray4(int[] A, int K) {
        int l = A.length;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (right < l) {
            sum += A[right];
            if (sum <= 0) {
                sum = 0;
            } else if (sum >= K) {
                //反向获取
                int offset = right;
                int sumHelp = 0;
                while (offset >= 0) {
                    sumHelp += A[offset];
                    if (sumHelp >= K) {
                        break;
                    }
                    offset--;
                }
                min = Math.min(min, right - offset + 1);
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

}
