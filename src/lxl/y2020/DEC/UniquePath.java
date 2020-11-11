package lxl.y2020.DEC;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-17 09:34
 **/
public class UniquePath {

    public int uniquePaths(int m, int n) {
        int[][] help = new int[m][n];
        Arrays.fill(help[0],1);
        for (int i = 1; i < m; i++) {
            help[i][0] = 1;
            for (int j = 1; j < n; j++) {
                help[i][j] = help[i][j-1]+help[i-1][j];
            }
        }
        return help[m-1][n-1];
    }
    public static void main(String[] args) {
        UniquePath uniquePath = new UniquePath();
        System.out.println(uniquePath.uniquePaths(7,3));
    }

}
