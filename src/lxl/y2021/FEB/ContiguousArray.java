package lxl.y2021.FEB;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 525. 连续数组
 * 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 * <p>
 * <p>
 * <p>
 * 注意: 给定的二进制数组的长度不会超过50000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/2/25 11:26
 * @Version 1.0
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        //hashmap
//        使用一个 HashMap map 来保存所有的 (index,count) 对。对于一个 count ，我们只记录它第一次出现的位置，
//        后面遇到相同的 count 我们都用这个第一次记录的 index 来计算子数组的长度。
//
//        作者：LeetCode
//        链接：https://leetcode-cn.com/problems/contiguous-array/solution/lian-xu-shu-zu-by-leetcode/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0;
        for (int i = 0; i < len; i++) {
            count += (nums[i] == 0) ? -1 : 1;
            if (!map.containsKey(count)) {
                map.put(count, i);
            } else {
                maxlen = Math.max(maxlen, i - map.get(count));
            }
        }
        return maxlen;
    }
}