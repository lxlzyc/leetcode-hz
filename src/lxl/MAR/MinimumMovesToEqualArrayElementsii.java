package lxl.MAR;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 462. 最少移动次数使数组元素相等 II
 * 给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000。
 * <p>
 * 例如:
 * <p>
 * 输入:
 * [1,2,3]
 * <p>
 * 输出:
 * 2
 * <p>
 * 说明：
 * 只有两个动作是必要的（记得每一步仅可使其中一个元素加1或减1）：
 * <p>
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-03-31 14:37
 **/
public class MinimumMovesToEqualArrayElementsii {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int mid = nums[nums.length / 2];
        for (int num : nums) {
            count += Math.abs(num - mid);
        }
        return count;
    }
}
