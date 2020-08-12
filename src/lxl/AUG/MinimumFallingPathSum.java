package lxl.AUG;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 931. 下降路径最小和
 * 给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。
 * <p>
 * 下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：12
 * 解释：
 * 可能的下降路径有：
 * <p>
 * [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
 * [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
 * [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
 * <p>
 * 和最小的下降路径是 [1,4,7]，所以答案是 12。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length == A[0].length <= 100
 * -100 <= A[i][j] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-falling-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-12 14:52
 **/
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        int l = A.length;
        for (int i = 1; i < l; i++) {
            for (int j = 0; j < l; j++) {
                int min = this.getMinParent(A[i - 1], j, l);
                A[i][j] = A[i][j] + min;
            }
        }
        return Arrays.stream(A[l - 1]).min().getAsInt();
    }

    private int getMinParent(int[] dp, int j, int l) {
        int min = dp[j];
        if (j - 1 >= 0) {
            min = Math.min(min, dp[j - 1]);
        }
        if (j + 1 < l) {
            min = Math.min(min, dp[j + 1]);
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3}, {4, 0, 6}, {7, 8, 9}
        };
        MinimumFallingPathSum min = new MinimumFallingPathSum();
        System.out.println(min.minFallingPathSum(A));
    }

}
