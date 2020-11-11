package lxl.y2020.JUN;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 698. 划分为k个相等的子集
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-05 10:04
 **/
public class PartitionToKEqualSumSubsets {


    public boolean canPartitionKSubsets(int[] nums, int k) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        sum = sum / k;
        Arrays.sort(nums);
        int last = nums.length - 1;
        while (last >= 0) {
            if (nums[last] > sum) {
                return false;
            } else if (nums[last] == sum) {
                last--;
                k--;
            } else {
                break;
            }
        }
        return this.check(new int[k], nums, last, sum);
    }

    private boolean check(int[] groups, int[] nums, int last, int sum) {
        if (last < 0) {
            return true;
        }
        int v = nums[last];
        last--;
        for (int i = 0, l = groups.length; i < l; i++) {
            if (groups[i] + v <= sum) {
                groups[i] += v;
                if (check(groups, nums, last, sum)) {
                    return true;
                }
                groups[i] -= v;
            }
            if (groups[i] == 0) {
                break;
            }

        }
        return false;
    }
}
