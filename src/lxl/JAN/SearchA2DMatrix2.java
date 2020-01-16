package lxl.JAN;

/**
 * @program: leetcode-hz
 * @description: 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://dev.lingkou.xyz/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-17 15:40
 **/
public class SearchA2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //从左下角开始剪枝
        int m = matrix.length - 1;
        if (m < 0) {
            return false;
        }
        int n = matrix[0].length;
        int left = 0;
        while (m >= 0 && left < n) {
            if (matrix[m][left] > target) {
                m--;
            } else if (matrix[m][left] < target) {
                left++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 6}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        SearchA2DMatrix2 searchA2DMatrix = new SearchA2DMatrix2();
        System.out.println(searchA2DMatrix.searchMatrix(matrix, 13));
    }
}
