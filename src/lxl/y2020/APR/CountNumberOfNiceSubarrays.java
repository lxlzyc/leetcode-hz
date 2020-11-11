package lxl.y2020.APR;

/**
 * @program: leetcode-hz
 * @description: 1248. 统计「优美子数组」
 * 给你一个整数数组 nums 和一个整数 k。
 * <p>
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * <p>
 * 请返回这个数组中「优美子数组」的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-21 10:52
 **/
public class CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length, res = 0, feed = 0, arr[] = new int[len + 2];
        for (int i = 0; i < len; i++) {
            // if it is odd
            if ((nums[i] & 1) == 1) {
                arr[++feed] = i;
            }
        }
        // left border
        arr[0] = -1;
        // right border
        arr[feed + 1] = len;
        for (int i = 1; i + k < feed + 2; i++) {
            res += (arr[i] - arr[i - 1]) * (arr[i + k] - arr[i + k - 1]);
        }
        return res;
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }

}
