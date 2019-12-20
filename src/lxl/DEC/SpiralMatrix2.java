package lxl.DEC;

import lxl.util.JSONUtil;

/**
 * @program: leetcode-hz
 * @description: 59. 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-16 16:37
 **/
public class SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        int[][] re = new int[n][n];


        int top = 0;
        int right = n;
        int bottom = n;
        int left = 0;
        // 1 往右 2 往下 3往左 4 往上
        int status = 1;
        int beginI = 0;
        int beginJ = -1;
        int maxCount = n*n;
        for (int i = 1; i <= maxCount; i++) {
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
            re[beginI][beginJ] = i;
        }

        return re;
    }


    public static void main(String[] args) {
        SpiralMatrix2 spiralMatrix = new SpiralMatrix2();
        System.out.println(JSONUtil.toJson(spiralMatrix.generateMatrix(4)));
    }

}
