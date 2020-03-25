package lxl.MAR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 442. 数组中重复的数据
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 * <p>
 * 找到所有出现两次的元素。
 * <p>
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 * <p>
 * 示例：
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [2,3]
 * @author: lxl
 * @create: 2020-03-25 09:46
 **/
public class FindAllDuplicatesInAnArray {

    public List<Integer> findDuplicates(int[] nums) {
        Arrays.sort(nums);
        List<Integer> re = new ArrayList<>();
        for (int i = 1, l = nums.length; i < l; i++) {
            if (nums[i] == nums[i - 1]) {
                re.add(nums[i]);
                i++;
            }
        }
        return re;
    }
}
