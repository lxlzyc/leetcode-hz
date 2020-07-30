package lxl.JUL;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 885. 螺旋矩阵 III
 * 在 R 行 C 列的矩阵上，我们从 (r0, c0) 面朝东面开始
 * <p>
 * 这里，网格的西北角位于第一行第一列，网格的东南角位于最后一行最后一列。
 * <p>
 * 现在，我们以顺时针按螺旋状行走，访问此网格中的每个位置。
 * <p>
 * 每当我们移动到网格的边界之外时，我们会继续在网格之外行走（但稍后可能会返回到网格边界）。
 * <p>
 * 最终，我们到过网格的所有 R * C 个空间。
 * <p>
 * 按照访问顺序返回表示网格位置的坐标列表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：R = 1, C = 4, r0 = 0, c0 = 0
 * 输出：[[0,0],[0,1],[0,2],[0,3]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：R = 5, C = 6, r0 = 1, c0 = 4
 * 输出：[[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],
 * [4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= R <= 100
 * 1 <= C <= 100
 * 0 <= r0 < R
 * 0 <= c0 < C
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-30 10:30
 **/
public class SpiralMatrixiii {
    //* 输入：R = 1, C = 4, r0 = 0, c0 = 0
    //           * 输出：[[0,0],[0,1],[0,2],[0,3]]

    //东南西北
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] re = new int[R * C][2];
        //东南西北运行
        int count = R * C;
        int beginLength = 0;
        int dir = 3;
        int offset = 1;
        int x = r0;
        int y = c0;
        re[0] = this.buildIntArr(x, y);
        while (offset < count) {
            dir++;
            //方向变幻 //每隔两次 长度+1；即转向西 东的时候+1
            if (dir == 4) {
                dir = 0;
            }
            if (dir % 2 == 0) {
                beginLength++;
            }
            int[] nextDir = directions[dir];
            for (int i = 0; i < beginLength; i++) {
                x += nextDir[0];
                y += nextDir[1];
                if (x < R && y < C && x >= 0 && y >= 0) {
                    re[offset] = this.buildIntArr(x, y);
                    offset++;
                }
            }
        }
        return re;
    }

    private int[] buildIntArr(int x, int y) {
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        SpiralMatrixiii spiralMatrixiii = new SpiralMatrixiii();
        int[][] re = spiralMatrixiii.spiralMatrixIII(5, 6, 1, 4);
        for (int[] index : re) {
            System.out.print(Arrays.toString(index));
        }
    }
}
