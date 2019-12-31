package lxl.DEC;

import java.util.HashMap;

/**
 * @program: leetcode-hz
 * @description: 137. 只出现一次的数字 II
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,3,2]
 * 输出: 3
 * <p>
 * 示例 2:
 * <p>
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-31 14:00
 **/
public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0, l = nums.length; i < l; i++) {
            int index = nums[i];
            int count = map.getOrDefault(index, 0);
            if (count == 2) {
                map.remove(index);
            } else {
                map.put(index, count + 1);
            }
        }
        return map.keySet().iterator().next();
    }

}
