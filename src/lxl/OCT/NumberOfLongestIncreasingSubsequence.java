package lxl.OCT;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 673. 最长递增子序列的个数
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 * <p>
 * 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-10-15 16:06
 **/
public class NumberOfLongestIncreasingSubsequence {
    //dp[i] = compare(index,i-n)?dp[i-n];
    public int findNumberOfLIS2(int[] nums) {
        int N = nums.length;
        if (N <= 1) return N;
        int[] lengths = new int[N]; //lengths[i] = length of longest ending in nums[i]
        int[] counts = new int[N]; //count[i] = number of longest ending in nums[i]
        Arrays.fill(counts, 1);

        for (int j = 0; j < N; ++j) {
            for (int i = 0; i < j; ++i) {
                if (nums[i] < nums[j]) {
                    if (lengths[i] >= lengths[j]) {
                        lengths[j] = lengths[i] + 1;
                        counts[j] = counts[i];
                    } else if (lengths[i] + 1 == lengths[j]) {
                        counts[j] += counts[i];
                    }
                }
            }
        }

        int longest = 0, ans = 0;
        for (int length : lengths) {
            longest = Math.max(longest, length);
        }
        for (int i = 0; i < N; ++i) {
            if (lengths[i] == longest) {
                ans += counts[i];
            }
        }
        return ans;
    }

    public int findNumberOfLIS(int[] nums) {
        int l = nums.length;
        if (l < 1) {
            return l;
        }
        //以i位结尾的 最大长度
        int[] lens = new int[l];
        //以i位结尾的 最大长度路径
        int[] counts = new int[l];
        Arrays.fill(counts, 1);
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (lens[j] >= lens[i]) {
                        counts[i] = counts[j];
                        lens[i] = lens[j] + 1;
                    } else if (lens[j] + 1 == lens[i]) {
                        counts[i] += counts[j];
                    }
                }
            }
        }

        int maxLen = Arrays.stream(lens).max().getAsInt();
        int ansCount = 0;
        for (int i = 0; i < l; i++) {
            if (lens[i] == maxLen) {
                ansCount += counts[i];
            }
        }
        return ansCount;
    }

    public static void main(String[] args) {
        NumberOfLongestIncreasingSubsequence numberOfLongestIncreasingSubsequence = new NumberOfLongestIncreasingSubsequence();
        int[] nums = {1, 3, 5, 4, 7};
        System.out.println(numberOfLongestIncreasingSubsequence.findNumberOfLIS(nums));
    }

}
