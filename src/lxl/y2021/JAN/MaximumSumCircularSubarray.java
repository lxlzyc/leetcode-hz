package lxl.y2021.JAN;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 918. 环形子数组的最大和
 * 给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。
 * <p>
 * 在此处，环形数组意味着数组的末端将会与开头相连呈环状。（形式上，当0 <= i < A.length 时 C[i] = A[i]，且当 i >= 0 时 C[i+A.length] = C[i]）
 * <p>
 * 此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。（形式上，对于子数组 C[i], C[i+1], ..., C[j]，不存在 i <= k1, k2 <= j 其中 k1 % A.length = k2 % A.length）
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,-2,3,-2]
 * 输出：3
 * 解释：从子数组 [3] 得到最大和 3
 * <p>
 * 示例 2：
 * <p>
 * 输入：[5,-3,5]
 * 输出：10
 * 解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
 * <p>
 * 示例 3：
 * <p>
 * 输入：[3,-1,2,-1]
 * 输出：4
 * 解释：从子数组 [2,-1,3] 得到最大和 2 + (-1) + 3 = 4
 * <p>
 * 示例 4：
 * <p>
 * 输入：[3,-2,2,-3]
 * 输出：3
 * 解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
 * <p>
 * 示例 5：
 * <p>
 * 输入：[-2,-3,-1]
 * 输出：-1
 * 解释：从子数组 [-1] 得到最大和 -1
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * -30000 <= A[i] <= 30000
 * 1 <= A.length <= 30000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-sum-circular-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/1/21 9:58
 * @Version 1.0
 */
public class MaximumSumCircularSubarray {
    //    Kadane 算法。在这个章节，我们解释算法背后的核心逻辑。
//
//    对于一个给定数组 A，Kadane 算法可以用来找到 A 的最大子段和。这里，我们只考虑非空子段。
//
//    Kadane 算法基于动态规划。令 dp[j] 为以 A[j] 结尾的最大子段和。也就是，
//
//     dp[j]=imax​(A[i]+A[i+1]+⋯+A[j])
//
//    那么，以 j+1 j结尾的子段（例如 A[i], A[i+1] + ... + A[j+1]）最大化了 A[i] + ... + A[j] 的和，当这个子段非空那么就等于 dp[j] 否则就等于 0。所以，有以下递推式：
//
//    dp[j+1]=A[j+1]+max(dp[j],0)
    public int maxSubarraySumCircular(int[] A) {
        int len = A.length;

        int[] dp = new int[len * 2];
        dp[0] = A[0];
        int max = A[0];
        int sum = A[0];
        //最大值max在原数组中。
        for (int i = 1; i < len; i++) {
            dp[i] = A[i] + Math.max(dp[i - 1], 0);
            max = Math.max(dp[i], max);
            sum += A[i];
        }
        //最大值max在环形数组中。
        //作为环，如果连续子串和最小，则其余子串和最大
        //改为求连续子串的最小值
        int min = 0;
        dp[0] = A[0];
        for (int i = 1; i < A.length - 1; i++) {
            dp[i] = A[i] + Math.min(dp[i - 1], 0);
            min = Math.min(dp[i], min);
        }
        return Math.max(max, sum - min);
    }

    public static void main(String[] args) {
        MaximumSumCircularSubarray maximumSumCircularSubarray = new MaximumSumCircularSubarray();
//        int[] a = {1,-1,2,3,1,-1,2,-2,3};
//        int[] b = {5,-3,5};
//        int[] c = {3,-1,2,-1};
//        int[] d = {3,-2,2,-3};
//        int[] e = {3,-1,2,-1};
        int[] f = {-2, 1, 1, -1};

//        System.out.println(maximumSumCircularSubarray.maxSubarraySumCircular(a));
//        System.out.println(maximumSumCircularSubarray.maxSubarraySumCircular(b));
//        System.out.println(maximumSumCircularSubarray.maxSubarraySumCircular(c));
//        System.out.println(maximumSumCircularSubarray.maxSubarraySumCircular(d));
//        System.out.println(maximumSumCircularSubarray.maxSubarraySumCircular(e));
        System.out.println(maximumSumCircularSubarray.maxSubarraySumCircular(f));

    }

}