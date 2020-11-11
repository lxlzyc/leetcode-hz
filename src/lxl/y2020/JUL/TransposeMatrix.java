package lxl.y2020.JUL;

/**
 * @program: leetcode-hz
 * @description: 867. 转置矩阵
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 * <p>
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：[[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 1000
 * 1 <= A[0].length <= 1000
 * @author: lxl
 * @create: 2020-07-27 15:23
 **/
public class TransposeMatrix {

    public int[][] transpose(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][i] = A[i][j];
            }
        }
        return ans;
    }

}
