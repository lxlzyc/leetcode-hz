package lxl.y2020.AUG;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description: 994. 腐烂的橘子
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * <p>
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * <p>
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * <p>
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * <p>
 * 示例 2：
 * <p>
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * <p>
 * 示例 3：
 * <p>
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] 仅为 0、1 或 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotting-oranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-19 16:17
 **/
public class RottingOranges {
    //上下左右
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Stack<int[]> badOranges = new Stack<>();
        int goodCount = 0;
        int time = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    badOranges.push(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    goodCount++;
                }

            }
        }
        if (goodCount == 0) {
            return 0;
        }
        while (!badOranges.isEmpty() && goodCount > 0) {
            time++;
            ArrayList<int[]> next = new ArrayList<>();
            while (!badOranges.isEmpty()) {
                int[] item = badOranges.pop();
                for (int k = 0; k < 4; k++) {
                    int nextI = item[0] + directions[k][0];
                    int nextJ = item[1] + directions[k][1];
                    if (nextI >= 0 && nextJ >= 0 && nextI < m && nextJ < n) {
                        if (grid[nextI][nextJ] == 1) {
                            grid[nextI][nextJ] = 2;
                            next.add(new int[]{nextI, nextJ});
                            goodCount--;
                        }
                    }
                }
            }
            badOranges.addAll(next);
        }
        return goodCount > 0 ? -1 : time;
    }

    public static void main(String[] args) {
        RottingOranges rottingOranges = new RottingOranges();
        int[][] oranges = {
                {2, 1, 1}, {1, 1, 0}, {0, 1, 1}
        };
        System.out.println(rottingOranges.orangesRotting(oranges));
    }

}
