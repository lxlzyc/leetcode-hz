package lxl.y2020.JAN;

/**
 * @program: leetcode-hz
 * @description: 152. 乘积最大子序列
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-06 16:26
 **/
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int length = nums.length;
        int left = 0;
        int right = 0;
        int product = 1;
        while (left < length && right < length) {
            max = Math.max(max, nums[right]);
            if (nums[right] != 0) {
                product = product * nums[right];
                max = Math.max(product, max);
                right++;
                if (right >= length) {
                    if (product < 0) {
                        while (left < right - 1) {
                            product = product / nums[left];
                            if (product > 0) {
                                max = Math.max(product, max);
                                break;
                            }
                            left++;
                        }
                    }
                    break;
                }
            } else {
                if (product < 0) {
                    while (left < right - 1) {
                        product = product / nums[left];
                        if (product > 0) {
                            max = Math.max(product, max);
                            break;
                        }
                        left++;
                    }
                }
                left = right + 1;
                while (left < length) {
                    if (nums[left] != 0) {
                        product = nums[left];
                        max = Math.max(product, max);
                        break;
                    }
                    left++;
                }
                right = left + 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        int[] nums = {-2, 0, -1};
        System.out.println(maximumProductSubarray.maxProduct(nums));
    }

}
