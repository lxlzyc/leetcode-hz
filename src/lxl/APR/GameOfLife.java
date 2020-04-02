package lxl.APR;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 289. 生命游戏
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 * <p>
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：
 * 1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * <p>
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * <p>
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * [
 * [0,1,0],
 * [0,0,1],
 * [1,1,1],
 * [0,0,0]
 * ]
 * 输出：
 * [
 * [0,0,0],
 * [1,0,1],
 * [0,1,1],
 * [0,1,0]
 * ]
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
 * 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
 * @author: lxl
 * @create: 2020-04-02 09:52
 **/
public class GameOfLife {

    //定义 初始状态 0 1 ，
    // 当前状态0，下一次状态1 为-1，
    // 当前状态1，下一次状态0为2。
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //*     如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
                //*     如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
                //*     如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
                //*     如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
                int liveCount = this.getBoardLiveCount(board, i, j, m, n);
                if (board[i][j] > 0) {
                    if (liveCount < 2 || liveCount > 3) {
                        board[i][j] = 2;
                    }
                } else {
                    if (liveCount == 3) {
                        board[i][j] = -1;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 1;
                } else if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
            }
        }

    }

    private int getBoardLiveCount(int[][] board, int i, int j, int m, int n) {
        int count = 0;
        //八个位置
        //左右
        if (i - 1 >= 0) {
            count += this.checkIsLive(board[i - 1][j]);
            if (j - 1 >= 0) {
                count += this.checkIsLive(board[i - 1][j - 1]);

            }
            if (j + 1 < n) {
                count += this.checkIsLive(board[i - 1][j + 1]);
            }
        }
        if (i + 1 < m) {
            count += this.checkIsLive(board[i + 1][j]);
            if (j - 1 >= 0) {
                count += this.checkIsLive(board[i + 1][j - 1]);

            }
            if (j + 1 < n) {
                count += this.checkIsLive(board[i + 1][j + 1]);

            }
        }
        if (j - 1 >= 0) {
            count += this.checkIsLive(board[i][j - 1]);

        }
        if (j + 1 < n) {
            count += this.checkIsLive(board[i][j + 1]);
        }
        return count;
    }

    private int checkIsLive(int i) {
        return i > 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife();
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0},
        };
        gameOfLife.gameOfLife(board);
        for (int[] index : board) {
            System.out.println(Arrays.toString(index));
        }
    }
}
