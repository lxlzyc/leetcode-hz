package lxl.y2019.DEC;

/**
 * @program: leetcode-hz
 * @description: 221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]]
 * 输出：4
 * <p>
 * 示例 2：
 * <p>
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 * <p>
 * 示例 3：
 * <p>
 * 输入：matrix = [["0"]]
 * 输出：0
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] 为 '0' 或 '1'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-12-15 13:44
 **/
public class MaximalSquare {
    //我们用 dp(i,j)  表示以 (i,j) 为右下角的最大面积 且只包含 1  的正方形的边长!!最大值
    //正方形！！！！
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0] - '0';
        int maxside = 0;
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
            maxside = Math.max(dp[i][0], maxside);
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = matrix[0][i] - '0';
            maxside = Math.max(dp[0][i], maxside);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    int min = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]);
                    dp[i][j] = min + 1;
                    maxside = Math.max(dp[i][j], maxside);
                }
            }
        }
        return maxside;
    }

    public static void main(String[] args) {

    }
}
