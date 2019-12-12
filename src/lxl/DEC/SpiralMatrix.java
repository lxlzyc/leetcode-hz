package lxl.DEC;

import lxl.util.JSONUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 54. 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 *
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-12 17:23
 **/
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> integers = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0){
            return integers;
        }
        int top = 0;
        int right = matrix[0].length;
        int bottom = matrix.length;
        int left = 0;
        // 1 往右 2 往下 3往左 4 往上
        int status = 1;
        int beginI = 0;
        int beginJ = -1;
        int count = 0;
        int maxCount = right*bottom;
        while (count<maxCount){
            boolean hasNext = true;
            while (true){
                if(status%4 == 1){
                    if(beginJ+1<right){
                        beginJ ++;
                        break;
                    }else{
                        status ++;
                        top++;
                    }
                }
                if(status%4==2){
                    if(beginI+1<bottom){
                        beginI++;
                        break;
                    }else{
                        status ++;
                        right --;
                    }
                }
                if(status%4==3){
                    if(beginJ-1>=left){
                        beginJ --;
                        break;
                    }else{
                        status ++;
                        bottom --;
                    }
                }
                if(status%4==0){
                    if(beginI-1>=top){
                        beginI --;
                        break;
                    }else{
                        status ++;
                        left ++;
                    }
                }
                if(status%4 == 1){
                    if(beginJ+1<right){
                        beginJ ++;
                        break;
                    }else{
                        hasNext = false;
                        break;
                    }
                }
            }
            if(!hasNext){
                break;
            }
            count++;
            integers.add(matrix[beginI][beginJ]);

        }

        return integers;

    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 5, 1, 9,11},
                { 2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        System.out.println(JSONUtil.toJson(spiralMatrix.spiralOrder(matrix)));
    }

}
