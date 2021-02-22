package lxl.y2021.FEB;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 1184. 公交站间的距离
 * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。
 * 我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 * <p>
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 * <p>
 * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：distance = [1,2,3,4], start = 0, destination = 1
 * 输出：1
 * 解释：公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：distance = [1,2,3,4], start = 0, destination = 2
 * 输出：3
 * 解释：公交站 0 和 2 之间的距离是 3 或 7，最小值是 3。
 * <p>
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：distance = [1,2,3,4], start = 0, destination = 3
 * 输出：4
 * 解释：公交站 0 和 3 之间的距离是 6 或 4，最小值是 4。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^4
 * distance.length == n
 * 0 <= start, destination < n
 * 0 <= distance[i] <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distance-between-bus-stops
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/2/22 10:45
 * @Version 1.0
 */
public class DistanceBetweenBusStops {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        //        正序和总路长
        int ans1 = 0;
        int n = distance.length;
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        int sum = 0;
        //        总路长
        for (int i = 0; i < n; i++) {
            sum += distance[i];
        }
        //        正序
        for (int i = start; i < destination; i++) {
            ans1 += distance[i];
        }
        return Math.min(ans1, sum - ans1);
    }

    public static void main(String[] args) {
        DistanceBetweenBusStops distanceBetweenBusStops = new DistanceBetweenBusStops();
        int[] bus = {1, 2, 3, 4, 6, 2, 2, 1, 3};
        System.out.println(distanceBetweenBusStops.distanceBetweenBusStops(bus, 3, 7));
    }

}