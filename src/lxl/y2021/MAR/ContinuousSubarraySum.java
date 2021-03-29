package lxl.y2021.MAR;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 523. 连续的子数组和
 * 给定一个包含 非负数 的数组和一个目标 整数 k ，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，且总和为 k 的倍数，即总和为 n * k ，其中 n 也是一个整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[23,2,4,6,7], k = 6
 * 输出：True
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6。
 * <p>
 * 示例 2：
 * <p>
 * 输入：[23,2,6,4,7], k = 6
 * 输出：True
 * 解释：[23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
 * <p>
 * <p>
 * <p>
 * 说明：
 * <p>
 * 数组的长度不会超过 10,000 。
 * 你可以认为所有数字总和在 32 位有符号整数范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/29 13:39
 * @Version 1.0
 */
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) {
            return false;
        }
        int[] sums = new int[len + 1];
        sums[0] = 0;
        for (int i = 0; i < len; i++) {
            sums[i + 1] = nums[i] + sums[i];
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                //区间和
                int sum = sums[j + 1] - sums[i];
                if (sum == k || (k != 0 && sum % k == 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    //数学法
//    设位置 j < i :
//    0 到 j 的前缀和 preSum1 = 某常数1 * k + 余数1
//    0 到 i 的前缀和 preSum2 = 某常数2 * k + 余数2
//    当找到 余数1 等于 余数2时， 则 j + 1 到 i 的连续和 = preSum2 - preSum1 = (某常数2 - 某常数1) * k， 必为 k 的倍数， 返回true

    public boolean checkSubarraySum2(int[] nums, int k) {
        int sum = 0;
        // key：区间 [0..i] 里所有元素的和 % k
        // value：下标 i
        Map<Integer, Integer> map = new HashMap<>();
        // 理解初始化的意义
        map.put(0, -1);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (k != 0) {
                sum = sum % k;
            }

            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {23, 2, 4, 6, 6};
        ContinuousSubarraySum continuousSubarraySum = new ContinuousSubarraySum();
        System.out.println(continuousSubarraySum.checkSubarraySum(nums, 7));
    }
}