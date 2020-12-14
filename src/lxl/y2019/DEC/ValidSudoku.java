package lxl.y2019.DEC;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode-hz
 * @description: 36.有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * 上图是一个部分填充的有效的数独。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-06 09:34
 **/
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        //三种检测
        Set<Character> help = new HashSet<>(16);
        Set<Character> help2 = new HashSet<>(16);

        //行 //竖
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!help.contains(board[i][j]) || board[i][j] == '.') {
                    help.add(board[i][j]);
                } else {
                    return false;
                }
                if (!help2.contains(board[j][i]) || board[j][i] == '.') {
                    help2.add(board[j][i]);
                } else {
                    return false;
                }
            }
            help.clear();
            help2.clear();
        }
        //3*3区域
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (!help.contains(board[i + k][j + l]) || board[i + k][j + l] == '.') {
                            help.add(board[i + k][j + l]);
                        } else {
                            return false;
                        }
                    }
                }
                help.clear();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] borad = {
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
        char[][] borad2 = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}

        };
        ValidSudoku validSudoku = new ValidSudoku();
        System.out.println(validSudoku.isValidSudoku(borad));
        System.out.println(validSudoku.isValidSudoku(borad2));

    }

}
