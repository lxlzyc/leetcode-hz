package lxl.y2019.DEC;

import lxl.util.JSONUtil;

/**
 * @program: leetcode-hz
 * @description: 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出:
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * @author: lxl
 * @create: 2019-12-17 15:12
 **/
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;
        int[] zeroLine = new int[m];
        for (int i = 0; i < n; i++) {
            boolean hasZero = false;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    //记录竖0标志
                    zeroLine[j] = 1;
                    hasZero = true;
                }
            }
            if (hasZero) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (zeroLine[i] == 1) {
                for (int j = 0; j < n; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[][] nums = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        setMatrixZeroes.setZeroes(nums);
        for (int[] index : nums) {
            System.out.println(JSONUtil.toJson(index));
        }
    }


}
