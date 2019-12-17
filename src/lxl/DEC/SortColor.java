package lxl.DEC;

import lxl.util.JSONUtil;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * <p>
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-17 16:56
 **/
public class SortColor {

    public void sortColors(int[] nums) {
        int l = nums.length;
        if (l <= 1) {
            return;
        }
        int[] offsets = new int[3];
        Arrays.fill(offsets, -1);
        int old = -1;
        int index;
        int offset;
        int helpI;
        for (int i = 0; i < l; i++) {
            index = nums[i];
            if (index < old) {
                offset = offsets[2];

                if (index == 1) {
                    //交换一次
                    this.swapArray(nums, offset, i);
                    //更新位置
                    if (offsets[1] < 0) {
                        offsets[1] = offset;
                    }
                    offsets[2] = offset + 1;
                } else if (index == 0) {
                    //交换两次
                    if (offset >= 0) {
                        //和2交换
                        helpI = offset;
                        this.swapArray(nums, offset, i);
                        offsets[2] = offset + 1;
                        //和1交换
                        offset = offsets[1];
                        if (offset >= 0) {
                            this.swapArray(nums, offset, helpI);
                            offsets[1] = offset + 1;
                            offsets[0] = offset;
                        } else {
                            //1未初始化
                            offsets[0] = helpI;
                        }
                    } else {
                        offset = offsets[1];
                        this.swapArray(nums, offset, i);
                        if (offsets[0] < 0) {
                            offsets[0] = offset;
                        }
                        offsets[1] = offset + 1;
                    }
                }
            } else if (index > old) {
                if (offsets[index] == -1) {
                    offsets[index] = i;
                }
                old = index;
            }
        }
    }

    private void swapArray(int[] nums, int i, int j) {
        int help = nums[i];
        nums[i] = nums[j];
        nums[j] = help;

    }

    public static void main(String[] args) {
        int[] nums = {2,1,1,1,0,1,0,0,0,1,2,2,0,0};
        SortColor sortColor = new SortColor();
        System.out.println("begin" + JSONUtil.toJson(nums));

        sortColor.sortColors(nums);
        System.out.println("end" + JSONUtil.toJson(nums));
    }
}
