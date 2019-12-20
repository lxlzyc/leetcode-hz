package lxl.DEC;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 15. 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-11-28 18:07
 **/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int length = nums.length;
        if(length<3){
            return lists;
        }
        Arrays.sort(nums);

        Map<Integer, Integer> numMap = new HashMap<>();
        int hasZero = 0;
        int first;
        for (int i = 0; i < length; i++) {
            first = nums[i];
            if (first == 0) {
                hasZero++;
            }
            numMap.put(first, i);
        }
        int index = 0;
        int sum;
        int second;
        int firstRight = length - 2;
        int secondRight = length - 1;
        int third;
        while (index < firstRight) {
            first = nums[index];
            if (first >= 0) {
                break;
            }
            if (index > 0) {
                if (first == nums[index - 1]) {
                    index++;
                    continue;
                }
            }
            sum = 0 - first;
            for (int i = index + 1; i < secondRight; i++) {
                second = nums[i];
                if (i > index + 1 && second == nums[i - 1]) {
                    continue;
                }
                third = sum - second;
                if(third < second){
                    break;
                }
                Integer offset = numMap.get(third);
                if (offset == null ) {
                    continue;
                }else if(offset > i){
                    lists.add(Arrays.asList(first, second, third));
                    continue;
                }else{
                    break;
                }
            }
            index++;
        }
        //0 处理完毕
        if (hasZero >= 3) {
            lists.add(Arrays.asList(0, 0, 0));
        }
        return lists;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {1,-1,-1,0};
        System.out.println(threeSum.threeSum(nums));
    }



}
