package lxl.y2020.MAR;

import lxl.util.JSONUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 417. 太平洋大西洋水流问题
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 * <p>
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 * <p>
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 输出坐标的顺序不重要
 * m 和 n 都小于150
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 给定下面的 5x5 矩阵:
 * <p>
 * 太平洋 ~   ~   ~   ~   ~
 * ~  1   2   2   3  (5) *
 * ~  3   2   3  (4) (4) *
 * ~  2   4  (5)  3   1  *
 * ~ (6) (7)  1   4   5  *
 * ~ (5)  1   1   2   4  *
 * *   *   *   *   * 大西洋
 * <p>
 * 返回:
 * <p>
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
 * @author: lxl
 * @create: 2020-03-19 15:45
 **/
public class PacificAtlanticWaterFlow {
    private int m;
    private int n;
    private int[][] t;
    private List<List<Integer>> re = new ArrayList<>();

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {

        m = matrix.length;
        if (m == 0) {
            return re;
        }
        n = matrix[0].length;
        t = new int[m][n];
        if (m == 1 || n == 1) {
            this.getPacificAtlanticAll();
            return re;
        }
        //计算太平洋
        for (int i = 0; i < n; i++) {
            if (t[0][i] == 1) {
                continue;
            }
            t[0][i] = 1;
            this.bfsT(matrix, t, 0, i);
        }
        for (int i = 1; i < m; i++) {
            if (t[i][0] == 1) {
                continue;
            }
            t[i][0] = 1;
            this.bfsT(matrix, t, i, 0);
        }
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(t[i]));

        }
        System.out.println("-------------------");

        int[][] d = new int[m][n];
        //计算大西洋
        for (int i = n - 1; i >= 0; i--) {
            if (d[m - 1][i] == 1) {
                continue;
            }
            d[m - 1][i] = 1;
            this.bfsT(matrix, d, m - 1, i);
        }
        for (int i = m - 2; i >= 0; i--) {
            if (d[i][n - 1] == 1) {
                continue;
            }
            d[i][n - 1] = 1;
            this.bfsT(matrix, d, i, n - 1);
        }


        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(d[i]));

        }
        System.out.println("==========================");
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(t[i]));

        }
        System.out.println("----------------");

        for (List<Integer> index : re) {
            System.out.println(JSONUtil.toJson(index));
        }
        this.getPacificAtlantic(t, d);

        return re;

    }


    //太平洋 往右下遍历
    private void bfsT(int[][] matrix, int[][] t, int i, int j) {
        if (i == 2 && j == 2) {
            System.out.println("i");
        }
        if (i + 1 < m) {
            if (t[i + 1][j] != 1) {
                if (matrix[i][j] <= matrix[i + 1][j]) {
                    t[i + 1][j] = 1;
                    this.bfsT(matrix, t, i + 1, j);
                }
            }

        }
        if (j + 1 < n) {
            if (t[i][j + 1] != 1) {
                if (matrix[i][j] <= matrix[i][j + 1]) {
                    t[i][j + 1] = 1;
                    this.bfsT(matrix, t, i, j + 1);
                }
            }

        }

        if (i - 1 >= 0) {
            if (t[i - 1][j] != 1) {
                if (matrix[i][j] <= matrix[i - 1][j]) {
                    t[i - 1][j] = 1;
                    this.bfsT(matrix, t, i - 1, j);
                }
            }

        }
        if (j - 1 >= 0) {
            if (t[i][j - 1] != 1) {
                if (matrix[i][j] <= matrix[i][j - 1]) {
                    t[i][j - 1] = 1;
                    this.bfsT(matrix, t, i, j - 1);
                }
            }

        }
    }

    private void getPacificAtlantic(int[][] t, int[][] d) {
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < n; k++) {
                if (t[j][k] + d[j][k] == 2) {
                    re.add(Arrays.asList(j, k));
                }
            }
        }
    }

    private void getPacificAtlanticAll() {
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < n; k++) {
                re.add(Arrays.asList(j, k));
            }
        }
    }

    public static void main(String[] args) {
        //int[][] nums = {
        //        {1, 2, 2, 3, 5},
        //        {3, 2, 3, 4, 4},
        //        {2, 4, 5, 3, 1},
        //        {6, 7, 1, 4, 5},
        //        {5, 1, 1, 2, 4}
        //};
        int[][] nums = {
                {1}, {2}
        };
        PacificAtlanticWaterFlow pacificAtlanticWaterFlow = new PacificAtlanticWaterFlow();
        System.out.println(pacificAtlanticWaterFlow.pacificAtlantic(nums));
    }
}
