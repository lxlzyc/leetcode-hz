package lxl.DEC;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 80. 删除排序数组中的重复项 II
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [1,1,1,2,2,3],
 * <p>
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-18 15:24
 **/
public class RemoveDuplicatesFromSortedArray2 {

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 0) {
            return 0;
        }
        int oldNum = nums[0];
        int sameCount = 1;
        int oldCount = 1;
        for (int i = 1, l = nums.length; i < l; i++) {
            if (nums[i] != oldNum) {
                oldNum = nums[i];
                nums[sameCount] = oldNum;
                sameCount++;
                oldCount = 1;
            } else {
                if( oldCount == 1){
                    oldNum = nums[i];
                    nums[sameCount] = oldNum;
                    sameCount++;
                }
                oldCount++;
            }
            System.out.println("i="+i+"="+sameCount+"="+oldCount);
        }
        return sameCount;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray2 removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray2();
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
    //[0,0,1,1,2,3,3]
}
