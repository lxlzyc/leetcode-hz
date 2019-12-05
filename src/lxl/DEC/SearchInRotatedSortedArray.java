package lxl.DEC;

/**
 * @program: leetcode-hz
 * @description: 33. 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-05 16:15
 **/
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        if (length < 8) {
            for (int i = 0; i < length; i++) {
                if (target == nums[i]) {
                    return i;
                }
            }
        }

        //二分查找
        return binarySearch(nums, target);
    }

    public int binarySearch(int[] srcArray, int des) {
        boolean flag = false;
        //定义初始最小、最大索引
        int start = 0;
        int end = srcArray.length - 1;

        int left = srcArray[0];
        int right = srcArray[end];

        //确保不会出现重复查找，越界
        int middle;
        int index;
        while (start <= end) {
            //计算出中间索引值
            //防止溢出
            middle = (end + start) >>> 1;
            index = srcArray[middle];
            if (des == index) {
                return middle;
                //判断下限
            }
            if (index <= right) {
                //index ---> right是有序数组
                //右半段
                if (des > index && des<=right) {
                    start = middle + 1;
                } else {
                    end = end - 1;
                }
                //判断上限
            } else {
                //left ---> index是有序数组
                //左半段
                if (des < index && des>=left) {
                    end = middle - 1;
                } else {
                    start = start +1;
                }
            }
        }
        //若没有，则返回-1
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
        //[8,1,2,3,4,5,6,7]
        //6
        //
        int[] nums = {8,1,2,3,4,5,6,7};
        System.out.println(search.search(nums, 6));
    }
}
