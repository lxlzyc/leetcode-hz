package lxl.y2020.JAN;

/**
 * @program: leetcode-hz
 * @description: 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * <p>
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-16 17:07
 **/
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int lengh = nums.length;
        int max = 0;
        if (lengh == 0) {
            return max;
        }
        max = 1;
        int indexLength = 1;
        int right = 1;
        int pre = nums[0];
        while (right < lengh) {
            if (nums[right] > pre) {
                indexLength++;
                pre = nums[right];
            } else {
                pre = nums[right];
                max = Math.max(indexLength, max);
                indexLength = 1;
                if (lengh - right < indexLength) {
                    break;
                }
            }
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(nums));
    }


}
