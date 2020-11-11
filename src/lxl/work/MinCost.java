package lxl.work;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-08-09 10:54
 **/
public class MinCost {

    private int max;

    public int minCost(int n, int[] cuts) {
        max = -1;
        return this.subarraySum(cuts, n);
    }

    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        // 计算前缀和数组
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                // 区间和 [left..right]，注意下标偏移
                if (preSum[right + 1] - preSum[left] == k) {
                    if (left > max) {
                        max = right;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 6, 6, 3, 5, 4, 1, 2, 8};
        MinCost minCost = new MinCost();
        System.out.println(minCost.minCost(10, nums));
    }

}
