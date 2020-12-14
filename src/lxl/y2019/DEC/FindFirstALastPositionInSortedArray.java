package lxl.y2019.DEC;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-05 17:18
 **/
public class FindFirstALastPositionInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] ints = new int[2];
        ints[0] = -1;
        ints[1] = -1;
        if (nums == null) {
            return ints;
        }
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
            ints[0] = left;
            ints[1] = right;
        }
        return ints;

    }

    public static void main(String[] args) {
        FindFirstALastPositionInSortedArray firstALastPositionInSortedArray = new FindFirstALastPositionInSortedArray();
        int[] nums = {5, 7, 7, 8, 8, 8, 9, 10};
        System.out.println(Arrays.toString(firstALastPositionInSortedArray.searchRange(nums, 11)));
    }

}
