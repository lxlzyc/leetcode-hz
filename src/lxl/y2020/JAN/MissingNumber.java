package lxl.y2020.JAN;

/**
 * @program: leetcode-hz
 * @description: 268. 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,0,1]
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * <p>
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-16 10:48
 **/
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int[] help = new int[nums.length + 1];
        for (int i = 0, l = nums.length; i < l; i++) {
            if (nums[i] < l) {
                help[nums[i]] = 1;
            }
        }
        for (int i = 0, l = help.length; i < l; i++) {
            if (help[i] == 0) {
                return i;
            }
        }
        return 0;
    }
}
