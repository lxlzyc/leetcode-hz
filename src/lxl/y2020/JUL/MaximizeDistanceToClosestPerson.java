package lxl.y2020.JUL;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 849. 到最近的人的最大距离
 * 在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
 * <p>
 * 至少有一个空座位，且至少有一人坐在座位上。
 * <p>
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 * <p>
 * 返回他到离他最近的人的最大距离。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,0,0,1,0,1]
 * 输出：2
 * 解释：
 * 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
 * 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
 * 因此，他到离他最近的人的最大距离是 2 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：[1,0,0,0]
 * 输出：3
 * 解释：
 * 如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
 * 这是可能的最大距离，所以答案是 3 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= seats.length <= 20000
 * seats 中只含有 0 和 1，至少有一个 0，且至少有一个 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximize-distance-to-closest-person
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-22 16:08
 **/
public class MaximizeDistanceToClosestPerson {

    public int maxDistToClosest(int[] seats) {
        int l = seats.length;
        List<Integer> lists = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < l; i++) {
            if (seats[i] == 1) {
                lists.add(i);
            }
        }
        max = Math.max(max, lists.get(0) - 0);
        max = Math.max(max, l - 1 - lists.get(lists.size() - 1));
        for (int i = 0, size = lists.size(); i < size - 1; i++) {
            max = Math.max(max, (lists.get(i + 1) - lists.get(i)) / 2);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximizeDistanceToClosestPerson maximizeDistanceToClosestPerson = new MaximizeDistanceToClosestPerson();
        int[] seats = {0, 0, 0, 1};
        System.out.println(maximizeDistanceToClosestPerson.maxDistToClosest(seats));
    }
}
