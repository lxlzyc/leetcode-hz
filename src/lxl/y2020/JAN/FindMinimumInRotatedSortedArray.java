package lxl.y2020.JAN;

/**
 * @program: leetcode-hz
 * @description: 153. 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 你可以假设数组中不存在重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * <p>
 * 示例 2:
 * <p>
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-07 13:56
 **/
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        //int min = nums[0];
        //if (length < 8) {
        //    for (int i = 1; i < length; i++) {
        //        if (min > nums[i]) {
        //            return nums[i];
        //        }
        //    }
        //    return min;
        //}

        //二分查找
        return searchMin(nums);
    }

    public int searchMin(int[] srcArray) {
        int min = srcArray[0];
        boolean flag = false;
        //定义初始最小、最大索引
        int start = 0;
        int end = srcArray.length - 1;

        int left;
        int right;

        //确保不会出现重复查找，越界
        int middle;
        int index;
        int des = Integer.MIN_VALUE;
        while (start <= end) {
            left = srcArray[start];
            right = srcArray[end];
            //计算出中间索引值
            //防止溢出
            middle = (end + start) >>> 1;
            index = srcArray[middle];
            if (middle == 0) {
                return min;
            }
            if (index < srcArray[middle - 1]) {
                return index;
            }
            min = Math.min(min, index);
            if (index <= right) {
                //index ---> right是有序数组
                //右半段
                if (des > index && des <= right) {
                    start = middle + 1;
                } else {
                    end = end - 1;
                }
                //判断上限
            } else {
                //left ---> index是有序数组
                //左半段
                if (des < index && des >= left) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
        }
        //若没有，则返回-1
        return min;
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray findMinimumInRotatedSortedArray = new FindMinimumInRotatedSortedArray();
        int[] nums = {4, 5, 6, 7};
        System.out.println(findMinimumInRotatedSortedArray.findMin(nums));
    }
}
