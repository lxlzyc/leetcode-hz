package lxl.work2;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves， 字符串 leaves 仅包含小写字符 r 和 y， 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。
 * 出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。每部分树叶数量可以不相等，但均需大于等于 1。每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。
 * <p>
 * 示例 1：
 * <p>
 * 输入：leaves = "rrryyyrryyyrr"
 * <p>
 * 输出：2
 * <p>
 * 解释：调整两次，将中间的两片红叶替换成黄叶，得到 "rrryyyyyyyyrr"
 * <p>
 * 示例 2：
 * <p>
 * 输入：leaves = "ryr"
 * <p>
 * 输出：0
 * <p>
 * 解释：已符合要求，不需要额外操作
 * <p>
 * 提示：
 * <p>
 * 3 <= leaves.length <= 10^5
 * leaves 中只包含字符 'r' 和字符 'y'
 * @author: lxl
 * @create: 2020-09-12 15:28
 **/
public class MinimumOperations {
    private int[][] dp;
    private int[] dpRLeft;
    private int[] dpRRight;

    public int minimumOperations(String leaves) {
        int l = leaves.length();
        //i j 标识i-j为y，需要的改变数
        dp = new int[l][l];
        dpRLeft = new int[l];
        dpRRight = new int[l];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                dp[i][j] = -1;

            }
        }
        char[] chars = leaves.toCharArray();
        for (int i = 0; i < l; i++) {
            if (chars[i] == 'r') {
                dp[i][i] = 1;
            } else {
                dp[i][i] = 0;
            }
        }

        for (int i = 1; i < l - 1; i++) {
            if (chars[i] == 'y') {
                dpRLeft[i] = dpRLeft[i - 1] + 1;
            } else {
                dpRLeft[i] = dpRLeft[i - 1];
            }

            if (chars[l - i - 1] == 'y') {
                dpRRight[l - i - 1] = dpRRight[l - i] + 1;
            } else {
                dpRRight[l - i - 1] = dpRRight[l - i];

            }
        }

        for (int i = 1; i < l - 1; i++) {
            for (int j = i + 1; j < l - 1; j++) {
                //从i-j全为红色 = i-j-1全为红色+j全为红色
                dp[i][j] = dp[i][j - 1] + dp[j][j];
            }
        }
        int min = l;
        for (int i = 1; i < l - 1; i++) {
            System.out.println(Arrays.toString(dp[i]));
            for (int j = i; j < l - 1; j++) {
                //从i-j全为红色 = i-j-1全为红色+j全为红色
                dp[i][j] += dpRLeft[i - 1] + dpRRight[j + 1];
                min = Math.min(dp[i][j], min);
            }
        }
        return min + (1 - dp[0][0]) + (1 - dp[l - 1][l - 1]);
    }


    //i-j全改为红色需要的次数 =
    private int getMinimumOperations(int i, int j) {
        if (i > j) {
            return 0;
        }

        if (i == j) {
            return dp[i][j];
        }
        //全红色
        int a = dp[i][j];
        //左右黄色
        int b = dpRLeft[i] + dpRRight[j] + this.getMinimumOperations(i + 1, j - 1);

        //左黄色
        int c = dpRLeft[i] + this.getMinimumOperations(i + 1, j);
        //右黄色
        int d = dpRRight[j] + this.getMinimumOperations(i, j - 1);

        System.out.println(a + "-" + b + "-" + c + "-" + d);
        return Math.min(Math.min(a, b), Math.min(c, d));
    }

    public static void main(String[] args) {
        MinimumOperations minimumOperations = new MinimumOperations();
        System.out.println(minimumOperations.minimumOperations("ryrrryr"));
    }


}
