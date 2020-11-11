package lxl.y2020.SEP;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode-hz
 * @description: 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * <p>
 * <p>
 * <p>
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-09-09 16:24
 **/
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] help = nums1;
            nums1 = nums2;
            nums2 = help;
        }
        Set<Integer> help = new HashSet<>();
        for (int num : nums1) {
            help.add(num);
        }
        Set<Integer> ans = new HashSet<>();
        for (int num : nums2) {
            if (help.contains(num)) {
                ans.add(num);
                if (ans.size() >= help.size()) {
                    break;
                }
            }
        }
        int[] re = new int[ans.size()];
        int i = 0;
        for (int num : ans) {
            re[i++] = num;
        }
        return re;
    }
}
