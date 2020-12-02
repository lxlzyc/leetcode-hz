package lxl.y2021.DEC;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 321. 拼接最大数
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。
 * 现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * <p>
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 * <p>
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 * <p>
 * 示例 3:
 * <p>
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/create-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-12-02 09:32
 **/
public class CreateMaximumNumber {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        int m = nums1.length;
        int n = nums2.length;
        //第一部分最小需要的个数
        int part1Start = Math.max(0, (k - n));
        //第一部分最大需要的个数
        int part1End = Math.min(m, k);
        for (int i = part1Start; i <= part1End; i++) {
            int[] max1 = this.getMaxArrs(nums1, i);
            int[] max2 = this.getMaxArrs(nums2, k - i);
            int[] maxMerge = this.mergeMaxArr(max1, max2, k);
            System.out.println(Arrays.toString(max1));
            System.out.println(Arrays.toString(max2));
            System.out.println(Arrays.toString(maxMerge));
            System.out.println("--------------");
            if (this.compareNumArr(maxMerge, 0, ans, 0)) {
                //赋值
                System.arraycopy(maxMerge, 0, ans, 0, k);
            }
        }
        return ans;
    }

    public boolean compareNumArr(int[] nums1, int p1, int[] nums2, int p2) {
        if (p2 >= nums2.length) return true;
        if (p1 >= nums1.length) return false;
        if (nums1[p1] > nums2[p2]) return true;
        if (nums1[p1] < nums2[p2]) return false;
        return compareNumArr(nums1, p1 + 1, nums2, p2 + 1);
    }

    //合并成最大数组
    private int[] mergeMaxArr(int[] nums1, int[] nums2, int length) {
        int[] res = new int[length];
        int cur = 0, p1 = 0, p2 = 0;
        while (cur < length) {
            if (compareNumArr(nums1, p1, nums2, p2)) { // 不能只比较当前值，如果当前值相等还需要比较后续哪个大
                res[cur++] = nums1[p1++];
            } else {
                res[cur++] = nums2[p2++];
            }
        }
        return res;
    }

    //获取数组下长度为length的最大子串
    private int[] getMaxArrs(int[] nums, int length) {
        if (length == 0) {
            return new int[0];
        }
        int[] stack = new int[length];
        int l = nums.length;
        //上次插入位置
        int offset = -1;
        //剩余可用长度
        int last = l - length;
        for (int i = 0; i < l; i++) {
            while (offset >= 0 && nums[i] > stack[offset] && last > 0) {
                offset--;
                //出栈一个，后面要补一个
                last--;
            }
            if (offset < length - 1) {
                stack[++offset] = nums[i];
            } else {
                last--;
            }
        }
        return stack;
    }

    public static void main(String[] args) {
        CreateMaximumNumber createMaximumNumber = new CreateMaximumNumber();
        int[] nums1 = {8, 9};
        int[] nums2 = {3, 9};
        System.out.println(Arrays.toString(createMaximumNumber.maxNumber(nums1, nums2, 3)));
    }
}
