package lxl.y2020.MAR;

/**
 * @program: leetcode-hz
 * @description: 419. 甲板上的战舰
 * 给定一个二维的甲板， 请计算其中有多少艘战舰。 战舰用 'X'表示，空位用 '.'表示。 你需要遵守以下规则：
 * <p>
 * 给你一个有效的甲板，仅由战舰或者空位组成。
 * 战舰只能水平或者垂直放置。换句话说,战舰只能由 1xN (1 行, N 列)组成，或者 Nx1 (N 行, 1 列)组成，其中N可以是任意大小。
 * 两艘战舰之间至少有一个水平或垂直的空位分隔 - 即没有相邻的战舰。
 * <p>
 * 示例 :
 * <p>
 * X..X
 * ...X
 * ...X
 * <p>
 * 在上面的甲板中有2艘战舰。
 * <p>
 * 无效样例 :
 * <p>
 * ...X
 * XXXX
 * ...X
 * <p>
 * 你不会收到这样的无效甲板 - 因为战舰之间至少会有一个空位将它们分开。
 * <p>
 * 进阶:
 * <p>
 * 你可以用一次扫描算法，只使用O(1)额外空间，并且不修改甲板的值来解决这个问题吗？
 * @author: lxl
 * @create: 2020-03-23 10:18
 **/
public class BattleshipsInABoard {

    public int countBattleships(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return 0;
        }
        int n = board[0].length;
        int[] counts = new int[n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    counts[j] = 1;
                } else {
                    if (counts[j] == 1) {
                        counts[j] = 0;
                        count += 1;
                    }
                }
            }

            count += this.getCountAndClear(counts);
        }
        count += getCountAndClearWithSingle(counts);
        return count;

    }

    private int getCountAndClear(int[] counts) {
        int l = counts.length;
        int i = 0;
        int re = 0;
        while (i < l - 1) {
            if (counts[i] == 1 && counts[i + 1] == 1) {
                re += 1;
                counts[i] = 0;
                counts[i + 1] = 0;
                i = i + 2;
                while (i < l) {
                    if (counts[i] == 1) {
                        counts[i] = 0;
                        i++;
                    } else {
                        break;
                    }
                }
            }

            i++;
        }
        return re;
    }

    private int getCountAndClearWithSingle(int[] counts) {
        int l = counts.length;
        int i = 0;
        int re = 0;
        while (i < l) {
            if (counts[i] == 1) {
                re += 1;
                counts[i] = 0;
                i = i + 1;
                while (i < l) {
                    if (counts[i] == 1) {
                        counts[i] = 0;
                        i++;
                    } else {
                        break;
                    }
                }
            }

            i++;
        }
        return re;
    }

    public static void main(String[] args) {
        BattleshipsInABoard battleshipsInABoard = new BattleshipsInABoard();
        char[][] board = {
                {'X', '.', 'X', 'X'},
                {'.', 'X', '.', '.'},
                {'.', 'X', '.', 'X'},
                {'.', '.', '.', '.'},
                {'X', '.', 'X', 'X'},};
        System.out.println(battleshipsInABoard.countBattleships(board));
    }

}
