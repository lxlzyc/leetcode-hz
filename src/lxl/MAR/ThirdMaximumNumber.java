package lxl.MAR;

import java.util.TreeSet;

/**
 * @program: leetcode-hz
 * @description: 414. 第三大的数
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3, 2, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 第三大的数是 1.
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1, 2]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * <p>
 * 示例 3:
 * <p>
 * 输入: [2, 2, 3, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-03-18 11:06
 **/
public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        boolean max = false;
        for (int num : nums) {
            if (!max) {
                treeSet.add(num);
                if (treeSet.size() == 3) {
                    max = true;
                }
            } else if (!treeSet.contains(num) && treeSet.first() < num) {
                treeSet.remove(treeSet.first());
                treeSet.add(num);
            }
        }
        return treeSet.size() < 3 ? treeSet.last() : treeSet.first();
    }

    public static void main(String[] args) {
        ThirdMaximumNumber thirdMaximumNumber = new ThirdMaximumNumber();
        int[] nums = {2, 2, 3, 1, 2, 3, 1, 3, 3, 4};
        System.out.println(thirdMaximumNumber.thirdMax(nums));
    }

}
