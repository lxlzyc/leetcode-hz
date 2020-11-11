package lxl.y2020.JUL;

/**
 * @program: leetcode-hz
 * @description: 329. 矩阵中的最长递增路径
 * 给定一个整数矩阵，找出最长递增路径的长度。
 * <p>
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums =
 * [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums =
 * [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-27 10:36
 **/
public class LongestIncreasingPathInAMatrix {

    private int maxLength = 0;
    //上下左右
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLength = Math.max(this.buildPath(matrix, paths, m, n, i, j), maxLength);
            }
        }
        return maxLength;
    }

    private int buildPath(int[][] matrix, int[][] paths, int m, int n, int i, int j) {
        if (paths[i][j] != 0) {
            return paths[i][j];
        }
        int base = matrix[i][j];
        int nextI;
        int nextJ;
        int nextMax = 0;
        for (int k = 0; k < 4; k++) {
            nextI = i + directions[k][0];
            nextJ = j + directions[k][1];
            if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n) {
                if (base < matrix[nextI][nextJ]) {
                    nextMax = Math.max(this.buildPath(matrix, paths, m, n, nextI, nextJ), nextMax);
                }
            }
        }
        paths[i][j] = nextMax + 1;
        return paths[i][j];
    }

    public static void main(String[] args) {
        LongestIncreasingPathInAMatrix longestIncreasingPathInAMatrix = new LongestIncreasingPathInAMatrix();
        int[][] matrix = {
                {3, 5, 3, 2}
        };
        System.out.println(longestIncreasingPathInAMatrix.longestIncreasingPath(matrix));
    }
}
