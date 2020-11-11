package lxl.y2020.APR;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 475. 供暖器
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * <p>
 * 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
 * <p>
 * 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
 * <p>
 * 说明:
 * <p>
 * 给出的房屋和供暖器的数目是非负数且不会超过 25000。
 * 给出的房屋和供暖器的位置均是非负数且不会超过10^9。
 * 只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
 * 所有供暖器都遵循你的半径标准，加热的半径也一样。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3],[2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4],[1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 * @author: lxl
 * @create: 2020-04-02 14:06
 **/
public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        if (houses.length == 0 || heaters.length == 0) {
            return 0;
        }
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int min = Integer.MIN_VALUE;
        int index = 0;
        int abs;
        for (int i = 0, l1 = houses.length, l2 = heaters.length; i < l1; i++) {

            abs = heaters[index] - houses[i];
            if (abs >= 0) {
                min = Math.max(abs, min);
                continue;
            } else {
                abs = 0 - abs;
                while (index + 1 < l2) {
                    if (Math.abs(heaters[index + 1] - houses[i]) <= abs) {
                        abs = Math.abs(heaters[index + 1] - houses[i]);
                        index++;
                    } else {
                        break;
                    }
                }
                min = Math.max(abs, min);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Heaters heaters = new Heaters();
        int[] houses = {4};
        int[] heater = {1, 2, 3, 4};
        System.out.println(heaters.findRadius(houses, heater));
    }

}
