package lxl.y2020.APR;

/**
 * @program: leetcode-hz
 * @description: 593. 有效的正方形
 * 给定二维空间中四点的坐标，返回四点是否可以构造一个正方形。
 * <p>
 * 一个点的坐标（x，y）由一个有两个整数的整数数组表示。
 * <p>
 * 示例:
 * <p>
 * 输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * 输出: True
 * <p>
 * <p>
 * <p>
 * 注意:
 * <p>
 * 所有输入整数都在 [-10000，10000] 范围内。
 * 一个有效的正方形有四个等长的正长和四个等角（90度角）。
 * 输入点没有顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-25 09:33
 **/
public class ValidSquare {

    public double dist(int[] p1, int[] p2) {
        return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
    }

    public boolean check(int[] p1, int[] p2, int[] p3, int[] p4) {
        return dist(p1, p2) > 0 && dist(p1, p2) == dist(p2, p3) && dist(p2, p3) == dist(p3, p4) && dist(p3, p4) == dist(p4, p1) && dist(p1, p3) == dist(p2, p4);
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return check(p1, p2, p3, p4) || check(p1, p3, p2, p4) || check(p1, p2, p4, p3);
    }

}
