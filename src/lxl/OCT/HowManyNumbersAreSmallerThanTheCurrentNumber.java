package lxl.OCT;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 1365. 有多少小于当前数字的数字
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 * <p>
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 * <p>
 * 以数组形式返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-10-26 09:31
 **/
public class HowManyNumbersAreSmallerThanTheCurrentNumber {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] numsCp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsCp);
        Map<Integer, Integer> help = new HashMap<>();
        help.put(numsCp[0], 0);
        int same = 1;
        for (int i = 1, l = numsCp.length; i < l; i++) {
            if (numsCp[i] > numsCp[i - 1]) {
                help.put(numsCp[i], help.get(numsCp[i - 1]) + same);
                same = 1;
            } else {
                same++;
            }
        }
        int[] ans = new int[nums.length];
        for (int i = 0, l = nums.length; i < l; i++) {
            ans[i] = help.get(nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        HowManyNumbersAreSmallerThanTheCurrentNumber hm = new HowManyNumbersAreSmallerThanTheCurrentNumber();
        int[] a = {7, 7, 7, 7};
        System.out.println(Arrays.toString(hm.smallerNumbersThanCurrent(a)));
    }
}
