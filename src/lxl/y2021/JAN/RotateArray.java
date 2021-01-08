package lxl.y2021.JAN;

import java.util.Arrays;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * <p>
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/1/8 10:14
 * @Version 1.0
 */
public class RotateArray {
    //    方法三：数组翻转
//
//    该方法基于如下的事实：当我们将数组的元素向右移动 kkk 次后，尾部  kmodn 个元素会移动至数组头部，其余元素向后移动  kmodn 个位置。
//
//    该方法为数组的翻转：我们可以先将所有元素翻转，这样尾部的 k  个元素就被移至数组头部，然后我们再翻转  [0,kmodn−1] 区间的元素和  [kmodn,n−1] 区间的元素即能得到最后的答案。
//
//    我们以 n=7 ，k=3  为例进行如下展示：
//
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode-solution-nipk/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public void rotate(int[] nums, int k) {
        int l = nums.length;
        k = k % l;
        this.revise(nums, 0, l - 1);
        this.revise(nums, 0, k - 1);
        this.revise(nums, k, l - 1);
    }

    private void revise(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotateArray.rotate(nums, 10);
        System.out.println(Arrays.toString(nums));
    }
}