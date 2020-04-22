package lxl.APR;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 566. 重塑矩阵
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 * <p>
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 * <p>
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 * <p>
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 1, c = 4
 * 输出:
 * [[1,2,3,4]]
 * 解释:
 * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 2, c = 4
 * 输出:
 * [[1,2],
 * [3,4]]
 * 解释:
 * 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
 * <p>
 * 注意：
 * <p>
 * 给定矩阵的宽和高范围在 [1, 100]。
 * 给定的 r 和 c 都是正数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reshape-the-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-22 09:35
 **/
public class ReshapeTheMatrix {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        if (m == 0) {
            return nums;
        }
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }
        int[][] re = new int[r][c];
        int reI = 0;
        int reJ = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (reJ == c) {
                    reJ = 0;
                    reI++;
                }
                re[reI][reJ] = nums[i][j];
                reJ++;
            }
        }
        return re;
    }

    public static void main(String[] args) {
        ReshapeTheMatrix reshapeTheMatrix = new ReshapeTheMatrix();
        int[][] nums = {{1, 2, 3, 4}};
        int[][] re = reshapeTheMatrix.matrixReshape(nums, 2, 2);
        for (int[] index : re) {
            System.out.println(Arrays.toString(index));
        }
    }
}
