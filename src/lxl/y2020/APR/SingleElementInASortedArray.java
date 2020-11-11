package lxl.y2020.APR;

/**
 * @program: leetcode-hz
 * @description: 540. 有序数组中的单一元素
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * 输入: [3,3,7,7,10,11,11]
 * 输出: 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-17 19:58
 **/
public class SingleElementInASortedArray {

    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            boolean halvesAreEven = (hi - mid) % 2 == 0;
            if (nums[mid + 1] == nums[mid]) {
                if (halvesAreEven) {
                    lo = mid + 2;
                } else {
                    hi = mid - 1;
                }
            } else if (nums[mid - 1] == nums[mid]) {
                if (halvesAreEven) {
                    hi = mid - 2;
                } else {
                    lo = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[lo];
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 4, 4, 6, 6, 8, 8};
        SingleElementInASortedArray singleElementInASortedArray = new SingleElementInASortedArray();
        System.out.println(singleElementInASortedArray.singleNonDuplicate(nums));
    }

}
