package lxl.JAN;

/**
 * @program: leetcode-hz
 * @description: 223. 矩形面积
 * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 * <p>
 * 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
 * <p>
 * Rectangle Area
 * <p>
 * 示例:
 * <p>
 * 输入: -3, 0, 3, 4, 0, -1, 9, 2
 * 输出: 45
 * <p>
 * 说明: 假设矩形面积不会超出 int 的范围。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rectangle-area
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-13 10:19
 **/
public class RectangleArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        if (E >= C || G <= A || H <= B || F >= D) {
            // 不相交
            return area1 + area2;
        }

        int leftBottomX = Math.max(A, E);
        int leftBottomY = Math.max(B, F);
        int rightUpX = Math.min(C, G);
        int rightUpY = Math.min(D, H);
        int commonArea = (rightUpX - leftBottomX) * (rightUpY - leftBottomY);
        return area1 + area2 - commonArea;

    }

    public static void main(String[] args) {
        RectangleArea rectangleArea = new RectangleArea();
        System.out.println(rectangleArea.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }

}
