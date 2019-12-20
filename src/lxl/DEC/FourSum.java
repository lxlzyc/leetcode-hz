package lxl.DEC;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-03 10:25
 **/
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        int length = nums.length;
        if(length<4){
            return lists;
        }
        Arrays.sort(nums);

        int first;
        int second;
        int third;
        int fourth;
        int left;
        int right;
        int targetPart = target/4+1;
        int sum;
        int partSum;
        if(target>nums[length-1]*4){
            return lists;
        }
        for (int i = 0,l = length-3; i < l; i++) {
            first = nums[i];
            if(first>targetPart){
                break;
            }
            if(i>0){
                if(first == nums[i-1]){
                    continue;
                }
            }
            for (int j = i+1,k = length -2; j < k; j++) {
                second = nums[j];
                if(j>i+1){
                    if(second == nums[j-1]){
                        continue;
                    }
                }
                partSum = first + second;
                left = j+1;
                right = length - 1;
                while (true){
                    while (left>j+1 && left<right){
                        if(nums[left] == nums[left-1]){
                            left ++;
                        }else{
                            break;
                        }
                    }
                    while (right<length-1 && left<right){
                        if(nums[right] == nums[right+1]){
                            right --;
                        }else{
                            break;
                        }
                    }
                    if(left>=right){
                        break;
                    }
                    third = nums[left];
                    fourth = nums[right];
                    sum = partSum + third+fourth;
                    if(sum == target){
                        lists.add(Arrays.asList(first, second,third,fourth));
                        left ++;
                        right --;
                    }else if(sum < target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }

        return lists;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] nums = {-4,0,-4,2,2,2,-2,-2};
        System.out.println(fourSum.fourSum(nums,7));
    }


}
