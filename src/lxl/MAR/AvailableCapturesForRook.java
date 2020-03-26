package lxl.MAR;

/**
 * @program: leetcode-hz
 * @description: 999. 车的可用捕获量
 * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。
 * 它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 * <p>
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），
 * 然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。
 * 另外，车不能与其他友方（白色）象进入同一个方格。
 * <p>
 * 返回车能够在一次移动中捕获到的卒的数量。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * 输出：3
 * 解释：
 * 在本例中，车能够捕获所有的卒。
 * <p>
 * <p>
 * 提示：
 * <p>
 * board.length == board[i].length == 8
 * board[i][j] 可以是 'R'，'.'，'B' 或 'p'
 * 只有一个格子上存在 board[i][j] == 'R'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/available-captures-for-rook
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-03-26 14:52
 **/
public class AvailableCapturesForRook {

    public int numRookCaptures(char[][] board) {
        int i = -1;
        int j = -1;
        for (int k = 0; k < 8; k++) {
            for (int l = 0; l < 8; l++) {
                if (board[k][l] == 'R') {
                    i = k;
                    j = l;
                }
            }
        }
        return this.checkBoard(board, i, j);
    }

    private int checkBoard(char[][] board, int i, int j) {
        int count = 0;
        if (i >= 0 && j >= 0) {
            int m = i - 1;
            char index;
            while (m >= 0) {
                index = board[m][j];
                if (index == 'p') {
                    count++;
                    break;
                } else if (index == 'B') {
                    break;
                }
                m--;
            }
            m = i + 1;
            while (m < 8) {
                index = board[m][j];
                if (index == 'p') {
                    count++;
                    break;
                } else if (index == 'B') {
                    break;
                }
                m++;
            }
            m = j - 1;
            while (m >= 0) {
                index = board[i][m];
                if (index == 'p') {
                    count++;
                    break;
                } else if (index == 'B') {
                    break;
                }
                m--;
            }
            m = j + 1;
            while (m < 8) {
                index = board[i][m];
                if (index == 'p') {
                    count++;
                    break;
                } else if (index == 'B') {
                    break;
                }
                m++;
            }
        }
        return count;
    }
}
