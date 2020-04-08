package lxl.APR;

import java.util.Random;

/**
 * @program: leetcode-hz
 * @description: 497. 非重叠矩形中的随机点
 * 给定一个非重叠轴对齐矩形的列表 rects，写一个函数 pick 随机均匀地选取矩形覆盖的空间中的整数点。
 * <p>
 * 提示：
 * <p>
 * 整数点是具有整数坐标的点。
 * 矩形周边上的点包含在矩形覆盖的空间中。
 * 第 i 个矩形 rects [i] = [x1，y1，x2，y2]，其中 [x1，y1] 是左下角的整数坐标，[x2，y2] 是右上角的整数坐标。
 * 每个矩形的长度和宽度不超过 2000。
 * 1 <= rects.length <= 100
 * pick 以整数坐标数组 [p_x, p_y] 的形式返回一个点。
 * pick 最多被调用10000次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["Solution","pick","pick","pick"]
 * [[[[1,1,5,5]]],[],[],[]]
 * 输出:
 * [null,[4,1],[4,1],[3,3]]
 * <p>
 * 示例 2：
 * <p>
 * 输入:
 * ["Solution","pick","pick","pick","pick","pick"]
 * [[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
 * 输出:
 * [null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/random-point-in-non-overlapping-rectangles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-08 18:58
 **/
public class RandomPointInNonOverlappingRectangles {
    //非重叠！！
    //先随机选择矩形
    //再随机选择点
    private int[][] rects;
    private int area;
    private int[] areas;
    private Random rand = new Random();

    public RandomPointInNonOverlappingRectangles(int[][] rects) {
        this.rects = rects;
        int length = rects.length;
        if (length == 0) {
            area = 0;
            return;
        }
        areas = new int[length];
        area = 0;
        for (int i = 0; i < length; i++) {
            areas[i] = (rects[i][3] - rects[i][1] + 1) * (rects[i][2] - rects[i][0] + 1) + area;
            area += areas[i];
        }
    }

    public int[] pick() {
        int random = rand.nextInt(area);
        int lo = 0;
        int hi = rects.length - 1;
        while (lo != hi) {
            int mid = (lo + hi) / 2;
            if (random >= areas[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        int[] rect = rects[lo];

        int height = rect[3] - rect[1] + 1;
        int width = rect[2] - rect[0] + 1;
        int base = areas[lo] - width * height;
        return new int[]{rect[0] + (random - base) % width, rect[1] + (random - base) / width};

    }

}
