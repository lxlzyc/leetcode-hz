package lxl.y2021.MAR;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 1572. 矩阵对角线元素的和
 * 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
 * <p>
 * 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
 * <p>
 * <p>
 * <p>
 * 示例  1：
 * <p>
 * 输入：mat = [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * 输出：25
 * 解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
 * 请注意，元素 mat[1][1] = 5 只会被计算一次。
 * <p>
 * 示例  2：
 * <p>
 * 输入：mat = [[1,1,1,1],
 * [1,1,1,1],
 * [1,1,1,1],
 * [1,1,1,1]]
 * 输出：8
 * <p>
 * 示例 3：
 * <p>
 * 输入：mat = [[5]]
 * 输出：5
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == mat.length == mat[i].length
 * 1 <= n <= 100
 * 1 <= mat[i][j] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/matrix-diagonal-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/26 13:46
 * @Version 1.0
 */
public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || m - i + 1 == j) {
                    ans += mat[i][j];
                }
            }
        }
        return ans;
    }
}