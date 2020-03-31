package lxl.MAR;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 912. 排序数组
 * 给你一个整数数组 nums，将该数组升序排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[5,2,3,1]
 * 输出：[1,2,3,5]
 * <p>
 * 示例 2：
 * <p>
 * 输入：[5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 * @author: lxl
 * @create: 2020-03-31 09:43
 **/
public class SortAnArray {


    public int[] sortArray2(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int[] help = new int[max - min + 1];
        for (int num : nums) {
            help[num - min]++;
        }
        int index = 0;
        int helpNum;
        for (int i = 0, l = help.length; i < l; i++) {
            helpNum = help[i];
            while (helpNum > 0) {
                nums[index] = min + i;
                index++;
                helpNum--;
            }
        }
        return nums;
    }

    //快速排序的主要思想是通过划分将待排序的序列分成前后两部分，其中前一部分的数据都比后一部分的数据要小，
    //然后再递归调用函数对两部分的序列分别进行快速排序，以此使整个序列达到有序。
    public int[] sortArray(int[] nums) {
        this.quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int lo = left + 1;
        int hi = right;
        while (lo <= hi) {
            if (nums[lo] > nums[left]) {
                this.swap(nums, lo, hi);
                hi--;
            } else {
                lo++;
            }
        }
        lo--;
        swap(nums, left, lo);

        quickSort(nums, left, lo - 1);
        quickSort(nums, lo + 1, right);

    }

    private void swap(int[] nums, int lo, int hi) {
        int help = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = help;
    }

    public static void main(String[] args) {
        SortAnArray sortAnArray = new SortAnArray();
        int[] nums = {5, 2, 3, 1, 1, 1, 231, 2, 13, 1, 2, 13, 7};
        int[] nums2 = {5, 2, 3, 1, 1, 1, 231, 2, 13, 1, 2, 13, 7};

        System.out.println(Arrays.toString(sortAnArray.sortArray(nums)));
        System.out.println(Arrays.toString(sortAnArray.sortArray2(nums2)));

    }

}
