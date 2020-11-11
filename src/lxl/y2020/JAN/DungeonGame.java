package lxl.y2020.JAN;

import lxl.util.JSONUtil;

/**
 * @program: leetcode-hz
 * @description: 174. 地下城游戏
 * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 * <p>
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * <p>
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 * <p>
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 * <p>
 * <p>
 * <p>
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 * <p>
 * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
 * -2 (K) 	-3 	3
 * -5 	-10 	1
 * 10 	30 	-5 (P)
 * <p>
 * <p>
 * <p>
 * 说明:
 * <p>
 * 骑士的健康点数没有上限。
 * 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dungeon-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-07 16:58
 **/
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int rowSize = dungeon.length;
        int colSize = dungeon[0].length;
        int[][] dp = new int[rowSize][colSize];
        // 设置最后一个值。
        dp[rowSize - 1][colSize - 1] = Math.max(0, -dungeon[rowSize - 1][colSize - 1]);

        // 设置最后一列的值
        for (int i = rowSize - 2; i >= 0; --i) {
            int needMin = dp[i + 1][colSize - 1] - dungeon[i][colSize - 1];
            dp[i][colSize - 1] = Math.max(0, needMin);
        }

        // 设置最后一行的值
        for (int i = colSize - 2; i >= 0; --i) {
            int needMin = dp[rowSize - 1][i + 1] - dungeon[rowSize - 1][i];
            dp[rowSize - 1][i] = Math.max(0, needMin);
        }

        //
        //    for (int i = 0; i < rowSize; i++) {
        //        System.out.println(JSONUtil.toJson(dungeon[i]));
        //
        //    }

        for (int i = 0; i < rowSize; i++) {
            System.out.println(JSONUtil.toJson(dp[i]));

        }

        for (int i = rowSize - 2; i >= 0; --i) {
            for (int j = colSize - 2; j >= 0; --j) {
                // 从右边和下边选择一个最小值，然后减去当前的 dungeon 值
                int needMin = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = Math.max(0, needMin);
            }
        }
        return dp[0][0] + 1;

    }

    public int calculateMinimumHP2(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] help = new int[m][n];
        help[m - 1][n - 1] = dungeon[m - 1][n - 1] > 0 ? 0 : -dungeon[m - 1][n - 1];
        for (int i = m - 2; i >= 0; i--) {
            help[i][n - 1] = Math.max(0, help[i + 1][n - 1] - dungeon[i][n - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            help[m - 1][i] = Math.max(0, help[m - 1][i + 1] - dungeon[m - 1][i]);
        }
        for (int i = 0; i < m; i++) {
            System.out.println(JSONUtil.toJson(help[i]));

        }

        for (int i = m - 2; i >= 0; --i) {
            for (int j = n - 2; j >= 0; --j) {
                // 从右边和下边选择一个最小值，然后减去当前的 dungeon 值
                int needMin = Math.min(help[i + 1][j], help[i][j + 1]) - dungeon[i][j];
                help[i][j] = Math.max(0, needMin);
            }
        }

        System.out.println("-------------------------------------");

        for (int i = 0; i < m; i++) {
            System.out.println(JSONUtil.toJson(dungeon[i]));

        }
        System.out.println("-------------------------------------");
        for (int i = 0; i < m; i++) {
            System.out.println(JSONUtil.toJson(help[i]));

        }
        return help[0][0] + 1;
    }

    public static void main(String[] args) {
        DungeonGame dungeonGame = new DungeonGame();
        int[][] nums = {
                {1, -3, 3},
                {0, -2, 0},
                {-3, -3, -3}
        };
        //int[][] nums = {
        //        {-2,-3,3},
        //        {-5,-10,1},
        //        {10,30,-5}
        //};
        //[[1,-3,3],[0,-2,0],[-3,-3,-3]]
        System.out.println(dungeonGame.calculateMinimumHP(nums));
        int[][] nums2 = {
                {1, -3, 3},
                {0, -2, 0},
                {-3, -3, -3}
        };
        System.out.println(dungeonGame.calculateMinimumHP2(nums2));

    }

}
