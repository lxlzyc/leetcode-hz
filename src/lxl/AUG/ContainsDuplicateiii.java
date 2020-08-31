package lxl.AUG;

import java.util.TreeSet;

/**
 * @program: leetcode-hz
 * @description: 220. 存在重复元素 III
 * 在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的绝对值也小于等于 ķ 。
 * <p>
 * 如果存在则返回 true，不存在返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * <p>
 * 示例 3:
 * <p>
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-31 13:58
 **/
public class ContainsDuplicateiii {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> help = new TreeSet<>();

        for (int i = 0, l = nums.length; i < l; i++) {
            Integer bigger = help.ceiling(nums[i]);
            if (bigger != null && bigger <= nums[i] + t) {
                return true;
            }
            Integer small = help.floor(nums[i]);
            if (small != null && nums[i] <= small + t) {
                return true;
            }
            help.add(nums[i]);
            if (help.size() > k) {
                help.remove(nums[i - k]);
            }
        }
        return false;
    }

}
