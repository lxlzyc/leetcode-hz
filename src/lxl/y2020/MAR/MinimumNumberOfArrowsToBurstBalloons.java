package lxl.y2020.MAR;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @program: leetcode-hz
 * @description: 452. 用最少数量的箭引爆气球
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x坐标就足够了。开始坐标总是小于结束坐标。平面内最多存在104个气球。
 * <p>
 * 一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 * <p>
 * Example:
 * <p>
 * 输入:
 * [[10,16], [2,8], [1,6], [7,12]]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-03-30 14:00
 **/
public class MinimumNumberOfArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        //合并相邻区间
        int length = points.length;
        if (length <= 1) {
            return length;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        LinkedList<Integer> lines = new LinkedList<>();
        lines.add(points[0][0]);
        lines.add(points[0][1]);
        int left;
        int right;
        for (int i = 1; i < length; i++) {
            left = points[i][0];
            right = points[i][1];
            if (left <= lines.getLast()) {
                right = Math.min(right, lines.pollLast());
                lines.add(right);
            } else {
                lines.add(left);
                lines.add(right);
            }
        }
        return lines.size() / 2;
    }

    public static void main(String[] args) {
        MinimumNumberOfArrowsToBurstBalloons m = new MinimumNumberOfArrowsToBurstBalloons();
        int[][] points = {
                {10, 16}, {2, 8}, {1, 6}, {7, 12}
        };
        System.out.println(m.findMinArrowShots(points));
    }
}
