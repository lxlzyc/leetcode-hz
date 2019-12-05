package lxl.DEC;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 1,3,4,2 → 1,4,2,3
 * 1,3,2 → 2,1,3
 * 1,4,2,3,1 → 1,4,3,2,1
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-05 13:46
 **/
public class NextPermutation {
    //将给定数字序列重新排列成字典序中下一个更大的排列!!
    public void nextPermutation(int[] nums) {
        if (nums == null) {
            return;
        }
        int length = nums.length;
        if (length <= 1) {
            return;
        }
        int help;
        for (int i = length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                    //找到比nums[i - 1] 位大和比nums[i] 当前位小的值的index；
                    int index = this.findNumsIndex(nums,i, length);
                    help = nums[index];
                    nums[index] = nums[i-1];
                    nums[i-1] = help;
                    Arrays.sort(nums, i, length);
                    return;
            }
        }
        Arrays.sort(nums);
    }

    private int findNumsIndex(int[] nums,int begin, int length) {
        int min = nums[begin-1];
        int max = nums[begin];
        int re = begin;
        int minHelp = max;
        for (int i = begin+1; i < length; i++) {
            if (nums[i] > min && nums[i] < max) {
                if (nums[i] < minHelp) {
                    re = i;
                    minHelp = nums[i];
                }
            }
        }
        return re;
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = {3,2,1};
        nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

}
