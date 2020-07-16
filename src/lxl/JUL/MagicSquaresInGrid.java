package lxl.JUL;

/**
 * @program: leetcode-hz
 * @description: 840. 矩阵中的幻方
 * 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
 * <p>
 * 给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入: [[4,3,8,4],
 * [9,5,1,9],
 * [2,7,6,2]]
 * 输出: 1
 * 解释:
 * 下面的子矩阵是一个 3 x 3 的幻方：
 * 438
 * 951
 * 276
 * <p>
 * 而这一个不是：
 * 384
 * 519
 * 762
 * <p>
 * 总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
 * <p>
 * 提示:
 * <p>
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * 0 <= grid[i][j] <= 15
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/magic-squares-in-grid
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-16 11:17
 **/
public class MagicSquaresInGrid {

    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        if (m < 3) {
            return 0;
        }
        int count = 0;
        int n = grid[0].length;
        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                if (grid[i][j] != 5 && this.isMagic(grid, i, j)) {
                    count++;
                    j++;
                }
            }
        }
        return count;
    }

    public boolean isMagic(int[][] grid, int top, int left) {
        if (grid[top + 1][left + 1] != 5) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            int sum1 = 0;
            int sum2 = 0;
            for (int j = 0; j < 3; j++) {
                if (grid[i + top][j + left] < 1 || grid[i + top][j + left] > 9) {
                    return false;
                }
                sum1 += grid[i + top][j + left];
                sum2 += grid[j + top][i + left];
            }
            if (sum1 != 15 || sum2 != 15) {
                return false;
            }
        }
        if (grid[top][left] + grid[top + 2][left + 2] != 10) {
            return false;
        }
        if (grid[top + 2][left] + grid[top][left + 2] != 10) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {3, 2, 9, 2, 7},
                {6, 1, 8, 4, 2},
                {7, 5, 3, 2, 7},
                {2, 9, 4, 9, 6},
                {4, 3, 8, 2, 5},
        };

        MagicSquaresInGrid magicSquaresInGrid = new MagicSquaresInGrid();
        System.out.println(magicSquaresInGrid.numMagicSquaresInside(grid));
        //System.out.println(magicSquaresInGrid.isMagic(grid,1,0));

    }
}
