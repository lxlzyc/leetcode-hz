package lxl.y2020.JUL;

/**
 * @program: leetcode-hz
 * @description: 812. 最大三角形面积
 * 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
 * <p>
 * 示例:
 * 输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * 输出: 2
 * 解释:
 * 这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
 * <p>
 * 注意:
 * <p>
 * 3 <= points.length <= 50.
 * 不存在重复的点。
 * -50 <= points[i][j] <= 50.
 * 结果误差值在 10^-6 以内都认为是正确答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-triangle-area
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-10 14:45
 **/
public class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        double area = 0D;
        for (int i = 0, l = points.length; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                for (int k = j + 1; k < l; k++) {
                    area = Math.max(area, this.area(points[i], points[j], points[k]));
                }
            }
        }
        return area;
    }

    public double area(int[] P, int[] Q, int[] R) {
        return 0.5 * Math.abs(P[0] * Q[1] + Q[0] * R[1] + R[0] * P[1]
                - P[1] * Q[0] - Q[1] * R[0] - R[1] * P[0]);
    }

    public static void main(String[] args) {
        LargestTriangleArea largestTriangleArea = new LargestTriangleArea();
        int[][] points = {{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}};
        System.out.println(largestTriangleArea.largestTriangleArea(points));
    }
}
