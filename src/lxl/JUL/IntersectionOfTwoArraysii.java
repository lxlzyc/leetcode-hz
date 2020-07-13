package lxl.JUL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * <p>
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * <p>
 * <p>
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-13 14:49
 **/
public class IntersectionOfTwoArraysii {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //if (nums1.length < nums2.length) {
        //    int[] temp = nums1;
        //    nums1 = nums2;
        //    nums2 = temp;
        //}
        int l1 = nums1.length - 1;
        int l2 = nums2.length - 1;

        List<Integer> list = new ArrayList<>();
        while (l1 >= 0 && l2 >= 0) {
            if (nums1[l1] == nums2[l2]) {
                list.add(nums1[l1]);
                l1--;
                l2--;
            } else if (nums1[l1] < nums2[l2]) {
                l2--;
            } else {
                l1--;
            }
        }
        int[] re = new int[list.size()];
        for (int i = 0, l = list.size(); i < l; i++) {
            re[i] = list.get(i);
        }
        return re;
    }
}
