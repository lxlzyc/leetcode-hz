package lxl.y2020.APR;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 532. 数组中的K-diff数对
 * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3, 1, 4, 1, 5], k = 2
 * 输出: 2
 * 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 * <p>
 * 示例 2:
 * <p>
 * 输入:[1, 2, 3, 4, 5], k = 1
 * 输出: 4
 * 解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
 * <p>
 * 示例 3:
 * <p>
 * 输入: [1, 3, 1, 5, 4], k = 0
 * 输出: 1
 * 解释: 数组中只有一个 0-diff 数对，(1, 1)。
 * <p>
 * 注意:
 * <p>
 * 数对 (i, j) 和数对 (j, i) 被算作同一数对。
 * 数组的长度不超过10,000。
 * 所有输入的整数的范围在 [-1e7, 1e7]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-diff-pairs-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-14 21:36
 **/
public class KDiffPairsInAnArray {

    public int findPairs(int[] nums, int k) {
        Integer old = null;
        Arrays.sort(nums);
        int count = 0;
        int i = 0;
        int j = 1;
        int length = nums.length;
        while (i < length && j < length) {
            while (j < length) {
                if (i == j) {
                    j++;
                    continue;
                }
                if (nums[j] - nums[i] == k) {
                    if (old != null) {
                        if (nums[j] != old) {
                            count++;
                            old = nums[j];
                        }
                    } else {
                        old = nums[j];
                        count++;
                    }
                    j++;
                    i++;
                    break;
                } else if (nums[j] - nums[i] < k) {
                    j++;
                } else {
                    i++;
                    break;
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        KDiffPairsInAnArray kDiffPairsInAnArray = new KDiffPairsInAnArray();
        int[] nums = {1, 3, 1, 5, 4};
        System.out.println(kDiffPairsInAnArray.findPairs(nums, 1));
    }

}
