package lxl.y2021.FEB;

import java.util.Arrays;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 324. 摆动排序 II
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * <p>
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,1,1,6,4]
 * 输出：[1,6,1,5,1,4]
 * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,3,2,2,3,1]
 * 输出：[2,3,1,3,1,2]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 104
 * 0 <= nums[i] <= 5000
 * 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果
 * <p>
 * <p>
 * <p>
 * 进阶：你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wiggle-sort-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/2/4 11:18
 * @Version 1.0
 */
public class WiggleSortii {
    public void wiggleSort(int[] nums) {
        int[] ans = Arrays.copyOf(nums, nums.length);
        Arrays.sort(ans);
        int len = nums.length;
        int offset = len;
        for (int i = 1; i < len; i += 2) {
            nums[i] = ans[--offset];
        }
        for (int i = 0; i < len; i += 2) {
            nums[i] = ans[--offset];
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 5, 6};
        WiggleSortii wiggleSortii = new WiggleSortii();
        wiggleSortii.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}