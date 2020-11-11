package lxl.y2020.JAN;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * <p>
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-07 16:13
 **/
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int max = nums[0];
        int maxCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int value = map.getOrDefault(num, 0) + 1;
            if (value > maxCount) {
                maxCount = value;
                max = num;
            }
            map.put(num, value);
        }
        return max;
    }
}
