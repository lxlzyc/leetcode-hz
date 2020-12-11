package lxl.y2021.DEC;

import java.util.Random;

/**
 * @program: leetcode-hz
 * @description: 面试题 16.17. 连续数列
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 * <p>
 * 示例：
 * <p>
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 进阶：
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-sequence-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-12-11 13:57
 **/
public class ContiguousSequenceLcci {

    public int maxSubArray(int[] nums) {
        int l = nums.length;
        if (l == 0) {
            return 0;
        }
        int sum = 0;
        int max = nums[0];
        for (int i = 0; i < l; i++) {
            sum += nums[i];
            max = Math.max(sum, max);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int l = nums.length;
        int max = 0;
        for (int i = 1; i < l; ++i) {
            if (nums[i - 1] > 0)
                nums[i] += nums[i - 1];
            if (nums[i] > nums[max])
                max = i;
        }
        return nums[max];
    }

    public static void main(String[] args) {
        ContiguousSequenceLcci contiguousSequenceLcci = new ContiguousSequenceLcci();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            int[] nums = new int[20];
            for (int j = 0; j < 20; j++) {
                nums[j] = random.nextInt(20);
                if (random.nextInt(20) > 13) {
                    nums[j] = 0 - nums[j];
                }
            }
            //System.out.println(Arrays.toString(nums));
            System.out.println(contiguousSequenceLcci.maxSubArray(nums) == contiguousSequenceLcci.maxSubArray2(nums));
            //System.out.println("--------------------------");
        }
    }
}
