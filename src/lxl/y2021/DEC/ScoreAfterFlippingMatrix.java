package lxl.y2021.DEC;

/**
 * @program: leetcode-hz
 * @description: 861. 翻转矩阵后的得分
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * <p>
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * <p>
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * <p>
 * 返回尽可能高的分数。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[[0,0,1,1],
 * [1,0,1,0],
 * [1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b11 + 0b1001 + 0b11 = 15 + 9 + 15 = 39
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] 是 0 或 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-after-flipping-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-12-07 09:37
 **/
public class ScoreAfterFlippingMatrix {

    //先横竖变换保证第一列全部是1
    //竖变换保证其他列1比0多
    public int matrixScore(int[][] A) {
        //处理第一列
        int m = A.length;
        int n = A[0].length;
        //先横竖变换保证第一列全部是1
        //第一列全为1的分数为 m* 2^n-1
        int ans = m * (1 << (n - 1));
        //竖变换保证其他列1比0多
        //每一列为1的分数为 k* 2^n-i-1
        for (int i = 1; i < n; i++) {
            int oneCount = 0;
            for (int j = 0; j < m; j++) {
                if (A[j][0] == 1) {
                    //第一位没有翻转
                    oneCount += A[j][i];
                } else {
                    //第一位翻转，取反
                    oneCount += (1 - A[j][i]);
                }
            }
            ans += Math.max(oneCount, m - oneCount) * (1 << (n - i - 1));
        }
        return ans;
    }
}
