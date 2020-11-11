package lxl.y2020.JUL;

/**
 * @program: leetcode-hz
 * @description: 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-01 17:23
 **/
public class SearchI {

    public int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int middle;
        int offset = -1;
        while (left <= right) {
            middle = (left + right) >>> 1;
            if (nums[middle] == target) {
                offset = middle;
                break;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        if (offset >= 0) {
            left = offset;
            right = offset;
            for (int i = offset + 1; i < length; i++) {
                if (nums[i] == target) {
                    right = i;
                } else {
                    break;
                }
            }
            for (int i = offset - 1; i >= 0; i--) {
                if (nums[i] == target) {
                    left = i;
                } else {
                    break;
                }
            }
        }
        return right - left + 1;
    }

    //二分法查询左右边界
    public int search2(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }

}
