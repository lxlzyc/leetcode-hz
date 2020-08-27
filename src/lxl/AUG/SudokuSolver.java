package lxl.AUG;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 37. 解数独
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * 空白格用 '.' 表示。
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-06 10:17
 **/
public class SudokuSolver {

    private int[][] transverse;
    private int[][] vertical;
    private int[][] box;

    public void solveSudoku(char[][] board) {
        transverse = new int[9][9];
        vertical = new int[9][9];
        box = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int value = board[i][j] - '1';
                    transverse[i][value]++;
                    vertical[j][value]++;
                    box[(i / 3) * 3 + j / 3][value]++;

                }
            }
        }
        this.buildBoard(board, 0, 0);
    }

    private boolean buildBoard(char[][] board, int i, int j) {
        if (i == 9) {
            return true;
        }
        int nexti = i;
        int nextj = j + 1;
        if (nextj == 9) {
            nextj = 0;
            nexti++;
        }
        if (board[i][j] == '.') {
            for (int k = 0; k < 9; k++) {
                if (transverse[i][k] == 0 && vertical[j][k] == 0 && box[(i / 3) * 3 + j / 3][k] == 0) {
                    transverse[i][k]++;
                    vertical[j][k]++;
                    box[(i / 3) * 3 + j / 3][k]++;
                    board[i][j] = (char) ('1' + k);
                    if (buildBoard(board, nexti, nextj)) {
                        return true;
                    }
                    transverse[i][k]--;
                    vertical[j][k]--;
                    box[(i / 3) * 3 + j / 3][k]--;
                    board[i][j] = '.';
                }
            }
        } else {
            return this.buildBoard(board, nexti, nextj);
        }
        return false;
    }

    public static void main(String[] args) {

        SudokuSolver sudokuSolver = new SudokuSolver();


        char[][] borad2 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };


        sudokuSolver.solveSudoku(borad2);
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(borad2[i]));

        }

        System.out.println(borad2);
    }


}
