package lxl.y2020.APR;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 594. 最长和谐子序列
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 * <p>
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,2,2,5,2,3,7]
 * 输出: 5
 * 原因: 最长的和谐数组是：[3,2,2,2,3].
 * <p>
 * 说明: 输入的数组长度最大不超过20,000.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-harmonious-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-25 09:43
 **/
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int num : nums) {
            numsMap.put(num, numsMap.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> index : numsMap.entrySet()) {
            count = Math.max(count,
                    index.getValue() +
                            numsMap.getOrDefault(index.getKey() - 1, 0 - index.getValue()));

            count = Math.max(count,
                    index.getValue() +
                            numsMap.getOrDefault(index.getKey() + 1, 0 - index.getValue()));
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1};
        LongestHarmoniousSubsequence longestHarmoniousSubsequence = new LongestHarmoniousSubsequence();
        System.out.println(longestHarmoniousSubsequence.findLHS(nums));
    }
}
