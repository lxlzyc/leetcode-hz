package lxl.work;

/**
 * @program: leetcode-hz
 * @description: 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * <p>
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-11-26 16:33
 **/
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //double re = re;
        int length1 = nums1.length;
        int length2 = nums2.length;
        int maxOffset = length1 + length2;

        int mid1 = nums1[length1 / 2];
        int mid2 = nums2[length2 / 2];
        return 0D;

    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2);
    }

}
