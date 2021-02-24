package lxl.y2021.FEB;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 892. 三维形体的表面积
 * 给你一个 n * n 的网格 grid ，上面放置着一些 1 x 1 x 1 的正方体。
 * <p>
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * <p>
 * 放置好正方体后，任何直接相邻的正方体都会互相粘在一起，形成一些不规则的三维形体。
 * <p>
 * 请你返回最终这些形体的总表面积。
 * <p>
 * 注意：每个形体的底面也需要计入表面积中。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[2]]
 * 输出：10
 * <p>
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2],[3,4]]
 * 输出：34
 * <p>
 * 示例 3：
 * <p>
 * 输入：grid = [[1,0],[0,2]]
 * 输出：16
 * <p>
 * 示例 4：
 * <p>
 * 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * <p>
 * 示例 5：
 * <p>
 * 输入：grid = [[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 50
 * 0 <= grid[i][j] <= 50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surface-area-of-3d-shapes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/2/24 10:44
 * @Version 1.0
 */
public class SurfaceAreaOf3dShapes {

    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int sum = 0;

        //所有节点都计算右,下边
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int item = grid[i][j];
                //上
                if (i == 0) {
                    sum += item;
                }
                //左
                if (j == 0) {
                    sum += item;
                }
                //顶部底部
                if (item > 0) {
                    sum += 2;
                }
                int nextRight = j + 1 == n ? 0 : grid[i][j + 1];
                int nextBottom = i + 1 == n ? 0 : grid[i + 1][j];
                //右
                sum += Math.abs(item - nextRight);
                //下
                sum += Math.abs(item - nextBottom);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 0},
                {0, 2}
        };
        SurfaceAreaOf3dShapes surfaceAreaOf3dShapes = new SurfaceAreaOf3dShapes();
        System.out.println(surfaceAreaOf3dShapes.surfaceArea(grid));
    }
}