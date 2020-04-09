package lxl.APR;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 498. 对角线遍历
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * <p>
 * 输出:  [1,2,4,7,5,3,6,8,9]
 * <p>
 * 解释:
 * <p>
 * <p>
 * <p>
 * 说明:
 * <p>
 * 给定矩阵中的元素总数不会超过 100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diagonal-traverse
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-09 10:52
 **/
public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new int[0];
        }
        if (m == 1) {
            return matrix[0];
        }
        //两个方向
        int top = 1;
        int n = matrix[0].length;
        int[] re = new int[m * n];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < m && j < n) {
            //System.out.println(i+"-"+j);
            re[index] = matrix[i][j];
            index++;
            if (top == 1) {
                //向上
                //如果右上没有 尝试右侧
                //右侧也没有 尝试下
                if (i > 0 && j < n - 1) {
                    i--;
                    j++;
                } else if (j < n - 1) {
                    j++;
                    top = 0;
                } else {
                    i++;
                    top = 0;
                }

            } else {
                //向下
                //如果左下没有 尝试下侧
                //下侧也没有 尝试右侧
                if (i < m - 1 && j > 0) {
                    i++;
                    j--;
                } else if (i < m - 1) {
                    i++;
                    top = 1;
                } else {
                    j++;
                    top = 1;
                }

            }
        }
        return re;

    }

    public static void main(String[] args) {
        int[][] m = {
                {1, 12, 13}
        };

        DiagonalTraverse diagonalTraverse = new DiagonalTraverse();
        System.out.println(Arrays.toString(diagonalTraverse.findDiagonalOrder(m)));
    }
}
