package lxl.y2020.JAN;

/**
 * @program: leetcode-hz
 * @description: 154. 寻找旋转排序数组中的最小值 II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 注意数组中可能存在重复的元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入: [1,3,5]
 * 输出: 1
 * <p>
 * 示例 2：
 * <p>
 * 输入: [2,2,2,0,1]
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-07 13:56
 **/
public class FindMinimumInRotatedSortedArray2 {

    public int findMin(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return nums[0];
        }
        int min = nums[0];
        if (length < 8) {
            for (int i = 1; i < length; i++) {
                if (min > nums[i]) {
                    return nums[i];
                }
            }
            return min;
        }

        //二分查找
        return binarySearch(nums);
    }

    public int binarySearch(int[] srcArray) {
        int des = Integer.MIN_VALUE;
        //定义初始最小、最大索引
        int start = 0;
        int end = srcArray.length - 1;

        int left = srcArray[0];
        int right = srcArray[end];

        int min = left;

        //确保不会出现重复查找，越界
        int middle;
        int index;
        while (start <= end) {
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

            left = srcArray[start];
            right = srcArray[end];
            if (index == des) {
                return index;
            }
            while (index == right && end > start) {
                end--;
                right = srcArray[end];
            }
            if (index == des) {
                return index;
            }
            min = Math.min(min, index);
            if (index < right) {
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
                    start = start + 1;
                }
            }
        }
        //若没有，则返回-1
        return min;
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray2 findMinimumInRotatedSortedArray = new FindMinimumInRotatedSortedArray2();
        int[] nums = {4, 5, 6, 7, 0, 1, 1, 1, 1, 1, 1, 1, 2};
        System.out.println(findMinimumInRotatedSortedArray.findMin(nums));
    }
}
