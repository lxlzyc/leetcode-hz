package lxl.y2020.APR;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description: 496. 下一个更大元素 I
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * <p>
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 * 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 * 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 * 对于num1中的数字2，第二个数组中的下一个较大数字是3。
 * 对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
 * <p>
 * 注意:
 * <p>
 * nums1和nums2中所有元素是唯一的。
 * nums1和nums2 的数组大小都不超过1000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-08 16:33
 **/
public class NextGreaterElementi {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1.length <= 0) {
            return nums1;
        }

        if (nums2.length <= 0) {
            Arrays.fill(nums1, -1);
            return nums1;
        }
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        //for(int num:nums1){
        //    numsMap.put(num,-1);
        //}
        Stack<Integer> stack = new Stack<>();
        int length = nums2.length;
        int i = 0;
        while (i < length) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                numsMap.put(stack.pop(), nums2[i]);
            }
            stack.add(nums2[i]);
            i++;

        }
        for (int j = 0, l = nums1.length; j < l; j++) {
            nums1[j] = numsMap.getOrDefault(nums1[j], -1);
        }
        return nums1;
    }

    public static void main(String[] args) {
        NextGreaterElementi nextGreaterElementi = new NextGreaterElementi();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElementi.nextGreaterElement(nums1, nums2)));
    }
}
