package lxl.y2020.AUG;

import lxl.util.JSONUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 986. 区间列表的交集
 * 给定两个由一些 闭区间 组成的列表，每个区间列表都是成对不相交的，并且已经排序。
 * <p>
 * 返回这两个区间列表的交集。
 * <p>
 * （形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b。两个闭区间的交集是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3]。）
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length < 1000
 * 0 <= B.length < 1000
 * 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interval-list-intersections
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-26 10:33
 **/
public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList<>();
        int al = A.length;
        int bl = B.length;
        int offseta = 0;
        int offsetb = 0;
        while (offseta < al && offsetb < bl) {
            int[] a = A[offseta];
            int[] b = B[offsetb];
            if (a[0] > b[1]) {
                offsetb++;
            } else if (b[0] > a[1]) {
                offseta++;
            } else {
                ans.add(new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])});
                if (a[1] < b[1]) {
                    offseta++;
                } else {
                    offsetb++;
                }
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }

    public static void main(String[] args) {
        IntervalListIntersections intervalListIntersections = new IntervalListIntersections();
        int[][] A = {
                {0, 2},
                {5, 10},
                {13, 23},
                {24, 25}
        };
        int[][] B = {
                {1, 5},
                {8, 12},
                {15, 24},
                {25, 26}
        };
        System.out.println(JSONUtil.toJson(intervalListIntersections.intervalIntersection(A, B)));
    }
}
