package lxl.DEC;

/**
 * @program: leetcode-hz
 * @description: 74. 搜索二维矩阵
 * @author: lxl
 * @create: 2019-12-17 15:40
 **/
public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m <= 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n <= 0) {
            return false;
        }
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }
        int left = 0;
        int right = m - 1;
        int half = 0;
        while (left <= right) {
            half = left + right >> 1;
            if (matrix[half][0] > target) {
                right = half - 1;
            } else if (matrix[half][0] < target) {
                if (matrix[half][n - 1] >= target) {
                    break;
                } else {
                    left = half + 1;
                }
            } else {
                return true;
            }
        }
        System.out.println(half);
        left = 1;
        right = n - 1;
        int line = half;
        while (left <= right) {
            half = left + right >> 1;
            if (matrix[line][half] > target) {
                right = half - 1;
            } else if (matrix[line][half] < target) {
                left = half + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 6}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();
        System.out.println(searchA2DMatrix.searchMatrix(matrix, 13));
    }
}
