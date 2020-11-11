package lxl.y2020.AUG;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode-hz
 * @description: 219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * <p>
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-10 15:22
 **/
public class ContainsDuplicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> help = new HashSet<>();
        int left = 0;
        int right = 0;
        int l = nums.length;
        while (right < l) {
            if (help.contains(nums[right])) {
                return true;
            }
            help.add(nums[right]);
            if (help.size() > k) {
                help.remove(nums[left]);
                left++;
            }
            right++;
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate2 containsDuplicate2 = new ContainsDuplicate2();
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate2.containsNearbyDuplicate(nums, 3));
    }

}
