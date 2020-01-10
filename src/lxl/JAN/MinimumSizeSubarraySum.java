package lxl.JAN;

/**
 * @program: leetcode-hz
 * @description: 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例:
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * <p>
 * 进阶:
 * <p>
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-10 09:53
 **/
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int length = nums.length;
        int left = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            while (sum >= s) {
                min = Math.min(min, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return min < Integer.MAX_VALUE ? min : 0;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minimumSizeSubarraySum.minSubArrayLen(7, nums));
    }

}
