package lxl.y2020.DEC;

/**
 * @program: leetcode-hz
 * @description: 41.缺失的第一个正整数
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * <p>
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * <p>
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * <p>
 * 说明:
 * <p>
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-09 13:35
 **/
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 1;
        }
        int[] numsHelp = new int[length + 2];
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0 && nums[i] < length + 1) {
                numsHelp[nums[i]] = 1;
            }
        }
        for (int i = 1; i < length + 2; i++) {
            if (numsHelp[i] != 1) {
                return i;
            }
        }
        return length;
    }
    //public int firstMissingPositive(int[] nums) {
    //    int length = nums.length;
    //    if(length == 0){
    //        return 1;
    //    }
    //    int min = 2;
    //    int max = Integer.MAX_VALUE;
    //    boolean minChange = false;
    //    boolean maxChange = false;
    //    boolean hashOne = false;
    //    Set<Integer> minSet = new HashSet<>();
    //    Set<Integer> maxSet = new HashSet<>();
    //
    //    for (int i = 0; i < length; i++) {
    //        if(nums[i] > 0){
    //            maxChange = true;
    //            if(max == nums[i]){
    //                max = nums[i]+1;
    //            }else{
    //                max = Math.min(nums[i]+1,max);
    //            }
    //            //max = Math.max(nums[i]+1,max);
    //            if(nums[i] ==1){
    //                hashOne = true;
    //            }else{
    //                minChange = true;
    //                min = Math.min(nums[i]-1,min);
    //            }
    //        }
    //    }
    //    System.out.println(min+"-"+max);
    //    if(!hashOne){
    //        return 1;
    //    }
    //    if(minChange){
    //       return min>1?min:max;
    //    }
    //    if(maxChange){
    //        return max;
    //    }else{
    //        return 1;
    //    }
    //}

    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int[] nums = {3, 4, -1, 1};
        System.out.println(firstMissingPositive.firstMissingPositive(nums));
    }

}
