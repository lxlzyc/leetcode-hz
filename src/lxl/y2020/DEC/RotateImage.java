package lxl.y2020.DEC;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 48. 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-11 17:59
 **/
public class RotateImage {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        if(length<=1){
            return;
        }
        int help;
        int begin;
        int end;
        int lineLength;
        //从外到里旋转需旋转的次数
        for (int i = 0,l=length/2; i < l; i++) {
            //找到初始旋转位置和旋转数
            begin = i;
            lineLength = length-i-i;
            end = begin+lineLength-1;
            for (int j = 0; j < lineLength-1; j++) {
                help = matrix[begin][begin+j];
                matrix[begin][begin+j] = matrix[end-j][begin];
                matrix[end-j][begin] = matrix[end][end-j];
                matrix[end][end-j] =  matrix[begin+j][end];
                matrix[begin+j][end] = help;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 5, 1, 9,11},
                { 2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

}
