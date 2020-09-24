package lxl.SEP;

/**
 * @program: leetcode-hz
 * @description: 4. 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * <p>
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
 * @create: 2020-09-24 10:55
 **/
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            int[] ans = getKthElement(nums1, nums2, midIndex + 1, length1, length2);
            return ans[0];
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            int[] ans = getKthElement(nums1, nums2, midIndex1 + 1, length1, length2);
            return (double) (ans[0] + ans[1]) / 2;
        }
    }

    /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
     * 这里的 "/" 表示整除
     * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
     * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
     * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
     * 这样 pivot 本身最大也只能是第 k-1 小的元素
     * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
     * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
     * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
     */
    // 0 1 标识中间为两个数
    private int[] getKthElement(int[] nums1, int[] nums2, int k, int len1, int len2) {
        int index1 = 0;
        int index2 = 0;
        while (true) {
            //边界情况
            if (index1 == len1) {
                return new int[]{nums2[index2 + k - 1], index2 + k >= len2 ? -1 : nums2[index2 + k]};
            }
            if (index2 == len2) {
                return new int[]{nums1[index1 + k - 1], index1 + k >= len1 ? -1 : nums1[index1 + k]};
            }
            if (k == 1) {
                return nums1[index1] <= nums2[index2] ?
                        new int[]{nums1[index1], index1 + 1 <= len1 ? Math.min(nums1[index1 + 1], nums2[index2]) : nums2[index2]}
                        : new int[]{nums2[index2], index2 + 1 <= len2 ? Math.min(nums2[index2 + 1], nums1[index1]) : nums1[index1]};

            }
            int half = k / 2;

            int newIndex1 = Math.min(index1 + half, len1) - 1;
            int newIndex2 = Math.min(index2 + half, len2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {-1, 3};
        int[] nums2 = {1, 2};
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));
    }
}
