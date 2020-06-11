package lxl.JUN;

/**
 * @program: leetcode-hz
 * @description: 718. 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 * <p>
 * 说明:
 * <p>
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-10 14:24
 **/
public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        int max = 0;
        int[][] help = new int[A.length + 1][B.length + 1];
        for (int i = A.length - 1; i >= 0; --i) {
            for (int j = B.length - 1; j >= 0; --j) {
                if (A[i] == B[j]) {
                    help[i][j] = help[i + 1][j + 1] + 1;
                    max = Math.max(max, help[i][j]);
                }
            }
        }
        return max;
    }

    //public int findLength(int[] A, int[] B) {
    //    int ans = 0;
    //    int[][] memo = new int[A.length + 1][B.length + 1];
    //    for (int i = A.length - 1; i >= 0; --i) {
    //        for (int j = B.length - 1; j >= 0; --j) {
    //            if (A[i] == B[j]) {
    //                memo[i][j] = memo[i + 1][j + 1] + 1;
    //                if (ans < memo[i][j]) {
    //                    ans = memo[i][j];
    //                }
    //            }
    //        }
    //    }
    //    return ans;
    //}

}
