package lxl.DEC;

import lxl.util.JSONUtil;

/**
 * @program: leetcode-hz
 * @description: 130. 被围绕的区域
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * <p>
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 示例:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * <p>
 * 运行你的函数后，矩阵变为：
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * <p>
 * 解释:
 * <p>
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-30 17:39
 **/
public class SurroundedRegions {
    private int m = 0;
    private int n = 0;

    public void solve(char[][] board) {
        //把边界相连的都置成‘0’;
        m = board.length;
        if (m == 0) {
            return;
        }
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (i == 0 || i == m - 1) {
                for (int j = 0; j < n; j++) {
                    this.clearBoard(board, i, j);
                }
            } else {
                this.clearBoard(board, i, 0);
                this.clearBoard(board, i, n - 1);

            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '0') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void clearBoard(char[][] board, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = '0';
            this.clearBoard(board, i - 1, j);
            this.clearBoard(board, i + 1, j);
            this.clearBoard(board, i, j - 1);
            this.clearBoard(board, i, j + 1);
        }
    }

    public static void main(String[] args) {
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        char[][] chars = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        surroundedRegions.solve(chars);
        for (char[] chars1 : chars) {
            System.out.println(JSONUtil.toJson(chars1));
        }
    }
}
