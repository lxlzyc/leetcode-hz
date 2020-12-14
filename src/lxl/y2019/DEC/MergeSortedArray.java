package lxl.y2019.DEC;

import lxl.util.JSONUtil;

/**
 * @program: leetcode-hz
 * @description: 88. 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-23 14:02
 **/
public class MergeSortedArray {
    //先找到位置，再一遍赋值
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int offset = 0;
        int[] offsets = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = offset; j <= m; j++) {
                if (nums1[j] >= nums2[i]) {
                    offsets[i] = i + j;
                    offset = j;
                    break;
                } else if (j == m) {
                    offsets[i] = i + j;
                    offset = m;
                    break;
                }
            }
        }
        offset = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (offset < 0) {
                break;
            } else if (offsets[offset] == i) {
                nums1[i] = nums2[offset];
                offset--;
            } else {
                nums1[i] = nums1[m - 1];
                m--;
            }
        }
    }

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] nums1 = {1, 2, 7, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        mergeSortedArray.merge(nums1, 3, nums2, 3);
        System.out.println(JSONUtil.toJson(nums1));

    }

}
