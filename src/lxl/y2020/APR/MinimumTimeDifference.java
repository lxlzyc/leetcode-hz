package lxl.y2020.APR;

import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 539. 最小时间差
 * 给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: ["23:59","00:00"]
 * 输出: 1
 * <p>
 * <p>
 * 备注:
 * <p>
 * 列表中时间数在 2~20000 之间。
 * 每个时间取值在 00:00~23:59 之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-time-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-16 14:32
 **/
public class MinimumTimeDifference {

    public int findMinDifference(List<String> timePoints) {
        int length = timePoints.size();
        if (length > 1440) {
            return 0;
        }
        int[] times = new int[1441];
        int[] timesSort = new int[length];
        int i = 0;
        for (String timePoint : timePoints) {
            int value = this.getTimeValue(timePoint);
            if (times[value] != 0) {
                return 0;
            }
            times[value] = 1;
            timesSort[i] = value;
            i++;
        }
        Arrays.sort(timesSort);
        int min = 1440 + timesSort[0] - timesSort[length - 1];
        for (int j = 1; j < length; j++) {
            min = Math.min(timesSort[j] - timesSort[j - 1], min);
        }
        return min;

    }

    private int getTimeValue(String timePoint) {
        String[] strings = timePoint.split(":");
        return Integer.valueOf(strings[0]) * 60 + Integer.valueOf(strings[1]);
    }

}
