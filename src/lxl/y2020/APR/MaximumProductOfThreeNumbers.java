package lxl.y2020.APR;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 628. 三个数的最大乘积
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: 6
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: 24
 * <p>
 * 注意:
 * <p>
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-30 10:45
 **/
public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int last = nums.length - 1;
        int max = nums[last] * nums[last - 1] * nums[last - 2];
        if (nums[0] < 0) {
            return Math.max(max, nums[last] * nums[0] * nums[1]);
        }
        return max;
    }
}
