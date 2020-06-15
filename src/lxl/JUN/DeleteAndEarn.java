package lxl.JUN;

import lxl.util.JSONUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 740. 删除与获得点数
 * 给定一个整数数组 nums ，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [3, 4, 2]
 * 输出: 6
 * 解释:
 * 删除 4 来获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 来获得 2 个点数。总共获得 6 个点数。
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [2, 2, 3, 3, 3, 4]
 * 输出: 9
 * 解释:
 * 删除 3 来获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 * <p>
 * 注意:
 * <p>
 * nums的长度最大为20000。
 * 每个整数nums[i]的大小都在[1, 10000]范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-and-earn
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-15 11:35
 **/
public class DeleteAndEarn {
    //dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * all[i]);
    public int deleteAndEarn(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(JSONUtil.toJson(map));
        Integer[] single = (Integer[]) map.keySet().toArray(new Integer[map.size()]);
        Arrays.sort(single);
        int[] dp = new int[single.length];
        dp[0] = map.get(single[0]) * single[0];
        dp[1] = (single[1] == single[0] + 1) ?
                (Math.max(dp[0], map.get(single[1]) * single[1])) : (map.get(single[1]) * single[1] + dp[0]);
//      动态规划求解
        int index;
        int indexSum;
        for (int i = 2; i < single.length; i++) {
            index = single[i];
            indexSum = index * map.get(index);
            //存在相邻最小值
            if (single[i - 1] + 1 == index) {
                if (single[i - 2] + 2 == index) {
                    dp[i] = Math.max(dp[i - 1], dp[i - 2] + indexSum);

                } else {
                    dp[i] = dp[i - 2] + Math.max(single[i - 1] * map.get(single[i - 1]), indexSum);
                }
            } else {
                //不存在直接相加
                dp[i] = dp[i - 1] + indexSum;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[single.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9, 9, 10, 10, 10};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        DeleteAndEarn deleteAndEarn = new DeleteAndEarn();
        System.out.println(deleteAndEarn.deleteAndEarn(nums));
    }
}
