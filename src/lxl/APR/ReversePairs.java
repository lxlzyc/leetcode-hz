package lxl.APR;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 面试题51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 * @author: lxl
 * @create: 2020-04-24 10:32
 **/
public class ReversePairs {

    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        int[] copy = Arrays.copyOf(nums, len);
        int[] temp = new int[len];
        //分治法
        int count = this.mergeSort(copy, 0, len - 1, temp);
        return count;
    }

    private int mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;

        int leftCount = this.mergeSort(nums, left, mid, temp);
        int rightCount = this.mergeSort(nums, mid + 1, right, temp);
        if (nums[mid] <= nums[mid + 1]) {
            return leftCount + rightCount;
        }
        int indexCount = this.merge(nums, left, mid, right, temp);
        return indexCount + leftCount + rightCount;
    }

    private int merge(int[] nums, int left, int mid, int right, int[] temp) {
        for (int j = left; j <= right; j++) {
            temp[j] = nums[j];
        }
        int count = 0;
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                //把右边的拼回去
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                //把左边的拼回去
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                //左边
                nums[k] = temp[i];
                i++;
            } else {
                //右边
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
