package lxl.y2020.JAN;

/**
 * @program: leetcode-hz
 * @description: 200. 岛屿数量
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出: 1
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * 输出: 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-09 14:06
 **/
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m <= 0) {
            return 0;
        }
        int n = grid[0].length;
        int count = 0;
        for (int i = 0, l = grid.length; i < l; i++) {
            char[] gridIndex = grid[i];
            for (int j = 0, k = gridIndex.length; j < k; j++) {
                if (gridIndex[j] == '1') {
                    count++;
                    this.removeLand(grid, i, j, m, n);
                }
            }
        }
        return count;
    }

    private void removeLand(char[][] grid, int i, int j, int m, int n) {
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            // 上
            if (i - 1 >= 0) {
                this.removeLand(grid, i - 1, j, m, n);
            }
            // 下
            if (i + 1 < m) {
                this.removeLand(grid, i + 1, j, m, n);
            }
            // 左
            if (j - 1 >= 0) {
                this.removeLand(grid, i, j - 1, m, n);
            }
            // 右
            if (j + 1 < n) {
                this.removeLand(grid, i, j + 1, m, n);
            }
        }
    }

    public static void main(String[] args) {
        char[][] chars = {
                {'1', '1', '0', '1'},
                {'1', '0', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '0', '1', '1'}
        };
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.numIslands(chars));
    }

}
