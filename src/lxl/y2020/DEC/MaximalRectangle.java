package lxl.y2020.DEC;

/**
 * @program: leetcode-hz
 * @description: 85. 最大矩形
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-23 10:47
 **/
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int offsetM;
        int offsetN;
        int endM;
        int endN;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                offsetM = i;
                offsetN = j;
                if (matrix[offsetM][offsetN] == '1') {
                    endM = offsetM;
                    endN = offsetN;
                    //往三个方向延伸
                    //右
                    while (endM + 1 < m) {
                        if (matrix[endM + 1][offsetN] != '1') {
                            //endM--;
                            break;
                        } else {
                            endM++;
                        }
                    }
                    max = Math.max(endM - offsetM + 1, max);
                    //下
                    while (endN + 1 < n) {
                        if (matrix[offsetM][endN + 1] != '1') {
                            //endN--;
                            break;
                        } else {
                            endN++;
                        }
                    }
                    max = Math.max(endN - offsetN + 1, max);
                    //斜矩形
                    if (endM > offsetM && endN > offsetN) {
                        for (int k = offsetM + 1; k <= endM; k++) {
                            for (int l = offsetN + 1; l <= endN; l++) {
                                if (matrix[k][l] != '1') {
                                    endN = l - 1;
                                    break;
                                } else {
                                    max = Math.max((k - offsetM + 1) * (l - offsetN + 1), max);
                                }
                            }
                        }
                    }
                } else if ((m - i) * (n - j) < max) {
                    //跳出去
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

        //[["1","0","1","1","1"],["0","1","0","1","0"],["1","1","0","1","1"],["1","1","0","1","1"],["0","1","1","1","1"]]

        char[][] nums = {{'1', '0', '1', '1', '1'},
                {'0', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '1'},
                {'1', '1', '0', '1', '1'},
                {'0', '1', '1', '1', '1'}};
        //char[][] nums = {
        //                {'1','1','1','1','1','1','1','1'},
        //                {'1','1','1','1','1','1','1','0'},
        //                {'1','1','1','1','1','1','1','0'},
        //                {'1','1','1','1','1','0','0','0'},
        //                {'0','1','1','1','1','0','0','0'}
        //};
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        System.out.println(maximalRectangle.maximalRectangle(nums));
    }
}
