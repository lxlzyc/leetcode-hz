package lxl.JUN;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 697. 数组的度
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 * <p>
 * 注意:
 * <p>
 * nums.length 在1到50,000区间范围内。
 * nums[i] 是一个在0到49,999范围内的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-04 14:56
 **/
public class DegreeOfAnArray {
    private Map<Integer, int[]> numsMap;
    private Map<Integer, Integer> numsCount;

    public int findShortestSubArray(int[] nums) {
        numsMap = new HashMap<>();
        numsCount = new HashMap<>();
        for (int i = 0, l = nums.length; i < l; i++) {
            int index = nums[i];
            if (numsCount.containsKey(index)) {
                int[] help = numsMap.get(index);
                help[1] = i;
                numsMap.put(index, help);
                numsCount.put(index, numsCount.get(index) + 1);
            } else {
                int[] help = new int[2];
                help[0] = i;
                help[1] = i;
                numsMap.put(index, help);
                numsCount.put(index, 1);
            }
        }
        int degree = Collections.max(numsCount.values());
        int min = nums.length;
        for (Integer key : numsCount.keySet()) {
            if (numsCount.get(key) == degree) {
                int[] help = numsMap.get(key);
                min = Math.min(help[1] - help[0] + 1, min);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1, 4, 2};
        DegreeOfAnArray degreeOfAnArray = new DegreeOfAnArray();
        System.out.println(degreeOfAnArray.findShortestSubArray(nums));
    }
}
