package lxl.y2020.DEC;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 面试题 01.07. 旋转矩阵
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * <p>
 * 不占用额外内存空间能否做到？
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * <p>
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-matrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-12-18 10:11
 **/
public class RotateMatrixLcci {
    ////顺时针旋转
    //private int[][] help = { };

    public void rotate(int[][] matrix) {
        //从外往里 从左往右 循环
        int m = matrix.length;
        if (m <= 1) {
            return;
        }
        for (int i = 0; i < m / 2; i++) {
            for (int j = i; j < m - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m - j - 1][i];
                matrix[m - j - 1][i] = matrix[m - i - 1][m - j - 1];
                matrix[m - i - 1][m - j - 1] = matrix[j][m - i - 1];
                matrix[j][m - i - 1] = temp;
                ////四方向互换
                ////上
                //matrix[i][j]；
                ////右
                //matrix[j][m-i-1]；
                ////下
                //matrix[m-i-1][m-j-1]；
                ////左
                //matrix[m-j-1][i]；
                //System.out.println(matrix[i][j]);
                //System.out.println(matrix[j][m-i-1]);
                //System.out.println( matrix[m-i-1][m-j-1]);
                //System.out.println(matrix[m-j-1][i]);
                //System.out.println("--------------------");
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        RotateMatrixLcci ro = new RotateMatrixLcci();
        ro.rotate(arr);
        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
