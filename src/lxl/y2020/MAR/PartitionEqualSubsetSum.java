package lxl.y2020.MAR;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 416. 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 注意:
 * <p>
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1, 5, 11, 5]
 * <p>
 * 输出: true
 * <p>
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * <p>
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1, 2, 3, 5]
 * <p>
 * 输出: false
 * <p>
 * 解释: 数组不能分割成两个元素和相等的子集.
 * @author: lxl
 * @create: 2020-03-19 15:02
 **/
public class PartitionEqualSubsetSum {
    private int length;

    public boolean canPartition(int[] nums) {

        length = nums.length;
        if (length <= 1) {
            return false;
        }
        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        return this.checkSum(nums, length - 1, sum, sum);
    }

    //    策略：
//    对于S中的每一个元素，对于子集X，都有接受和丢弃两种操作，且这两种操作是互补且等价的
//（可以想象有两个子集，接受是放到第一个子集中，丢弃是放到第二个子集里）。
//            1、当任意一个子集装满SUM(S)/2后，即成功找到一个解。
//            2、当任意一个子集超过SUM(S)/2后，则在此种分支下不可能找到一个可行解，剪枝。
    private boolean checkSum(int[] nums, int index, int sumpart1, int sumpart2) {
        if (sumpart1 == 0 || sumpart2 == 0) {
            return true;
        } else if (sumpart1 < 0 || sumpart2 < 0) {
            return false;
        }
        return this.checkSum(nums, index - 1, sumpart1 - nums[index], sumpart2)  //第一个子集保存
                || this.checkSum(nums, index - 1, sumpart1, sumpart2 - nums[index]);  //第二个子集保存
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 100};
        System.out.println(partitionEqualSubsetSum.canPartition(nums));
    }


}
