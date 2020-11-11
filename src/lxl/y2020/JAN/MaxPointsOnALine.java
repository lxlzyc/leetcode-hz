package lxl.y2020.JAN;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 149. 直线上最多的点数
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-points-on-a-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-06 13:49
 **/
public class MaxPointsOnALine {

    public int maxPoints(int[][] points) {
        int length = points.length;
        if (length <= 0) {
            return length;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] == o2[0]) {
                    if (o1[1] > o2[1]) {
                        return 1;
                    } else if (o1[1] == o2[1]) {
                        return 0;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            }
        });
        Map<String, Integer> lines = new HashMap<>();
        int max = 1;
        String key;
        int value;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                key = this.buildKey(points[i], points[j]);
                System.out.println(Arrays.toString(points[i]) + "-" + Arrays.toString(points[j]) + "=" + key);
                value = lines.getOrDefault(key, 0) + 1;
                max = Math.max(value + 1, max);
                lines.put(key, value);
            }
            lines.clear();
        }
        return max;
    }

    private String buildKey(int[] point, int[] point1) {
        int a = point1[0] - point[0];
        int b = point1[1] - point[1];
        if (a == 0 && b == 0) {
            return "1_1";
        }
        int gcd = this.gcd(a, b);
        gcd = gcd == 0 ? 1 : gcd;
        return b / gcd + "_" + a / gcd;
    }


    private int gcd(int a, int b) {
        if (a < b) {
            swap(a, b);
        }
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }


    }

    private void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }

    public static void main(String[] args) {
        int[][] points = {
                {0, 0},
                {2, 2},
                {0, 0}
                //,
                //{2,3},
                //{3,2},
                //{4,1}
        };

        MaxPointsOnALine maxPointsOnALine = new MaxPointsOnALine();
        System.out.println(maxPointsOnALine.maxPoints(points));

    }
}
