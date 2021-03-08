package lxl.y2021.MAR;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 883. 三维形体投影面积
 * 在 N * N 的网格中，我们放置了一些与 x，y，z 三轴对齐的 1 * 1 * 1 立方体。
 * <p>
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
 * <p>
 * 现在，我们查看这些立方体在 xy、yz 和 zx 平面上的投影。
 * <p>
 * 投影就像影子，将三维形体映射到一个二维平面上。
 * <p>
 * 在这里，从顶部、前面和侧面看立方体时，我们会看到“影子”。
 * <p>
 * 返回所有三个投影的总面积。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[2]]
 * 输出：5
 * <p>
 * 示例 2：
 * <p>
 * 输入：[[1,2],[3,4]]
 * 输出：17
 * 解释：
 * 这里有该形体在三个轴对齐平面上的三个投影(“阴影部分”)。
 * <p>
 * 示例 3：
 * <p>
 * 输入：[[1,0],[0,2]]
 * 输出：8
 * <p>
 * 示例 4：
 * <p>
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：14
 * <p>
 * 示例 5：
 * <p>
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：21
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length = grid[0].length <= 50
 * 0 <= grid[i][j] <= 50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/projection-area-of-3d-shapes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/8 10:25
 * @Version 1.0
 */
public class ProjectionAreaOf3dShapes {
    public int projectionArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            int x = 0;
            int y = 0;
            for (int j = 0; j < n; j++) {
                x = Math.max(x, grid[i][j]);
                y = Math.max(y, grid[j][i]);
                if (grid[i][j] > 0) {
                    sum++;
                }
            }
            sum += x;
            sum += y;
        }
        return sum;
    }

    public static void main(String[] args) {
        ProjectionAreaOf3dShapes projectionAreaOf3dShapes = new ProjectionAreaOf3dShapes();
        int[][] grid = {
                {1, 1, 1}, {1, 1, 1}, {1, 1, 1}
        };
        System.out.println(projectionAreaOf3dShapes.projectionArea(grid));
    }
}